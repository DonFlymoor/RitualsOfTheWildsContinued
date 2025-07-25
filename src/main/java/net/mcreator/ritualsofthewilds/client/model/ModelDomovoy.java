package net.mcreator.ritualsofthewilds.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.ritualsofthewilds.entity.DomovoiEntity;
import net.mcreator.ritualsofthewilds.DomovoiAnimations;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ModelDomovoy<T extends DomovoiEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("rituals_of_the_wilds", "model_domovoy"), "main");
	public final ModelPart root;
	public final ModelPart Body;
	public final ModelPart legs;
	public final ModelPart leg_right;
	public final ModelPart leg_left;
	public final ModelPart Head;
	public final ModelPart Hat;

	public ModelDomovoy(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.legs = this.Body.getChild("legs");
		this.leg_right = this.legs.getChild("leg_right");
		this.leg_left = this.legs.getChild("leg_left");
		this.Head = this.Body.getChild("Head");
		this.Hat = this.Head.getChild("Hat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));
		PartDefinition legs = Body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition leg_right = legs.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(40, 26).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition leg_left = legs.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(40, 31).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition Head = Body.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(36, 37).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(40, 18).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(42, 48).addBox(-2.0F, -4.0F, -1.01F, 3.0F, 4.0F, 0.1F, new CubeDeformation(0.0F)).texOffs(36, 48).addBox(-13.0F, -4.0F, -1.01F, 3.0F, 4.0F, 0.05F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -1.0F, 2.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition Hat = Head.addOrReplaceChild("Hat", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.3619F, 1.4188F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r2 = Hat.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 37).addBox(-4.5F, -3.01F, -4.0468F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-8.5F, 0.0F, -9.0F, 17.0F, 0.05F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.3619F, -0.4188F, -0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, DomovoiAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.walkAnimationState, DomovoiAnimations.WALK, ageInTicks, 1f);
		this.animate(entity.sittowalkAnimationState, DomovoiAnimations.SIT_TO_WALK, ageInTicks, 1f);
		this.animate(entity.walktositAnimationState, DomovoiAnimations.WALK_TO_SIT, ageInTicks, 1f);
		this.animate(entity.backtohatAnimationState, DomovoiAnimations.HAT, ageInTicks, 1f);
		this.animate(entity.fromhatAnimationState, DomovoiAnimations.HAT2, ageInTicks, 1f);
		this.animate(entity.danceAnimationState, DomovoiAnimations.DANCE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
