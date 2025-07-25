
package net.mcreator.ritualsofthewilds;

import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationChannel;

public class LeshyAnimations {
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("neck",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(70f, -35f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(50f, -35f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(70f, -35f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-89.66f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-89.66f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-89.66f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(70f, 35f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(50f, 35f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(70f, 35f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm2", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-89.66f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(-89.66f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-89.66f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
	public static final AnimationDefinition HOP = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.posVec(0f, 2f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("root",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("neck",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-4.17f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(-5.73f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-6.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(2.66f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.83333f, KeyframeAnimations.degreeVec(-6.25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("beard",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.83333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hood",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(-15f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(20f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.875f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(70f, -35f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(73.89f, -42.53f, -19.94f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(96.11f, -50.87f, -63.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(70f, -35f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_arm2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-89.66f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-82.16f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-74.74f, 43.32f, -64.13f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-59.79f, 41.31f, -46.28f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-89.66f, 12.61f, -27.45f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("left_fingers",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(70f, 35f, 0f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(73.89f, 42.53f, 19.94f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(96.11f, 50.87f, 63.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(70f, 35f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_arm2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-89.66f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-82.16f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-74.74f, -43.32f, 64.13f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.70833f, KeyframeAnimations.degreeVec(-59.79f, -41.31f, 46.28f), AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-89.66f, -12.61f, 27.45f), AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("right_fingers", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(-40f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
			.build();
}
