package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class SuperSmallGlassJarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:candle_for_jars"))) == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item_display,distance=..1,tag=jar_item]");
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("firstitem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("seconditem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.WHITE_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.WHITE_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.ORANGE_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.ORANGE_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.MAGENTA_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.MAGENTA_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.LIGHT_BLUE_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.LIGHT_BLUE_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.YELLOW_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.YELLOW_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.LIME_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.LIME_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.PINK_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.PINK_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GRAY_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.GRAY_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.LIGHT_GRAY_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.LIGHT_GRAY_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.CYAN_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.CYAN_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.PURPLE_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.PURPLE_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.BLUE_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLUE_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.BROWN_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BROWN_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GREEN_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.GREEN_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.RED_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.RED_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.BLACK_CANDLE.asItem()) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLACK_SMALL_CANDLE_GLASS_JAR.get().defaultBlockState(), 3);
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.WATER_ALCHEMY_BOTTLE.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item_display,distance=..1,tag=jar_item]");
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("firstitem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("seconditem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.ALCHEMY_BOTTLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SMALL_GLASS_JAR_WITH_WATER.get().defaultBlockState(), 3);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.POPPY_FUMES.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item_display,distance=..1,tag=jar_item]");
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("firstitem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("seconditem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FUMES_BOTTLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SMALL_GLASS_JAR_WITH_POPPY_FUMES.get().defaultBlockState(), 3);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.DANDELION_FUMES.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item_display,distance=..1,tag=jar_item]");
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("firstitem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("seconditem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FUMES_BOTTLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SMALL_GLASS_JAR_WITH_DANDELION_FUMES.get().defaultBlockState(), 3);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.CORN_FLOWER_FUMES.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item_display,distance=..1,tag=jar_item]");
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("firstitem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("seconditem", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FUMES_BOTTLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SMALL_GLASS_JAR_WITH_CORNFLOWER_FUMES.get().defaultBlockState(), 3);
		} else {
			if (entity.isShiftKeyDown() == true) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "seconditem")).equals("")) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.insert")), SoundSource.BLOCKS, 1, (float) 0.85);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.insert")), SoundSource.BLOCKS, 1, (float) 0.85, false);
						}
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[type=item_display,tag=" + ((new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "seconditem") + "]"));
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putString("seconditem", "");
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "firstitem")).equals("")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.insert")), SoundSource.BLOCKS, 1, (float) 0.85);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bundle.insert")), SoundSource.BLOCKS, 1, (float) 0.85, false);
							}
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("kill @e[type=item_display,tag=" + ((new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "firstitem") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("firstitem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "can_be_putted_in_jars.json");
				if (file.exists() == true) {
					try {
						BufferedReader fileReader = new BufferedReader(new FileReader(file));
						String stringiterator = "";
						while ((stringiterator = fileReader.readLine()) != null) {
							if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
									|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
									&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
								if ((new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "firstitem")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.step")), SoundSource.BLOCKS, (float) 0.75, (float) 0.3);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.step")), SoundSource.BLOCKS, (float) 0.75, (float) 0.3, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("firstitem", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.175), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "firstitem"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[-0.8f,0.2f,0f,1f],translation:[0f,0f,0f],scale:[0.3f,0.3f,0.3f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "firstitem") + "\",\"jar_item\"]}"));
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
								} else {
									if ((new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, BlockPos.containing(x, y, z), "seconditem")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.step")), SoundSource.BLOCKS, (float) 0.75, (float) 0.3);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.step")), SoundSource.BLOCKS, (float) 0.75, (float) 0.3, false);
											}
										}
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putString("seconditem", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.175), (z + 0.4)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
														public String getValue(LevelAccessor world, BlockPos pos, String tag) {
															BlockEntity blockEntity = world.getBlockEntity(pos);
															if (blockEntity != null)
																return blockEntity.getPersistentData().getString(tag);
															return "";
														}
													}.getValue(world, BlockPos.containing(x, y, z), "seconditem"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
															+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.75f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.3f,0.3f,0.3f]},Tags:[\""
															+ ((new Object() {
																public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																	BlockEntity blockEntity = world.getBlockEntity(pos);
																	if (blockEntity != null)
																		return blockEntity.getPersistentData().getString(tag);
																	return "";
																}
															}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "seconditem") + "\",\"jar_item\"]}"));
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									}
								}
							}
						}
						fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
