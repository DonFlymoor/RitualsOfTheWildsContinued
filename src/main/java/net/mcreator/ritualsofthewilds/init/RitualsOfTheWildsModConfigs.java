package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.ritualsofthewilds.configuration.RitualsOfTheWildsConfigConfiguration;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

@Mod.EventBusSubscriber(modid = RitualsOfTheWildsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RitualsOfTheWildsModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RitualsOfTheWildsConfigConfiguration.SPEC, "Rituals Of The Wilds Continued.toml");
		});
	}
}
