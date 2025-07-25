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
public class GenerateDeliveryQuestProcedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/eng"), File.separator + "chernobog_elder_delivery.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Quest name", "Shard of the Abyss");
			object.addProperty("Text Line", "Chernobog gives you an Umbral Crystal. Deliver it to the Elder\u2014the robed conjurer who commands fangs and phantoms. He\u2019llknow what to do.");
			object.addProperty("Quest After Finishing Text", "");
			object.addProperty("Quest Finishing Sound", "playsound minecraft:entity.pillager.celebrate hostile @s ~ ~ ~ 1 0.9");
			object.addProperty("Quest Type", 2);
			object.addProperty("Delivery Target Entity ID or Tag", "minecraft:evoker");
			object.addProperty("Quest Item ID or Tag", "rituals_of_the_wilds:umbral_crystal");
			object.addProperty("Quest Item Count", 1);
			object.addProperty("Quest Reward Item ID", "rituals_of_the_wilds:honey_stones");
			object.addProperty("Quest Reward Min Give Amount", 8);
			object.addProperty("Quest Reward Max Give Amount", 8);
			object.addProperty("Quest Reward Command", "");
			object.addProperty("Quest Reward Command Execution Type", 0);
			object.addProperty("Quest Reward Min Command Execution", 1);
			object.addProperty("Quest Reward Max Command Execution", 1);
			object.addProperty("Quest Reputation Reward", 3);
			object.addProperty("Quest Reputation Source", 2);
			object.addProperty("Next Quest ID", "chernobog_honey_stone_delivery");
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
