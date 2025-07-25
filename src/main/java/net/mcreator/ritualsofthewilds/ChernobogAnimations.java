
package net.mcreator.ritualsofthewilds;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

public class ChernobogAnimations {
	public static final AnimationDefinition POSE = AnimationDefinition.Builder.withLength(0f)
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition UPRIGHT = AnimationDefinition.Builder.withLength(0.25f)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16667f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16667f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1.66667f)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.33333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.58333f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.83333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.08333f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.33333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.625f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.33333f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.54167f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.04167f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.54167f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.54167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 0.25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0.45f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 1.45f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0.45f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, 1.45f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0.45f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.54167f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-6.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.25f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.54167f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.625f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.66667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition WALKING = AnimationDefinition.Builder.withLength(1.5f).looping()
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, -7.5f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.75f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -0.75f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -0.75f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -1.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -1.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.91667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, -5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.33333f, KeyframeAnimations.degreeVec(-11.11f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.posVec(0f, 0.65f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 0.56f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.posVec(0f, 1.45f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 1.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.posVec(0f, 1.11f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 1.11f, -1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.posVec(0f, 0.67f, -1.44f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.posVec(0f, 1.11f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 1.11f, -1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.33333f, KeyframeAnimations.posVec(0f, 0.67f, -1.44f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-11.11f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 1.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.95833f, KeyframeAnimations.posVec(0f, 0.65f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0.56f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.33333f, KeyframeAnimations.posVec(0f, 1.45f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 1.5f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(0.875f)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-12f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-4.11f, -0.76f, -7.46f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.48f, -0.35f, -1.98f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, -2f, -3f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-100f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-100f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(2.5f, -7.5f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.83333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.79167f, KeyframeAnimations.degreeVec(-1.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-11.81f, 29.72f, -8.64f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-7f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition ATTACK2 = AnimationDefinition.Builder.withLength(0.91667f)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-12f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-4.11f, -0.76f, -7.46f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.48f, -0.35f, -1.98f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, -2f, -3f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-100f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-100f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.posVec(0f, 1f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(4.18f, -39.82f, -36.52f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-16.75f, -36.46f, 5.62f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.83333f, KeyframeAnimations.degreeVec(-7.13f, -4.36f, 3.53f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.79167f, KeyframeAnimations.degreeVec(-1.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 47.5f, 60f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.66667f, KeyframeAnimations.degreeVec(22.5f, 66.25f, 30f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.79167f, KeyframeAnimations.degreeVec(0.98f, 4.94f, -8.38f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.91667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.58333f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-7f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition HEART = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("heart",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.66667f, KeyframeAnimations.degreeVec(15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.83333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 17.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("heart",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.scaleVec(0.9f, 1.1f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.scaleVec(1.1f, 0.9f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.66667f, KeyframeAnimations.scaleVec(0.9f, 1.1f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.83333f, KeyframeAnimations.scaleVec(1.1f, 0.9f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition DYING = AnimationDefinition.Builder.withLength(0.75f)
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.33333f, KeyframeAnimations.degreeVec(11.67f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.41667f, KeyframeAnimations.degreeVec(-21.67f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.45833f, KeyframeAnimations.degreeVec(-15.83f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(52.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 0f, -1f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mane",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.scaleVec(1f, 1f, 1.3f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.33333f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.41667f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.45833f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("arms",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("cape", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("capeling",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.33333f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.375f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.41667f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(30f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 90f, -90f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(0f, 90f, -90f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16667f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-80f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-80f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(70f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -90f, 90f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.66667f, KeyframeAnimations.degreeVec(0f, -90f, 90f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.16667f, KeyframeAnimations.degreeVec(8.75f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20833f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-80f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-80f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(70f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("heart",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.45833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.66667f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("heart",
					new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.16667f, KeyframeAnimations.scaleVec(1f, 1f, 1f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.20833f, KeyframeAnimations.scaleVec(1.2f, 1.2f, 1f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.45833f, KeyframeAnimations.scaleVec(0.5f, 0.5f, 0.5f), AnimationChannel.Interpolations.LINEAR)))
			.build();
}
