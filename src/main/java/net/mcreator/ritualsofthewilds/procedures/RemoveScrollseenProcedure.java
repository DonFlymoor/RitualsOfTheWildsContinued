package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class RemoveScrollseenProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if (!(((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen).equals("")) {
			if ((((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "setting_to");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen)
					.contains(new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "scroll_id")) + "ritual") == true) {
				{
					String _setval = (((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "setting_to");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen)
							.replace(new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "scroll_id")) + "ritual", "");
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
						capability.ritualsseen = _setval;
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
					_player.displayClientMessage(Component.literal(("No ritual scroll in seen list with id: " + new java.text.DecimalFormat("##").format(DoubleArgumentType.getDouble(arguments, "scroll_id")))), false);
			}
		}
	}
}
