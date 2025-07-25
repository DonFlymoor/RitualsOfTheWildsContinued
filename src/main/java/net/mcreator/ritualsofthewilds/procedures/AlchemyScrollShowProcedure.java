package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class AlchemyScrollShowProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == RitualsOfTheWildsModItems.ALCHEMY_SCROLL.get()) {
			if (!(itemstack.getOrCreateTag().getString("alchemy_recipe")).equals("")) {
				tooltip.add(Component.literal((itemstack.getOrCreateTag().getString("name_of_alchemy_recipe"))));
			} else {
				tooltip.add(Component.literal((Component.translatable("item.rituals_of_the_wilds.alchemy_scroll_unopened").getString())));
			}
		}
	}
}
