package com.dragones.registry;

import com.dragones.DragonesMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item HUEVO_DRAGON = Registry.register(
            Registries.ITEM,
            Identifier.of(DragonesMod.MOD_ID, "dragon_spawn_egg"),
            new SpawnEggItem(ModEntities.DRAGON, 0x2E7D32, 0xFFB300, new Item.Settings())
    );

    public static void registrar() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.add(HUEVO_DRAGON));
    }
}
