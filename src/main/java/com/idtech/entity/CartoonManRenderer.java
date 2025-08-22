package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class CartoonManRenderer extends MobRenderer<CartoonMan, CartoonManModel<CartoonMan>> {
    public CartoonManRenderer(EntityRendererProvider.Context p_174304_, CartoonManModel<CartoonMan> p_174305_, float p_174306_) {
        super(p_174304_, p_174305_, p_174306_);
    }

    public CartoonManRenderer(EntityRendererProvider.Context provider){
        super(provider,new CartoonManModel<>(provider.bakeLayer(CartoonManModel.LAYER_LOCATION)),0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(CartoonMan p_114482_) {
        return new ResourceLocation(BaseMod.MODID,"textures/entity/cartoonman.png");
    }
}
