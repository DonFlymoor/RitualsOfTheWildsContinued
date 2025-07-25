
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ritualsofthewilds.client.model.ModelLeshiy;
import net.mcreator.ritualsofthewilds.client.model.ModelDomovoy;
import net.mcreator.ritualsofthewilds.client.model.ModelChernobog;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class RitualsOfTheWildsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelChernobog.LAYER_LOCATION, ModelChernobog::createBodyLayer);
		event.registerLayerDefinition(ModelLeshiy.LAYER_LOCATION, ModelLeshiy::createBodyLayer);
		event.registerLayerDefinition(ModelDomovoy.LAYER_LOCATION, ModelDomovoy::createBodyLayer);
	}
}
