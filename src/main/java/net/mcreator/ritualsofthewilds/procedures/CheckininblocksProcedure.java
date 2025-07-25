package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CheckininblocksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, File filegive, File filerecieve) {
		if (entity == null || filegive == null || filerecieve == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		String resultitem = "";
		String sixthblock = "";
		String firstblock = "";
		String fourthblock = "";
		String replacement4 = "";
		String fifthblock = "";
		String replacement5 = "";
		String replacement2 = "";
		String replacement3 = "";
		String replacement8 = "";
		String replacement6 = "";
		String replacement7 = "";
		String Ingredient6 = "";
		String secondblock = "";
		String Ingredient5 = "";
		String Ingredient8 = "";
		String Ingredient7 = "";
		String Ingredient2 = "";
		String Ingredient1 = "";
		String replacement1 = "";
		String Ingredient4 = "";
		String Ingredient3 = "";
		String eightblock = "";
		String seventhblock = "";
		String Ingredient9 = "";
		String thirdblock = "";
		String Ingredient10 = "";
		String firstupperblock = "";
		String thirdupperblock = "";
		String fourth = "";
		String fifthupperblock = "";
		String sixthupperblock = "";
		String seventhupperblock = "";
		String eightupperblock = "";
		String secondupperblock = "";
		String replacementupper1 = "";
		String replacementupper2 = "";
		String replacementupper3 = "";
		String replacementupper4 = "";
		String replacementupper5 = "";
		String replacementupper6 = "";
		String replacementupper7 = "";
		String replacementupper8 = "";
		double mingive = 0;
		double maxgive = 0;
		double removetype = 0;
		double maxexecute = 0;
		double minexecute = 0;
		boolean removeblocks = false;
		boolean fixedresultitem = false;
		boolean checkblocks = false;
		boolean checkupperblocks = false;
		boolean removeupperblocks = false;
		boolean command = false;
		boolean executeasplayer = false;
		file = filerecieve;
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
					Ingredient1 = object.get("Ingredient ID or Tag 1").getAsString();
					Ingredient2 = object.get("Ingredient ID or Tag 2").getAsString();
					Ingredient3 = object.get("Ingredient ID or Tag 3").getAsString();
					Ingredient4 = object.get("Ingredient ID or Tag 4").getAsString();
					Ingredient5 = object.get("Ingredient ID or Tag 5").getAsString();
					Ingredient6 = object.get("Ingredient ID or Tag 6").getAsString();
					Ingredient7 = object.get("Ingredient ID or Tag 7").getAsString();
					Ingredient8 = object.get("Ingredient ID or Tag 8").getAsString();
					Ingredient9 = object.get("Ingredient ID or Tag 9").getAsString();
					Ingredient10 = object.get("Ingredient ID or Tag 10").getAsString();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "first_ingredient")).equals(Ingredient1) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "first_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient1).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "second_ingredient")).equals(Ingredient2) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "second_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient2).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "third_ingredient")).equals(Ingredient3) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "third_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient3).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "fourth_ingredient")).equals(Ingredient4) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "fourth_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient4).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "fifth_ingredient")).equals(Ingredient5) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "fifth_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient5).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "sixth_ingredient")).equals(Ingredient6) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "sixth_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient6).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "seventh_ingredient")).equals(Ingredient7) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "seventh_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient7).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "eight_ingredient")).equals(Ingredient8) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "eight_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient8).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "nineth_ingredient")).equals(Ingredient9) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "nineth_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient9).toLowerCase(java.util.Locale.ENGLISH))))) && ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "tenth_ingredient")).equals(Ingredient10) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "tenth_ingredient"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((Ingredient10).toLowerCase(java.util.Locale.ENGLISH)))))) {
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
						firstblock = object.get("Block X-3 ID Or Tag").getAsString();
						secondblock = object.get("Block X+3 ID Or Tag").getAsString();
						thirdblock = object.get("Block Z-3 ID Or Tag").getAsString();
						fourthblock = object.get("Block Z+3 ID Or Tag").getAsString();
						fifthblock = object.get("Block X-2 Z-2 ID Or Tag").getAsString();
						sixthblock = object.get("Block X+2 Z+2 ID Or Tag").getAsString();
						seventhblock = object.get("Block X-2 Z+2 ID Or Tag").getAsString();
						eightblock = object.get("Block X+2 Z-2 ID Or Tag").getAsString();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock()).toString())
						.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((firstblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
						|| (world.getBlockState(BlockPos.containing(x - 3, y, z))).is(BlockTags.create(new ResourceLocation((firstblock).toLowerCase(java.util.Locale.ENGLISH))))) {
					if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock()).toString())
							.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((secondblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
							|| (world.getBlockState(BlockPos.containing(x + 3, y, z))).is(BlockTags.create(new ResourceLocation((secondblock).toLowerCase(java.util.Locale.ENGLISH))))) {
						if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock()).toString())
								.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((thirdblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
								|| (world.getBlockState(BlockPos.containing(x, y, z - 3))).is(BlockTags.create(new ResourceLocation((thirdblock).toLowerCase(java.util.Locale.ENGLISH))))) {
							if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock()).toString())
									.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((fourthblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
									|| (world.getBlockState(BlockPos.containing(x, y, z + 3))).is(BlockTags.create(new ResourceLocation((fourthblock).toLowerCase(java.util.Locale.ENGLISH))))) {
								if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock()).toString())
										.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((fifthblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
										|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).is(BlockTags.create(new ResourceLocation((fifthblock).toLowerCase(java.util.Locale.ENGLISH))))) {
									if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock()).toString())
											.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((sixthblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
											|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(new ResourceLocation((sixthblock).toLowerCase(java.util.Locale.ENGLISH))))) {
										if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock()).toString())
												.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((seventhblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
												|| (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).is(BlockTags.create(new ResourceLocation((seventhblock).toLowerCase(java.util.Locale.ENGLISH))))) {
											if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock()).toString())
													.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((eightblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
													|| (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(new ResourceLocation((eightblock).toLowerCase(java.util.Locale.ENGLISH))))) {
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
														checkupperblocks = object.get("Check for Blocks +2Y(Only works with Check for blocks around true)").getAsBoolean();
													} catch (IOException e) {
														e.printStackTrace();
													}
												}
												if (checkupperblocks == true) {
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
															firstupperblock = object.get("Block X-3 Y+2 ID Or Tag").getAsString();
															secondupperblock = object.get("Block X+3 Y+2 ID Or Tag").getAsString();
															thirdupperblock = object.get("Block Y+2 Z-3 ID Or Tag").getAsString();
															fourth = object.get("Block Y+2 Z+3 ID Or Tag").getAsString();
															fifthupperblock = object.get("Block X-2 Y+2 Z-2 ID Or Tag").getAsString();
															sixthupperblock = object.get("Block X+2 Y+2 Z+2 ID Or Tag").getAsString();
															seventhupperblock = object.get("Block X-2 Y+2 Z+2 ID Or Tag").getAsString();
															eightupperblock = object.get("Block X+2 Y+2 Z-2 ID Or Tag").getAsString();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock()).toString())
															.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((firstupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
															|| (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).is(BlockTags.create(new ResourceLocation((firstupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
														if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock()).toString())
																.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((secondupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																|| (world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).is(BlockTags.create(new ResourceLocation((secondupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
															if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y + 2, z - 3))).getBlock()).toString())
																	.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((thirdupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																	|| (world.getBlockState(BlockPos.containing(x, y + 2, z - 3))).is(BlockTags.create(new ResourceLocation((thirdupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
																if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y + 2, z + 3))).getBlock()).toString())
																		.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((fourth).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																		|| (world.getBlockState(BlockPos.containing(x, y + 2, z + 3))).is(BlockTags.create(new ResourceLocation((fourth).toLowerCase(java.util.Locale.ENGLISH))))) {
																	if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 2))).getBlock()).toString())
																			.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((fifthupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																			|| (world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 2))).is(BlockTags.create(new ResourceLocation((fifthupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
																		if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 2))).getBlock()).toString())
																				.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((sixthupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																				|| (world.getBlockState(BlockPos.containing(x + 2, y + 2, z + 2))).is(BlockTags.create(new ResourceLocation((sixthupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
																			if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 2))).getBlock()).toString())
																					.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((seventhupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																					|| (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 2)))
																							.is(BlockTags.create(new ResourceLocation((seventhupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
																				if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 2))).getBlock()).toString())
																						.equals(ForgeRegistries.BLOCKS.getKey(ForgeRegistries.BLOCKS.getValue(new ResourceLocation((eightupperblock).toLowerCase(java.util.Locale.ENGLISH)))).toString())
																						|| (world.getBlockState(BlockPos.containing(x + 2, y + 2, z - 2)))
																								.is(BlockTags.create(new ResourceLocation((eightupperblock).toLowerCase(java.util.Locale.ENGLISH))))) {
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
																							removeblocks = object.get("Remove blocks when used").getAsBoolean();
																							removeupperblocks = object.get("Remove upper blocks when used").getAsBoolean();
																							removetype = object.get("Remove Type").getAsDouble();
																							removetype = object.get("Remove Upper Type").getAsDouble();
																							command = object.get("Execute Command Instead of Giving Item").getAsBoolean();
																						} catch (IOException e) {
																							e.printStackTrace();
																						}
																					}
																					if (removeblocks == true) {
																						if (removetype <= 1) {
																							world.setBlock(BlockPos.containing(x - 3, y, z), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 3, y, z), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y, z - 3), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y, z + 3), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
																						} else if (removetype >= 2) {
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
																									replacement1 = object.get("Replacement Block X-3 ID").getAsString();
																									replacement2 = object.get("Replacement Block X+3 ID").getAsString();
																									replacement3 = object.get("Replacement Block Z-3 ID").getAsString();
																									replacement4 = object.get("Replacement Block Z+3 ID").getAsString();
																									replacement5 = object.get("Replacement Block X+2 Z+2 ID").getAsString();
																									replacement6 = object.get("Replacement Block X-2 Z+2 ID").getAsString();
																									replacement7 = object.get("Replacement Block X+2 Z-2 ID").getAsString();
																									replacement8 = object.get("Replacement Block X-2 Z-2 ID").getAsString();
																								} catch (IOException e) {
																									e.printStackTrace();
																								}
																							}
																							world.setBlock(BlockPos.containing(x - 3, y, z),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement1).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 3, y, z),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement2).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y, z - 3),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement3).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y, z + 3),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement4).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y, z + 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement5).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y, z + 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement6).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y, z - 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement7).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y, z - 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement8).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																						}
																					}
																					if (removeupperblocks == true) {
																						if (removetype <= 1) {
																							world.setBlock(BlockPos.containing(x - 3, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 3, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y + 2, z - 3), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y + 2, z + 3), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y + 2, z + 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y + 2, z + 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y + 2, z - 2), Blocks.AIR.defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y + 2, z - 2), Blocks.AIR.defaultBlockState(), 3);
																						} else if (removetype >= 2) {
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
																									replacementupper1 = object.get("Replacement Block X-3 Y+2 ID").getAsString();
																									replacementupper2 = object.get("Replacement Block X+3 Y+2 ID").getAsString();
																									replacementupper3 = object.get("Replacement Block Y+2 Z-3 ID").getAsString();
																									replacementupper4 = object.get("Replacement Block Y+2 Z+3 ID").getAsString();
																									replacementupper5 = object.get("Replacement Block X+2 Y+2 Z+2 ID").getAsString();
																									replacementupper6 = object.get("Replacement Block X-2 Y+2 Z+2 ID").getAsString();
																									replacementupper7 = object.get("Replacement Block X+2 Y+2 Z-2 ID").getAsString();
																									replacementupper8 = object.get("Replacement Block X-2 Y+2 Z-2 ID").getAsString();
																								} catch (IOException e) {
																									e.printStackTrace();
																								}
																							}
																							world.setBlock(BlockPos.containing(x - 3, y + 2, z),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper1).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 3, y + 2, z),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper2).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y + 2, z - 3),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper3).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x, y + 2, z + 3),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper4).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y + 2, z + 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper5).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y + 2, z + 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper6).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x + 2, y + 2, z - 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper7).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																							world.setBlock(BlockPos.containing(x - 2, y + 2, z - 2),
																									ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacementupper8).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
																						}
																					}
																					if (command == false) {
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
																								resultitem = object.get("Result item ID").getAsString();
																							} catch (IOException e) {
																								e.printStackTrace();
																							}
																						}
																						if (world instanceof ServerLevel _level)
																							_level.getServer().getCommands().performPrefixedCommand(
																									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																											.withSuppressedOutput(),
																									("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + resultitem
																											+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.65f,0.65f,0.65f]},Tags:[\""
																											+ ((new Object() {
																												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																													BlockEntity blockEntity = world.getBlockEntity(pos);
																													if (blockEntity != null)
																														return blockEntity.getPersistentData().getString(tag);
																													return "";
																												}
																											}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "itemoutput") + "\",\"itemoutput\"]}"));
																						RitualsOfTheWildsMod.queueServerWork(35, () -> {
																							if (world instanceof ServerLevel _level)
																								_level.getServer().getCommands().performPrefixedCommand(
																										new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																												.withSuppressedOutput(),
																										"kill @e[type=minecraft:item_display,distance=..2.5,tag=itemoutput]");
																							ItemGiveProcedure.execute(world, x, y, z, filegive);
																						});
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
																								resultitem = object.get("Result Command").getAsString();
																								executeasplayer = object.get("Execute as player").getAsBoolean();
																								minexecute = object.get("Min/Fixed result execution count").getAsDouble();
																								maxexecute = object.get("Max result execution count").getAsDouble();
																							} catch (IOException e) {
																								e.printStackTrace();
																							}
																						}
																						for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), minexecute, maxexecute); index0++) {
																							if (executeasplayer == false) {
																								if (world instanceof ServerLevel _level)
																									_level.getServer().getCommands().performPrefixedCommand(
																											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																													.withSuppressedOutput(),
																											resultitem);
																							} else {
																								{
																									Entity _ent = entity;
																									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																										_ent.getServer().getCommands()
																												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
																														_ent.level().getServer(), _ent), resultitem);
																									}
																								}
																							}
																						}
																					}
																					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands().performPrefixedCommand(
																								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																										.withSuppressedOutput(),
																								"particle rituals_of_the_wilds:amethyst_powder_particle ~ ~1.15 ~ 0.1 0.1 0.1 0.075 15");
																					if (world instanceof Level _level) {
																						if (!_level.isClientSide()) {
																							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")),
																									SoundSource.BLOCKS, 1, 1);
																						} else {
																							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1, false);
																						}
																					}
																					if (world instanceof ServerLevel _level)
																						_level.getServer().getCommands().performPrefixedCommand(
																								new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																										.withSuppressedOutput(),
																								"kill @e[type=minecraft:item_display,distance=..2.5,tag=cauldron]");
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("first_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("second_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("third_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("fourth_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("fifth_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("sixth_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("seventh_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("eight_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("nineth_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putString("tenth_ingredient", "");
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putDouble("ingredient_numeration", 0);
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putBoolean("filledwithlava", false);
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
																					}
																					if (!world.isClientSide()) {
																						BlockPos _bp = BlockPos.containing(x, y, z);
																						BlockEntity _blockEntity = world.getBlockEntity(_bp);
																						BlockState _bs = world.getBlockState(_bp);
																						if (_blockEntity != null)
																							_blockEntity.getPersistentData().putBoolean("filledwithwater", false);
																						if (world instanceof Level _level)
																							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
															removeblocks = object.get("Remove blocks when used").getAsBoolean();
															removetype = object.get("Remove Type").getAsDouble();
															command = object.get("Execute Command Instead of Giving Item").getAsBoolean();
														} catch (IOException e) {
															e.printStackTrace();
														}
													}
													if (removeblocks == true) {
														if (removetype <= 1) {
															world.setBlock(BlockPos.containing(x - 3, y, z), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 3, y, z), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x, y, z - 3), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x, y, z + 3), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x - 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x - 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
														} else if (removetype >= 2) {
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
																	replacement1 = object.get("Replacement Block X-3 ID").getAsString();
																	replacement2 = object.get("Replacement Block X+3 ID").getAsString();
																	replacement3 = object.get("Replacement Block Z-3 ID").getAsString();
																	replacement4 = object.get("Replacement Block Z+3 ID").getAsString();
																	replacement5 = object.get("Replacement Block X+2 Z+2 ID").getAsString();
																	replacement6 = object.get("Replacement Block X-2 Z+2 ID").getAsString();
																	replacement7 = object.get("Replacement Block X+2 Z-2 ID").getAsString();
																	replacement8 = object.get("Replacement Block X-2 Z-2 ID").getAsString();
																} catch (IOException e) {
																	e.printStackTrace();
																}
															}
															world.setBlock(BlockPos.containing(x - 3, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement1).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 3, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement2).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x, y, z - 3), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement3).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x, y, z + 3), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement4).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 2, y, z + 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement5).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x - 2, y, z + 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement6).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x + 2, y, z - 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement7).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
															world.setBlock(BlockPos.containing(x - 2, y, z - 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((replacement8).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
														}
													}
													if (command == false) {
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
																resultitem = object.get("Result item ID").getAsString();
															} catch (IOException e) {
																e.printStackTrace();
															}
														}
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + resultitem
																			+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.65f,0.65f,0.65f]},Tags:[\""
																			+ ((new Object() {
																				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																					BlockEntity blockEntity = world.getBlockEntity(pos);
																					if (blockEntity != null)
																						return blockEntity.getPersistentData().getString(tag);
																					return "";
																				}
																			}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "itemoutput") + "\",\"itemoutput\"]}"));
														RitualsOfTheWildsMod.queueServerWork(35, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"kill @e[type=minecraft:item_display,distance=..2.5,tag=itemoutput]");
															ItemGiveProcedure.execute(world, x, y, z, filegive);
														});
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
																resultitem = object.get("Result Command").getAsString();
																executeasplayer = object.get("Execute as player").getAsBoolean();
																minexecute = object.get("Min/Fixed result execution count").getAsDouble();
																maxexecute = object.get("Max result execution count").getAsDouble();
															} catch (IOException e) {
																e.printStackTrace();
															}
														}
														for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), minexecute, maxexecute); index1++) {
															if (executeasplayer == false) {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), resultitem);
															} else {
																{
																	Entity _ent = entity;
																	if (!_ent.level().isClientSide() && _ent.getServer() != null) {
																		_ent.getServer().getCommands()
																				.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																						_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																						resultitem);
																	}
																}
															}
														}
													}
													(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"particle rituals_of_the_wilds:amethyst_powder_particle ~ ~1.15 ~ 0.1 0.1 0.1 0.075 15");
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1);
														} else {
															_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1, false);
														}
													}
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"kill @e[type=minecraft:item_display,distance=..2.5,tag=cauldron]");
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("first_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("second_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("third_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("fourth_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("fifth_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("sixth_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("seventh_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("eight_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("nineth_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("tenth_ingredient", "");
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putDouble("ingredient_numeration", 0);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putBoolean("filledwithlava", false);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putBoolean("filledwithwater", false);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
	}
}
