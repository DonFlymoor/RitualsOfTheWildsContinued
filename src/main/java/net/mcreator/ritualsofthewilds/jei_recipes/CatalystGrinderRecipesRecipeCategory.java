
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

public class CatalystGrinderRecipesRecipeCategory implements IRecipeCategory<CatalystGrinderRecipesRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("rituals_of_the_wilds", "catalyst_grinder_recipes");
	public final static ResourceLocation TEXTURE = new ResourceLocation("rituals_of_the_wilds", "textures/screens/catalyst_grinder_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public CatalystGrinderRecipesRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 136, 82);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(RitualsOfTheWildsModBlocks.CATALYST_GRINDER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<CatalystGrinderRecipesRecipe> getRecipeType() {
		return RitualsOfTheWildsModJeiPlugin.CatalystGrinderRecipes_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Grinding");
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
	public void setRecipe(IRecipeLayoutBuilder builder, CatalystGrinderRecipesRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 38).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 38).addItemStack(recipe.getResultItem(null));
	}
}
