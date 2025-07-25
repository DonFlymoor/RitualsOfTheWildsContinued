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
public class GenerateKillQuest2Procedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/eng"), File.separator + "chernobog_vex_kill_quest.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Quest name", "Silence the Screaming");
			object.addProperty("Text Line", "The Vexes shriek through realms unseen. Slay 32 of these cursed spirits, and prove to Chernobog that even chaos can be bound by shadow.");
			object.addProperty("Quest After Finishing Text", "");
			object.addProperty("Quest Finishing Sound", "playsound minecraft:entity.evoker.prepare_attack neutral @s ~ ~ ~ 1 0.5");
			object.addProperty("Quest Type", 3);
			object.addProperty("Kill Target Entity ID or Tag", "minecraft:vex");
			object.addProperty("Kill count", 32);
			object.addProperty("Quest Reward Item ID", "");
			object.addProperty("Quest Reward Min Give Amount", 1);
			object.addProperty("Quest Reward Max Give Amount", 1);
			object.addProperty("Quest Reward Command", "");
			object.addProperty("Quest Reward Command Execution Type", 0);
			object.addProperty("Quest Reward Min Command Execution", 1);
			object.addProperty("Quest Reward Max Command Execution", 1);
			object.addProperty("Quest Reputation Reward", 5);
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
