package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
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
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CatalystGrinderOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		String neededItem = "";
		String afterdrying = "";
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		double clicksmade = 0;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "catalyst_grinder_ingredients.json");
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 0) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6 ? blockstate.getValue(_getip6) : -1) == 1) {
			{
				int _value = 2;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1) == 2) {
			{
				int _value = 3;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12 ? blockstate.getValue(_getip12) : -1) == 3) {
			{
				int _value = 4;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1) == 4) {
			{
				int _value = 5;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip18 ? blockstate.getValue(_getip18) : -1) == 5) {
			{
				int _value = 6;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21 ? blockstate.getValue(_getip21) : -1) == 6) {
			{
				int _value = 7;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip24 ? blockstate.getValue(_getip24) : -1) == 7) {
			{
				int _value = 8;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip27 ? blockstate.getValue(_getip27) : -1) == 8) {
			{
				int _value = 9;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip30 ? blockstate.getValue(_getip30) : -1) == 9) {
			{
				int _value = 10;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip33 ? blockstate.getValue(_getip33) : -1) == 10) {
			{
				int _value = 11;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip36 ? blockstate.getValue(_getip36) : -1) == 11) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
		if (file.exists() == true) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (!(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding")).equals("")) {
					if (entity.isShiftKeyDown() == false) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("clicksalreadymade", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "clicksalreadymade") + 1));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.hanging_sign.step")), SoundSource.BLOCKS, (float) 0.4, (float) 0.75);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.hanging_sign.step")), SoundSource.BLOCKS, (float) 0.4, (float) 0.75, false);
							}
						}
						for (int index0 = 0; index0 < 500; index0++) {
							file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/catalyst_grinder"), File.separator + (new java.text.DecimalFormat("##").format(new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "recipechecking")) + "catalystgrinderrecipe.json"));
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
										afterdrying = object.get("Result Item ID").getAsString();
										clicksmade = object.get("Clicks Needed").getAsDouble();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								if (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getDouble(tag);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "clicksalreadymade") >= clicksmade) {
									if ((new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding")).equals(neededItem) || new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
										public String getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getString(tag);
											return "";
										}
									}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation((neededItem).toLowerCase(java.util.Locale.ENGLISH))))) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.BLOCKS, (float) 0.75, (float) 0.55);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.BLOCKS, (float) 0.75, (float) 0.55, false);
											}
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
													}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "]"));
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putString("itemgrinding", afterdrying);
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if ((new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate)) == Direction.SOUTH) {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.45), (z + 0.6)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
																+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.45f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
																+ ((new Object() {
																	public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																		BlockEntity blockEntity = world.getBlockEntity(pos);
																		if (blockEntity != null)
																			return blockEntity.getPersistentData().getString(tag);
																		return "";
																	}
																}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
										} else if ((new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate)) == Direction.NORTH) {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.45), (z + 0.4)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
																+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.45f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
																+ ((new Object() {
																	public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																		BlockEntity blockEntity = world.getBlockEntity(pos);
																		if (blockEntity != null)
																			return blockEntity.getPersistentData().getString(tag);
																		return "";
																	}
																}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
										} else if ((new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate)) == Direction.EAST) {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.65), (y + 0.45), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
																+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.45f,1.45f,1.15f,1f],translation:[0f,0f,0f],scale:[0.1f,0.1f,0.1f]},Tags:[\""
																+ ((new Object() {
																	public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																		BlockEntity blockEntity = world.getBlockEntity(pos);
																		if (blockEntity != null)
																			return blockEntity.getPersistentData().getString(tag);
																		return "";
																	}
																}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
										} else if ((new Object() {
											public Direction getDirection(BlockState _bs) {
												Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
												if (_prop instanceof DirectionProperty _dp)
													return _bs.getValue(_dp);
												_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
												return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
														? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
														: Direction.NORTH;
											}
										}.getDirection(blockstate)) == Direction.WEST) {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.35), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
																+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0.45f,-1.45f,-1.15f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.1f,0.1f,0.1f]},Tags:[\""
																+ ((new Object() {
																	public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																		BlockEntity blockEntity = world.getBlockEntity(pos);
																		if (blockEntity != null)
																			return blockEntity.getPersistentData().getString(tag);
																		return "";
																	}
																}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
										}
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x, y, z);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null)
												_blockEntity.getPersistentData().putDouble("clicksalreadymade", 0);
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).copy();
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
									}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "]"));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("itemgrinding", "");
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("clicksalreadymade", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				}
			} else {
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
							}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding")).equals("")) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putString("itemgrinding", (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()));
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if ((new Object() {
									public Direction getDirection(BlockState _bs) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp)
											return _bs.getValue(_dp);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
												? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
												: Direction.NORTH;
									}
								}.getDirection(blockstate)) == Direction.SOUTH) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.45), (z + 0.6)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.95f,0f,0f,0.45f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
								} else if ((new Object() {
									public Direction getDirection(BlockState _bs) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp)
											return _bs.getValue(_dp);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
												? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
												: Direction.NORTH;
									}
								}.getDirection(blockstate)) == Direction.NORTH) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y + 0.45), (z + 0.4)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.45f,0f,0f,0.95f],translation:[0f,0f,0f],scale:[0.35f,0.35f,0.35f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
								} else if ((new Object() {
									public Direction getDirection(BlockState _bs) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp)
											return _bs.getValue(_dp);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
												? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
												: Direction.NORTH;
									}
								}.getDirection(blockstate)) == Direction.EAST) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.65), (y + 0.45), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0.45f,1.45f,1.15f,1f],translation:[0f,0f,0f],scale:[0.1f,0.1f,0.1f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
								} else if ((new Object() {
									public Direction getDirection(BlockState _bs) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp)
											return _bs.getValue(_dp);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
												? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
												: Direction.NORTH;
									}
								}.getDirection(blockstate)) == Direction.WEST) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.35), (y + 0.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon minecraft:item_display ~ ~ ~ {item:{id:\"" + "" + ForgeRegistries.ITEMS.getKey(ForgeRegistries.ITEMS.getValue(new ResourceLocation(((new Object() {
													public String getValue(LevelAccessor world, BlockPos pos, String tag) {
														BlockEntity blockEntity = world.getBlockEntity(pos);
														if (blockEntity != null)
															return blockEntity.getPersistentData().getString(tag);
														return "";
													}
												}.getValue(world, BlockPos.containing(x, y, z), "itemgrinding"))).toLowerCase(java.util.Locale.ENGLISH)))).toString()
														+ "\",Count:1},item_display:\"fixed\",interpolation_duration:6,teleport_duration:6,transformation:{left_rotation:[0.45f,-1.45f,-1.15f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[0.1f,0.1f,0.1f]},Tags:[\""
														+ ((new Object() {
															public String getValue(LevelAccessor world, BlockPos pos, String tag) {
																BlockEntity blockEntity = world.getBlockEntity(pos);
																if (blockEntity != null)
																	return blockEntity.getPersistentData().getString(tag);
																return "";
															}
														}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "grindingitem") + "\",\"catalyst_grinder\"]}"));
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null)
										_blockEntity.getPersistentData().putDouble("clicksalreadymade", 0);
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
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
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
