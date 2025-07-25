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
public class GenerateQuest7Procedure {
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
		if (RitualsOfTheWildsConfigConfiguration.AUTOREGENQUESTS.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/eng"), File.separator + "chernobog_null_heart.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Quest name", "Heart Beneath Dust");
			object.addProperty("Text Line", "A Null Heart lies in a buried shrine, sealed and forgotten. Retrieve it for Chernobog\u2014its silence holds the echo of ancient voidbound power.");
			object.addProperty("Quest After Finishing Text", "So\u2026 the Null Heart stirs once more. Even buried in silence, it remembers. You have done well, mortal. With this, the void breathes deeper. Here take this.");
			object.addProperty("Quest Finishing Sound", "playsound minecraft:entity.evoker.prepare_attack neutral @s ~ ~ ~ 1 0.5");
			object.addProperty("Quest Type", 1);
			object.addProperty("Quest Item ID or Tag", "rituals_of_the_wilds:null_heart");
			object.addProperty("Quest Item Count", 1);
			object.addProperty("Quest Reward Item ID", "rituals_of_the_wilds:ritual_dagger");
			object.addProperty("Quest Reward Min Give Amount", 1);
			object.addProperty("Quest Reward Max Give Amount", 1);
			object.addProperty("Quest Reward Command", "");
			object.addProperty("Quest Reward Command Execution Type", 0);
			object.addProperty("Quest Reward Min Command Execution", 1);
			object.addProperty("Quest Reward Max Command Execution", 1);
			object.addProperty("Quest Reputation Reward", 10);
			object.addProperty("Quest Reputation Source", 0);
			object.addProperty("Next Quest ID", "");
			object.addProperty("Next Quest Giver", 0);
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
