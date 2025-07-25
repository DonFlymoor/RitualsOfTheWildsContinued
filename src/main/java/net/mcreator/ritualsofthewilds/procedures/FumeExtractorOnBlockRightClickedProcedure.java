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

public class FumeExtractorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double hitY) {
		if (entity == null)
			return;
		File file = new File("");
		double clicksmade = 0;
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		String neededItem = "";
		String afterdrying = "";
		String blockunder = "";
		String particles = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (hitY >= y + 0 && hitY <= y + 0.4) {
				if (!(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "fuelitem")).equals("")) {
					if (entity.isShiftKeyDown() == true) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "fuelitem"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fuelexctractitem") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("fuelitem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("tickingofextacting", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("fuelneeded", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("neeededitem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("afteritem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("particlestosummon", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("timeneed", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			} else if (hitY >= y + 0.41 && hitY <= y + 1) {
				if (!(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting")).equals("")) {
					if (entity.isShiftKeyDown() == true) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fumeitem") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("itemfumeextracting", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("tickingofextacting", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("fuelneeded", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("neeededitem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("afteritem", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("particlestosummon", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("timeneed", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		} else {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "fume_extractor_ingredients.json");
			if (file.exists() == true) {
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH)))) == true
								|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((stringiterator).toLowerCase(java.util.Locale.ENGLISH))))
								&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
							if (hitY >= y + 0 && hitY <= y + 0.4) {
								if ((new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "fuelitem")).equals("")) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("fuelneeded", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("neeededitem", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("afteritem", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("particlestosummon", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("timeneed", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("fuelitem", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.15), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "fuelitem"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[1f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.15f,0.15f,0.15f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fuelexctractitem") + "\",\"fume_extracting\"]}"));
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("tickingofextacting", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									for (int index0 = 0; index0 < 500; index0++) {
										file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
											public double getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getDouble(tag);
												return -1;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "fumeextractorrecipe.json"));
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
													blockunder = object.get("Needed Fuel ID or Tag").getAsString();
													afterdrying = object.get("Result Item ID").getAsString();
													particles = object.get("Particles ID").getAsString();
													clicksmade = object.get("Extracting time(In ticks)").getAsDouble();
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
											}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting"))).toLowerCase(java.util.Locale.ENGLISH))))
													.is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
												if ((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "fuelitem")).equals(blockunder) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "fuelitem"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((blockunder).toLowerCase(java.util.Locale.ENGLISH))))) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("fuelneeded", blockunder);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("neeededitem", neededItem);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("afteritem", afterdrying);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("particlestosummon", particles);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putDouble("timeneed", clicksmade);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													break;
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
							} else if (hitY >= y + 0.41 && hitY <= y + 1) {
								if ((new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting")).equals("")) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("fuelneeded", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("neeededitem", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("afteritem", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("particlestosummon", "");
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("timeneed", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putString("itemfumeextracting", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.4), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[1f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.15f,0.15f,0.15f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fumeitem") + "\",\"fume_extracting\"]}"));
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null)
											_blockEntity.getPersistentData().putDouble("tickingofextacting", 0);
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
									for (int index1 = 0; index1 < 500; index1++) {
										file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
											public double getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getPersistentData().getDouble(tag);
												return -1;
											}
										}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "fumeextractorrecipe.json"));
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
													blockunder = object.get("Needed Fuel ID or Tag").getAsString();
													afterdrying = object.get("Result Item ID").getAsString();
													particles = object.get("Particles ID").getAsString();
													clicksmade = object.get("Extracting time(In ticks)").getAsDouble();
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
											}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
												public String getValue(LevelAccessor world, BlockPos pos, String tag) {
													BlockEntity blockEntity = world.getBlockEntity(pos);
													if (blockEntity != null)
														return blockEntity.getPersistentData().getString(tag);
													return "";
												}
											}.getValue(world, BlockPos.containing(x, y, z), "itemfumeextracting"))).toLowerCase(java.util.Locale.ENGLISH))))
													.is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
												if ((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "fuelitem")).equals(blockunder) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "fuelitem"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((blockunder).toLowerCase(java.util.Locale.ENGLISH))))) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("fuelneeded", blockunder);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("neeededitem", neededItem);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("afteritem", afterdrying);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putString("particlestosummon", particles);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x, y, z);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putDouble("timeneed", clicksmade);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
													break;
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
