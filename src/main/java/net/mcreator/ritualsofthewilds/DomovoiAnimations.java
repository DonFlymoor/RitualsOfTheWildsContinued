
package net.mcreator.ritualsofthewilds;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

public class DomovoiAnimations {
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition SIT_TO_WALK = AnimationDefinition.Builder.withLength(0.5f)
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition WALK_TO_SIT = AnimationDefinition.Builder.withLength(0.5f)
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(20.16f, -7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(20.16f, 7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-20.16f, 7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-20.16f, -7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-19.94f, 12.6f, -1.94f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-19.85f, -7.9f, 0.21f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition HAT = AnimationDefinition.Builder.withLength(0.5f)
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 2f, 2f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, 2f, 3f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.33333f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.scaleVec(0.9f, 0.9f, 0.9f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.5f, KeyframeAnimations.scaleVec(0.3f, 0.3f, 0.3f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, -2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, -3.91f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -2.91f, -3.8f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.scaleVec(1.1f, 1.1f, 1.1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.scaleVec(1.3f, 1.3f, 1.3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5f, KeyframeAnimations.scaleVec(2.6f, 2.6f, 2.6f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM))).build();
	public static final AnimationDefinition HAT2 = AnimationDefinition.Builder.withLength(0.70833f)
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 2f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.45833f, KeyframeAnimations.posVec(0f, 0.25f, 1.18f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.45833f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(0.3f, 0.3f, 0.3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.29167f, KeyframeAnimations.scaleVec(0.9f, 0.9f, 0.9f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.45833f, KeyframeAnimations.degreeVec(-32.72f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -2.91f, -3.8f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, -3.91f, 2f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, -2f, 3f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.45833f, KeyframeAnimations.posVec(0f, -1.11f, 2.94f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.45833f, KeyframeAnimations.degreeVec(-19.78f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(2.6f, 2.6f, 2.6f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.16667f, KeyframeAnimations.scaleVec(1.3f, 1.3f, 1.3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.scaleVec(1.1f, 1.1f, 1.1f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.70833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
	public static final AnimationDefinition DANCE = AnimationDefinition.Builder.withLength(1.41667f).looping()
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(-1f, 1.25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.04167f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.20833f, KeyframeAnimations.posVec(1f, 1.25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.20833f, KeyframeAnimations.degreeVec(-4.19f, 12.05f, -8.22f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-5.24f, 11.63f, -13.31f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.degreeVec(-4.19f, -12.05f, 8.22f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.04167f, KeyframeAnimations.degreeVec(-5.24f, -11.63f, 13.31f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.20833f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.41667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(-0.4f, -0.2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.41667f, KeyframeAnimations.posVec(-1f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.posVec(-0.4f, -0.2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(-1f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.16667f, KeyframeAnimations.degreeVec(3.7f, 2.59f, -2.07f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-4.35f, 0.07f, 7.78f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-7.54f, 4.48f, 8.9f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875f, KeyframeAnimations.degreeVec(3.7f, -2.59f, 2.07f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.04167f, KeyframeAnimations.degreeVec(-4.35f, -0.07f, -7.78f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.29167f, KeyframeAnimations.degreeVec(-7.54f, -4.48f, -8.9f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.04167f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(6.97f, -0.61f, 4.96f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.91667f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.04167f, KeyframeAnimations.degreeVec(6.97f, 0.61f, -4.96f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.20833f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, 0f, -0.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.54167f, KeyframeAnimations.posVec(0f, 0f, 0.25f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.posVec(0f, 0f, 0.25f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, 0f, -0.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.29167f, KeyframeAnimations.posVec(0f, 0f, 0.25f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, 0.2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.posVec(-0.5f, 0.25f, -0.25f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.posVec(-0.75f, 0.15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0.5f, 0.25f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.04167f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.posVec(-0.75f, 0.15f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.20833f, KeyframeAnimations.posVec(-1f, -0.7f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.20833f, KeyframeAnimations.degreeVec(-2.5f, 2.39f, 7.39f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-2.93f, 1.93f, 7.74f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.41667f, KeyframeAnimations.degreeVec(-5.29f, 4.48f, -4.11f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(4.49f, 20.63f, -2.91f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.58333f, KeyframeAnimations.degreeVec(2.65f, 7.38f, -1.98f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.91667f, KeyframeAnimations.degreeVec(10.24f, 12.31f, 2.2f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.04167f, KeyframeAnimations.degreeVec(-2.26f, 12.31f, 2.2f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.degreeVec(-5.29f, 4.48f, -4.11f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.20833f, KeyframeAnimations.degreeVec(-7.49f, -2.46f, -0.43f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.posVec(0.75f, 0.15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(1f, -0.7f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, 0.2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.04167f, KeyframeAnimations.posVec(0.5f, 0.25f, -0.25f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.20833f, KeyframeAnimations.posVec(-0.5f, 0.25f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.41667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.20833f, KeyframeAnimations.degreeVec(10.24f, -12.31f, -2.2f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-2.26f, -12.31f, -2.2f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.41667f, KeyframeAnimations.degreeVec(-5.29f, -4.48f, 4.11f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.49f, 2.46f, 0.43f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.70833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.degreeVec(-2.5f, -2.39f, -7.39f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.04167f, KeyframeAnimations.degreeVec(-2.93f, -1.93f, -7.74f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.20833f, KeyframeAnimations.degreeVec(4.49f, -20.63f, 2.91f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.29167f, KeyframeAnimations.degreeVec(2.65f, -7.38f, 1.98f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.41667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition DEMO = AnimationDefinition.Builder.withLength(6f)
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 3f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.04167f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.16667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.625f, KeyframeAnimations.posVec(0f, 2f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.79167f, KeyframeAnimations.posVec(0f, 2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.95833f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.29167f, KeyframeAnimations.posVec(0f, 0f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.45833f, KeyframeAnimations.posVec(0f, 2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5.58333f, KeyframeAnimations.posVec(0f, 2f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.75f, KeyframeAnimations.posVec(0f, 0.25f, 1.18f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.375f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.625f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(20.16f, -7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.25f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(20.16f, 7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(20.16f, -7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.25f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(20.16f, 7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.875f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.04167f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.45833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.625f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.degreeVec(42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.58333f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5.75f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(4.45833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625f, KeyframeAnimations.scaleVec(0.9f, 0.9f, 0.9f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.95833f, KeyframeAnimations.scaleVec(0.3f, 0.3f, 0.3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5f, KeyframeAnimations.scaleVec(0.3f, 0.3f, 0.3f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.29167f, KeyframeAnimations.scaleVec(0.3f, 0.3f, 0.3f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(5.58333f, KeyframeAnimations.scaleVec(0.9f, 0.9f, 0.9f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.16667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.625f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.95833f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.29167f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.58333f, KeyframeAnimations.posVec(0f, -1f, -1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.375f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-20.16f, 7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(-20.16f, -7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-20.16f, 7.05f, -2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(-20.16f, -7.05f, 2.58f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.875f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.04167f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.45833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.625f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.degreeVec(47.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.58333f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.75f, KeyframeAnimations.degreeVec(-32.72f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(4.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.625f, KeyframeAnimations.posVec(0f, -2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.posVec(0f, -3.91f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.posVec(0f, -2.91f, -3.8f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.posVec(0f, -2.91f, -3.8f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.posVec(0f, -2.91f, -3.8f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.posVec(0f, -3.91f, 2f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.58333f, KeyframeAnimations.posVec(0f, -2f, 3f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5.75f, KeyframeAnimations.posVec(0f, -1.11f, 2.94f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(6f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(4.45833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.95833f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(5.29167f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.58333f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5.75f, KeyframeAnimations.degreeVec(-19.78f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("Hat", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(4.45833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625f, KeyframeAnimations.scaleVec(1.1f, 1.1f, 1.1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.scaleVec(1.3f, 1.3f, 1.3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.95833f, KeyframeAnimations.scaleVec(2.6f, 2.6f, 2.6f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.scaleVec(2.6f, 2.6f, 2.6f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(5.29167f, KeyframeAnimations.scaleVec(2.6f, 2.6f, 2.6f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.scaleVec(1.3f, 1.3f, 1.3f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.58333f, KeyframeAnimations.scaleVec(1.1f, 1.1f, 1.1f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_right",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.posVec(0f, 1f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, -2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("leg_left",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.5f, KeyframeAnimations.posVec(0f, -0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.04167f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.16667f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.625f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.79167f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.45833f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(5.58333f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(6f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.375f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.625f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2f, KeyframeAnimations.degreeVec(-19.94f, 12.6f, -1.94f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.5f, KeyframeAnimations.degreeVec(-19.85f, -7.9f, 0.21f), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3f, KeyframeAnimations.degreeVec(-19.94f, 12.6f, -1.94f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.25f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.5f, KeyframeAnimations.degreeVec(-19.85f, -7.9f, 0.21f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.875f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.04167f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(4.16667f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(4.45833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.625f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.79167f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(4.95833f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.29167f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(5.45833f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5.58333f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(4.95833f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(5.29167f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(4.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(6f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(4.45833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(4.95833f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.29167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(6f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.CATMULLROM)))
			.build();
}
