package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KilledRightEntityProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof ServerPlayer || sourceentity instanceof Player) {
			if (!((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
				if (entity.getType()
						.is(TagKey.create(Registries.ENTITY_TYPE,
								new ResourceLocation((((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest1))
										.toLowerCase(java.util.Locale.ENGLISH)))) == true
						|| ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest1)
								.equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString())) {
					{
						double _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest1 + 1;
						sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest1 = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (!((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
				if (entity.getType()
						.is(TagKey.create(Registries.ENTITY_TYPE,
								new ResourceLocation((((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest2))
										.toLowerCase(java.util.Locale.ENGLISH)))) == true
						|| ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest2)
								.equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString())) {
					{
						double _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest2 + 1;
						sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest2 = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (!((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
				if (entity.getType()
						.is(TagKey.create(Registries.ENTITY_TYPE,
								new ResourceLocation((((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest3))
										.toLowerCase(java.util.Locale.ENGLISH)))) == true
						|| ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest3)
								.equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString())) {
					{
						double _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest3 + 1;
						sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest3 = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (!((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
				if (entity.getType()
						.is(TagKey.create(Registries.ENTITY_TYPE,
								new ResourceLocation((((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest4))
										.toLowerCase(java.util.Locale.ENGLISH)))) == true
						|| ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest4)
								.equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString())) {
					{
						double _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest4 + 1;
						sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest4 = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (!((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
				if (entity.getType()
						.is(TagKey.create(Registries.ENTITY_TYPE,
								new ResourceLocation((((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest5))
										.toLowerCase(java.util.Locale.ENGLISH)))) == true
						|| ((sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).whokillquest5)
								.equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString())) {
					{
						double _setval = (sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).killcountingquest5 + 1;
						sourceentity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.killcountingquest5 = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
		}
	}
}
