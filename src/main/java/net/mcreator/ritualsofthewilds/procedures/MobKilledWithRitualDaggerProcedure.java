package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.configuration.RitualsOfTheWildsConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MobKilledWithRitualDaggerProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof ServerPlayer || sourceentity instanceof Player) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.RITUAL_DAGGER.get()) {
				sourceentity.getPersistentData().putDouble("SacrificesMade", (sourceentity.getPersistentData().getDouble("SacrificesMade") + 1));
				sourceentity.getPersistentData().putBoolean("SacrificesWasMade", true);
				sourceentity.getPersistentData().putDouble("SacrificesTimeLeft", ((double) RitualsOfTheWildsConfigConfiguration.TIMESACRIFICESLEFT.get()));
			}
		}
	}
}
