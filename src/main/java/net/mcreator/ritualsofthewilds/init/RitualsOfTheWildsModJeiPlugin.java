
package net.mcreator.ritualsofthewilds.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.ritualsofthewilds.jei_recipes.MortarAndPestleRecipesRecipeCategory;
import net.mcreator.ritualsofthewilds.jei_recipes.MortarAndPestleRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.FumeExtractingRecipeCategory;
import net.mcreator.ritualsofthewilds.jei_recipes.FumeExtractingRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.DryingRackRecipesRecipeCategory;
import net.mcreator.ritualsofthewilds.jei_recipes.DryingRackRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.DistilationFlaskRecipesRecipeCategory;
import net.mcreator.ritualsofthewilds.jei_recipes.DistilationFlaskRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.CatalystGrinderRecipesRecipeCategory;
import net.mcreator.ritualsofthewilds.jei_recipes.CatalystGrinderRecipesRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class RitualsOfTheWildsModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<MortarAndPestleRecipesRecipe> MortarAndPestleRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(MortarAndPestleRecipesRecipeCategory.UID, MortarAndPestleRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DryingRackRecipesRecipe> DryingRackRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(DryingRackRecipesRecipeCategory.UID, DryingRackRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<CatalystGrinderRecipesRecipe> CatalystGrinderRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(CatalystGrinderRecipesRecipeCategory.UID, CatalystGrinderRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<DistilationFlaskRecipesRecipe> DistilationFlaskRecipes_Type = new mezz.jei.api.recipe.RecipeType<>(DistilationFlaskRecipesRecipeCategory.UID, DistilationFlaskRecipesRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<FumeExtractingRecipe> FumeExtracting_Type = new mezz.jei.api.recipe.RecipeType<>(FumeExtractingRecipeCategory.UID, FumeExtractingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("rituals_of_the_wilds:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new MortarAndPestleRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DryingRackRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CatalystGrinderRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DistilationFlaskRecipesRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FumeExtractingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<MortarAndPestleRecipesRecipe> MortarAndPestleRecipesRecipes = recipeManager.getAllRecipesFor(MortarAndPestleRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(MortarAndPestleRecipes_Type, MortarAndPestleRecipesRecipes);
		List<DryingRackRecipesRecipe> DryingRackRecipesRecipes = recipeManager.getAllRecipesFor(DryingRackRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(DryingRackRecipes_Type, DryingRackRecipesRecipes);
		List<CatalystGrinderRecipesRecipe> CatalystGrinderRecipesRecipes = recipeManager.getAllRecipesFor(CatalystGrinderRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(CatalystGrinderRecipes_Type, CatalystGrinderRecipesRecipes);
		List<DistilationFlaskRecipesRecipe> DistilationFlaskRecipesRecipes = recipeManager.getAllRecipesFor(DistilationFlaskRecipesRecipe.Type.INSTANCE);
		registration.addRecipes(DistilationFlaskRecipes_Type, DistilationFlaskRecipesRecipes);
		List<FumeExtractingRecipe> FumeExtractingRecipes = recipeManager.getAllRecipesFor(FumeExtractingRecipe.Type.INSTANCE);
		registration.addRecipes(FumeExtracting_Type, FumeExtractingRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(RitualsOfTheWildsModBlocks.MORTAR_AND_PESTLE.get().asItem()), MortarAndPestleRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(RitualsOfTheWildsModBlocks.DRYING_RACK.get().asItem()), DryingRackRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(RitualsOfTheWildsModBlocks.CATALYST_GRINDER.get().asItem()), CatalystGrinderRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(RitualsOfTheWildsModBlocks.DISTILATION_FLASK.get().asItem()), DistilationFlaskRecipes_Type);
		registration.addRecipeCatalyst(new ItemStack(RitualsOfTheWildsModBlocks.FUME_EXTRACTOR.get().asItem()), FumeExtracting_Type);
	}
}
