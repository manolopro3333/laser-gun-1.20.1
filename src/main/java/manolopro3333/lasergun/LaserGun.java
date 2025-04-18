package manolopro3333.lasergun;

import manolopro3333.lasergun.custom.particle.ModParticles;
import manolopro3333.lasergun.items.ModItemsGroups;
import manolopro3333.lasergun.items.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import manolopro3333.lasergun.items.ModItems;

public class LaserGun implements ModInitializer {
	public static final String MOD_ID = "lasergun";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {



		LOGGER.info("LaserGun mod inicializado");
		ModSounds.registerSounds();
		ModItems.registerItems();
		ModItemsGroups.registerItemGroups();
		ModParticles.registerParticles();

	}
}
