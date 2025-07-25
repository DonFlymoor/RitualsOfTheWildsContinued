
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

public class RitualsOfTheWildsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<SimpleParticleType> AMETHYST_POWDER_PARTICLE = REGISTRY.register("amethyst_powder_particle", () -> new SimpleParticleType(false));
}
