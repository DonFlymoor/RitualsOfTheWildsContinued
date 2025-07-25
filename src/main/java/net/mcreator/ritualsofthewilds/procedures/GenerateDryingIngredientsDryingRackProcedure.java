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
import java.io.BufferedWriter;

@Mod.EventBusSubscriber
public class GenerateDryingIngredientsDryingRackProcedure {
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
		if (RitualsOfTheWildsConfigConfiguration.AUTOREGENINGREDIENTSTAB.get() == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "drying_rack_ingredients.json");
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				FileWriter filewriter = new FileWriter(file, false);
				BufferedWriter filebw = new BufferedWriter(filewriter);
				{
					filebw.write("rituals_of_the_wilds:blood_fern");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dream_vine");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:ember_leaf_berry");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:ethergrass");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:frost_moss");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:moonpetal");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:spiritbloom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:suns_tear");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:thornbloom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:voidroot");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:witchthorn");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:mistcap_mushroom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:aether_blob");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:honeycomb");
					filebw.newLine();
				}
				filebw.close();
				filewriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
