package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class SecondAnswerQuestNeededProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		String questneeded = "";
		String allquests = "";
		double thingtodo = 0;
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
					questneeded = object.get("Second Answer Quest Requirement").getAsString();
					thingtodo = object.get("Second Answer Quest Requirement State").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			allquests = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone;
			if (!(questneeded).equals("")) {
				if (thingtodo <= 0) {
					if (allquests.contains(questneeded) == true) {
						return true;
					} else {
						return false;
					}
				} else if (thingtodo == 1) {
					if (allquests.contains(questneeded) == true) {
						return false;
					} else {
						return true;
					}
				} else if (thingtodo == 2) {
					if (allquests.contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).contains(questneeded) == true) {
						return true;
					} else {
						return false;
					}
				} else if (thingtodo == 3) {
					if (allquests.contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).contains(questneeded) == true) {
						return false;
					} else {
						return true;
					}
				} else if (thingtodo == 4) {
					if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).contains(questneeded) == true) {
						return true;
					} else {
						return false;
					}
				} else if (thingtodo >= 5) {
					if (((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).contains(questneeded) == true
							|| ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).contains(questneeded) == true) {
						return false;
					} else {
						return true;
					}
				}
			} else {
				return true;
			}
		}
		return false;
	}
}
