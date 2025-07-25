package net.mcreator.ritualsofthewilds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ritualsofthewilds.world.inventory.TalkingMenu;
import net.mcreator.ritualsofthewilds.procedures.ThirdLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.ThirdAnswerQuestNeededProcedure;
import net.mcreator.ritualsofthewilds.procedures.ThirdAnswerProcedure;
import net.mcreator.ritualsofthewilds.procedures.TenthLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.TalkingWithProcedure;
import net.mcreator.ritualsofthewilds.procedures.SixthLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.SeventhLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.SecondLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.SecondAnswerQuestNeededProcedure;
import net.mcreator.ritualsofthewilds.procedures.SecondAnswerProcedure;
import net.mcreator.ritualsofthewilds.procedures.NineLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.FourthLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.FourthAnswerQuestNeededProcedure;
import net.mcreator.ritualsofthewilds.procedures.FourthAnswerProcedure;
import net.mcreator.ritualsofthewilds.procedures.FirstLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.FirstAnswerQuestNeededProcedure;
import net.mcreator.ritualsofthewilds.procedures.FirstAnswerProcedure;
import net.mcreator.ritualsofthewilds.procedures.FifthLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.procedures.EightLineOfTextProcedure;
import net.mcreator.ritualsofthewilds.network.TalkingButtonMessage;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TalkingScreen extends AbstractContainerScreen<TalkingMenu> {
	private final static HashMap<String, Object> guistate = TalkingMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;

	public TalkingScreen(TalkingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 500;
		this.imageHeight = 253;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				TalkingWithProcedure.execute(entity), 15, 4, -1, false);
		guiGraphics.drawString(this.font,

				FirstLineOfTextProcedure.execute(entity), 24, 19, -1, false);
		guiGraphics.drawString(this.font,

				SecondLineOfTextProcedure.execute(entity), 24, 29, -1, false);
		guiGraphics.drawString(this.font,

				ThirdLineOfTextProcedure.execute(entity), 24, 39, -1, false);
		guiGraphics.drawString(this.font,

				FourthLineOfTextProcedure.execute(entity), 24, 49, -1, false);
		guiGraphics.drawString(this.font,

				FifthLineOfTextProcedure.execute(entity), 24, 59, -1, false);
		guiGraphics.drawString(this.font,

				SixthLineOfTextProcedure.execute(entity), 24, 69, -1, false);
		guiGraphics.drawString(this.font,

				SeventhLineOfTextProcedure.execute(entity), 24, 79, -1, false);
		guiGraphics.drawString(this.font,

				EightLineOfTextProcedure.execute(entity), 24, 89, -1, false);
		guiGraphics.drawString(this.font,

				NineLineOfTextProcedure.execute(entity), 24, 99, -1, false);
		guiGraphics.drawString(this.font,

				TenthLineOfTextProcedure.execute(entity), 24, 109, -1, false);
		if (FirstAnswerQuestNeededProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					FirstAnswerProcedure.execute(entity), 24, 174, -3342337, false);
		if (SecondAnswerQuestNeededProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					SecondAnswerProcedure.execute(entity), 24, 194, -3342337, false);
		if (ThirdAnswerQuestNeededProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					ThirdAnswerProcedure.execute(entity), 24, 214, -3342337, false);
		if (FourthAnswerQuestNeededProcedure.execute(entity))
			guiGraphics.drawString(this.font,

					FourthAnswerProcedure.execute(entity), 24, 234, -3342337, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 24, this.topPos + 169, 441, 20, Component.translatable("gui.rituals_of_the_wilds.talking.button_empty"), e -> {
			if (FirstAnswerQuestNeededProcedure.execute(entity)) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new TalkingButtonMessage(0, x, y, z));
				TalkingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (FirstAnswerQuestNeededProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + 24, this.topPos + 189, 441, 20, Component.translatable("gui.rituals_of_the_wilds.talking.button_empty1"), e -> {
			if (SecondAnswerQuestNeededProcedure.execute(entity)) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new TalkingButtonMessage(1, x, y, z));
				TalkingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (SecondAnswerQuestNeededProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new PlainTextButton(this.leftPos + 24, this.topPos + 209, 441, 20, Component.translatable("gui.rituals_of_the_wilds.talking.button_empty2"), e -> {
			if (ThirdAnswerQuestNeededProcedure.execute(entity)) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new TalkingButtonMessage(2, x, y, z));
				TalkingButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ThirdAnswerQuestNeededProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new PlainTextButton(this.leftPos + 24, this.topPos + 229, 450, 20, Component.translatable("gui.rituals_of_the_wilds.talking.button_empty3"), e -> {
			if (FourthAnswerQuestNeededProcedure.execute(entity)) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new TalkingButtonMessage(3, x, y, z));
				TalkingButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (FourthAnswerQuestNeededProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:button_empty3", button_empty3);
		this.addRenderableWidget(button_empty3);
	}
}
