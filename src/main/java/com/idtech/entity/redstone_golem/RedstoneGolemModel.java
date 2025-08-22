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

public class RedstoneGolemModel<T extends RedstoneGolem> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BaseMod.MODID, "redstone_golem"), "main");
	private final ModelPart bb_main;

	public RedstoneGolemModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(40, 95).addBox(-1.5F, -18.0F, -13.0F, 11.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(100, 0).addBox(-1.5F, -18.0F, 2.0F, 11.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(92, 82).addBox(-1.5F, -26.5F, -8.0F, 11.0F, 11.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -45.0F, -15.0F, 21.0F, 21.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(92, 50).addBox(10.5F, -51.0F, -9.0F, 13.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 50).addBox(-3.0F, -44.0F, -24.0F, 14.0F, 21.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(46, 50).addBox(-3.0F, -44.0F, 13.0F, 14.0F, 21.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 95).addBox(-10.5F, -43.0F, -7.0F, 5.0F, 15.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(40, 95).addBox(-1.5F, -9.0F, -13.0F, 11.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(100, 0).addBox(-1.5F, -10.0F, 2.0F, 11.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 50).addBox(-3.0F, -44.0F, -24.0F, 14.0F, 21.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(-9, -7).addBox(-3.0F, -23.0F, -24.0F, 14.0F, 12.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(-9, -7).addBox(-3.0F, -23.0F, 13.0F, 14.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}



	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

	}
}