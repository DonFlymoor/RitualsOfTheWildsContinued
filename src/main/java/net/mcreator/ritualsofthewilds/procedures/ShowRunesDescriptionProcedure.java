package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.network.chat.Component;

public class ShowRunesDescriptionProcedure {
	public static String execute() {
		return Component.translatable("item.rituals_of_the_wilds.runic_cauldron_show_description").getString();
	}
}
