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
public class GenerateRecipeRuneScriberTable3Procedure {
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
		if (RitualsOfTheWildsConfigConfiguration.RUNESCRIBERTABLERECIPESREGENERATE.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/rune_scribing_table"),
					File.separator + (new java.text.DecimalFormat("##").format(3) + "_" + new java.text.DecimalFormat("##").format(1) + "runescribingtablerecipe.json"));
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID Or Tag", "rituals_of_the_wilds:netherrack_rune_base");
			object.addProperty("Result slot 1 item ID", "rituals_of_the_wilds:netherrack_rune_m");
			object.addProperty("Result slot 2 item ID", "rituals_of_the_wilds:netherrack_rune_c");
			object.addProperty("Result slot 3 item ID", "rituals_of_the_wilds:netherrack_rune_a");
			object.addProperty("Result slot 4 item ID", "rituals_of_the_wilds:netherrack_rune_r");
			object.addProperty("Result slot 5 item ID", "rituals_of_the_wilds:netherrack_rune_n");
			object.addProperty("Result slot 6 item ID", "rituals_of_the_wilds:netherrack_rune_k");
			object.addProperty("Result slot 7 item ID", "rituals_of_the_wilds:netherrack_rune_t");
			object.addProperty("Result slot 8 item ID", "rituals_of_the_wilds:netherrack_rune_s");
			object.addProperty("Result slot 9 item ID", "rituals_of_the_wilds:netherrack_rune_v");
			object.addProperty("Result slot 10 item ID", "rituals_of_the_wilds:netherrack_rune_b");
			object.addProperty("Result slot 11 item ID", "rituals_of_the_wilds:netherrack_rune_u");
			object.addProperty("Result slot 12 item ID", "rituals_of_the_wilds:netherrack_rune_l");
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/rune_scribing_table"),
					File.separator + (new java.text.DecimalFormat("##").format(3) + "_" + new java.text.DecimalFormat("##").format(2) + "runescribingtablerecipe.json"));
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("Needed Item ID Or Tag", "rituals_of_the_wilds:netherrack_rune_base");
			object.addProperty("Result slot 1 item ID", "rituals_of_the_wilds:netherrack_rune_x");
			object.addProperty("Result slot 2 item ID", "rituals_of_the_wilds:netherrack_rune_o");
			object.addProperty("Result slot 3 item ID", "rituals_of_the_wilds:netherrack_rune_d");
			object.addProperty("Result slot 4 item ID", "rituals_of_the_wilds:netherrack_rune_p");
			object.addProperty("Result slot 5 item ID", "rituals_of_the_wilds:netherrack_rune_e");
			object.addProperty("Result slot 6 item ID", "rituals_of_the_wilds:netherrack_rune_i");
			object.addProperty("Result slot 7 item ID", "");
			object.addProperty("Result slot 8 item ID", "");
			object.addProperty("Result slot 9 item ID", "");
			object.addProperty("Result slot 10 item ID", "");
			object.addProperty("Result slot 11 item ID", "");
			object.addProperty("Result slot 12 item ID", "");
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
