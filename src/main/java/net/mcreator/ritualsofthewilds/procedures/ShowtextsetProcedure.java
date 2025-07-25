package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class ShowtextsetProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		double nextdialogue = 0;
		double questtypeing = 0;
		if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).showquests == true) {
			if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 0) {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
					file = new File(
							(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
									+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid + ".json"));
					if (file.exists() == false) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
								File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid + ".json"));
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
								{
									String _setval = object.get("Quest name").getAsString();
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).quest_name).replace("<playername>",
											entity.getDisplayName().getString());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								questtypeing = object.get("Quest Type").getAsDouble();
								if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, 30);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 0) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 30 && (object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, 60);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 60 && (object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, 90);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 90 && (object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, 120);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 120 && (object.get("Text Line").getAsString()).length() >= 150) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, 150);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (questtypeing == 3) {
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
									{
										String _setval = object.get("Kill Target Entity ID or Tag").getAsString();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.whokillquest1 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = object.get("Kill count").getAsDouble();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.killstoshow = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							{
								double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest1;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								String _setval = "";
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killstoshow = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else {
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.quest_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.secondquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.thirdquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fourthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fifthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.whokillquest1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountleft1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killstoshow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 1) {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
					file = new File(
							(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
									+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid + ".json"));
					if (file.exists() == false) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
								File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid + ".json"));
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
								{
									String _setval = object.get("Quest name").getAsString();
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).quest_name).replace("<playername>",
											entity.getDisplayName().getString());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, 30);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 0) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 30 && (object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, 60);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 60 && (object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, 90);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 90 && (object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, 120);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 120 && (object.get("Text Line").getAsString()).length() >= 150) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, 150);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								questtypeing = object.get("Quest Type").getAsDouble();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (questtypeing == 3) {
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
									{
										String _setval = object.get("Kill Target Entity ID or Tag").getAsString();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.whokillquest2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = object.get("Kill count").getAsDouble();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.killstoshow = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							{
								double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest2;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								String _setval = "";
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killstoshow = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else {
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.quest_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.secondquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.thirdquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fourthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fifthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.whokillquest2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountleft1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killstoshow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 2) {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
					file = new File(
							(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
									+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid + ".json"));
					if (file.exists() == false) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
								File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid + ".json"));
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
								{
									String _setval = object.get("Quest name").getAsString();
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).quest_name).replace("<playername>",
											entity.getDisplayName().getString());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, 30);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 0) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 30 && (object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, 60);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 60 && (object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, 90);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 90 && (object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, 120);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 120 && (object.get("Text Line").getAsString()).length() >= 150) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, 150);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								questtypeing = object.get("Quest Type").getAsDouble();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (questtypeing == 3) {
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
									{
										String _setval = object.get("Kill Target Entity ID or Tag").getAsString();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.whokillquest3 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = object.get("Kill count").getAsDouble();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.killstoshow = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							{
								double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest3;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								String _setval = "";
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest3 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killstoshow = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else {
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.quest_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.secondquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.thirdquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fourthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fifthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.whokillquest3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountleft1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killstoshow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 3) {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
					file = new File(
							(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
									+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid + ".json"));
					if (file.exists() == false) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
								File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid + ".json"));
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
								{
									String _setval = object.get("Quest name").getAsString();
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).quest_name).replace("<playername>",
											entity.getDisplayName().getString());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, 30);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 0) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 30 && (object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, 60);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 60 && (object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, 90);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 90 && (object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, 120);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 120 && (object.get("Text Line").getAsString()).length() >= 150) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, 150);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								questtypeing = object.get("Quest Type").getAsDouble();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (questtypeing == 3) {
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
									{
										String _setval = object.get("Kill Target Entity ID or Tag").getAsString();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.whokillquest4 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = object.get("Kill count").getAsDouble();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.killstoshow = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							{
								double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest4;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								String _setval = "";
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest4 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killstoshow = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else {
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.quest_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.secondquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.thirdquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fourthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fifthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.whokillquest4 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest4 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountleft1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killstoshow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing >= 4) {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
					file = new File(
							(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/"
									+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid + ".json"));
					if (file.exists() == false) {
						file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"),
								File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid + ".json"));
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
								{
									String _setval = object.get("Quest name").getAsString();
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).quest_name).replace("<playername>",
											entity.getDisplayName().getString());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.quest_name = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, 30);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 0) {
									{
										String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.firstquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 30 && (object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, 60);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 30) {
									{
										String _setval = object.get("Text Line").getAsString().substring(30, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.secondquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 60 && (object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, 90);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 60) {
									{
										String _setval = object.get("Text Line").getAsString().substring(60, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.thirdquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 90 && (object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, 120);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 90) {
									{
										String _setval = object.get("Text Line").getAsString().substring(90, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fourthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if ((object.get("Text Line").getAsString()).length() >= 120 && (object.get("Text Line").getAsString()).length() >= 150) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, 150);
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((object.get("Text Line").getAsString()).length() >= 120) {
									{
										String _setval = object.get("Text Line").getAsString().substring(120, (int) (object.get("Text Line").getAsString()).length());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquesttextline).replace("<playername>",
												entity.getDisplayName().getString());
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									{
										String _setval = "";
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								questtypeing = object.get("Quest Type").getAsDouble();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (questtypeing == 3) {
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
									{
										String _setval = object.get("Kill Target Entity ID or Tag").getAsString();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.whokillquest5 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = object.get("Kill count").getAsDouble();
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.killstoshow = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							{
								double _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest5;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								String _setval = "";
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.whokillquest5 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killcountleft1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 0;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.killstoshow = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else {
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.quest_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.secondquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.thirdquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fourthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fifthquesttextline = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.whokillquest5 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest5 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountleft1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killstoshow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
