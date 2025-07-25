package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class SpiritBloomRCOBProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("forge:herbs_growth_possible"))) == true) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x, y + 1, z), RitualsOfTheWildsModBlocks.SPIRIT_BLOOM_1.get().defaultBlockState(), 3);
				itemstack.shrink(1);
			}
		}
	}
}
