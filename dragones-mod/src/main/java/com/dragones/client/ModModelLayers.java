package com.dragones.client;

import com.dragones.DragonesMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer DRAGON =
            new EntityModelLayer(Identifier.of(DragonesMod.MOD_ID, "dragon"), "main");
}
