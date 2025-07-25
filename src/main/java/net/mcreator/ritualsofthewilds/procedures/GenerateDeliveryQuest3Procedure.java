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
public class GenerateDeliveryQuest3Procedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/eng"), File.separator + "leshy_sheep_feed_delivery.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Quest name", "Feed the Woolen Ones");
			object.addProperty("Text Line", "The sheep grow restless. Bring 8 hay bales to calm their spirits. Leshy watches how you treat the meek\u2014nature remembers every kindness.");
			object.addProperty("Quest After Finishing Text", "They spoke of you. Not in words \u2014 in warmth. The cows in the southern meadow... they wait now. Bring 12 hay bales.");
			object.addProperty("Quest Finishing Sound", "");
			object.addProperty("Quest Type", 2);
			object.addProperty("Delivery Target Entity ID or Tag", "minecraft:sheep");
			object.addProperty("Quest Item ID or Tag", "minecraft:hay_block");
			object.addProperty("Quest Item Count", 8);
			object.addProperty("Quest Reward Item ID", "rituals_of_the_wilds:honey_stones");
			object.addProperty("Quest Reward Min Give Amount", 1);
			object.addProperty("Quest Reward Max Give Amount", 4);
			object.addProperty("Quest Reward Command", "");
			object.addProperty("Quest Reward Command Execution Type", 0);
			object.addProperty("Quest Reward Min Command Execution", 1);
			object.addProperty("Quest Reward Max Command Execution", 1);
			object.addProperty("Quest Reputation Reward", 0);
			object.addProperty("Quest Reputation Source", 0);
			object.addProperty("Next Quest ID", "leshy_cow_feed_delivery");
			object.addProperty("Next Quest Giver", 2);
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
