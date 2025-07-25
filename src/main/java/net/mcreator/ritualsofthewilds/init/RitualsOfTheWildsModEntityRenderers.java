
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ritualsofthewilds.client.renderer.LeshyRenderer;
import net.mcreator.ritualsofthewilds.client.renderer.DomovoiRenderer;
import net.mcreator.ritualsofthewilds.client.renderer.ChernobogRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RitualsOfTheWildsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(RitualsOfTheWildsModEntities.DOMOVOI.get(), DomovoiRenderer::new);
		event.registerEntityRenderer(RitualsOfTheWildsModEntities.CHERNOBOG.get(), ChernobogRenderer::new);
		event.registerEntityRenderer(RitualsOfTheWildsModEntities.LESHY.get(), LeshyRenderer::new);
	}
}
