package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.world.inventory.RitualScrollShowcaseMenu;
import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

public class RitualScrollRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		ItemStack itemtomake = ItemStack.EMPTY;
		double weatherneeded = 0;
		double moonstage = 0;
		double sacrificeneeded = 0;
		double ritualtype = 0;
		double rituallevel = 0;
		double minammount = 0;
		double ritualnumber = 0;
		double centralblockreplacmenttype = 0;
		double otherblocksreplcament = 0;
		String entitynearnead = "";
		String offhanditemid = "";
		String centerblockid = "";
		String result = "";
		String blockfourth = "";
		String resultitem = "";
		String blockthird = "";
		String blockfirst = "";
		String blocksecond = "";
		String blockfifth = "";
		String blocksixth = "";
		String blocksevent = "";
		String blockeight = "";
		String block14 = "";
		String block15 = "";
		String block16 = "";
		String block10 = "";
		String block11 = "";
		String block12 = "";
		String block13 = "";
		String block1 = "";
		String block2 = "";
		String block3 = "";
		String block4 = "";
		String block5 = "";
		String block6 = "";
		String block7 = "";
		String block8 = "";
		String block9 = "";
		String ritualname = "";
		boolean fullmoonneed = false;
		boolean Needentitynear = false;
		boolean hasentitynearit = false;
		boolean fixedresultitem = false;
		boolean canbespawnedinn = false;
		if ((itemstack.getOrCreateTag().getString("ritual_recipe")).equals("")) {
			while ((itemstack.getOrCreateTag().getString("ritual_recipe")).equals("")) {
				ritualnumber = Mth.nextDouble(RandomSource.create(), 1, 500);
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/"
								+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + (new java.text.DecimalFormat("##").format(ritualnumber) + "ritual.json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/eng"), File.separator + (new java.text.DecimalFormat("##").format(ritualnumber) + "ritual.json"));
				}
				if (file.exists() == true) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							canbespawnedinn = object.get("May Spawn In Ritual Scroll").getAsBoolean();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (canbespawnedinn == true) {
						itemstack.getOrCreateTag().putString("ritual_recipe", (new java.text.DecimalFormat("##").format(ritualnumber) + "ritual.json"));
					}
				}
			}
		} else {
			file = new File(
					(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/"
							+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
					File.separator + (itemstack.getOrCreateTag().getString("ritual_recipe")));
			if (file.exists() == false) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Rituals/eng"), File.separator + (itemstack.getOrCreateTag().getString("ritual_recipe")));
			}
			if (file.exists() == true) {
				if (!(((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen)
						.contains((itemstack.getOrCreateTag().getString("ritual_recipe")).replace(".json", "")) == true)) {
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).ritualsseen + ""
								+ (itemstack.getOrCreateTag().getString("ritual_recipe")).replace(".json", "");
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ritualsseen = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						ritualtype = object.get("Ritual Type").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("RitualScrollShowcase");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new RitualScrollShowcaseMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.85, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.85, (float) 0.5, false);
					}
				}
				if (ritualtype <= 1) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							minammount = object.get("Min/Fixed result item give count").getAsDouble();
							ritualname = object.get("Ritual Name").getAsString();
							result = object.get("Result item ID").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((result).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount((int) minammount);
						((Slot) _slots.get(30)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					itemstack.getOrCreateTag().putString("name_of_ritual", ritualname);
				} else if (ritualtype >= 2) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							minammount = object.get("Min/Fixed result command execution count").getAsDouble();
							result = object.get("Info about result").getAsString();
							ritualname = object.get("Ritual Name").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					itemtomake = new ItemStack(RitualsOfTheWildsModItems.ABOUT_RITUAL.get());
					itemtomake.getOrCreateTag().putString("infodescription", result);
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = itemtomake.copy();
						_setstack.setCount((int) minammount);
						((Slot) _slots.get(30)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					itemstack.getOrCreateTag().putString("name_of_ritual", ritualname);
				}
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						rituallevel = object.get("Ritual Difficulty Level").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (rituallevel <= 0) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							centerblockid = object.get("Central Block ID or Tag").getAsString();
							offhanditemid = object.get("Offhand Item ID or Tag").getAsString();
							sacrificeneeded = object.get("Sacrifices needed").getAsDouble();
							Needentitynear = object.get("Entity Near needed").getAsBoolean();
							fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
							moonstage = object.get("Moon Stage").getAsDouble();
							weatherneeded = object.get("Weather Type needed").getAsDouble();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (Needentitynear == true) {
						{
							try {
								BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
								StringBuilder jsonstringbuilder = new StringBuilder();
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									jsonstringbuilder.append(line);
								}
								bufferedReader.close();
								object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								entitynearnead = object.get("Entity Near ID or Tag").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						itemstack.getOrCreateTag().putString("NearEntityNeed", entitynearnead);
						{
							String _setval = entitynearnead;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						itemstack.getOrCreateTag().putString("NearEntityNeed", "");
						{
							String _setval = "";
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (fullmoonneed == true) {
						if (moonstage <= 0) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FULL_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LAST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 4) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NEW_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 5) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FIRST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage >= 7) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(32)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (weatherneeded <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NORMAL_WEATHER.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.RAIN_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.THUNDER_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(25)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (sacrificeneeded >= 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.SKELETON_SKULL).copy();
							_setstack.setCount((int) sacrificeneeded);
							((Slot) _slots.get(33)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				} else if (rituallevel == 1) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							centerblockid = object.get("Central Block ID or Tag").getAsString();
							offhanditemid = object.get("Offhand Item ID or Tag").getAsString();
							blockfirst = object.get("Block X+2 ID or Tag").getAsString();
							blocksecond = object.get("Block X-2 ID or Tag").getAsString();
							blockthird = object.get("Block Z+2 ID or Tag").getAsString();
							blockfourth = object.get("Block Z-2 ID or Tag").getAsString();
							sacrificeneeded = object.get("Sacrifices needed").getAsDouble();
							Needentitynear = object.get("Entity Near needed").getAsBoolean();
							fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
							moonstage = object.get("Moon Stage").getAsDouble();
							weatherneeded = object.get("Weather Type needed").getAsDouble();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (Needentitynear == true) {
						{
							try {
								BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
								StringBuilder jsonstringbuilder = new StringBuilder();
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									jsonstringbuilder.append(line);
								}
								bufferedReader.close();
								object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								entitynearnead = object.get("Entity Near ID or Tag").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						itemstack.getOrCreateTag().putString("NearEntityNeed", entitynearnead);
						{
							String _setval = entitynearnead;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						itemstack.getOrCreateTag().putString("NearEntityNeed", "");
						{
							String _setval = "";
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (fullmoonneed == true) {
						if (moonstage <= 0) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FULL_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LAST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 4) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NEW_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 5) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FIRST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage >= 7) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(32)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (weatherneeded <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NORMAL_WEATHER.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.RAIN_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.THUNDER_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(7)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(7)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(2)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(2)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(1)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(4)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(4)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(25)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (sacrificeneeded >= 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.SKELETON_SKULL).copy();
							_setstack.setCount((int) sacrificeneeded);
							((Slot) _slots.get(33)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				} else if (rituallevel == 2) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							centerblockid = object.get("Central Block ID or Tag").getAsString();
							offhanditemid = object.get("Offhand Item ID or Tag").getAsString();
							blockfirst = object.get("Block X+3 ID or Tag").getAsString();
							blocksecond = object.get("Block X-3 ID or Tag").getAsString();
							blockthird = object.get("Block Z+3 ID or Tag").getAsString();
							blockfourth = object.get("Block Z-3 ID or Tag").getAsString();
							blockfifth = object.get("Block X+2 Z+2 ID or Tag").getAsString();
							blocksixth = object.get("Block X-2 Z+2 ID or Tag").getAsString();
							blocksevent = object.get("Block X+2 Z-2 ID or Tag").getAsString();
							blockeight = object.get("Block X-2 Z-2 ID or Tag").getAsString();
							sacrificeneeded = object.get("Sacrifices needed").getAsDouble();
							Needentitynear = object.get("Entity Near needed").getAsBoolean();
							fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
							moonstage = object.get("Moon Stage").getAsDouble();
							weatherneeded = object.get("Weather Type needed").getAsDouble();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (Needentitynear == true) {
						{
							try {
								BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
								StringBuilder jsonstringbuilder = new StringBuilder();
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									jsonstringbuilder.append(line);
								}
								bufferedReader.close();
								object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								entitynearnead = object.get("Entity Near ID or Tag").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						itemstack.getOrCreateTag().putString("NearEntityNeed", entitynearnead);
						{
							String _setval = entitynearnead;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						itemstack.getOrCreateTag().putString("NearEntityNeed", "");
						{
							String _setval = "";
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (fullmoonneed == true) {
						if (moonstage <= 0) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FULL_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LAST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 4) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NEW_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 5) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FIRST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage >= 7) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(32)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (weatherneeded <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NORMAL_WEATHER.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.RAIN_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.THUNDER_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(8)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(8)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(3)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(3)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(6)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(6)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(5)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(5)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfifth).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(17)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(17)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfifth).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(17)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blocksixth).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(18)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(18)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blocksixth).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blocksevent).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(12)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(12)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blocksevent).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(12)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockeight).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(11)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(11)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockeight).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(11)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(25)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (sacrificeneeded >= 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.SKELETON_SKULL).copy();
							_setstack.setCount((int) sacrificeneeded);
							((Slot) _slots.get(33)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				} else if (rituallevel >= 3) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							centerblockid = object.get("Central Block ID or Tag").getAsString();
							offhanditemid = object.get("Offhand Item ID or Tag").getAsString();
							blockfirst = object.get("Block X+2 ID or Tag").getAsString();
							blocksecond = object.get("Block X-2 ID or Tag").getAsString();
							blockthird = object.get("Block Z+2 ID or Tag").getAsString();
							blockfourth = object.get("Block Z-2 ID or Tag").getAsString();
							block1 = object.get("Block X+4 ID or Tag").getAsString();
							block2 = object.get("Block X-4 ID or Tag").getAsString();
							block3 = object.get("Block Z+4 ID or Tag").getAsString();
							block4 = object.get("Block Z-4 ID or Tag").getAsString();
							block5 = object.get("Block X+4 Z+4 ID or Tag").getAsString();
							block6 = object.get("Block X-4 Z+4 ID or Tag").getAsString();
							block7 = object.get("Block X+4 Z-4 ID or Tag").getAsString();
							block8 = object.get("Block X-4 Z-4 ID or Tag").getAsString();
							block9 = object.get("Block X+2 Z+3 ID or Tag").getAsString();
							block10 = object.get("Block X+3 Z+2 ID or Tag").getAsString();
							block11 = object.get("Block X+2 Z-3 ID or Tag").getAsString();
							block12 = object.get("Block X+3 Z-2 ID or Tag").getAsString();
							block13 = object.get("Block X-3 Z-2 ID or Tag").getAsString();
							block14 = object.get("Block X-2 Z-3 ID or Tag").getAsString();
							block15 = object.get("Block X-2 Z+3 ID or Tag").getAsString();
							block16 = object.get("Block X-3 Z+2 ID or Tag").getAsString();
							sacrificeneeded = object.get("Sacrifices needed").getAsDouble();
							Needentitynear = object.get("Entity Near needed").getAsBoolean();
							fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
							moonstage = object.get("Moon Stage").getAsDouble();
							weatherneeded = object.get("Weather Type needed").getAsDouble();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (Needentitynear == true) {
						{
							try {
								BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
								StringBuilder jsonstringbuilder = new StringBuilder();
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									jsonstringbuilder.append(line);
								}
								bufferedReader.close();
								object = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								entitynearnead = object.get("Entity Near ID or Tag").getAsString();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						itemstack.getOrCreateTag().putString("NearEntityNeed", entitynearnead);
						{
							String _setval = entitynearnead;
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						itemstack.getOrCreateTag().putString("NearEntityNeed", "");
						{
							String _setval = "";
							entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.entitycheckinginscroll = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (fullmoonneed == true) {
						if (moonstage <= 0) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FULL_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 1) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 2) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LAST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 3) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 4) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NEW_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 5) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_CRESCENT_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage == 6) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FIRST_QUARTER_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						} else if (moonstage >= 7) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_GIBBOUS_MOON.get()).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(32)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					} else {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(32)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (weatherneeded <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NORMAL_WEATHER.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.RAIN_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (weatherneeded >= 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.THUNDER_NEEDED.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(31)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((centerblockid).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(7)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfirst).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(7)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(2)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blocksecond).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(2)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockthird).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(1)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(4)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((blockfourth).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(4)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block1).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(29)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(29)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block1).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(29)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block2).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(27)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(27)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block2).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(27)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block3).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(26)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(26)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block3).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(26)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block4).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(28)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(28)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block4).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(28)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block5).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(24)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(24)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block5).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(24)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block6).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(23)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(23)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block6).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(23)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block7).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(15)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(15)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block7).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(15)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block8).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(16)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(16)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block8).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(16)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block9).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(21)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block9).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(21)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block10).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(22)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(22)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block10).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(22)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block11).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(13)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(13)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block11).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(13)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block12).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(14)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(14)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block12).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(14)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block13).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(9)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block13).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(9)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block14).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(10)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(10)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block14).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(10)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block15).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(19)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(19)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block15).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(19)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block16).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(20)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(20)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block16).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(20)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((offhanditemid).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(25)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (sacrificeneeded >= 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(Items.SKELETON_SKULL).copy();
							_setstack.setCount((int) sacrificeneeded);
							((Slot) _slots.get(33)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}
