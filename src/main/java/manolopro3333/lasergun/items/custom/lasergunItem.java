package manolopro3333.lasergun.items.custom;


import manolopro3333.lasergun.custom.particle.ModParticles;
import manolopro3333.lasergun.items.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class lasergunItem extends Item {

    private final double rango;
    private final float dano;

    public lasergunItem(Settings settings, double rango, float dano) {
        super(settings);
        this.rango = rango;
        this.dano = dano;
    }

    private boolean cd1 = true;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            if (cd1) {
                cd1 = false;
                Vec3d start = player.getCameraPosVec(1.0f);
                Vec3d look = player.getRotationVec(1.0f);
                Vec3d end = start.add(look.multiply(rango));

                HitResult blockHit = player.raycast(rango, 0.0f, false);
                Vec3d blockHitPos = null;
                if (blockHit.getType() == HitResult.Type.BLOCK) {
                    BlockHitResult bhr = (BlockHitResult) blockHit;
                    blockHitPos = bhr.getPos();
                }

                Box box = player.getBoundingBox().stretch(look.multiply(rango)).expand(1.0);
                List<Entity> entities = world.getOtherEntities(player, box);

                Entity closest = null;
                double closestDistance = rango * rango;
                Vec3d entityHitPos = null;

                for (Entity e : entities) {
                    Box targetBox = e.getBoundingBox().expand(0.3);
                    Optional<Vec3d> optionalHit = targetBox.raycast(start, end);

                    if (optionalHit.isPresent()) {
                        Vec3d hitPos = optionalHit.get();
                        double dist = start.squaredDistanceTo(hitPos);

                        if (dist < closestDistance) {
                            closest = e;
                            closestDistance = dist;
                            entityHitPos = hitPos;
                        }
                    }
                }

                Vec3d hitPoint = end;
                if (blockHitPos != null && start.squaredDistanceTo(blockHitPos) < closestDistance) {
                    hitPoint = blockHitPos;
                } else if (entityHitPos != null) {
                    hitPoint = entityHitPos;
                }

                if (closest != null) {
                    closest.damage(player.getDamageSources().playerAttack(player), dano);
                }

                world.playSound(null, player.getBlockPos(), ModSounds.DISPARO, SoundCategory.PLAYERS);

                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                        cd1 = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();

                if (world instanceof ServerWorld serverWorld) {
                    double maxDistance = start.distanceTo(hitPoint);
                    for (double d = 0; d < maxDistance; d += 0.2) {
                        Vec3d pos = start.add(look.multiply(d));
                        serverWorld.spawnParticles(
                                ModParticles.LASER_PARTICLE,
                                pos.x, pos.y, pos.z,
                                2,
                                0, 0, 0,
                                0.05
                        );
                    }
                }
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand), world.isClient());
    }
}