package com.idtech.entity.redstone_golem;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class RedstoneGolemRenderFactory implements EntityRendererProvider<RedstoneGolem> {
    public static RedstoneGolemRenderFactory INSTANCE = new RedstoneGolemRenderFactory();

    @Override
    public EntityRenderer<RedstoneGolem> create(Context manager){
        return new RedstoneGolemRenderer(manager);
    }
}
