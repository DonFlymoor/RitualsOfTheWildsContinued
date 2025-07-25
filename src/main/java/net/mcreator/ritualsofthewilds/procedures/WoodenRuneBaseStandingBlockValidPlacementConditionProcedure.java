package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class WoodenRuneBaseStandingBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x, y - 1, z)).isFaceSturdy(world, BlockPos.containing(x, y - 1, z), Direction.UP) == true) {
			return true;
		}
		return false;
	}
}
