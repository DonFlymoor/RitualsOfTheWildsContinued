package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GivingScrolllProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		ItemStack itemgivingto = ItemStack.EMPTY;
		itemgivingto = new ItemStack(RitualsOfTheWildsModItems.RITUAL_SCROLL.get());
		itemgivingto.getOrCreateTag().putString("ritual_recipe", (new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "scroll_id")) + "ritual.json"));
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "giving_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player) {
			ItemStack _setstack = itemgivingto.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
