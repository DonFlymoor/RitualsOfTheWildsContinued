package net.mcreator.ritualsofthewilds.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ritualsofthewilds.world.inventory.AlchemyScrollGUIMenu;
import net.mcreator.ritualsofthewilds.procedures.UpperShowProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowWhenNoBothProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowWhenBothProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowIfupperhasProcedure;
import net.mcreator.ritualsofthewilds.procedures.ShowIflowerhasProcedure;
import net.mcreator.ritualsofthewilds.procedures.LowerShowProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AlchemyScrollGUIScreen extends AbstractContainerScreen<AlchemyScrollGUIMenu> {
	private final static HashMap<String, Object> guistate = AlchemyScrollGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AlchemyScrollGUIScreen(AlchemyScrollGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
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
		if (ShowWhenBothProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("rituals_of_the_wilds:textures/screens/alchemy_scroll_gui_all_things.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 400, 200, 400, 200);
		}
		if (ShowWhenNoBothProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("rituals_of_the_wilds:textures/screens/alchemy_scroll_gui_no_both.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 400, 200, 400, 200);
		}
		if (UpperShowProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("rituals_of_the_wilds:textures/screens/alchemy_scroll_gui_no_lower.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 400, 200, 400, 200);
		}
		if (LowerShowProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("rituals_of_the_wilds:textures/screens/alchemy_scroll_gui_no_upper.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 400, 200, 400, 200);
		}

		guiGraphics.blit(new ResourceLocation("rituals_of_the_wilds:textures/screens/compass_thingy_alchmey.png"), this.leftPos + 190, this.topPos + 127, 0, 0, 64, 64, 64, 64);

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
		if (ShowIflowerhasProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_lower_block_scheme"), 10, 6, -13421773, false);
		if (ShowIflowerhasProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_on_height_with_cauldron"), 10, 15, -13421773, false);
		if (ShowIfupperhasProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_upper_block_scheme"), 199, 6, -13421773, false);
		if (ShowIfupperhasProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_on_2_height_from_cauldron"), 199, 15, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_fill_type"), 312, 159, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_moonstage"), 311, 181, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_cauldron_state"), 286, 136, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.rituals_of_the_wilds.alchemy_scroll_gui.label_ingredient_order"), 7, 138, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
