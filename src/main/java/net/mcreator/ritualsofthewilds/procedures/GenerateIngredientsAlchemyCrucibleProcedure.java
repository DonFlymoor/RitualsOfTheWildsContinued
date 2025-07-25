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
public class GenerateIngredientsAlchemyCrucibleProcedure {
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
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds"), File.separator + "alchemy_cauldron_ingredients.json");
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
					filebw.write("minecraft:sugar");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:redstone");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:glowstone_dust");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:blaze_powder");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:nether_wart");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:fermented_spider_eye");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:magma_cream");
					filebw.newLine();
				}
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
					filebw.write("rituals_of_the_wilds:dried_blood_fern");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_dream_vine");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_ember_leaf_berry");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_ethergrass");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_frost_moss");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_mistcap_mushroom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_moonpetal");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_spiritbloom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_suns_tear");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_thornbloom");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_voidroot");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:dried_witchthorn");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:aether_blob");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:aether_crystalized");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:ender_catalyst");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:color_catalyst");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:honey_stones");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:void_opal");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:umbral_geode");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:cryorite_gem");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:white_crystal_shard");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:color_dust");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:void_ash");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:umbral_crystal");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:cryorite_powder");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:netherrack_dust");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:stabilizing_powder");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:umbral_crystal_shard");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:white_crystal_dust");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:copper_ingot");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:feather");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:iron_ingot");
					filebw.newLine();
				}
				{
					filebw.write("forge:black_dye");
					filebw.newLine();
				}
				{
					filebw.write("forge:white_dye");
					filebw.newLine();
				}
				{
					filebw.write("forge:stones_can_be_turned_into_geode");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:ice");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:magma_block");
					filebw.newLine();
				}
				{
					filebw.write("rituals_of_the_wilds:empty_ink_bottle");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:diamond");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:ink_sac");
					filebw.newLine();
				}
				{
					filebw.write("minecraft:string");
					filebw.newLine();
				}
				{
					filebw.write("forge:redstone_ore");
					filebw.newLine();
				}
				{
					filebw.write("forge:lapis_ore");
					filebw.newLine();
				}
				{
					filebw.write("forge:coal_ore");
					filebw.newLine();
				}
				{
					filebw.write("forge:iron_ore");
					filebw.newLine();
				}
				{
					filebw.write("forge:copper_ore");
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
