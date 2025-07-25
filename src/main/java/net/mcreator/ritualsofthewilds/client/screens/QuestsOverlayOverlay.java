
package net.mcreator.ritualsofthewilds.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.ritualsofthewilds.procedures.ShowQuestsProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowQuestTextLine5Procedure;
import net.mcreator.ritualsofthewilds.procedures.ShowQuestTextLine4Procedure;
import net.mcreator.ritualsofthewilds.procedures.ShowQuestTextLine3Procedure;
import net.mcreator.ritualsofthewilds.procedures.ShowQuestTextLine2Procedure;
import net.mcreator.ritualsofthewilds.procedures.ShowQuestTextLine1Procedure;
import net.mcreator.ritualsofthewilds.procedures.ShowKilledAlreadyProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowIfNameIsTrueProcedure;
import net.mcreator.ritualsofthewilds.procedures.QuestNameProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class QuestsOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (ShowQuestsProcedure.execute(entity)) {
			if (ShowIfNameIsTrueProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.rituals_of_the_wilds.quests_overlay.label_ssm"), 1, 6, -1, false);
			if (ShowIfNameIsTrueProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						QuestNameProcedure.execute(entity), 1, 2, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowQuestTextLine1Procedure.execute(entity), 11, 14, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowQuestTextLine2Procedure.execute(entity), 11, 25, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowQuestTextLine3Procedure.execute(entity), 11, 35, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowQuestTextLine4Procedure.execute(entity), 11, 46, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowQuestTextLine5Procedure.execute(entity), 11, 57, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ShowKilledAlreadyProcedure.execute(entity), 11, 68, -1, false);
		}
	}
}
