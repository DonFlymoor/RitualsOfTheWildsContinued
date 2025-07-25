package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class GiveBackItemQuest4Procedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		boolean randomornot = false;
		String itemgiveidortag = "";
		String RewardItem = "";
		String questafter = "";
		String rewardcommand = "";
		String finishingSound = "";
		String entitytagtoget = "";
		String nextquestid = "";
		File file = new File("");
		File testfile = new File("");
		double questingtype = 0;
		double questitemcount = 0;
		double RewardType = 0;
		double minammount = 0;
		double maxammount = 0;
		double nextdialogue = 0;
		double mincommandam = 0;
		double maxcommandam = 0;
		double executiontype = 0;
		double reputationgive = 0;
		double whomquestwillbe = 0;
		double killcounting = 0;
		double alreadykilled = 0;
		double whotogivereputation = 0;
		if ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 3) {
			file = new File(
					(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
							+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
					File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid + ".json"));
			if (file.exists() == false) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid + ".json"));
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
						questingtype = object.get("Quest Type").getAsDouble();
						finishingSound = object.get("Quest Finishing Sound").getAsString();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				finishingSound = finishingSound.replace("<entity_id>", entity.getStringUUID());
				finishingSound = finishingSound.replace("<player_id>", sourceentity.getStringUUID());
				if (questingtype == 1) {
					if (((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestgivenby).equals(entity.getStringUUID())) {
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
								itemgiveidortag = object.get("Quest Item ID or Tag").getAsString();
								questitemcount = object.get("Quest Item Count").getAsDouble();
								questafter = object.get("Quest After Finishing Text").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						questafter = questafter.replace("<playername>", sourceentity.getDisplayName().getString());
						if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((itemgiveidortag).toLowerCase(java.util.Locale.ENGLISH)))
									|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((itemgiveidortag).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
								if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= questitemcount) {
									(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink((int) questitemcount);
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
											RewardItem = object.get("Quest Reward Item ID").getAsString();
											nextquestid = object.get("Next Quest ID").getAsString();
											rewardcommand = object.get("Quest Reward Command").getAsString();
											reputationgive = object.get("Quest Reputation Reward").getAsDouble();
											whotogivereputation = object.get("Quest Reputation Source").getAsDouble();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									if (!(RewardItem).equals("")) {
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
												minammount = object.get("Quest Reward Min Give Amount").getAsDouble();
												maxammount = object.get("Quest Reward Max Give Amount").getAsDouble();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										if (sourceentity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((RewardItem).toLowerCase(java.util.Locale.ENGLISH)))).copy();
											_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), minammount, maxammount));
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (!(rewardcommand).equals("")) {
										rewardcommand = rewardcommand.replace("<entity_id>", entity.getStringUUID());
										rewardcommand = rewardcommand.replace("<player_id>", sourceentity.getStringUUID());
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
												mincommandam = object.get("Quest Reward Min Command Execution").getAsDouble();
												maxcommandam = object.get("Quest Reward Max Command Execution").getAsDouble();
												executiontype = object.get("Quest Reward Command Execution Type").getAsDouble();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										if (executiontype <= 0) {
											for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index0++) {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), rewardcommand);
											}
										} else if (executiontype == 1) {
											for (int index1 = 0; index1 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index1++) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
													}
												}
											}
										} else if (executiontype >= 2) {
											for (int index2 = 0; index2 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index2++) {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
													}
												}
											}
										}
									}
									if (!(reputationgive == 0)) {
										if (whotogivereputation <= 0) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease @s " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd @s " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										} else if (whotogivereputation == 1) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										} else if (whotogivereputation >= 2) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										}
									}
									{
										String _setval = "";
										sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquestid = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
									{
										String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestgivenby;
										sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.previousquestgiver4 = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
									{
										String _setval = "";
										sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquestgivenby = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
									if (!(nextquestid).equals("")) {
										testfile = new File(
												(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
														+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
												File.separator + (nextquestid + ".json"));
										if (testfile.exists() == false) {
											testfile = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"), File.separator + (nextquestid + ".json"));
										}
										if (testfile.exists() == true) {
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
													whomquestwillbe = object.get("Next Quest Giver").getAsDouble();
												} catch (IOException e) {
													e.printStackTrace();
												}
											}
											if (whomquestwillbe <= 0) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = entity.getStringUUID();
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											} else if (whomquestwillbe >= 1) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											} else if (whomquestwillbe >= 2) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											}
										}
									} else {
										{
											String _setval = "";
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.previousquestgiver4 = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
										{
											String _setval = "";
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.originalquestgiver4 = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									}
									if (((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone)
											.contains(file.getName().replace(".json", "")) == false) {
										{
											String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone + " "
													+ file.getName().replace(".json", "");
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.questsalreadydone = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									}
									if (!(questafter).equals("")) {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + questafter)), false);
									}
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), finishingSound);
										}
									}
								}
							}
						}
					}
				} else if (questingtype == 2) {
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
							entitytagtoget = object.get("Delivery Target Entity ID or Tag").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation((entitytagtoget).toLowerCase(java.util.Locale.ENGLISH)))) == true
							|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals(entitytagtoget)) {
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
								itemgiveidortag = object.get("Quest Item ID or Tag").getAsString();
								questitemcount = object.get("Quest Item Count").getAsDouble();
								questafter = object.get("Quest After Finishing Text").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						questafter = questafter.replace("<playername>", sourceentity.getDisplayName().getString());
						if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
							if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation((itemgiveidortag).toLowerCase(java.util.Locale.ENGLISH)))
									|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation((itemgiveidortag).toLowerCase(java.util.Locale.ENGLISH)))) == true) {
								if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= questitemcount) {
									(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink((int) questitemcount);
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
											RewardItem = object.get("Quest Reward Item ID").getAsString();
											nextquestid = object.get("Next Quest ID").getAsString();
											rewardcommand = object.get("Quest Reward Command").getAsString();
											reputationgive = object.get("Quest Reputation Reward").getAsDouble();
											whotogivereputation = object.get("Quest Reputation Source").getAsDouble();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									if (!(RewardItem).equals("")) {
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
												minammount = object.get("Quest Reward Min Give Amount").getAsDouble();
												maxammount = object.get("Quest Reward Max Give Amount").getAsDouble();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										if (sourceentity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((RewardItem).toLowerCase(java.util.Locale.ENGLISH)))).copy();
											_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), minammount, maxammount));
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
									}
									if (!(rewardcommand).equals("")) {
										rewardcommand = rewardcommand.replace("<delivery_id>", entity.getStringUUID());
										rewardcommand = rewardcommand.replace("<entity_id>",
												(sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestgivenby);
										rewardcommand = rewardcommand.replace("<player_id>", sourceentity.getStringUUID());
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
												mincommandam = object.get("Quest Reward Min Command Execution").getAsDouble();
												maxcommandam = object.get("Quest Reward Max Command Execution").getAsDouble();
												executiontype = object.get("Quest Reward Command Execution Type").getAsDouble();
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
										if (executiontype <= 0) {
											for (int index3 = 0; index3 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index3++) {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), rewardcommand);
											}
										} else if (executiontype == 1) {
											for (int index4 = 0; index4 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index4++) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
													}
												}
											}
										} else if (executiontype >= 2) {
											for (int index5 = 0; index5 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index5++) {
												{
													Entity _ent = sourceentity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
																_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
													}
												}
											}
										}
									}
									if (!(reputationgive == 0)) {
										if (whotogivereputation <= 0) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease @s " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd @s " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										} else if (whotogivereputation == 1) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										} else if (whotogivereputation >= 2) {
											if (reputationgive < 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationsdecrease "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
													}
												}
											} else if (reputationgive > 0) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd "
																		+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4
																		+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
													}
												}
											}
										}
									}
									{
										String _setval = "";
										sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquestid = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
									{
										String _setval = "";
										sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquestgivenby = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
									if (!(nextquestid).equals("")) {
										testfile = new File(
												(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
														+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
												File.separator + (nextquestid + ".json"));
										if (testfile.exists() == false) {
											testfile = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"), File.separator + (nextquestid + ".json"));
										}
										if (testfile.exists() == true) {
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
													whomquestwillbe = object.get("Next Quest Giver").getAsDouble();
												} catch (IOException e) {
													e.printStackTrace();
												}
											}
											if (whomquestwillbe <= 0) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = entity.getStringUUID();
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											} else if (whomquestwillbe >= 1) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											} else if (whomquestwillbe >= 2) {
												{
													String _setval = nextquestid;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestid = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
												{
													String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4;
													sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.fourthquestgivenby = _setval;
														capability.syncPlayerVariables(sourceentity);
													});
												}
											}
										}
									} else {
										{
											String _setval = "";
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.previousquestgiver4 = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
										{
											String _setval = "";
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.originalquestgiver4 = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									}
									if (((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone)
											.contains(file.getName().replace(".json", "")) == false) {
										{
											String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone + " "
													+ file.getName().replace(".json", "");
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.questsalreadydone = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									}
									if (!(questafter).equals("")) {
										if (sourceentity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + questafter)), false);
									}
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), finishingSound);
										}
									}
								}
							}
						}
					}
				} else if (questingtype == 3) {
					if (((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestgivenby).equals(entity.getStringUUID())) {
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
								entitytagtoget = object.get("Kill Target Entity ID or Tag").getAsString();
								killcounting = object.get("Kill count").getAsDouble();
								questafter = object.get("Quest After Finishing Text").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						questafter = questafter.replace("<playername>", sourceentity.getDisplayName().getString());
						alreadykilled = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest4;
						if (alreadykilled >= killcounting) {
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
									RewardItem = object.get("Quest Reward Item ID").getAsString();
									nextquestid = object.get("Next Quest ID").getAsString();
									rewardcommand = object.get("Quest Reward Command").getAsString();
									reputationgive = object.get("Quest Reputation Reward").getAsDouble();
									whotogivereputation = object.get("Quest Reputation Source").getAsDouble();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if (!(RewardItem).equals("")) {
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
										minammount = object.get("Quest Reward Min Give Amount").getAsDouble();
										maxammount = object.get("Quest Reward Max Give Amount").getAsDouble();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								if (sourceentity instanceof Player _player) {
									ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((RewardItem).toLowerCase(java.util.Locale.ENGLISH)))).copy();
									_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), minammount, maxammount));
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}
							if (!(rewardcommand).equals("")) {
								rewardcommand = rewardcommand.replace("<entity_id>", entity.getStringUUID());
								rewardcommand = rewardcommand.replace("<player_id>", sourceentity.getStringUUID());
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
										mincommandam = object.get("Quest Reward Min Command Execution").getAsDouble();
										maxcommandam = object.get("Quest Reward Max Command Execution").getAsDouble();
										executiontype = object.get("Quest Reward Command Execution Type").getAsDouble();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								if (executiontype <= 0) {
									for (int index6 = 0; index6 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index6++) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), rewardcommand);
									}
								} else if (executiontype == 1) {
									for (int index7 = 0; index7 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index7++) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
											}
										}
									}
								} else if (executiontype >= 2) {
									for (int index8 = 0; index8 < (int) Mth.nextDouble(RandomSource.create(), mincommandam, maxcommandam); index8++) {
										{
											Entity _ent = sourceentity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), rewardcommand);
											}
										}
									}
								}
							}
							if (!(reputationgive == 0)) {
								if (whotogivereputation <= 0) {
									if (reputationgive < 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("reputationsdecrease @s " + sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
											}
										}
									} else if (reputationgive > 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands()
														.performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("reputationadd @s " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
											}
										}
									}
								} else if (whotogivereputation == 1) {
									if (reputationgive < 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("reputationsdecrease "
																+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4 + " "
																+ sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
											}
										}
									} else if (reputationgive > 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("reputationadd " + (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4
																+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
											}
										}
									}
								} else if (whotogivereputation >= 2) {
									if (reputationgive < 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("reputationsdecrease "
																+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4 + " "
																+ sourceentity.getStringUUID() + " " + (new java.text.DecimalFormat("##").format(reputationgive)).replace("-", "")));
											}
										}
									} else if (reputationgive > 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("reputationadd " + (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4
																+ " " + sourceentity.getStringUUID() + " " + new java.text.DecimalFormat("##").format(reputationgive)));
											}
										}
									}
								}
							}
							{
								double _setval = 0;
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountingquest4 = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "";
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest4 = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "";
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.fourthquestid = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestgivenby;
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.previousquestgiver4 = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "";
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.fourthquestgivenby = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							if (!(nextquestid).equals("")) {
								testfile = new File(
										(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
												+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
										File.separator + (nextquestid + ".json"));
								if (testfile.exists() == false) {
									testfile = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"), File.separator + (nextquestid + ".json"));
								}
								if (testfile.exists() == true) {
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
											whomquestwillbe = object.get("Next Quest Giver").getAsDouble();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									if (whomquestwillbe <= 0) {
										{
											String _setval = nextquestid;
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestid = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
										{
											String _setval = entity.getStringUUID();
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestgivenby = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									} else if (whomquestwillbe >= 1) {
										{
											String _setval = nextquestid;
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestid = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
										{
											String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).previousquestgiver4;
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestgivenby = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									} else if (whomquestwillbe >= 2) {
										{
											String _setval = nextquestid;
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestid = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
										{
											String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).originalquestgiver4;
											sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.fourthquestgivenby = _setval;
												capability.syncPlayerVariables(sourceentity);
											});
										}
									}
								}
							} else {
								{
									String _setval = "";
									sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.previousquestgiver4 = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "";
									sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.originalquestgiver4 = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
							if (((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone)
									.contains(file.getName().replace(".json", "")) == false) {
								{
									String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone + " "
											+ file.getName().replace(".json", "");
									sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questsalreadydone = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
							if (!(questafter).equals("")) {
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("<" + entity.getDisplayName().getString() + "> " + questafter)), false);
							}
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), finishingSound);
								}
							}
						}
					}
				}
			}
		}
	}
}
