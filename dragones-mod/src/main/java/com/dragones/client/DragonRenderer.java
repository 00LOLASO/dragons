package com.dragones.client;

import com.dragones.DragonesMod;
import com.dragones.entity.DragonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DragonRenderer extends MobEntityRenderer<DragonEntity, DragonModel> {
    private static final Identifier TEXTURA =
            Identifier.of(DragonesMod.MOD_ID, "textures/entity/dragon.png");

    public DragonRenderer(EntityRendererFactory.Context contexto) {
        super(contexto, new DragonModel(contexto.getPart(ModModelLayers.DRAGON)), 0.8f);
    }

    @Override
    public Identifier getTexture(DragonEntity dragon) {
        return TEXTURA;
    }
}
