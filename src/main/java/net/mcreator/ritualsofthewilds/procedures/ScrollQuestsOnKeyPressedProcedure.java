package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;

public class ScrollQuestsOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing >= 4) {
			if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
				{
					double _setval = 0;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.questshowing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
					{
						double _setval = 1;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.questshowing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
						{
							double _setval = 2;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.questshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
							{
								double _setval = 3;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.questshowing = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
								{
									double _setval = 4;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questshowing = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 3) {
			if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
				{
					double _setval = 4;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.questshowing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.questshowing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
						{
							double _setval = 1;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.questshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
							{
								double _setval = 2;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.questshowing = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
								{
									double _setval = 3;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questshowing = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 2) {
			if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
				{
					double _setval = 3;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.questshowing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.questshowing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
						{
							double _setval = 1;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.questshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
							{
								double _setval = 4;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.questshowing = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
								{
									double _setval = 2;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questshowing = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing == 1) {
			if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
				{
					double _setval = 2;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.questshowing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
					{
						double _setval = 0;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.questshowing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
						{
							double _setval = 3;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.questshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
							{
								double _setval = 4;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.questshowing = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
								{
									double _setval = 1;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questshowing = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).questshowing <= 0) {
			if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).secondquestid).equals("")) {
				{
					double _setval = 1;
					entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.questshowing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).thirdquestid).equals("")) {
					{
						double _setval = 2;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.questshowing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fourthquestid).equals("")) {
						{
							double _setval = 3;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.questshowing = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).fifthquestid).equals("")) {
							{
								double _setval = 4;
								entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.questshowing = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							if (!((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).firstquestid).equals("")) {
								{
									double _setval = 0;
									entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.questshowing = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		}
	}
}
