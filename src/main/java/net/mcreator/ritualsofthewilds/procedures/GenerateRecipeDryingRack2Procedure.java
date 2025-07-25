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
public class GenerateRecipeDryingRack2Procedure {
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
		if (RitualsOfTheWildsConfigConfiguration.DRYINGRACKRECIPESREGEN.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + "6dryingrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:moonpetal");
			object.addProperty("Drying Result Item ID", "rituals_of_the_wilds:dried_moonpetal");
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + "7dryingrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:spiritbloom");
			object.addProperty("Drying Result Item ID", "rituals_of_the_wilds:dried_spiritbloom");
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + "8dryingrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:suns_tear");
			object.addProperty("Drying Result Item ID", "rituals_of_the_wilds:dried_suns_tear");
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + "9dryingrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:thornbloom");
			object.addProperty("Drying Result Item ID", "rituals_of_the_wilds:dried_thornbloom");
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Drying_Rack"), File.separator + "10dryingrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID or Tag", "rituals_of_the_wilds:voidroot");
			object.addProperty("Drying Result Item ID", "rituals_of_the_wilds:dried_voidroot");
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
