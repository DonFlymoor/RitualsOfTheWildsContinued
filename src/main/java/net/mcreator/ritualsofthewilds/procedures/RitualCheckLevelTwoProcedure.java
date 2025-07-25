package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class RitualCheckLevelTwoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, File filegive) {
		if (entity == null || filegive == null)
			return;
		File file = new File("");
		boolean fixedresultitem = false;
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		double mingive = 0;
		double maxgive = 0;
		double rituallevel = 0;
		double centralblockreplacmenttype = 0;
		double otherblocksreplcament = 0;
		String resultitem = "";
		String blockfirst = "";
		String blocksecond = "";
		String blockthird = "";
		String blockfourth = "";
		String centralreplamcentblock = "";
		String blockreplacment1 = "";
		String blockreplacment2 = "";
		String blockreplacment3 = "";
		String blockreplacment4 = "";
		String blockfifth = "";
		String blocksixth = "";
		String blocksevent = "";
		String blockeight = "";
		String blockreplacment5 = "";
		String blockreplacment6 = "";
		String blockreplacment7 = "";
		String blockreplacment8 = "";
		file = filegive;
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
					blockfirst = object.get("Block X+3 ID or Tag").getAsString();
					blocksecond = object.get("Block X-3 ID or Tag").getAsString();
					blockthird = object.get("Block Z+3 ID or Tag").getAsString();
					blockfourth = object.get("Block Z-3 ID or Tag").getAsString();
					blockfifth = object.get("Block X+2 Z+2 ID or Tag").getAsString();
					blocksixth = object.get("Block X-2 Z+2 ID or Tag").getAsString();
					blocksevent = object.get("Block X+2 Z-2 ID or Tag").getAsString();
					blockeight = object.get("Block X-2 Z-2 ID or Tag").getAsString();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock()).toString()).equals(blockfirst)
					|| (world.getBlockState(BlockPos.containing(x + 3, y, z))).is(BlockTags.create(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock()).toString()).equals(blocksecond)
							|| (world.getBlockState(BlockPos.containing(x - 3, y, z))).is(BlockTags.create(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock()).toString()).equals(blockthird)
							|| (world.getBlockState(BlockPos.containing(x, y, z + 3))).is(BlockTags.create(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock()).toString()).equals(blockfourth)
							|| (world.getBlockState(BlockPos.containing(x, y, z - 3))).is(BlockTags.create(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock()).toString()).equals(blockfifth)
							|| (world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(new ResourceLocation((blockfifth).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).getBlock()).toString()).equals(blocksixth)
							|| (world.getBlockState(BlockPos.containing(x - 2, y, z + 2))).is(BlockTags.create(new ResourceLocation((blocksixth).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock()).toString()).equals(blocksevent)
							|| (world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(new ResourceLocation((blocksevent).toLowerCase(java.util.Locale.ENGLISH)))))
					&& ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).getBlock()).toString()).equals(blockeight)
							|| (world.getBlockState(BlockPos.containing(x - 2, y, z - 2))).is(BlockTags.create(new ResourceLocation((blockeight).toLowerCase(java.util.Locale.ENGLISH)))))) {
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
						fixedresultitem = object.get("Fixed or Random Amount").getAsBoolean();
						mingive = object.get("Min/Fixed result item give count").getAsDouble();
						maxgive = object.get("Max result item give count").getAsDouble();
						centralblockreplacmenttype = object.get("Central Block Replacment Type").getAsDouble();
						otherblocksreplcament = object.get("Block Replacment Type").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fixedresultitem == false) {
					for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), mingive, maxgive); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((resultitem).toLowerCase(java.util.Locale.ENGLISH)))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				} else {
					for (int index1 = 0; index1 < (int) mingive; index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((resultitem).toLowerCase(java.util.Locale.ENGLISH)))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
				if (centralblockreplacmenttype == 2) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else if (centralblockreplacmenttype >= 3) {
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
							centralreplamcentblock = object.get("Central Block Replacment ID").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					world.setBlock(BlockPos.containing(x, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((centralreplamcentblock).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
				}
				if (otherblocksreplcament == 2) {
					world.setBlock(BlockPos.containing(x + 3, y, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 3, y, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z + 3), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z - 3), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else if (otherblocksreplcament >= 3) {
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
							blockreplacment1 = object.get("Replacment Block X+3 ID").getAsString();
							blockreplacment2 = object.get("Replacment Block X-3 ID").getAsString();
							blockreplacment3 = object.get("Replacment Block Z+3 ID").getAsString();
							blockreplacment4 = object.get("Replacment Block Z-3 ID").getAsString();
							blockreplacment5 = object.get("Replacment Block X+2 Z+2 ID").getAsString();
							blockreplacment6 = object.get("Replacment Block X-2 Z+2 ID").getAsString();
							blockreplacment7 = object.get("Replacment Block X+2 Z-2 ID").getAsString();
							blockreplacment8 = object.get("Replacment Block X-2 Z-2 ID").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					world.setBlock(BlockPos.containing(x + 3, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment1).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 3, y, z), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment2).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z + 3), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment3).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y, z - 3), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment4).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y, z + 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment5).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y, z + 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment6).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + 2, y, z - 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment7).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x - 2, y, z - 2), ForgeRegistries.BLOCKS.getValue(new ResourceLocation((blockreplacment8).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState(), 3);
				}
				entity.getPersistentData().putDouble("SacrificesMade", 0);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle rituals_of_the_wilds:amethyst_powder_particle ~ ~0.75 ~ 0.1 0.1 0.1 0.075 15");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.BLOCKS, 1, (float) 0.7);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.BLOCKS, 1, (float) 0.7, false);
					}
				}
			}
		}
	}
}
