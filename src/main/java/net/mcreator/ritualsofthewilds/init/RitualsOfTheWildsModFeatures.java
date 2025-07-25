
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.ritualsofthewilds.world.features.WitchThornGeneratingFeature;
import net.mcreator.ritualsofthewilds.world.features.VoidRootGeneratingFeature;
import net.mcreator.ritualsofthewilds.world.features.ThornBloomGeneratngFeature;
import net.mcreator.ritualsofthewilds.world.features.SpiritBloomGenerationFeature;
import net.mcreator.ritualsofthewilds.world.features.MistCapMushroomsGeneratingFeature;
import net.mcreator.ritualsofthewilds.world.features.DreamFlowerGeneratingFeature;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

@Mod.EventBusSubscriber
public class RitualsOfTheWildsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<Feature<?>> DREAM_FLOWER_GENERATING = REGISTRY.register("dream_flower_generating", DreamFlowerGeneratingFeature::new);
	public static final RegistryObject<Feature<?>> VOID_ROOT_GENERATING = REGISTRY.register("void_root_generating", VoidRootGeneratingFeature::new);
	public static final RegistryObject<Feature<?>> WITCH_THORN_GENERATING = REGISTRY.register("witch_thorn_generating", WitchThornGeneratingFeature::new);
	public static final RegistryObject<Feature<?>> THORN_BLOOM_GENERATNG = REGISTRY.register("thorn_bloom_generatng", ThornBloomGeneratngFeature::new);
	public static final RegistryObject<Feature<?>> MIST_CAP_MUSHROOMS_GENERATING = REGISTRY.register("mist_cap_mushrooms_generating", MistCapMushroomsGeneratingFeature::new);
	public static final RegistryObject<Feature<?>> SPIRIT_BLOOM_GENERATION = REGISTRY.register("spirit_bloom_generation", SpiritBloomGenerationFeature::new);
}
