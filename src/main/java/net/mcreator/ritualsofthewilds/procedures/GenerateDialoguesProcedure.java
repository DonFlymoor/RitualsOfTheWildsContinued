package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.mcreator.ritualsofthewilds.configuration.RitualsOfTheWildsConfigConfiguration;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@Mod.EventBusSubscriber
public class GenerateDialoguesProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		if (RitualsOfTheWildsConfigConfiguration.AUTOREGENDIALOGUES.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/eng"), File.separator + "rituals_of_the_wilds_chernobog_1.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("First dialogue Based with reputation", true);
			object.addProperty("Bad Reputation", 10);
			object.addProperty("Neutral Reputation", 30);
			object.addProperty("Normal Reputation", 50);
			object.addProperty("Good Reputation", 75);
			object.addProperty("High Reputation", 100);
			object.addProperty("Text Line", "You stand before an echo of divinity \u2014 and you wear your mortality like a badge. Amusing.");
			object.addProperty("First Answer Text Line", "\u300B I did not come to offend. Only to learn.");
			object.addProperty("First Answer Quest Requirement", "chernobog_first_kill");
			object.addProperty("First Answer Quest Requirement State", 5);
			object.addProperty("First Answer Result Dialogue Number", 11);
			object.addProperty("First Answer Result Command", "");
			object.addProperty("First Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("First Answer Result Quest Give ID", "");
			object.addProperty("First Answer Sound", "playsound rituals_of_the_wilds:chernobog_living hostile @s ~ ~ ~ 100 0.75");
			object.addProperty("Second Answer Text Line", "\u300B You're not as terrifying as they say.");
			object.addProperty("Second Answer Quest Requirement", "");
			object.addProperty("Second Answer Quest Requirement State", 1);
			object.addProperty("Second Answer Result Dialogue Number", 0);
			object.addProperty("Second Answer Result Command", "damage @s 6 minecraft:wither by <entity_id>");
			object.addProperty("Second Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Second Answer Result Quest Give ID", "");
			object.addProperty("Second Answer Sound", "playsound rituals_of_the_wilds:chernobog_living hostile @s ~ ~ ~ 100 0.75");
			object.addProperty("Third Answer Text Line", "\u300B What are you?");
			object.addProperty("Third Answer Quest Requirement", "");
			object.addProperty("Third Answer Quest Requirement State", 1);
			object.addProperty("Third Answer Result Dialogue Number", 12);
			object.addProperty("Third Answer Result Command", "");
			object.addProperty("Third Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Third Answer Result Quest Give ID", "");
			object.addProperty("Third Answer Sound", "playsound rituals_of_the_wilds:chernobog_living hostile @s ~ ~ ~ 100 0.75");
			object.addProperty("Fourth Answer Text Line", "");
			object.addProperty("Fourth Answer Quest Requirement", "");
			object.addProperty("Fourth Answer Quest Requirement State", 1);
			object.addProperty("Fourth Answer Result Dialogue Number", 0);
			object.addProperty("Fourth Answer Result Command", "");
			object.addProperty("Fourth Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Fourth Answer Result Quest Give ID", "");
			object.addProperty("Fourth Answer Sound", "");
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(object));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
