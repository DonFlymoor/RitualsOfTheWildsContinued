package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShowKilledAlreadyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static String execute(Entity entity) {
		return execute(null, entity);
	}

	private static String execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return "";
		String getback = "";
		if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killstoshow <= 0)) {
			return Component.translatable("quests.rituals_of_the_wilds.left_to_kill").getString() + ""
					+ (new java.text.DecimalFormat("##").format((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountleft1) + "/"
							+ new java.text.DecimalFormat("##").format((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killstoshow));
		}
		return "";
	}
}
