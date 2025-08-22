package com.idtech.entity.redstone_golem;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedstoneGolemRenderer extends MobRenderer<RedstoneGolem, RedstoneGolemModel<RedstoneGolem>> {
    public RedstoneGolemRenderer(EntityRendererProvider.Context provider){
        super(provider,new RedstoneGolemModel<>(provider.bakeLayer(RedstoneGolemModel.LAYER_LOCATION)),0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedstoneGolem entity){
        return new ResourceLocation(BaseMod.MODID, "textures/entity/redstone_golem.png");
    }
}
