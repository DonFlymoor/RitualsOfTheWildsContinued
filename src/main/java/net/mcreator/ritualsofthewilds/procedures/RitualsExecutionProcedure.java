package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.util.List;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class RitualsExecutionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		String centerblockid = "";
		String offhanditemid = "";
		String entitynearnead = "";
		double moonstage = 0;
		double ritualtype = 0;
		double rituallevel = 0;
		double sacrificeneeded = 0;
		double weatherneeded = 0;
		boolean fullmoonneed = false;
		boolean hasentitynearit = false;
		boolean Needentitynear = false;
		boolean needsscrollbeingseen = false;
		for (int index0 = 0; index0 < 500; index0++) {
			file = new File(
					(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/"
							+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
					File.separator + (new java.text.DecimalFormat("##").format((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).RitualChecks)
							+ "ritual.json"));
			if (file.exists() == false) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/eng"), File.separator
						+ (new java.text.DecimalFormat("##").format((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).RitualChecks) + "ritual.json"));
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
						centerblockid = object.get("Central Block ID or Tag").getAsString();
						offhanditemid = object.get("Offhand Item ID or Tag").getAsString();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
					if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()).equals(centerblockid)
							|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
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
								ritualtype = object.get("Ritual Type").getAsDouble();
								fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
								moonstage = object.get("Moon Stage").getAsDouble();
								rituallevel = object.get("Ritual Difficulty Level").getAsDouble();
								sacrificeneeded = object.get("Sacrifices needed").getAsDouble();
								weatherneeded = object.get("Weather Type needed").getAsDouble();
								Needentitynear = object.get("Entity Near needed").getAsBoolean();
								needsscrollbeingseen = object.get("Must Read Scroll First").getAsBoolean();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (needsscrollbeingseen == true) {
							if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen)
									.contains(new java.text.DecimalFormat("##").format((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).RitualChecks)
											+ "ritual") == true) {
								if (entity.getPersistentData().getDouble("SacrificesMade") >= sacrificeneeded) {
									if (weatherneeded <= 0) {
										if (Needentitynear == false) {
											if (ritualtype <= 1) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl29 && _lvl29.isDay())) {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl31 && _lvl31.isDay())) {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl33 && _lvl33.isDay())) {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl35 && _lvl35.isDay())) {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
													}
												}
											} else if (ritualtype >= 2) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl37 && _lvl37.isDay())) {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl39 && _lvl39.isDay())) {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl41 && _lvl41.isDay())) {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl43 && _lvl43.isDay())) {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
													}
												}
											}
										} else {
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
													entitynearnead = object.get("Entity Near ID or Tag").getAsString();
												} catch (IOException e) {
													e.printStackTrace();
												}
											}
											{
												final Vec3 _center = new Vec3(x, y, z);
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
												for (Entity entityiterator : _entfound) {
													if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
															|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
														if (!(hasentitynearit == true)) {
															hasentitynearit = true;
														}
													}
												}
											}
											if (hasentitynearit == true) {
												if (ritualtype <= 1) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl50 && _lvl50.isDay())) {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl52 && _lvl52.isDay())) {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl54 && _lvl54.isDay())) {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl56 && _lvl56.isDay())) {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													}
												} else if (ritualtype >= 2) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl58 && _lvl58.isDay())) {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl60 && _lvl60.isDay())) {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl62 && _lvl62.isDay())) {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl64 && _lvl64.isDay())) {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													}
												}
											}
										}
									} else if (weatherneeded == 1) {
										if (world.getLevelData().isRaining() == true || world.getLevelData().isThundering() == true) {
											if (Needentitynear == false) {
												if (ritualtype <= 1) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl68 && _lvl68.isDay())) {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl70 && _lvl70.isDay())) {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl72 && _lvl72.isDay())) {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl74 && _lvl74.isDay())) {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													}
												} else if (ritualtype >= 2) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl76 && _lvl76.isDay())) {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl78 && _lvl78.isDay())) {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl80 && _lvl80.isDay())) {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl82 && _lvl82.isDay())) {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													}
												}
											} else {
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
														entitynearnead = object.get("Entity Near ID or Tag").getAsString();
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												{
													final Vec3 _center = new Vec3(x, y, z);
													List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
													for (Entity entityiterator : _entfound) {
														if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
																|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
															if (!(hasentitynearit == true)) {
																hasentitynearit = true;
															}
														}
													}
												}
												if (hasentitynearit == true) {
													if (ritualtype <= 1) {
														if (rituallevel <= 0) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl89 && _lvl89.isDay())) {
																	RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 1) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl91 && _lvl91.isDay())) {
																	RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 2) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl93 && _lvl93.isDay())) {
																	RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel >= 3) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl95 && _lvl95.isDay())) {
																	RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														}
													} else if (ritualtype >= 2) {
														if (rituallevel <= 0) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl97 && _lvl97.isDay())) {
																	RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 1) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl99 && _lvl99.isDay())) {
																	RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 2) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl101 && _lvl101.isDay())) {
																	RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel >= 3) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl103 && _lvl103.isDay())) {
																	RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														}
													}
												}
											}
										}
									} else if (weatherneeded >= 2) {
										if (world.getLevelData().isThundering() == true) {
											if (Needentitynear == false) {
												if (ritualtype <= 1) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl106 && _lvl106.isDay())) {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl108 && _lvl108.isDay())) {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl110 && _lvl110.isDay())) {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl112 && _lvl112.isDay())) {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													}
												} else if (ritualtype >= 2) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl114 && _lvl114.isDay())) {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl116 && _lvl116.isDay())) {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl118 && _lvl118.isDay())) {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl120 && _lvl120.isDay())) {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													}
												}
											} else {
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
														entitynearnead = object.get("Entity Near ID or Tag").getAsString();
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												{
													final Vec3 _center = new Vec3(x, y, z);
													List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream()
															.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
													for (Entity entityiterator : _entfound) {
														if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
																|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
															if (!(hasentitynearit == true)) {
																hasentitynearit = true;
															}
														}
													}
												}
												if (hasentitynearit == true) {
													if (ritualtype <= 1) {
														if (rituallevel <= 0) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl127 && _lvl127.isDay())) {
																	RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 1) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl129 && _lvl129.isDay())) {
																	RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 2) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl131 && _lvl131.isDay())) {
																	RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel >= 3) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl133 && _lvl133.isDay())) {
																	RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														}
													} else if (ritualtype >= 2) {
														if (rituallevel <= 0) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl135 && _lvl135.isDay())) {
																	RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 1) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl137 && _lvl137.isDay())) {
																	RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel == 2) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl139 && _lvl139.isDay())) {
																	RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else if (rituallevel >= 3) {
															if (fullmoonneed == true) {
																if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl141 && _lvl141.isDay())) {
																	RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
																}
															} else {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							if (entity.getPersistentData().getDouble("SacrificesMade") >= sacrificeneeded) {
								if (weatherneeded <= 0) {
									if (Needentitynear == false) {
										if (ritualtype <= 1) {
											if (rituallevel <= 0) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl144 && _lvl144.isDay())) {
														RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel == 1) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl146 && _lvl146.isDay())) {
														RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel == 2) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl148 && _lvl148.isDay())) {
														RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel >= 3) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl150 && _lvl150.isDay())) {
														RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
												}
											}
										} else if (ritualtype >= 2) {
											if (rituallevel <= 0) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl152 && _lvl152.isDay())) {
														RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel == 1) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl154 && _lvl154.isDay())) {
														RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel == 2) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl156 && _lvl156.isDay())) {
														RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
												}
											} else if (rituallevel >= 3) {
												if (fullmoonneed == true) {
													if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl158 && _lvl158.isDay())) {
														RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else {
													RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
												}
											}
										}
									} else {
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
												entitynearnead = object.get("Entity Near ID or Tag").getAsString();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
														|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
													if (!(hasentitynearit == true)) {
														hasentitynearit = true;
													}
												}
											}
										}
										if (hasentitynearit == true) {
											if (ritualtype <= 1) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl165 && _lvl165.isDay())) {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl167 && _lvl167.isDay())) {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl169 && _lvl169.isDay())) {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl171 && _lvl171.isDay())) {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
													}
												}
											} else if (ritualtype >= 2) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl173 && _lvl173.isDay())) {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl175 && _lvl175.isDay())) {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl177 && _lvl177.isDay())) {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl179 && _lvl179.isDay())) {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
													}
												}
											}
										}
									}
								} else if (weatherneeded == 1) {
									if (world.getLevelData().isRaining() == true || world.getLevelData().isThundering() == true) {
										if (Needentitynear == false) {
											if (ritualtype <= 1) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl183 && _lvl183.isDay())) {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl185 && _lvl185.isDay())) {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl187 && _lvl187.isDay())) {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl189 && _lvl189.isDay())) {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
													}
												}
											} else if (ritualtype >= 2) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl191 && _lvl191.isDay())) {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl193 && _lvl193.isDay())) {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl195 && _lvl195.isDay())) {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl197 && _lvl197.isDay())) {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
													}
												}
											}
										} else {
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
													entitynearnead = object.get("Entity Near ID or Tag").getAsString();
												} catch (IOException e) {
													e.printStackTrace();
												}
											}
											{
												final Vec3 _center = new Vec3(x, y, z);
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
												for (Entity entityiterator : _entfound) {
													if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
															|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
														if (!(hasentitynearit == true)) {
															hasentitynearit = true;
														}
													}
												}
											}
											if (hasentitynearit == true) {
												if (ritualtype <= 1) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl204 && _lvl204.isDay())) {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl206 && _lvl206.isDay())) {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl208 && _lvl208.isDay())) {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl210 && _lvl210.isDay())) {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													}
												} else if (ritualtype >= 2) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl212 && _lvl212.isDay())) {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl214 && _lvl214.isDay())) {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl216 && _lvl216.isDay())) {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl218 && _lvl218.isDay())) {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													}
												}
											}
										}
									}
								} else if (weatherneeded >= 2) {
									if (world.getLevelData().isThundering() == true) {
										if (Needentitynear == false) {
											if (ritualtype <= 1) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl221 && _lvl221.isDay())) {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl223 && _lvl223.isDay())) {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl225 && _lvl225.isDay())) {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl227 && _lvl227.isDay())) {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
													}
												}
											} else if (ritualtype >= 2) {
												if (rituallevel <= 0) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl229 && _lvl229.isDay())) {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 1) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl231 && _lvl231.isDay())) {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel == 2) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl233 && _lvl233.isDay())) {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
													}
												} else if (rituallevel >= 3) {
													if (fullmoonneed == true) {
														if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl235 && _lvl235.isDay())) {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else {
														RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
													}
												}
											}
										} else {
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
													entitynearnead = object.get("Entity Near ID or Tag").getAsString();
												} catch (IOException e) {
													e.printStackTrace();
												}
											}
											{
												final Vec3 _center = new Vec3(x, y, z);
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream()
														.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
												for (Entity entityiterator : _entfound) {
													if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(entitynearnead)
															|| entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitynearnead).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
														if (!(hasentitynearit == true)) {
															hasentitynearit = true;
														}
													}
												}
											}
											if (hasentitynearit == true) {
												if (ritualtype <= 1) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl242 && _lvl242.isDay())) {
																RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl244 && _lvl244.isDay())) {
																RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckAnotherProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl246 && _lvl246.isDay())) {
																RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl248 && _lvl248.isDay())) {
																RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreeeProcedure.execute(world, x, y, z, entity, file);
														}
													}
												} else if (ritualtype >= 2) {
													if (rituallevel <= 0) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl250 && _lvl250.isDay())) {
																RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelZeroSecondTypeProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 1) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl252 && _lvl252.isDay())) {
																RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelOneCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel == 2) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl254 && _lvl254.isDay())) {
																RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelTwoCommandProcedure.execute(world, x, y, z, entity, file);
														}
													} else if (rituallevel >= 3) {
														if (fullmoonneed == true) {
															if (world.dimensionType().moonPhase(world.dayTime()) == moonstage && !(world instanceof Level _lvl256 && _lvl256.isDay())) {
																RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
															}
														} else {
															RitualCheckLevelThreecommandProcedure.execute(world, x, y, z, entity, file);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).RitualChecks >= 500) {
				{
					double _setval = 1;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RitualChecks = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).RitualChecks + 1;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RitualChecks = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
