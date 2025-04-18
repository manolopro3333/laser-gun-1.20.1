package manolopro3333.lasergun;

import manolopro3333.lasergun.custom.particle.ModParticles;
import manolopro3333.lasergun.particle.client.LaserParticleFactory;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class LaserGunClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleFactoryRegistry.getInstance().register(
				ModParticles.LASER_PARTICLE,
				LaserParticleFactory::new
		);
	}
}