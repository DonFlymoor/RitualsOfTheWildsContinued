
package net.mcreator.ritualsofthewilds.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ritualsofthewilds.procedures.SizeOnMoonPhasessProcedure;
import net.mcreator.ritualsofthewilds.entity.ChernobogEntity;
import net.mcreator.ritualsofthewilds.client.model.ModelChernobog;

import com.mojang.blaze3d.vertex.PoseStack;

public class ChernobogRenderer extends MobRenderer<ChernobogEntity, ModelChernobog<ChernobogEntity>> {
	public ChernobogRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelChernobog(context.bakeLayer(ModelChernobog.LAYER_LOCATION)), 0.7f);
	}

	@Override
	protected void scale(ChernobogEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) SizeOnMoonPhasessProcedure.execute(world);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(ChernobogEntity entity) {
		return new ResourceLocation("rituals_of_the_wilds:textures/entities/chernobog.png");
	}
}
