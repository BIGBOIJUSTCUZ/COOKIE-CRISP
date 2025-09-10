package com.idtech.entity.redstone_golem;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.idtech.BaseMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RedstoneGolemModel extends AnimatedGeoModel<RedstoneGolem> {
	@Override
	public ResourceLocation getModelLocation(RedstoneGolem obj){
		return new ResourceLocation(BaseMod.MODID, "geo/redstone_golem.geo.json");
	}
	@Override
	public ResourceLocation getTextureLocation(RedstoneGolem obj){
		return new ResourceLocation(BaseMod.MODID, "textures/entity/redstone_golem.png");
	}
	@Override
	public ResourceLocation getAnimationFileLocation(RedstoneGolem obj){
		return new ResourceLocation(BaseMod.MODID, "animations/redstone_golem.animation.json");
	}
}