package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class DistilationFlaskBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).isFaceSturdy(world, BlockPos.containing(x, y + 1, z), Direction.DOWN) == true
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == RitualsOfTheWildsModBlocks.ROPE.get()) {
			return true;
		}
		return false;
	}
}
