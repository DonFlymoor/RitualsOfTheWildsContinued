package net.mcreator.ritualsofthewilds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ritualsofthewilds.world.inventory.CancelQuestMenu;
import net.mcreator.ritualsofthewilds.network.CancelQuestButtonMessage;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CancelQuestScreen extends AbstractContainerScreen<CancelQuestMenu> {
	private final static HashMap<String, Object> guistate = CancelQuestMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_yes;
	Button button_no;

	public CancelQuestScreen(CancelQuestMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 155;
		this.imageHeight = 72;
	}

	private static final ResourceLocation texture = new ResourceLocation("rituals_of_the_wilds:textures/screens/cancel_quest.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.cancel_quest.label_are_you_sure_that_you_want_to_ca"), 32, 5, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.cancel_quest.label_you_want_to"), 50, 14, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.cancel_quest.label_cancel_this_quest"), 32, 23, -3407872, false);
	}

	@Override
	public void init() {
		super.init();
		button_yes = Button.builder(Component.translatable("gui.rituals_of_the_wilds.cancel_quest.button_yes"), e -> {
			if (true) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new CancelQuestButtonMessage(0, x, y, z));
				CancelQuestButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 14, this.topPos + 41, 40, 20).build();
		guistate.put("button:button_yes", button_yes);
		this.addRenderableWidget(button_yes);
		button_no = Button.builder(Component.translatable("gui.rituals_of_the_wilds.cancel_quest.button_no"), e -> {
			if (true) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new CancelQuestButtonMessage(1, x, y, z));
				CancelQuestButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 41, 35, 20).build();
		guistate.put("button:button_no", button_no);
		this.addRenderableWidget(button_no);
	}
}
