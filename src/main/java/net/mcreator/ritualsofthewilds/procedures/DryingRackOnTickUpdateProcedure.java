package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ritualsofthewilds.configuration.RitualsOfTheWildsConfigConfiguration;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class DryingRackOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		String afterdrying = "";
		String neededItem = "";
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals("")) {
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "dryingornot")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "TimeDrying") >= (double) RitualsOfTheWildsConfigConfiguration.DRYINGTIME.get()) {
					for (int index0 = 0; index0 < 500; index0++) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "dryingrecipe.json"));
						if (file.exists() == true) {
							{
								try {
									BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
									StringBuilder jsonstringbuilder = new StringBuilder();
									String line;
									while ((line = bufferedReader.readLine()) != null) {
										jsonstringbuilder.append(line);
									}
									bufferedReader.close();
									object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
									neededItem = object.get("Needed Item ID or Tag").getAsString();
									afterdrying = object.get("Drying Result Item ID").getAsString();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_first"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("dryingornot", true);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("ingredient_first", afterdrying);
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("kill @e[type=item_display,tag=" + ((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitem") + "]"));
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
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 1), (z + 0.5), 5, 0.2, 0.3, 0.2, 0);
							}
						}
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") >= 500) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", 1);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("TimeDrying", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "TimeDrying") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
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
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second")).equals("")) {
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "dryingornotsecond")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingsecond") >= (double) RitualsOfTheWildsConfigConfiguration.DRYINGTIME.get()) {
					for (int index1 = 0; index1 < 500; index1++) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "dryingrecipe.json"));
						if (file.exists() == true) {
							{
								try {
									BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
									StringBuilder jsonstringbuilder = new StringBuilder();
									String line;
									while ((line = bufferedReader.readLine()) != null) {
										jsonstringbuilder.append(line);
									}
									bufferedReader.close();
									object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
									neededItem = object.get("Needed Item ID or Tag").getAsString();
									afterdrying = object.get("Drying Result Item ID").getAsString();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_second"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("dryingornotsecond", true);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("ingredient_second", afterdrying);
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("kill @e[type=item_display,tag=" + ((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemsecond") + "]"));
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
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.4), (z + 0.5), 5, 0.2, 0.3, 0.2, 0);
							}
						}
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") >= 500) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", 1);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("TimeDryingsecond", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingsecond") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
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
		} else {
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
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third")).equals("")) {
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "dryingornotthird")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingthird") >= (double) RitualsOfTheWildsConfigConfiguration.DRYINGTIME.get()) {
					for (int index2 = 0; index2 < 500; index2++) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "dryingrecipe.json"));
						if (file.exists() == true) {
							{
								try {
									BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
									StringBuilder jsonstringbuilder = new StringBuilder();
									String line;
									while ((line = bufferedReader.readLine()) != null) {
										jsonstringbuilder.append(line);
									}
									bufferedReader.close();
									object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
									neededItem = object.get("Needed Item ID or Tag").getAsString();
									afterdrying = object.get("Drying Result Item ID").getAsString();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_third"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("dryingornotthird", true);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("ingredient_third", afterdrying);
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("kill @e[type=item_display,tag=" + ((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemthird") + "]"));
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
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.6), (z + 0.5), 5, 0.2, 0.3, 0.2, 0);
							}
						}
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") >= 500) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", 1);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("TimeDryingthird", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingthird") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
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
		} else {
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
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth")).equals("")) {
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getBoolean(tag);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "dryingornotfourth")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingfourth") >= (double) RitualsOfTheWildsConfigConfiguration.DRYINGTIME.get()) {
					for (int index3 = 0; index3 < 500; index3++) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "dryingrecipe.json"));
						if (file.exists() == true) {
							{
								try {
									BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
									StringBuilder jsonstringbuilder = new StringBuilder();
									String line;
									while ((line = bufferedReader.readLine()) != null) {
										jsonstringbuilder.append(line);
									}
									bufferedReader.close();
									object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
									neededItem = object.get("Needed Item ID or Tag").getAsString();
									afterdrying = object.get("Drying Result Item ID").getAsString();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if ((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "ingredient_fourth"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putBoolean("dryingornotfourth", true);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("ingredient_fourth", afterdrying);
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("kill @e[type=item_display,tag=" + ((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "dryingitemfourth") + "]"));
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
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, (float) 0.85, (float) 0.85, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.9), (z + 0.5), 5, 0.2, 0.3, 0.2, 0);
							}
						}
						if (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") >= 500) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", 1);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("recipechecking", (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "recipechecking") + 1));
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("TimeDryingfourth", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "TimeDryingfourth") + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
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
		} else {
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
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") >= 1) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") == 1) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") == 2) {
				{
					int _value = 2;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "drying_racks_stacked") == 3) {
				{
					int _value = 3;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
