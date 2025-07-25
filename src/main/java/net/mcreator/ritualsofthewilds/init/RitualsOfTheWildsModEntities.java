
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.entity.LeshyEntity;
import net.mcreator.ritualsofthewilds.entity.DomovoiEntity;
import net.mcreator.ritualsofthewilds.entity.ChernobogEntity;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualsOfTheWildsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<EntityType<DomovoiEntity>> DOMOVOI = register("domovoi",
			EntityType.Builder.<DomovoiEntity>of(DomovoiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DomovoiEntity::new)

					.sized(0.5f, 1f));
	public static final RegistryObject<EntityType<ChernobogEntity>> CHERNOBOG = register("chernobog",
			EntityType.Builder.<ChernobogEntity>of(ChernobogEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChernobogEntity::new).fireImmune().sized(0.7f, 2f));
	public static final RegistryObject<EntityType<LeshyEntity>> LESHY = register("leshy",
			EntityType.Builder.<LeshyEntity>of(LeshyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LeshyEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DomovoiEntity.init();
			ChernobogEntity.init();
			LeshyEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DOMOVOI.get(), DomovoiEntity.createAttributes().build());
		event.put(CHERNOBOG.get(), ChernobogEntity.createAttributes().build());
		event.put(LESHY.get(), LeshyEntity.createAttributes().build());
	}
}
