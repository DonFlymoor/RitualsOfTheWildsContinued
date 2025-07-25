package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class TallCandleGlassJarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() == true) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.RED_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.RED_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.WHITE_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.WHITE_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLUE_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.BLUE_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLACK_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.BLACK_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BROWN_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.BROWN_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.CYAN_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.CYAN_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.GRAY_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.GRAY_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.GREEN_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.GREEN_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.LIGHT_BLUE_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.LIGHT_BLUE_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.LIGHT_GRAY_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.LIGHT_GRAY_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.LIME_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.LIME_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.MAGENTA_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.MAGENTA_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.ORANGE_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.ORANGE_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.PINK_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.PINK_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.PURPLE_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.PURPLE_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.YELLOW_TALL_CANDLE_GLASS_JAR.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.YELLOW_CANDLE).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.TALL_GLASS_JAR.get().defaultBlockState(), 3);
			}
		}
	}
}
