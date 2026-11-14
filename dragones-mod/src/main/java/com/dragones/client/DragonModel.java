package com.dragones.client;

import com.dragones.entity.DragonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

/**
 * Modelo simple hecho con cubos, con animacion por codigo
 * (patas al caminar, alas aleteando, cabeza siguiendo la vista).
 * Mas adelante se puede cambiar por un modelo de Blockbench.
 */
public class DragonModel extends EntityModel<DragonEntity> {
    private final ModelPart raiz;
    private final ModelPart cabeza;
    private final ModelPart cola;
    private final ModelPart alaIzq;
    private final ModelPart alaDer;
    private final ModelPart patasDelIzq;
    private final ModelPart patasDelDer;
    private final ModelPart patasTrasIzq;
    private final ModelPart patasTrasDer;

    public DragonModel(ModelPart raiz) {
        this.raiz = raiz;
        this.cabeza = raiz.getChild("cabeza");
        this.cola = raiz.getChild("cola");
        this.alaIzq = raiz.getChild("ala_izq");
        this.alaDer = raiz.getChild("ala_der");
        this.patasDelIzq = raiz.getChild("pata_del_izq");
        this.patasDelDer = raiz.getChild("pata_del_der");
        this.patasTrasIzq = raiz.getChild("pata_tras_izq");
        this.patasTrasDer = raiz.getChild("pata_tras_der");
    }

    public static TexturedModelData crearModelo() {
        ModelData datos = new ModelData();
        ModelPartData r = datos.getRoot();

        r.addChild("cuerpo", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4f, -4f, -8f, 8f, 8f, 16f), ModelTransform.pivot(0f, 16f, 0f));
        r.addChild("cabeza", ModelPartBuilder.create().uv(0, 24)
                .cuboid(-3f, -3f, -6f, 6f, 6f, 6f)
                .uv(24, 24).cuboid(-2f, 0f, -9f, 4f, 3f, 3f), ModelTransform.pivot(0f, 13f, -8f));
        r.addChild("cola", ModelPartBuilder.create().uv(0, 36)
                .cuboid(-2f, -2f, 0f, 4f, 4f, 12f), ModelTransform.pivot(0f, 16f, 8f));
        r.addChild("ala_izq", ModelPartBuilder.create().uv(24, 36)
                .cuboid(0f, -0.5f, -6f, 14f, 1f, 12f), ModelTransform.pivot(4f, 12f, 0f));
        r.addChild("ala_der", ModelPartBuilder.create().uv(24, 36).mirrored()
                .cuboid(-14f, -0.5f, -6f, 14f, 1f, 12f), ModelTransform.pivot(-4f, 12f, 0f));

        ModelPartBuilder pata = ModelPartBuilder.create().uv(0, 52)
                .cuboid(-1.5f, 0f, -1.5f, 3f, 4f, 3f);
        r.addChild("pata_del_izq", pata, ModelTransform.pivot(3f, 20f, -5f));
        r.addChild("pata_del_der", pata, ModelTransform.pivot(-3f, 20f, -5f));
        r.addChild("pata_tras_izq", pata, ModelTransform.pivot(3f, 20f, 5f));
        r.addChild("pata_tras_der", pata, ModelTransform.pivot(-3f, 20f, 5f));

        return TexturedModelData.of(datos, 64, 64);
    }

    @Override
    public void setAngles(DragonEntity dragon, float limbAngle, float limbDistance,
                          float animationProgress, float headYaw, float headPitch) {
        // cabeza sigue hacia donde mira
        this.cabeza.yaw = headYaw * ((float) Math.PI / 180f);
        this.cabeza.pitch = headPitch * ((float) Math.PI / 180f);

        // patas al caminar
        float swing = MathHelper.cos(limbAngle * 0.6662f) * 1.2f * limbDistance;
        this.patasDelIzq.pitch = swing;
        this.patasTrasDer.pitch = swing;
        this.patasDelDer.pitch = -swing;
        this.patasTrasIzq.pitch = -swing;

        // alas aleteando suave
        float aleteo = MathHelper.sin(animationProgress * 0.25f) * 0.35f;
        this.alaIzq.roll = aleteo;
        this.alaDer.roll = -aleteo;

        // cola moviendose
        this.cola.yaw = MathHelper.sin(animationProgress * 0.12f) * 0.25f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.raiz.render(matrices, vertices, light, overlay, color);
    }
}
