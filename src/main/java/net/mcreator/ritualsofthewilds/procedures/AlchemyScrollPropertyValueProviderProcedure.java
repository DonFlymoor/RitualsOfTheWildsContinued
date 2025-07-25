package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.item.ItemStack;

public class AlchemyScrollPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (!(itemstack.getOrCreateTag().getString("name_of_alchemy_recipe")).equals("")) {
			return 1;
		}
		return 0;
	}
}
