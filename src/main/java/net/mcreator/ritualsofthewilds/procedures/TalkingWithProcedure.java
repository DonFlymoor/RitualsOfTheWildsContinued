package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

public class TalkingWithProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.rituals_of_the_wilds.label_talking_with").getString() + " "
				+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).talking_to;
	}
}
