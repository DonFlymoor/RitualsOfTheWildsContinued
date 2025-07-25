package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

public class SettingScrollEntityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).entitycheckinginscroll).equals("")) {
			return Component.translatable("gui.rituals_of_the_wilds.label_entity_needed_near").getString() + " "
					+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).entitycheckinginscroll;
		}
		return " ";
	}
}
