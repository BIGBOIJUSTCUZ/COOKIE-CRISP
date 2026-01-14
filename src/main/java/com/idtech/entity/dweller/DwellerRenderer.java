package com.idtech.entity.dweller;

import com.idtech.BaseMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DwellerRenderer extends GeoEntityRenderer<Dweller> {
    public DwellerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DwellerModel());
        this.shadowRadius=0.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(Dweller inst){
        return new ResourceLocation(BaseMod.MODID, "textures/entity/dweller/dweller.png");
    }

    @Override
    public RenderType getRenderType(Dweller animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks,stack, renderTypeBuffer,vertexBuilder,packedLightIn,textureLocation);
    }
}
