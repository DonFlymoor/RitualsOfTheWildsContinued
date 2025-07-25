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
public class GenerateDialogueLeshy1Procedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/eng"), File.separator + "rituals_of_the_wilds_leshy_1.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("First dialogue Based with reputation", false);
			object.addProperty("Bad Reputation", 0);
			object.addProperty("Neutral Reputation", 0);
			object.addProperty("Normal Reputation", 0);
			object.addProperty("Good Reputation", 0);
			object.addProperty("High Reputation", 0);
			object.addProperty("Text Line", "The trees do not ask who you were. Only what you trample now. So speak, wanderer. The moss listens.");
			object.addProperty("First Answer Text Line", "\u300B What are you, really?");
			object.addProperty("First Answer Quest Requirement", "");
			object.addProperty("First Answer Quest Requirement State", 1);
			object.addProperty("First Answer Result Dialogue Number", 0);
			object.addProperty("First Answer Result Command",
					"tellraw @s \"<Leshy> I was a god once. But the woods asked for something smaller, something quieter. So I bent. I shed teeth. I learned to grow slow. I am not ruler. I am not guardian. I am what happens when the forest remembers its own name.\"");
			object.addProperty("First Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("First Answer Result Quest Give ID", "");
			object.addProperty("First Answer Sound", "");
			object.addProperty("Second Answer Text Line", "\u300B Why do you oppose Chernobog?");
			object.addProperty("Second Answer Quest Requirement", "");
			object.addProperty("Second Answer Quest Requirement State", 1);
			object.addProperty("Second Answer Result Dialogue Number", 0);
			object.addProperty("Second Answer Result Command",
					"tellraw @s \"<Leshy> Chernobog does not poison. He awakens. But the forest does not survive his truth. He unearths what should stay buried. I keep it under root and soil, where it can sleep. We are not enemies. We are necessities.\"");
			object.addProperty("Second Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Second Answer Result Quest Give ID", "");
			object.addProperty("Second Answer Sound", "");
			object.addProperty("Third Answer Text Line", "\u300B How can I help the forest?");
			object.addProperty("Third Answer Quest Requirement", "leshy_sheep_feed_delivery");
			object.addProperty("Third Answer Quest Requirement State", 3);
			object.addProperty("Third Answer Result Dialogue Number", 2);
			object.addProperty("Third Answer Result Command", "");
			object.addProperty("Third Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Third Answer Result Quest Give ID", "");
			object.addProperty("Third Answer Sound", "");
			object.addProperty("Fourth Answer Text Line", "[Listen in silence.]");
			object.addProperty("Fourth Answer Quest Requirement", "");
			object.addProperty("Fourth Answer Quest Requirement State", 1);
			object.addProperty("Fourth Answer Result Dialogue Number", 0);
			object.addProperty("Fourth Answer Result Command",
					"tellraw @s \"<Leshy> There were forests before gods. Before names. Before rot. Before hunger. We stretched beyond horizon and silence. And even as fire claimed us, and iron cut us, we grew. The forest will always grow again. Even through your bones.\"");
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
