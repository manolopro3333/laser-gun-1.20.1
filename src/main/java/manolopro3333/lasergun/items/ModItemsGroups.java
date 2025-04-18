package manolopro3333.lasergun.items;

import manolopro3333.lasergun.LaserGun;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    // grupos

    public static final ItemGroup LASER_MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LaserGun.MOD_ID, "laser_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ARMA_LASER))
            .displayName(Text.translatable("itemgroup.lasermod.laser_mod_items"))
            .entries((displayContext, entries) -> {

                // ITEMS DENTRO
                entries.add(ModItems.ARMA_LASER);

                // FIN ITEMS DENTRO

            })

            .build());

    // fin grupos

    public static void registerItemGroups() {
        LaserGun.LOGGER.info("Registrando grupos de items del mod");
    }

}
