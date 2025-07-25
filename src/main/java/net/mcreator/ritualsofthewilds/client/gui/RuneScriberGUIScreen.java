package net.mcreator.ritualsofthewilds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ritualsofthewilds.world.inventory.RuneScriberGUIMenu;
import net.mcreator.ritualsofthewilds.procedures.PageSettingProcedure;
import net.mcreator.ritualsofthewilds.procedures.NoPageUpsProcedure;
import net.mcreator.ritualsofthewilds.network.RuneScriberGUIButtonMessage;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RuneScriberGUIScreen extends AbstractContainerScreen<RuneScriberGUIMenu> {
	private final static HashMap<String, Object> guistate = RuneScriberGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_up_highlighted;
	ImageButton imagebutton_arrow_down_unhighlighted;

	public RuneScriberGUIScreen(RuneScriberGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("rituals_of_the_wilds:textures/screens/rune_scriber_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.rune_scriber_gui.label_rune_scribing_table"), 6, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.rune_scriber_gui.label_inventory"), 5, 73, -12829636, false);
		guiGraphics.drawString(this.font,

				PageSettingProcedure.execute(world, x, y, z), 138, 38, -10066330, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_up_highlighted = new ImageButton(this.leftPos + 134, this.topPos + 17, 17, 12, 0, 0, 12, new ResourceLocation("rituals_of_the_wilds:textures/screens/atlas/imagebutton_arrow_up_highlighted.png"), 17, 24, e -> {
			if (NoPageUpsProcedure.execute(world, x, y, z)) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new RuneScriberGUIButtonMessage(0, x, y, z));
				RuneScriberGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (NoPageUpsProcedure.execute(world, x, y, z))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_arrow_up_highlighted", imagebutton_arrow_up_highlighted);
		this.addRenderableWidget(imagebutton_arrow_up_highlighted);
		imagebutton_arrow_down_unhighlighted = new ImageButton(this.leftPos + 134, this.topPos + 59, 17, 12, 0, 0, 12, new ResourceLocation("rituals_of_the_wilds:textures/screens/atlas/imagebutton_arrow_down_unhighlighted.png"), 17, 24, e -> {
			if (true) {
				RitualsOfTheWildsMod.PACKET_HANDLER.sendToServer(new RuneScriberGUIButtonMessage(1, x, y, z));
				RuneScriberGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_down_unhighlighted", imagebutton_arrow_down_unhighlighted);
		this.addRenderableWidget(imagebutton_arrow_down_unhighlighted);
	}
}
