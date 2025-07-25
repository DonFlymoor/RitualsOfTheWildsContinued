
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ritualsofthewilds.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.ritualsofthewilds.network.ShowQuestsActiveMessage;
import net.mcreator.ritualsofthewilds.network.ScrollQuestsMessage;
import net.mcreator.ritualsofthewilds.network.CancelingQuestMessage;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class RitualsOfTheWildsModKeyMappings {
	public static final KeyMapping SHOW_QUESTS_ACTIVE = new KeyMapping("key.rituals_of_the_wilds.show_quests_active", GLFW.GLFW_KEY_K, "key.categories.rituals_of_the_wilds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new ShowQuestsActiveMessage(0, 0));
				ShowQuestsActiveMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SCROLL_QUESTS = new KeyMapping("key.rituals_of_the_wilds.scroll_quests", GLFW.GLFW_KEY_I, "key.categories.rituals_of_the_wilds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new ScrollQuestsMessage(0, 0));
				ScrollQuestsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CANCELING_QUEST = new KeyMapping("key.rituals_of_the_wilds.canceling_quest", GLFW.GLFW_KEY_M, "key.categories.rituals_of_the_wilds") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new CancelingQuestMessage(0, 0));
				CancelingQuestMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SHOW_QUESTS_ACTIVE);
		event.register(SCROLL_QUESTS);
		event.register(CANCELING_QUEST);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SHOW_QUESTS_ACTIVE.consumeClick();
				SCROLL_QUESTS.consumeClick();
				CANCELING_QUEST.consumeClick();
			}
		}
	}
}
