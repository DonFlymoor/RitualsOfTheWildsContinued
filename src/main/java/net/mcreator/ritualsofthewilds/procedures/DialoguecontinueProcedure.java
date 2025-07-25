package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.world.inventory.TalkingMenu;
import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

public class DialoguecontinueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		File file = new File("");
		boolean reputationfirstthing = false;
		double neutralreputation = 0;
		double normalreputation = 0;
		double Highreputation = 0;
		double badreputaiton = 0;
		double goodreputation = 0;
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		file = new File(
				(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
						+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
				File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
						+ new java.text.DecimalFormat("##").format(1) + ".json"));
		if (file.exists() == false) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
					File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(1) + ".json"));
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
					badreputaiton = object.get("Bad Reputation").getAsDouble();
					neutralreputation = object.get("Neutral Reputation").getAsDouble();
					normalreputation = object.get("Normal Reputation").getAsDouble();
					goodreputation = object.get("Good Reputation").getAsDouble();
					Highreputation = object.get("High Reputation").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) <= badreputaiton
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation)
					|| entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= badreputaiton
							&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation)
							&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation)
							&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation)
							&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation)) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(1) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(1) + ".json"));
				}
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
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 0) {
							{
								String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, 150);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 75) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, 225);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, 300);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, 375);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, 450);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, 525);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, 600);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, 675);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, 750);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						{
							String _setval = object.get("First Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Second Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Third Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Fourth Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(1) + ".json";
					sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.filename = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Talking");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TalkingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= badreputaiton
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation)) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(2) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(2) + ".json"));
				}
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
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 0) {
							{
								String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, 150);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 75) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, 225);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, 300);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, 375);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, 450);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, 525);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, 600);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, 675);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, 750);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						{
							String _setval = object.get("First Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Second Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Third Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Fourth Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(2) + ".json";
					sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.filename = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Talking");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TalkingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= badreputaiton
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation)
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation)) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(3) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(3) + ".json"));
				}
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
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 0) {
							{
								String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, 150);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 75) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, 225);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, 300);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, 375);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, 450);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, 525);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, 600);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, 675);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, 750);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						{
							String _setval = object.get("First Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Second Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Third Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Fourth Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(3) + ".json";
					sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.filename = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Talking");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TalkingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= badreputaiton
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation
					&& !(entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation)) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(4) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(4) + ".json"));
				}
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
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 0) {
							{
								String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, 150);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 75) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, 225);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, 300);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, 375);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, 450);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, 525);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, 600);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, 675);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, 750);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						{
							String _setval = object.get("First Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Second Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Third Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Fourth Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(4) + ".json";
					sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.filename = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Talking");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TalkingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= badreputaiton
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= neutralreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= normalreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= goodreputation
					&& entity.getPersistentData().getDouble(("dialogue_reputation_with_" + sourceentity.getStringUUID())) >= Highreputation) {
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/"
								+ (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
								+ new java.text.DecimalFormat("##").format(5) + ".json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/" + "eng"),
							File.separator + ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
									+ new java.text.DecimalFormat("##").format(5) + ".json"));
				}
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
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 0) {
							{
								String _setval = object.get("Text Line").getAsString().substring(0, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FirstLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 75 && (object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, 150);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 75) {
							{
								String _setval = object.get("Text Line").getAsString().substring(75, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SecondLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 150 && (object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, 225);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 150) {
							{
								String _setval = object.get("Text Line").getAsString().substring(150, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ThirdLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 225 && (object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, 300);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 225) {
							{
								String _setval = object.get("Text Line").getAsString().substring(225, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FourthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 300 && (object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, 375);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FifthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 300) {
							{
								String _setval = object.get("Text Line").getAsString().substring(300, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.FifthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 375 && (object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, 450);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SixthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 375) {
							{
								String _setval = object.get("Text Line").getAsString().substring(375, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SixthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 450 && (object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, 525);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SeventhLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 450) {
							{
								String _setval = object.get("Text Line").getAsString().substring(450, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SeventhLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 525 && (object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, 600);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).EightLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 525) {
							{
								String _setval = object.get("Text Line").getAsString().substring(525, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EightLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 600 && (object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, 675);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).NineLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 600) {
							{
								String _setval = object.get("Text Line").getAsString().substring(600, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.NineLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						if ((object.get("Text Line").getAsString()).length() >= 675 && (object.get("Text Line").getAsString()).length() >= 750) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, 750);
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<playername>",
										sourceentity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).TenthLineText).replace("<entityname>",
										entity.getDisplayName().getString());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if ((object.get("Text Line").getAsString()).length() >= 675) {
							{
								String _setval = object.get("Text Line").getAsString().substring(675, (int) (object.get("Text Line").getAsString()).length());
								sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TenthLineText = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
						{
							String _setval = object.get("First Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FirstAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Second Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).SecondAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SecondAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Third Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ThirdAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ThirdAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = object.get("Fourth Answer Text Line").getAsString();
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<playername>",
									sourceentity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							String _setval = ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).FourthAnswear).replace("<entityname>",
									entity.getDisplayName().getString());
							sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FourthAnswear = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to_id + "_"
							+ new java.text.DecimalFormat("##").format(5) + ".json";
					sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.filename = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Talking");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new TalkingMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
