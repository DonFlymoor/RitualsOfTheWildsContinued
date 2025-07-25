
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ritualsofthewilds.client.particle.AmethystPowderParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RitualsOfTheWildsModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(RitualsOfTheWildsModParticleTypes.AMETHYST_POWDER_PARTICLE.get(), AmethystPowderParticleParticle::provider);
	}
}
