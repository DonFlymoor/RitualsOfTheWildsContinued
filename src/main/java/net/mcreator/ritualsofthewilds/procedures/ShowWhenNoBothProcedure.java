package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

public class ShowWhenNoBothProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).showupperblock == false
				&& (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).showlowerblock == false) {
			return true;
		}
		return false;
	}
}
