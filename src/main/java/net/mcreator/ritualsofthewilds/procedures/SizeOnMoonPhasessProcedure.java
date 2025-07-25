package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SizeOnMoonPhasessProcedure {
	public static double execute(LevelAccessor world) {
		if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
			return 0.75;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 1) {
			return 1;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 2) {
			return 1.25;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 3) {
			return 1.5;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 4) {
			return 1.75;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 5) {
			return 1.5;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 6) {
			return 1.25;
		} else if (world.dimensionType().moonPhase(world.dayTime()) == 7) {
			return 1;
		}
		return 0.75;
	}
}
