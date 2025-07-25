package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ReputatioSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		(new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_entity");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getPersistentData().putDouble(("dialogue_reputation_with_" + (new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getStringUUID()), (DoubleArgumentType.getDouble(arguments, "reputation")));
		if ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Reputation of " + (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "setting_entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getDisplayName().getString() + " to " + (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "setting_to");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getDisplayName().getString() + " setted to " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "reputation")))), false);
	}
}
