
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.ritualsofthewilds.block.entity.TapBarrelBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.TallGlassJarBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.SmallGlassJarBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.RuneScribingTableBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.MortarAndPestleBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.GlassJarBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.GlassEnhancedDryingRackBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.FumeExtractorBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.DryingRackBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.DistilationFlaskBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.CatalystGrinderBlockEntity;
import net.mcreator.ritualsofthewilds.block.entity.AlchemyCauldronBlockEntity;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

public class RitualsOfTheWildsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ALCHEMY_CAULDRON = register("alchemy_cauldron", RitualsOfTheWildsModBlocks.ALCHEMY_CAULDRON, AlchemyCauldronBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DRYING_RACK = register("drying_rack", RitualsOfTheWildsModBlocks.DRYING_RACK, DryingRackBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLASS_ENHANCED_DRYING_RACK = register("glass_enhanced_drying_rack", RitualsOfTheWildsModBlocks.GLASS_ENHANCED_DRYING_RACK, GlassEnhancedDryingRackBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MORTAR_AND_PESTLE = register("mortar_and_pestle", RitualsOfTheWildsModBlocks.MORTAR_AND_PESTLE, MortarAndPestleBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CATALYST_GRINDER = register("catalyst_grinder", RitualsOfTheWildsModBlocks.CATALYST_GRINDER, CatalystGrinderBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DISTILATION_FLASK = register("distilation_flask", RitualsOfTheWildsModBlocks.DISTILATION_FLASK, DistilationFlaskBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RUNE_SCRIBING_TABLE = register("rune_scribing_table", RitualsOfTheWildsModBlocks.RUNE_SCRIBING_TABLE, RuneScribingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FUME_EXTRACTOR = register("fume_extractor", RitualsOfTheWildsModBlocks.FUME_EXTRACTOR, FumeExtractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLASS_JAR = register("glass_jar", RitualsOfTheWildsModBlocks.GLASS_JAR, GlassJarBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TALL_GLASS_JAR = register("tall_glass_jar", RitualsOfTheWildsModBlocks.TALL_GLASS_JAR, TallGlassJarBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SMALL_GLASS_JAR = register("small_glass_jar", RitualsOfTheWildsModBlocks.SMALL_GLASS_JAR, SmallGlassJarBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TAP_BARREL = register("tap_barrel", RitualsOfTheWildsModBlocks.TAP_BARREL, TapBarrelBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
