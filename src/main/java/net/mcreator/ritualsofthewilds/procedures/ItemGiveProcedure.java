package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ItemGiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, File filetry) {
		if (filetry == null)
			return;
		double maxgive = 0;
		double mingive = 0;
		File file = new File("");
		boolean fixedresultitem = false;
		boolean checkblocks = false;
		String Ingredient6 = "";
		String Ingredient5 = "";
		String Ingredient8 = "";
		String Ingredient7 = "";
		String resultitem = "";
		String Ingredient2 = "";
		String Ingredient1 = "";
		String Ingredient4 = "";
		String Ingredient3 = "";
		String Ingredient9 = "";
		String Ingredient10 = "";
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		file = filetry;
		if (file.exists() == true) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					resultitem = object.get("Result item ID").getAsString();
					mingive = object.get("Min/Fixed result item give count").getAsDouble();
					maxgive = object.get("Max result item give count").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), mingive, maxgive); index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((resultitem).toLowerCase(java.util.Locale.ENGLISH)))));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
