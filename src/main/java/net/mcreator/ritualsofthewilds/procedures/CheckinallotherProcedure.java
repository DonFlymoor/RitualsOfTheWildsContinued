package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
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

public class CheckinallotherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, File filegive) {
		if (entity == null || filegive == null)
			return;
		File file = new File("");
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
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		boolean removeblocks = false;
		boolean fixedresultitem = false;
		boolean checkblocks = false;
		boolean ingredientsorderneed = false;
		boolean command = false;
		boolean executeasplayer = false;
		double mingive = 0;
		double maxgive = 0;
		double removetype = 0;
		double minexecute = 0;
		double maxexecute = 0;
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
					checkblocks = object.get("Check for blocks around").getAsBoolean();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (checkblocks == false) {
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
							command = object.get("Execute Command Instead of Giving Item").getAsBoolean();
						} catch (IOException e) {
							e.printStackTrace();
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
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
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
						for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), minexecute, maxexecute); index0++) {
							if (executeasplayer == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands()
											.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), resultitem);
							} else {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), resultitem);
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
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
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
			} else {
				CheckininblocksProcedure.execute(world, x, y, z, entity, filegive, filegive);
			}
		}
	}
}
