package com.dragones.client;

import com.dragones.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DragonesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGON, DragonModel::crearModelo);
        EntityRendererRegistry.register(ModEntities.DRAGON, DragonRenderer::new);
    }
}
