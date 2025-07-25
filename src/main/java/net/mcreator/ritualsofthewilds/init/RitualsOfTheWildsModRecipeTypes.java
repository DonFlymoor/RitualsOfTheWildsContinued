package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.ritualsofthewilds.jei_recipes.MortarAndPestleRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.FumeExtractingRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.DryingRackRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.DistilationFlaskRecipesRecipe;
import net.mcreator.ritualsofthewilds.jei_recipes.CatalystGrinderRecipesRecipe;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

@Mod.EventBusSubscriber(modid = RitualsOfTheWildsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualsOfTheWildsModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "rituals_of_the_wilds");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("mortar_and_pestle_recipes", () -> MortarAndPestleRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("drying_rack_recipes", () -> DryingRackRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("catalyst_grinder_recipes", () -> CatalystGrinderRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("distilation_flask_recipes", () -> DistilationFlaskRecipesRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("fume_extracting", () -> FumeExtractingRecipe.Serializer.INSTANCE);
		});
	}
}
