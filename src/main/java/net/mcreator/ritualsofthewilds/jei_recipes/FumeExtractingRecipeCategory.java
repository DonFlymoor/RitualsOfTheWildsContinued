
package net.mcreator.ritualsofthewilds.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModJeiPlugin;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class FumeExtractingRecipeCategory implements IRecipeCategory<FumeExtractingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("rituals_of_the_wilds", "fume_extracting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("rituals_of_the_wilds", "textures/screens/fume_extractor_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public FumeExtractingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 136, 82);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(RitualsOfTheWildsModBlocks.FUME_EXTRACTOR.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<FumeExtractingRecipe> getRecipeType() {
		return RitualsOfTheWildsModJeiPlugin.FumeExtracting_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Fume Extracting");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, FumeExtractingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 51).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 21).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 38).addItemStack(recipe.getResultItem(null));
	}
}
