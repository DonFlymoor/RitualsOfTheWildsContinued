
package net.mcreator.ritualsofthewilds.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ritualsofthewilds.entity.LeshyEntity;
import net.mcreator.ritualsofthewilds.client.model.ModelLeshiy;

public class LeshyRenderer extends MobRenderer<LeshyEntity, ModelLeshiy<LeshyEntity>> {
	public LeshyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLeshiy(context.bakeLayer(ModelLeshiy.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LeshyEntity entity) {
		return new ResourceLocation("rituals_of_the_wilds:textures/entities/leshiy.png");
	}
}
