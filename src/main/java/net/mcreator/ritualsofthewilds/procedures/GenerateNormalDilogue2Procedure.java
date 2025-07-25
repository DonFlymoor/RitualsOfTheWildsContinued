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
public class GenerateNormalDilogue2Procedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/dialogues/eng"), File.separator + "rituals_of_the_wilds_chernobog_32.json");
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
			object.addProperty("Text Line",
					"Need? No. But use? Perhaps. There is a place \u2014 rotten, buried beneath the weight of silence. A shrine. Dead, but still twitching. I want what festers there. Something left behind... something locked. Retrieve it, if your spine permits.");
			object.addProperty("First Answer Text Line", "\u300B What am I looking for?");
			object.addProperty("First Answer Quest Requirement", "");
			object.addProperty("First Answer Quest Requirement State", 1);
			object.addProperty("First Answer Result Dialogue Number", 0);
			object.addProperty("First Answer Result Command", "tellraw @s \"<Chernobog> A stone. Black. Warm. It hums if you hold it long enough. They called it a Null Heart. Bring it to me.\"");
			object.addProperty("First Answer Result Quest Give ID", "");
			object.addProperty("First Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("First Answer Sound", "");
			object.addProperty("Second Answer Text Line", "\u300B Sounds cursed. I\u2019m in.");
			object.addProperty("Second Answer Quest Requirement", "chernobog_null_heart");
			object.addProperty("Second Answer Quest Requirement State", 3);
			object.addProperty("Second Answer Result Dialogue Number", 0);
			object.addProperty("Second Answer Result Command", "");
			object.addProperty("Second Answer Result Quest Give ID", "chernobog_null_heart");
			object.addProperty("Second Answer Sound", "");
			object.addProperty("Second Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Third Answer Text Line", "\u300B No thanks.");
			object.addProperty("Third Answer Quest Requirement", "");
			object.addProperty("Third Answer Quest Requirement State", 1);
			object.addProperty("Third Answer Result Dialogue Number", 0);
			object.addProperty("Third Answer Result Command", "tellraw @s \"<Chernobog> Then return when your blood is more interesting.\"");
			object.addProperty("Third Answer Result Quest Give ID", "");
			object.addProperty("Third Answer Sound", "");
			object.addProperty("Third Answer Result Command Player, World or Entity Executed", 0);
			object.addProperty("Fourth Answer Text Line", "");
			object.addProperty("Fourth Answer Quest Requirement", "");
			object.addProperty("Fourth Answer Quest Requirement State", 1);
			object.addProperty("Fourth Answer Result Dialogue Number", 0);
			object.addProperty("Fourth Answer Result Command", "");
			object.addProperty("Fourth Answer Result Quest Give ID", "");
			object.addProperty("Fourth Answer Sound", "");
			object.addProperty("Fourth Answer Result Command Player, World or Entity Executed", 0);
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
