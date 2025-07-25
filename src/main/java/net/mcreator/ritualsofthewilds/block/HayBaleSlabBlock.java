
package net.mcreator.ritualsofthewilds.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class HayBaleSlabBlock extends SlabBlock {
	public HayBaleSlabBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.CROP).strength(0.5f).dynamicShape());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}
}
