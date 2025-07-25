package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.network.chat.Component;

public class ShowWaterCauldronDescriptionProcedure {
	public static String execute() {
		return Component.translatable("item.rituals_of_the_wilds.water_cauldron_show_description").getString();
	}
}
