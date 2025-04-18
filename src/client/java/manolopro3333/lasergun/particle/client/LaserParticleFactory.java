package manolopro3333.lasergun.particle.client;

import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class LaserParticleFactory implements ParticleFactory<DefaultParticleType> {

    private final SpriteProvider spriteProvider;

    public LaserParticleFactory(SpriteProvider spriteProvider) {
        this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType type, ClientWorld world, double x, double y, double z, double vx, double vy, double vz) {
        return new LaserParticle(world, x, y, z, vx, vy, vz, this.spriteProvider);
    }
}