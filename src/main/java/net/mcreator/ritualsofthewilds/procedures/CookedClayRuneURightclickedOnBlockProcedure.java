package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class CookedClayRuneURightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP) == true)
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
			itemstack.shrink(1);
			world.setBlock(BlockPos.containing(x, y + 1, z), RitualsOfTheWildsModBlocks.COOKED_CLAY_RUNE_U_STANDING.get().defaultBlockState(), 3);
			{
				Direction _dir = ((entity.getDirection()).getOpposite());
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
		}
	}
}
