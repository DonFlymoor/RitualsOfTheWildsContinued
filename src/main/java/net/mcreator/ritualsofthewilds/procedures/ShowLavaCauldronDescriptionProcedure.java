package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.network.chat.Component;

public class ShowLavaCauldronDescriptionProcedure {
	public static String execute() {
		return Component.translatable("item.rituals_of_the_wilds.lava_cauldron_show_description").getString();
	}
}
