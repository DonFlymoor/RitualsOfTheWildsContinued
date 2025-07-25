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

public class FrostMossRCOBProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getDirection()) == Direction.NORTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x, y, z + 1), RitualsOfTheWildsModBlocks.FROST_MOSS_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.SOUTH;
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
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
				itemstack.shrink(1);
			}
		} else if ((entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x, y, z - 1), RitualsOfTheWildsModBlocks.FROST_MOSS_1.get().defaultBlockState(), 3);
				itemstack.shrink(1);
			}
		} else if ((entity.getDirection()) == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x + 1, y, z), RitualsOfTheWildsModBlocks.FROST_MOSS_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.EAST;
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
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
				itemstack.shrink(1);
			}
		} else if ((entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x - 1, y, z), RitualsOfTheWildsModBlocks.FROST_MOSS_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.WEST;
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
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
				itemstack.shrink(1);
			}
		}
	}
}
