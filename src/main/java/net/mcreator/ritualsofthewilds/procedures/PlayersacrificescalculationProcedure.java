package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class PlayersacrificescalculationProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal((Component.translatable("item.rituals_of_the_wilds.ritual_dagger_description_line_one").getString() + " " + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("SacrificesMade")))),
					true);
	}
}
