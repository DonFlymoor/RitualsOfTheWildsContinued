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
public class GenerateRecipeFumeExtractorProcedure {
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
		if (RitualsOfTheWildsConfigConfiguration.FUMEEXTRACTORRECIPESREGENERATE.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + "1fumeextractorrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "minecraft:poppy");
			object.addProperty("Needed Fuel ID or Tag", "rituals_of_the_wilds:fumes_bottle");
			object.addProperty("Result Item ID", "rituals_of_the_wilds:poppy_fumes");
			object.addProperty("Particles ID", "minecraft:falling_water");
			object.addProperty("Extracting time(In ticks)", 120);
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + "2fumeextractorrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "minecraft:dandelion");
			object.addProperty("Needed Fuel ID or Tag", "rituals_of_the_wilds:fumes_bottle");
			object.addProperty("Result Item ID", "rituals_of_the_wilds:dandelion_fumes");
			object.addProperty("Particles ID", "minecraft:falling_water");
			object.addProperty("Extracting time(In ticks)", 120);
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + "3fumeextractorrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "minecraft:cornflower");
			object.addProperty("Needed Fuel ID or Tag", "rituals_of_the_wilds:fumes_bottle");
			object.addProperty("Result Item ID", "rituals_of_the_wilds:corn_flower_fumes");
			object.addProperty("Particles ID", "minecraft:falling_water");
			object.addProperty("Extracting time(In ticks)", 120);
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/fume_extractor"), File.separator + "4fumeextractorrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:void_dust");
			object.addProperty("Needed Fuel ID or Tag", "rituals_of_the_wilds:old_ceramic_pot");
			object.addProperty("Result Item ID", "rituals_of_the_wilds:void_extract");
			object.addProperty("Particles ID", "minecraft:flame");
			object.addProperty("Extracting time(In ticks)", 280);
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
