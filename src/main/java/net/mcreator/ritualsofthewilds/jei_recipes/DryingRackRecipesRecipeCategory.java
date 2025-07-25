
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

public class DryingRackRecipesRecipeCategory implements IRecipeCategory<DryingRackRecipesRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("rituals_of_the_wilds", "drying_rack_recipes");
	public final static ResourceLocation TEXTURE = new ResourceLocation("rituals_of_the_wilds", "textures/screens/drying_rack_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public DryingRackRecipesRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 136, 82);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(RitualsOfTheWildsModBlocks.DRYING_RACK.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<DryingRackRecipesRecipe> getRecipeType() {
		return RitualsOfTheWildsModJeiPlugin.DryingRackRecipes_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Drying");
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
	public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipesRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 38).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 38).addItemStack(recipe.getResultItem(null));
	}
}
