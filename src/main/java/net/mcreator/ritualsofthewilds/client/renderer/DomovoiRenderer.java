
package net.mcreator.ritualsofthewilds.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ritualsofthewilds.entity.DomovoiEntity;
import net.mcreator.ritualsofthewilds.client.model.ModelDomovoy;

public class DomovoiRenderer extends MobRenderer<DomovoiEntity, ModelDomovoy<DomovoiEntity>> {
	public DomovoiRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDomovoy(context.bakeLayer(ModelDomovoy.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DomovoiEntity entity) {
		return new ResourceLocation("rituals_of_the_wilds:textures/entities/domovoy.png");
	}
}
