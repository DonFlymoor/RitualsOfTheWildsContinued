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

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class DryingRackOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double hitY) {
		if (entity == null)
			return;
		File file = new File("");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "drying_rack_ingredients.json");
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") <= 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals("")) {
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
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
							}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "]"));
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("ingredient_first", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("dryingornot", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeDrying", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (hitY >= y + 0 && hitY <= y + 0.25) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals("")) {
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
						}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
								}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "]"));
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putString("ingredient_first", "");
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("dryingornot", false);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("TimeDrying", 0);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (hitY >= y + 0.26 && hitY <= y + 0.5) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 1) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second")).equals("")) {
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
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemsecond") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("ingredient_second", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("dryingornotsecond", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("TimeDryingsecond", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if (hitY >= y + 0.51 && hitY <= y + 0.75) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third")).equals("")) {
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
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemthird") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("ingredient_third", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("dryingornotthird", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("TimeDryingthird", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if (hitY >= y + 0.76 && hitY <= y + 1) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 3) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && !(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth")).equals("")) {
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
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemfourth") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("ingredient_fourth", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("dryingornotfourth", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("TimeDryingfourth", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
		if (entity.isShiftKeyDown() == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModBlocks.DRYING_RACK.get().asItem()) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") <= 2) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("drying_racks_stacked", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 1) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("drying_racks_stacked", ((new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked")) - 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModBlocks.DRYING_RACK.get()).copy();
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
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
					}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
							}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemfourth") + "]"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item_display,tag=" + ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemthird") + "]"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item_display,tag=" + ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemsecond") + "]"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[type=item_display,tag=" + ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "]"));
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("ingredient_fourth", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("ingredient_third", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("ingredient_second", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putString("ingredient_first", "");
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("dryingornot", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("dryingornotsecond", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("dryingornotthird", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("dryingornotfourth", false);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeDrying", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeDryingsecond", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeDryingthird", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("TimeDryingfourth", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (file.exists() == true) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					if (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") <= 0) {
						if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
								|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
								&& (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1, false);
								}
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putString("ingredient_first", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.2), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
											public String getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getString(tag);
												return "";
											}
										}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
												+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
												+ ((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "\",\"drying_rack\"]}"));
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putBoolean("dryingornot", false);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("TimeDrying", 0);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					} else {
						if (hitY >= y + 0 && hitY <= y + 0.25) {
							if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
									|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
									&& (new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1, false);
									}
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("ingredient_first", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.2), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
													+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
													+ ((new Object() {
														public String getValue(LevelAccessor world, BlockPos pos, String tag) {
															BlockEntity blockEntity = world.getBlockEntity(pos);
															if (blockEntity != null)
																return blockEntity.getPersistentData().getString(tag);
															return "";
														}
													}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "\",\"drying_rack\"]}"));
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("dryingornot", false);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putDouble("TimeDrying", 0);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
						} else if (hitY >= y + 0.26 && hitY <= y + 0.5) {
							if (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 1) {
								if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
										|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS
												.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
										&& (new Object() {
											public String getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getString(tag);
												return "";
											}
										}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("ingredient_second", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemsecond") + "\",\"drying_rack\"]}"));
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putBoolean("dryingornotsecond", false);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("TimeDryingsecond", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								}
							}
						} else if (hitY >= y + 0.51 && hitY <= y + 0.75) {
							if (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 2) {
								if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
										|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS
												.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
										&& (new Object() {
											public String getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getString(tag);
												return "";
											}
										}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("ingredient_third", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.7), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemthird") + "\",\"drying_rack\"]}"));
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putBoolean("dryingornotthird", false);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("TimeDryingthird", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								}
							}
						} else if (hitY >= y + 0.75 && hitY <= y + 1) {
							if (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 3) {
								if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
										|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS
												.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
										&& (new Object() {
											public String getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getString(tag);
												return "";
											}
										}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth")).equals("") && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.place")), SoundSource.BLOCKS, (float) 0.75, (float) 0.1, false);
										}
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("ingredient_fourth", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 1), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemfourth") + "\",\"drying_rack\"]}"));
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putBoolean("dryingornotfourth", false);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("TimeDryingfourth", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
								}
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
