package manolopro3333.lasergun.custom.particle;

import manolopro3333.lasergun.LaserGun;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType LASER_PARTICLE = FabricParticleTypes.simple(true);

    public static void registerParticles() {
        Registry.register(
                Registries.PARTICLE_TYPE,
                new Identifier(LaserGun.MOD_ID, "laser_beam"),
                LASER_PARTICLE
        );
    }
}