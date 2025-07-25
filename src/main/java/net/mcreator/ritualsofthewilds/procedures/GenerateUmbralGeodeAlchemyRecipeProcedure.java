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
public class GenerateUmbralGeodeAlchemyRecipeProcedure {
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
		if (RitualsOfTheWildsConfigConfiguration.ALCHEMYCAULDRONRECIPESREGEN.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/eng"), File.separator + "3alchemyrecipe.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			object.addProperty("May Spawn In Alchemy Scroll", true);
			object.addProperty("Must Read Scroll First", true);
			object.addProperty("Name for Alchemy Scroll", "Alchemy Recipe: Umbral Geode");
			object.addProperty("Moon Stage Needed", true);
			object.addProperty("Moon Stage", 0);
			object.addProperty("Runes on cauldron needed", false);
			object.addProperty("Cauldron Fill Type", 0);
			object.addProperty("Check for blocks around", false);
			object.addProperty("Remove blocks when used", false);
			object.addProperty("Block X-3 ID Or Tag", "");
			object.addProperty("Block X+3 ID Or Tag", "");
			object.addProperty("Block Z-3 ID Or Tag", "");
			object.addProperty("Block Z+3 ID Or Tag", "");
			object.addProperty("Block X+2 Z+2 ID Or Tag", "");
			object.addProperty("Block X+2 Z-2 ID Or Tag", "");
			object.addProperty("Block X-2 Z+2 ID Or Tag", "");
			object.addProperty("Block X-2 Z-2 ID Or Tag", "");
			object.addProperty("Remove Type", 1);
			object.addProperty("Replacement Block X-3 ID", "");
			object.addProperty("Replacement Block X+3 ID", "");
			object.addProperty("Replacement Block Z-3 ID", "");
			object.addProperty("Replacement Block Z+3 ID", "");
			object.addProperty("Replacement Block X+2 Z+2 ID", "");
			object.addProperty("Replacement Block X-2 Z+2 ID", "");
			object.addProperty("Replacement Block X+2 Z-2 ID", "");
			object.addProperty("Replacement Block X-2 Z-2 ID", "");
			object.addProperty("Check for Blocks +2Y(Only works with Check for blocks around true)", false);
			object.addProperty("Remove upper blocks when used", false);
			object.addProperty("Block X-3 Y+2 ID Or Tag", "");
			object.addProperty("Block X+3 Y+2 ID Or Tag", "");
			object.addProperty("Block Y+2 Z-3 ID Or Tag", "");
			object.addProperty("Block Y+2 Z+3 ID Or Tag", "");
			object.addProperty("Block X-2 Y+2 Z-2 ID Or Tag", "");
			object.addProperty("Block X+2 Y+2 Z+2 ID Or Tag", "");
			object.addProperty("Block X-2 Y+2 Z+2 ID Or Tag", "");
			object.addProperty("Block X+2 Y+2 Z-2 ID Or Tag", "");
			object.addProperty("Remove Upper Type", 1);
			object.addProperty("Replacement Block X-3 Y+2 ID", "");
			object.addProperty("Replacement Block X+3 Y+2 ID", "");
			object.addProperty("Replacement Block Y+2 Z-3 ID", "");
			object.addProperty("Replacement Block Y+2 Z+3 ID", "");
			object.addProperty("Replacement Block X+2 Y+2 Z+2 ID", "");
			object.addProperty("Replacement Block X-2 Y+2 Z+2 ID", "");
			object.addProperty("Replacement Block X+2 Y+2 Z-2 ID", "");
			object.addProperty("Replacement Block X-2 Y+2 Z-2 ID", "");
			object.addProperty("Ingredient ID or Tag 1", "forge:black_dye");
			object.addProperty("Ingredient ID or Tag 2", "forge:black_dye");
			object.addProperty("Ingredient ID or Tag 3", "forge:black_dye");
			object.addProperty("Ingredient ID or Tag 4", "forge:black_dye");
			object.addProperty("Ingredient ID or Tag 5", "forge:stones_can_be_turned_into_geode");
			object.addProperty("Ingredient ID or Tag 6", "forge:stones_can_be_turned_into_geode");
			object.addProperty("Ingredient ID or Tag 7", "forge:stones_can_be_turned_into_geode");
			object.addProperty("Ingredient ID or Tag 8", "forge:stones_can_be_turned_into_geode");
			object.addProperty("Ingredient ID or Tag 9", "");
			object.addProperty("Ingredient ID or Tag 10", "");
			object.addProperty("Execute Command Instead of Giving Item", false);
			object.addProperty("Result item ID", "rituals_of_the_wilds:umbral_geode");
			object.addProperty("Min/Fixed result item give count", 1);
			object.addProperty("Max result item give count", 1);
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
