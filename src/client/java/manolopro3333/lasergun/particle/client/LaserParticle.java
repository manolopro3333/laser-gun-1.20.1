package manolopro3333.lasergun.particle.client;

import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteProvider;

public class LaserParticle extends SpriteBillboardParticle {

    private final SpriteProvider spriteProvider;

    protected LaserParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, SpriteProvider spriteProvider) {
        super(world, x, y, z, vx, vy, vz);
        this.spriteProvider = spriteProvider;
        this.scale = 0.1f;
        this.maxAge = 7;
        this.alpha = 0.5f;
        this.velocityX = vx * 0;
        this.velocityY = vy * 0;
        this.velocityZ = vz * 0;
        this.setSpriteForAge(spriteProvider);
    }


    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
}