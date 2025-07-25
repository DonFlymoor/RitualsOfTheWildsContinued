package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class AddDoneQuestProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if ((((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone)
				.contains(StringArgumentType.getString(arguments, "quest_id")) == false) {
			{
				String _setval = ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "setting_to");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questsalreadydone + " " + StringArgumentType.getString(arguments, "quest_id");
				(new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "setting_to");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.questsalreadydone = _setval;
					capability.syncPlayerVariables((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "setting_to");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()));
				});
			}
		} else {
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
				_player.displayClientMessage(Component.literal(("There is already quest in done list with id: " + StringArgumentType.getString(arguments, "quest_id"))), false);
		}
	}
}
