
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.ritualsofthewilds.world.inventory.TapBarrelGUIMenu;
import net.mcreator.ritualsofthewilds.world.inventory.TalkingMenu;
import net.mcreator.ritualsofthewilds.world.inventory.RuneScriberGUIMenu;
import net.mcreator.ritualsofthewilds.world.inventory.RitualScrollShowcaseMenu;
import net.mcreator.ritualsofthewilds.world.inventory.CancelQuestMenu;
import net.mcreator.ritualsofthewilds.world.inventory.AlchemyScrollGUIMenu;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

public class RitualsOfTheWildsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RitualsOfTheWildsMod.MODID);
	public static final RegistryObject<MenuType<RuneScriberGUIMenu>> RUNE_SCRIBER_GUI = REGISTRY.register("rune_scriber_gui", () -> IForgeMenuType.create(RuneScriberGUIMenu::new));
	public static final RegistryObject<MenuType<RitualScrollShowcaseMenu>> RITUAL_SCROLL_SHOWCASE = REGISTRY.register("ritual_scroll_showcase", () -> IForgeMenuType.create(RitualScrollShowcaseMenu::new));
	public static final RegistryObject<MenuType<TalkingMenu>> TALKING = REGISTRY.register("talking", () -> IForgeMenuType.create(TalkingMenu::new));
	public static final RegistryObject<MenuType<CancelQuestMenu>> CANCEL_QUEST = REGISTRY.register("cancel_quest", () -> IForgeMenuType.create(CancelQuestMenu::new));
	public static final RegistryObject<MenuType<AlchemyScrollGUIMenu>> ALCHEMY_SCROLL_GUI = REGISTRY.register("alchemy_scroll_gui", () -> IForgeMenuType.create(AlchemyScrollGUIMenu::new));
	public static final RegistryObject<MenuType<TapBarrelGUIMenu>> TAP_BARREL_GUI = REGISTRY.register("tap_barrel_gui", () -> IForgeMenuType.create(TapBarrelGUIMenu::new));
}
