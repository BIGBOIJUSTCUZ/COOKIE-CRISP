package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.w3c.dom.Entity;

public class CartoonManRenderFactory implements EntityRendererProvider<CartoonMan> {
    public static CartoonManRenderFactory INSTANCE = new CartoonManRenderFactory();

    @Override
    public EntityRenderer<CartoonMan> create(Context manager){
        return new CartoonManRenderer(manager);
    }
}
