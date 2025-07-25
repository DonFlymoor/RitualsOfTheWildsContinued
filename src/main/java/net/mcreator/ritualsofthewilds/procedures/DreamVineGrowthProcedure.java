package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class DreamVineGrowthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.DREAM_VINE_1.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.DREAM_VINE_2.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.DREAM_VINE_2.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.DREAM_VINE_3.get().defaultBlockState(), 3);
		}
	}
}
