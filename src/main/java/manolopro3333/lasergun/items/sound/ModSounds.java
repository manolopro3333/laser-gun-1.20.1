package manolopro3333.lasergun.items.sound;

import manolopro3333.lasergun.LaserGun;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class ModSounds {

    public static final SoundEvent DISPARO = registerSoundEvent("disparo");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(LaserGun.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        LaserGun.LOGGER.info("Registrando todos los sonidos.");
    }
}
