
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.ritualsofthewilds.client.gui.TapBarrelGUIScreen;
import net.mcreator.ritualsofthewilds.client.gui.TalkingScreen;
import net.mcreator.ritualsofthewilds.client.gui.RuneScriberGUIScreen;
import net.mcreator.ritualsofthewilds.client.gui.RitualScrollShowcaseScreen;
import net.mcreator.ritualsofthewilds.client.gui.CancelQuestScreen;
import net.mcreator.ritualsofthewilds.client.gui.AlchemyScrollGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RitualsOfTheWildsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(RitualsOfTheWildsModMenus.RUNE_SCRIBER_GUI.get(), RuneScriberGUIScreen::new);
			MenuScreens.register(RitualsOfTheWildsModMenus.RITUAL_SCROLL_SHOWCASE.get(), RitualScrollShowcaseScreen::new);
			MenuScreens.register(RitualsOfTheWildsModMenus.TALKING.get(), TalkingScreen::new);
			MenuScreens.register(RitualsOfTheWildsModMenus.CANCEL_QUEST.get(), CancelQuestScreen::new);
			MenuScreens.register(RitualsOfTheWildsModMenus.ALCHEMY_SCROLL_GUI.get(), AlchemyScrollGUIScreen::new);
			MenuScreens.register(RitualsOfTheWildsModMenus.TAP_BARREL_GUI.get(), TapBarrelGUIScreen::new);
		});
	}
}
