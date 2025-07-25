
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

public class RitualsOfTheWildsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<SoundEvent> MUSIC_DANCE_OF_THE_BEAR = REGISTRY.register("music_dance_of_the_bear", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "music_dance_of_the_bear")));
	public static final RegistryObject<SoundEvent> CHERNOBOG_STEP = REGISTRY.register("chernobog_step", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "chernobog_step")));
	public static final RegistryObject<SoundEvent> CHERNOBOG_LIVING = REGISTRY.register("chernobog_living", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "chernobog_living")));
	public static final RegistryObject<SoundEvent> CHERNOBOG_DEATH = REGISTRY.register("chernobog_death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "chernobog_death")));
	public static final RegistryObject<SoundEvent> CHERNOBOG_HURT = REGISTRY.register("chernobog_hurt", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "chernobog_hurt")));
	public static final RegistryObject<SoundEvent> MUSIC_FROM_WAR_TO_LIFE = REGISTRY.register("music_from_war_to_life", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("rituals_of_the_wilds", "music_from_war_to_life")));
}
