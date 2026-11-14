package com.dragones.registry;

import com.dragones.DragonesMod;
import com.dragones.entity.DragonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DragonEntity> DRAGON = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(DragonesMod.MOD_ID, "dragon"),
            EntityType.Builder.create(DragonEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 1.4f)
                    .maxTrackingRange(10)
                    .build("dragon")
    );

    public static void registrar() {
        FabricDefaultAttributeRegistry.register(DRAGON, DragonEntity.crearAtributos());
    }
}
