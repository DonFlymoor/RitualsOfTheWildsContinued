package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AlchemyCauldronFinishingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		double removetype = 0;
		double mingive = 0;
		double maxgive = 0;
		double filltype = 0;
		double moonstage = 0;
		double sacrificeneeded = 0;
		double rituallevel = 0;
		double minammount = 0;
		double weatherneeded = 0;
		double ritualtype = 0;
		double ritualnumber = 0;
		ItemStack itemtomake = ItemStack.EMPTY;
		String firstblock = "";
		String secondblock = "";
		String thirdblock = "";
		String fourthblock = "";
		String fifthblock = "";
		String sixthblock = "";
		String seventhblock = "";
		String eightblock = "";
		String Ingredient1 = "";
		String Ingredient2 = "";
		String Ingredient3 = "";
		String Ingredient4 = "";
		String Ingredient5 = "";
		String Ingredient6 = "";
		String Ingredient7 = "";
		String Ingredient8 = "";
		String Ingredient9 = "";
		String Ingredient10 = "";
		String resultitem = "";
		String replacement1 = "";
		String replacement2 = "";
		String replacement3 = "";
		String replacement4 = "";
		String replacement5 = "";
		String replacement6 = "";
		String replacement7 = "";
		String replacement8 = "";
		String blockfourth = "";
		String blockfifth = "";
		String block14 = "";
		String block15 = "";
		String block16 = "";
		String blockfirst = "";
		String result = "";
		String blocksevent = "";
		String block10 = "";
		String block11 = "";
		String block12 = "";
		String block13 = "";
		String ritualname = "";
		String blockeight = "";
		String block1 = "";
		String block2 = "";
		String offhanditemid = "";
		String block3 = "";
		String block4 = "";
		String block5 = "";
		String block6 = "";
		String block7 = "";
		String blockthird = "";
		String block8 = "";
		String block9 = "";
		String blocksixth = "";
		String entitynearnead = "";
		String centerblockid = "";
		String blocksecond = "";
		boolean checkblocks = false;
		boolean removeblocks = false;
		boolean fixedresultitem = false;
		boolean fullmoonneed = false;
		boolean runesneed = false;
		boolean canbespawnedinn = false;
		boolean Needentitynear = false;
		boolean scrolllogic = false;
		boolean hasentitynearit = false;
		boolean needsscrollbeingseen = false;
		for (int index0 = 0; index0 < 500; index0++) {
			file = new File(
					(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/"
							+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
					File.separator + (new java.text.DecimalFormat("##").format(new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "alchemyrecipe.json"));
			if (file.exists() == false) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/eng"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "alchemyrecipe.json"));
			}
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
						fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
						runesneed = object.get("Runes on cauldron needed").getAsBoolean();
						moonstage = object.get("Moon Stage").getAsDouble();
						filltype = object.get("Cauldron Fill Type").getAsDouble();
						scrolllogic = object.get("Must Read Scroll First").getAsBoolean();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (scrolllogic == true) {
					if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).alchemyscrollsseen)
							.contains(new java.text.DecimalFormat("##").format(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "alchemyrecipe") == true) {
						if (fullmoonneed == true) {
							if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl16 && _lvl16.isDay())) {
								if (runesneed == true) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "Runes Scribed")) == true) {
										if (filltype == 0) {
											if ((new Object() {
												public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getBoolean(tag);
													return false;
												}
											}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
												public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getBoolean(tag);
													return false;
												}
											}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
												CheckinallotherProcedure.execute(world, x, y, z, entity, file);
											}
										} else if (filltype == 1) {
											if ((new Object() {
												public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getBoolean(tag);
													return false;
												}
											}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
												CheckinallotherProcedure.execute(world, x, y, z, entity, file);
											}
										} else if (filltype == 2) {
											if ((new Object() {
												public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getBoolean(tag);
													return false;
												}
											}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
												CheckinallotherProcedure.execute(world, x, y, z, entity, file);
											}
										}
									}
								} else {
									if (filltype == 0) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 1) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 2) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									}
								}
							}
						} else {
							if (runesneed == true) {
								if ((new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "Runes Scribed")) == true) {
									if (filltype == 0) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 1) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 2) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									}
								}
							} else {
								if (filltype == 0) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 1) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 2) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								}
							}
						}
					}
				} else {
					if (fullmoonneed == true) {
						if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl36 && _lvl36.isDay())) {
							if (runesneed == true) {
								if ((new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "Runes Scribed")) == true) {
									if (filltype == 0) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 1) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									} else if (filltype == 2) {
										if ((new Object() {
											public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getBoolean(tag);
												return false;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
											CheckinallotherProcedure.execute(world, x, y, z, entity, file);
										}
									}
								}
							} else {
								if (filltype == 0) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 1) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 2) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								}
							}
						}
					} else {
						if (runesneed == true) {
							if ((new Object() {
								public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getBoolean(tag);
									return false;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "Runes Scribed")) == true) {
								if (filltype == 0) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 1) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								} else if (filltype == 2) {
									if ((new Object() {
										public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getBoolean(tag);
											return false;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
										CheckinallotherProcedure.execute(world, x, y, z, entity, file);
									}
								}
							}
						} else {
							if (filltype == 0) {
								if ((new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == false && (new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == false) {
									CheckinallotherProcedure.execute(world, x, y, z, entity, file);
								}
							} else if (filltype == 1) {
								if ((new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "filledwithwater")) == true) {
									CheckinallotherProcedure.execute(world, x, y, z, entity, file);
								}
							} else if (filltype == 2) {
								if ((new Object() {
									public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getBoolean(tag);
										return false;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "filledwithlava")) == true) {
									CheckinallotherProcedure.execute(world, x, y, z, entity, file);
								}
							}
						}
					}
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
	}
}
