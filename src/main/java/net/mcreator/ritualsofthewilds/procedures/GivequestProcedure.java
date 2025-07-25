package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

import java.io.File;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class GivequestProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double nextdialogue = 0;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "setting_to");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
				File.separator + (StringArgumentType.getString(arguments, "quest_id") + ".json"));
		if (file.exists() == false) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests/" + "eng"), File.separator + (StringArgumentType.getString(arguments, "quest_id") + ".json"));
		}
		if (file.exists() == true) {
			if ((((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "setting_to");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
				{
					String _setval = StringArgumentType.getString(arguments, "quest_id");
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
						capability.firstquestid = _setval;
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
				{
					String _setval = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "given_by");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getStringUUID();
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
						capability.firstquestgivenby = _setval;
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
				{
					String _setval = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "given_by");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getStringUUID();
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
						capability.originalquestgiver1 = _setval;
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
				{
					String _setval = (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "given_by");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getStringUUID();
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
						capability.previousquestgiver1 = _setval;
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
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("First quest been setted to: " + StringArgumentType.getString(arguments, "quest_id") + "| Quest can be given back to: " + (new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "given_by");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getDisplayName().getString())), false);
			} else {
				if ((((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "setting_to");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
					{
						String _setval = StringArgumentType.getString(arguments, "quest_id");
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
							capability.secondquestid = _setval;
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
					{
						String _setval = (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "given_by");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getStringUUID();
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
							capability.secondquestgivenby = _setval;
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
					{
						String _setval = (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "given_by");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getStringUUID();
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
							capability.originalquestgiver2 = _setval;
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
					{
						String _setval = (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "given_by");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getStringUUID();
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
							capability.previousquestgiver2 = _setval;
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
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Second quest been setted to: " + StringArgumentType.getString(arguments, "quest_id") + "| Quest can be given back to: " + (new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "given_by");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getDisplayName().getString())), false);
				} else {
					if ((((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "setting_to");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
						{
							String _setval = StringArgumentType.getString(arguments, "quest_id");
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
								capability.thirdquestid = _setval;
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
						{
							String _setval = (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "given_by");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getStringUUID();
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
								capability.thirdquestgivenby = _setval;
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
						{
							String _setval = (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "given_by");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getStringUUID();
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
								capability.originalquestgiver3 = _setval;
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
						{
							String _setval = (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "given_by");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getStringUUID();
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
								capability.previousquestgiver3 = _setval;
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
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Third quest been setted to: " + StringArgumentType.getString(arguments, "quest_id") + "| Quest can be given back to: " + (new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "given_by");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getDisplayName().getString())), false);
					} else {
						if ((((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "setting_to");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
							{
								String _setval = StringArgumentType.getString(arguments, "quest_id");
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
									capability.fourthquestid = _setval;
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
							{
								String _setval = (new Object() {
									public Entity getEntity() {
										try {
											return EntityArgument.getEntity(arguments, "given_by");
										} catch (CommandSyntaxException e) {
											e.printStackTrace();
											return null;
										}
									}
								}.getEntity()).getStringUUID();
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
									capability.fourthquestgivenby = _setval;
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
							{
								String _setval = (new Object() {
									public Entity getEntity() {
										try {
											return EntityArgument.getEntity(arguments, "given_by");
										} catch (CommandSyntaxException e) {
											e.printStackTrace();
											return null;
										}
									}
								}.getEntity()).getStringUUID();
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
									capability.originalquestgiver4 = _setval;
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
							{
								String _setval = (new Object() {
									public Entity getEntity() {
										try {
											return EntityArgument.getEntity(arguments, "given_by");
										} catch (CommandSyntaxException e) {
											e.printStackTrace();
											return null;
										}
									}
								}.getEntity()).getStringUUID();
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
									capability.previousquestgiver4 = _setval;
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
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Fourth quest been setted to: " + StringArgumentType.getString(arguments, "quest_id") + "| Quest can be given back to: " + (new Object() {
									public Entity getEntity() {
										try {
											return EntityArgument.getEntity(arguments, "given_by");
										} catch (CommandSyntaxException e) {
											e.printStackTrace();
											return null;
										}
									}
								}.getEntity()).getDisplayName().getString())), false);
						} else {
							if ((((new Object() {
								public Entity getEntity() {
									try {
										return EntityArgument.getEntity(arguments, "setting_to");
									} catch (CommandSyntaxException e) {
										e.printStackTrace();
										return null;
									}
								}
							}.getEntity()).getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
								{
									String _setval = StringArgumentType.getString(arguments, "quest_id");
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
										capability.fifthquestid = _setval;
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
								{
									String _setval = (new Object() {
										public Entity getEntity() {
											try {
												return EntityArgument.getEntity(arguments, "given_by");
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return null;
											}
										}
									}.getEntity()).getStringUUID();
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
										capability.fifthquestgivenby = _setval;
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
								{
									String _setval = (new Object() {
										public Entity getEntity() {
											try {
												return EntityArgument.getEntity(arguments, "given_by");
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return null;
											}
										}
									}.getEntity()).getStringUUID();
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
										capability.originalquestgiver5 = _setval;
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
								{
									String _setval = (new Object() {
										public Entity getEntity() {
											try {
												return EntityArgument.getEntity(arguments, "given_by");
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return null;
											}
										}
									}.getEntity()).getStringUUID();
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
										capability.previousquestgiver5 = _setval;
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
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("Fifth quest been setted to: " + StringArgumentType.getString(arguments, "quest_id") + "| Quest can be given back to: " + (new Object() {
										public Entity getEntity() {
											try {
												return EntityArgument.getEntity(arguments, "given_by");
											} catch (CommandSyntaxException e) {
												e.printStackTrace();
												return null;
											}
										}
									}.getEntity()).getDisplayName().getString())), false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("No empty quest spaces was found!"), false);
							}
						}
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("No file was found in " + (FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/quests") + " named: " + StringArgumentType.getString(arguments, "quest_id"))), false);
		}
	}
}
