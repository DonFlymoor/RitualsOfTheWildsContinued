package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class BloodFernOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_FERN_1.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_FERN_2.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_FERN_2.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_FERN_3.get().defaultBlockState(), 3);
		}
	}
}
