package com.idtech.entity.redstone_golem;

import com.idtech.BaseMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RedstoneGolemRenderer extends GeoEntityRenderer<RedstoneGolem> {
    public RedstoneGolemRenderer(EntityRendererProvider.Context provider){
        super(provider,new RedstoneGolemModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public ResourceLocation getTextureLocation(RedstoneGolem entity){
        return new ResourceLocation(BaseMod.MODID, "textures/entity/redstone_golem.png");
    }

    @Override
    public RenderType getRenderType(RedstoneGolem animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation){
        stack.scale(1.0f,1.0f,1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertextBuilder, packedLightIn, textureLocation);
    }
}
