package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.item.ItemStack;

public class RitualScrollPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (!(itemstack.getOrCreateTag().getString("name_of_ritual")).equals("")) {
			return 1;
		}
		return 0;
	}
}
