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
public class GenerateRitualLevelOneProcedure {
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
		if (RitualsOfTheWildsConfigConfiguration.RITUALRECIPESREGENERATE.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/eng"), File.separator + "6ritual.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Ritual Name", "Entity Type Ritual: Breeding");
			object.addProperty("May Spawn In Ritual Scroll", true);
			object.addProperty("Must Read Scroll First", true);
			object.addProperty("Central Block ID or Tag", "rituals_of_the_wilds:pink_candle_glass_jar");
			object.addProperty("Offhand Item ID or Tag", "minecraft:air");
			object.addProperty("Ritual Type", 2);
			object.addProperty("Moon Stage Needed", false);
			object.addProperty("Moon Stage", 0);
			object.addProperty("Sacrifices needed", 0);
			object.addProperty("Entity Near needed", false);
			object.addProperty("Entity Near ID or Tag", "");
			object.addProperty("Weather Type needed", 0);
			object.addProperty("Ritual Difficulty Level", 1);
			object.addProperty("Block X+2 ID or Tag", "rituals_of_the_wilds:cooked_clay_rune_s_standing");
			object.addProperty("Block X-2 ID or Tag", "rituals_of_the_wilds:cooked_clay_rune_s_standing");
			object.addProperty("Block Z+2 ID or Tag", "rituals_of_the_wilds:cooked_clay_rune_e_standing");
			object.addProperty("Block Z-2 ID or Tag", "rituals_of_the_wilds:cooked_clay_rune_x_standing");
			object.addProperty("Central Block Replacment Type", 1);
			object.addProperty("Central Block Replacment ID", "minecraft:air");
			object.addProperty("Block Replacment Type", 2);
			object.addProperty("Replacment Block X+2 ID", "minecraft:air");
			object.addProperty("Replacment Block X-2 ID", "minecraft:air");
			object.addProperty("Replacment Block Z+2 ID", "minecraft:air");
			object.addProperty("Replacment Block Z-2 ID", "minecraft:air");
			object.addProperty("Fixed or Random Executions", false);
			object.addProperty("Execute as player", false);
			object.addProperty("Min/Fixed result command execution count", 1);
			object.addProperty("Max command execution count", 1);
			object.addProperty("Result command", "execute as @e[distance=..6,sort=random,nbt={InLove:0}] run data merge entity @s {InLove:600}");
			object.addProperty("Info about result", "Makes all entities in 6 block radius breed.");
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
