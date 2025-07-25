
public class ModelChernobog<T extends ChernobogEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("rituals_of_the_wilds", "model_chernobog"), "main");
	public final ModelPart root;
	public final ModelPart legs;
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart body;
	public final ModelPart cape;
	public final ModelPart capeling;
	public final ModelPart head;
	public final ModelPart mane;
	public final ModelPart arms;
	public final ModelPart left_arm;
	public final ModelPart left_hand;
	public final ModelPart left_fingers;
	public final ModelPart right_arm;
	public final ModelPart right_hand;
	public final ModelPart right_fingers;
	public final ModelPart chest;
	public final ModelPart heart;

	public ModelChernobog(ModelPart root) {
		this.root = root.getChild("root");
		this.legs = this.root.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.right_leg = this.legs.getChild("right_leg");
		this.body = this.legs.getChild("body");
		this.cape = this.body.getChild("cape");
		this.capeling = this.cape.getChild("capeling");
		this.head = this.body.getChild("head");
		this.mane = this.head.getChild("mane");
		this.arms = this.body.getChild("arms");
		this.left_arm = this.arms.getChild("left_arm");
		this.left_hand = this.left_arm.getChild("left_hand");
		this.left_fingers = this.left_hand.getChild("left_fingers");
		this.right_arm = this.arms.getChild("right_arm");
		this.right_hand = this.right_arm.getChild("right_hand");
		this.right_fingers = this.right_hand.getChild("right_fingers");
		this.chest = this.body.getChild("chest");
		this.heart = this.chest.getChild("heart");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(),
				PartPose.offset(0.0F, -13.0F, 1.0F));
		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(70, 59).addBox(
				-2.6F, 0.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, 0.0F));
		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 73).addBox(
				-2.4F, 0.0F, -2.0F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 0.0F, 0.0F));
		PartDefinition body = legs.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, 0.0F, 12.0F, 23.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -15.0F, -10.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cape = body.addOrReplaceChild("cape", CubeListBuilder.create(),
				PartPose.offset(0.0F, -20.25F, -9.0F));
		PartDefinition cube_r2 = cape
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(34, 31).addBox(-8.0F, -2.0F, -1.0F, 16.0F, 6.0F, 7.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.25F, 1.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition capeling = cape.addOrReplaceChild("capeling", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.75F, 7.0F));
		PartDefinition cube_r3 = capeling.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 31).addBox(-7.0F, 0.0F, -1.0F, 14.0F, 23.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.75F, -2.0F, 0.5236F, 0.0F, 0.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 57).addBox(-4.0F,
				-4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -11.0F));
		PartDefinition mane = head.addOrReplaceChild("mane", CubeListBuilder.create(),
				PartPose.offset(0.0F, -0.25F, -2.5F));
		PartDefinition cube_r4 = mane.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(70, 44).addBox(-7.5F, -7.5F, 0.0F, 16.0F, 15.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -0.25F, 0.5F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r5 = mane.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(40, 0).addBox(-5.0F, -5.0F, -4.0F, 10.0F, 10.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.25F, 0.5F, -0.0873F, 0.0F, 0.0F));
		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(),
				PartPose.offset(0.0F, -18.0F, -5.0F));
		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(34, 44).addBox(
				0.0F, -2.0F, -2.0F, 4.0F, 27.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));
		PartDefinition left_hand = left_arm.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(40, 18)
				.addBox(-2.0F, -1.0F, 0.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.15F)),
				PartPose.offset(2.0F, 25.0F, -2.0F));
		PartDefinition left_fingers = left_hand.addOrReplaceChild("left_fingers", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r6 = left_fingers
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(76, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-0.5F, 0.5F, 1.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r7 = left_fingers
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(20, 73).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-2.0F, 0.5F, 1.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r8 = left_fingers
				.addOrReplaceChild("cube_r8",
						CubeListBuilder.create().texOffs(68, 18).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 0.5F, 1.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(52, 44).addBox(
				-4.0F, -2.0F, -2.0F, 4.0F, 27.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, 0.0F));
		PartDefinition right_hand = right_arm.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(54, 18)
				.addBox(-2.0F, -1.0F, 0.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.15F)),
				PartPose.offset(-2.0F, 25.0F, -2.0F));
		PartDefinition right_fingers = right_hand.addOrReplaceChild("right_fingers", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r9 = right_fingers
				.addOrReplaceChild("cube_r9",
						CubeListBuilder.create().texOffs(48, 76).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.5F, 0.5F, 1.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r10 = right_fingers
				.addOrReplaceChild("cube_r10",
						CubeListBuilder.create().texOffs(34, 76).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(2.0F, 0.5F, 1.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r11 = right_fingers
				.addOrReplaceChild("cube_r11",
						CubeListBuilder.create().texOffs(76, 7).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.0F, 0.5F, 1.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create(),
				PartPose.offset(0.0F, -9.0F, -7.0F));
		PartDefinition cube_r12 = chest
				.addOrReplaceChild("cube_r12",
						CubeListBuilder.create().texOffs(90, 0).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 10.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 0.4363F, 0.0F, 0.0F));
		PartDefinition heart = chest.addOrReplaceChild("heart", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r13 = heart
				.addOrReplaceChild("cube_r13",
						CubeListBuilder.create().texOffs(91, 13).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, ChernobogAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.walkAnimationState, ChernobogAnimations.WALKING, ageInTicks, 1f);
		this.animate(entity.attackoneAnimationState, ChernobogAnimations.ATTACK, ageInTicks, 1f);
		this.animate(entity.attacktwoAnimationState, ChernobogAnimations.ATTACK2, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
