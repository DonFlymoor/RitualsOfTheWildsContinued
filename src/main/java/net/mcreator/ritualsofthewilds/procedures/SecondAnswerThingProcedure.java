package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class SecondAnswerThingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		boolean playerthingornot = false;
		double checkingfile = 0;
		double nextdialogue = 0;
		double commandtryingplayering = 0;
		String commandthatexecute = "";
		String soundcommand = "";
		String questgive = "";
		file = new File(
				(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
						+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
				File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).filename));
		if (file.exists() == false) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
					File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).filename));
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
					soundcommand = object.get("Second Answer Sound").getAsString();
					commandthatexecute = object.get("Second Answer Result Command").getAsString();
					commandtryingplayering = object.get("Second Answer Result Command Player, World or Entity Executed").getAsDouble();
					nextdialogue = object.get("Second Answer Result Dialogue Number").getAsDouble();
					questgive = object.get("Second Answer Result Quest Give ID").getAsString();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!(commandthatexecute).equals("")) {
				commandthatexecute = commandthatexecute.replace("<player_id>", entity.getStringUUID());
				commandthatexecute = commandthatexecute.replace("<entity_id>", (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid);
				if (commandtryingplayering <= 0) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), commandthatexecute);
						}
					}
				} else if (commandtryingplayering == 1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								commandthatexecute);
				} else if (commandtryingplayering >= 2) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as " + (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid + " run " + commandthatexecute));
				}
			}
			if (!(questgive).equals("")) {
				if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
					{
						String _setval = questgive;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquestid = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firstquestgivenby = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.previousquestgiver1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.originalquestgiver1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
						{
							String _setval = questgive;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.secondquestid = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.secondquestgivenby = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.previousquestgiver2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.originalquestgiver2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
							{
								String _setval = questgive;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.thirdquestid = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.thirdquestgivenby = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.previousquestgiver3 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.originalquestgiver3 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
								{
									String _setval = questgive;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.fourthquestid = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.fourthquestgivenby = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.previousquestgiver4 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.originalquestgiver4 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
									{
										String _setval = questgive;
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquestid = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.fifthquesttextline = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.previousquestgiver5 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_uuid;
										entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.originalquestgiver5 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
					}
				}
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FirstLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SecondLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ThirdLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FourthLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FifthLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SixthLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SeventhLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EightLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NineLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TenthLineText = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FirstAnswear = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SecondAnswear = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ThirdAnswear = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "";
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FourthAnswear = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (nextdialogue > 0) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(nextdialogue) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(nextdialogue) + ".json"));
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
							if ((object.get("Text Line").getAsString()).length() >= 0 && (object.get("Text Line").getAsString()).length() >= 75) {
								{
									String _setval = object.get("Text Line").getAsString().substring(0, 75);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FirstLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 0) {
								{
									String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FirstLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
								{
									String _setval = object.get("Text Line").getAsString().substring(75, 150);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SecondLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 75) {
								{
									String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SecondLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
								{
									String _setval = object.get("Text Line").getAsString().substring(150, 225);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ThirdLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 150) {
								{
									String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ThirdLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
								{
									String _setval = object.get("Text Line").getAsString().substring(225, 300);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FourthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 225) {
								{
									String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FourthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
								{
									String _setval = object.get("Text Line").getAsString().substring(300, 375);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FifthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 300) {
								{
									String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.FifthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
								{
									String _setval = object.get("Text Line").getAsString().substring(375, 450);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SixthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 375) {
								{
									String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SixthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
								{
									String _setval = object.get("Text Line").getAsString().substring(450, 525);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SeventhLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 450) {
								{
									String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SeventhLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
								{
									String _setval = object.get("Text Line").getAsString().substring(525, 600);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.EightLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 525) {
								{
									String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.EightLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
								{
									String _setval = object.get("Text Line").getAsString().substring(600, 675);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.NineLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 600) {
								{
									String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.NineLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
								{
									String _setval = object.get("Text Line").getAsString().substring(675, 750);
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.TenthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((object.get("Text Line").getAsString()).length() >= 675) {
								{
									String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.TenthLineText = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								String _setval = object.get("First Answer Text Line").getAsString();
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstAnswear = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = object.get("Second Answer Text Line").getAsString();
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondAnswear = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = object.get("Third Answer Text Line").getAsString();
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdAnswear = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = object.get("Fourth Answer Text Line").getAsString();
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthAnswear = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(nextdialogue) + ".json";
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.filename = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), soundcommand);
				}
			}
		}
	}
}
