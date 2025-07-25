package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

public class ShowQuestsActiveOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).showquests == true) {
			{
				boolean _setval = false;
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showquests = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = true;
				entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showquests = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
