package manolopro3333.lasergun.items;

import manolopro3333.lasergun.LaserGun;
import manolopro3333.lasergun.items.custom.lasergunItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

public class ModItems {

    // CREAR ITEMS
    public static final Item ARMA_LASER = registerItem("armalaser", new lasergunItem(new Item.Settings().maxCount(1), 30.0,6.0f));
    // FIN ITEMS

    private static Item registerItem(String itemID, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LaserGun.MOD_ID, itemID), item);
    }

    public static void registerItems() {
        LaserGun.LOGGER.info("Registrando items...");
    }
}
