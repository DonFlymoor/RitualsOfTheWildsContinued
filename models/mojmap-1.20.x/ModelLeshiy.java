
public class ModelLeshiy<T extends LeshyEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("rituals_of_the_wilds", "model_leshiy"), "main");
	public final ModelPart root;
	public final ModelPart hood;
	public final ModelPart left_arm;
	public final ModelPart left_arm2;
	public final ModelPart left_fingers;
	public final ModelPart right_arm;
	public final ModelPart right_arm2;
	public final ModelPart right_fingers;
	public final ModelPart neck;
	public final ModelPart head;
	public final ModelPart beard;

	public ModelLeshiy(ModelPart root) {
		this.root = root.getChild("root");
		this.hood = this.root.getChild("hood");
		this.left_arm = this.root.getChild("left_arm");
		this.left_arm2 = this.left_arm.getChild("left_arm2");
		this.left_fingers = this.left_arm2.getChild("left_fingers");
		this.right_arm = this.root.getChild("right_arm");
		this.right_arm2 = this.right_arm.getChild("right_arm2");
		this.right_fingers = this.right_arm2.getChild("right_fingers");
		this.neck = this.root.getChild("neck");
		this.head = this.neck.getChild("head");
		this.beard = this.head.getChild("beard");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-7.0F, -25.0F, -4.0F, 14.0F, 25.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 2.0F));

		PartDefinition hood = root.addOrReplaceChild("hood", CubeListBuilder.create().texOffs(46, 35).addBox(-5.0F,
				-5.0F, 0.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, -1.0F));

		PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(74, 0)
				.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -17.0F, -4.0F));

		PartDefinition left_arm2 = left_arm.addOrReplaceChild("left_arm2",
				CubeListBuilder.create().texOffs(0, 51)
						.addBox(-1.0F, -1.0F, -10.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.25F)).texOffs(50, 13)
						.addBox(0.5F, 1.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition left_fingers = left_arm2.addOrReplaceChild("left_fingers", CubeListBuilder.create()
				.texOffs(0, 63).addBox(1.25F, -1.0F, -8.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition cube_r1 = left_fingers
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 63).addBox(-0.1F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(2.0F, 1.0F, 1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r2 = left_fingers
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition cube_r3 = left_fingers
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition right_arm = root.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(74, 0).mirror()
						.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-4.0F, -17.0F, -4.0F));

		PartDefinition right_arm2 = right_arm.addOrReplaceChild("right_arm2",
				CubeListBuilder.create().texOffs(0, 51).mirror()
						.addBox(-2.0F, -1.0F, -10.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.25F)).mirror(false)
						.texOffs(50, 13).addBox(-0.5F, 1.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition right_fingers = right_arm2.addOrReplaceChild("right_fingers",
				CubeListBuilder.create().texOffs(0, 63).mirror()
						.addBox(-1.25F, -1.0F, -8.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition cube_r4 = right_fingers.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 63).mirror()
						.addBox(0.1F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, 1.0F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r5 = right_fingers.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 63).mirror()
						.addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition cube_r6 = right_fingers.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 63).mirror()
						.addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition neck = root.addOrReplaceChild("neck", CubeListBuilder.create(),
				PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition cube_r7 = neck.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(74, 10).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 11.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, -8.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(46, 50)
						.addBox(-3.0F, -3.0F, -9.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(48, 27)
						.addBox(-2.0F, -1.0F, -14.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 35)
						.addBox(-6.0F, -6.0F, 0.0F, 12.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, -7.0F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(26, 51).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 7.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition beard = head.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F,
				-1.0F, -1.5F, 0.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -11.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, LeshyAnimations.IDLE, ageInTicks, 1f);
		this.animate(entity.walkAnimationState, LeshyAnimations.HOP, ageInTicks, 1f);
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
