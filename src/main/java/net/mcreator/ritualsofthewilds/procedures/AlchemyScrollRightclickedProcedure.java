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

import net.mcreator.ritualsofthewilds.world.inventory.AlchemyScrollGUIMenu;
import net.mcreator.ritualsofthewilds.network.RitualsOfTheWildsModVariables;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

public class AlchemyScrollRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		File file = new File("");
		ItemStack itemtomake = ItemStack.EMPTY;
		com.google.gson.JsonObject object = new com.google.gson.JsonObject();
		double moonstage = 0;
		double rituallevel = 0;
		double minammount = 0;
		double ritualnumber = 0;
		double filling = 0;
		boolean canbespawnedinn = false;
		boolean fullmoonneed = false;
		boolean commandthing = false;
		boolean runesneeded = false;
		boolean showlowerthing = false;
		boolean showupperthing = false;
		String result = "";
		String ritualname = "";
		String ingredient1 = "";
		String ingredient2 = "";
		String ingredient3 = "";
		String ingredient4 = "";
		String ingredient5 = "";
		String ingredient6 = "";
		String ingredient7 = "";
		String ingredient8 = "";
		String ingredient9 = "";
		String ingredient10 = "";
		String block1 = "";
		String block2 = "";
		String block3 = "";
		String block4 = "";
		String block5 = "";
		String block6 = "";
		String block7 = "";
		String block8 = "";
		String upperblock1 = "";
		String upperblock2 = "";
		String upperblock3 = "";
		String upperblock4 = "";
		String upperblock5 = "";
		String upperblock6 = "";
		String upperblock7 = "";
		String upperblock8 = "";
		if ((itemstack.getOrCreateTag().getString("alchemy_recipe")).equals("")) {
			while ((itemstack.getOrCreateTag().getString("alchemy_recipe")).equals("")) {
				ritualnumber = Mth.nextDouble(RandomSource.create(), 1, 500);
				file = new File(
						(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/"
								+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
						File.separator + (new java.text.DecimalFormat("##").format(ritualnumber) + "alchemyrecipe.json"));
				if (file.exists() == false) {
					file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/eng"), File.separator + (new java.text.DecimalFormat("##").format(ritualnumber) + "alchemyrecipe.json"));
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
							canbespawnedinn = object.get("May Spawn In Alchemy Scroll").getAsBoolean();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (canbespawnedinn == true) {
						itemstack.getOrCreateTag().putString("alchemy_recipe", (new java.text.DecimalFormat("##").format(ritualnumber) + "alchemyrecipe.json"));
					}
				}
			}
		} else {
			file = new File(
					(FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/"
							+ (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).languagesetted),
					File.separator + (itemstack.getOrCreateTag().getString("alchemy_recipe")));
			if (file.exists() == false) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/Rituals_of_the_wilds/Alchemy_Cauldron/eng"), File.separator + (itemstack.getOrCreateTag().getString("alchemy_recipe")));
			}
			if (file.exists() == true) {
				if (!(((entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).alchemyscrollsseen)
						.contains((itemstack.getOrCreateTag().getString("alchemy_recipe")).replace(".json", "")) == true)) {
					{
						String _setval = (entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RitualsOfTheWildsModVariables.PlayerVariables())).alchemyscrollsseen + ""
								+ (itemstack.getOrCreateTag().getString("alchemy_recipe")).replace(".json", "");
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.alchemyscrollsseen = _setval;
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
						commandthing = object.get("Execute Command Instead of Giving Item").getAsBoolean();
						ingredient1 = object.get("Ingredient ID or Tag 1").getAsString();
						ingredient2 = object.get("Ingredient ID or Tag 2").getAsString();
						ingredient3 = object.get("Ingredient ID or Tag 3").getAsString();
						ingredient4 = object.get("Ingredient ID or Tag 4").getAsString();
						ingredient5 = object.get("Ingredient ID or Tag 5").getAsString();
						ingredient6 = object.get("Ingredient ID or Tag 6").getAsString();
						ingredient7 = object.get("Ingredient ID or Tag 7").getAsString();
						ingredient8 = object.get("Ingredient ID or Tag 8").getAsString();
						ingredient9 = object.get("Ingredient ID or Tag 9").getAsString();
						ingredient10 = object.get("Ingredient ID or Tag 10").getAsString();
						fullmoonneed = object.get("Moon Stage Needed").getAsBoolean();
						moonstage = object.get("Moon Stage").getAsDouble();
						runesneeded = object.get("Runes on cauldron needed").getAsBoolean();
						filling = object.get("Cauldron Fill Type").getAsDouble();
						showupperthing = object.get("Check for Blocks +2Y(Only works with Check for blocks around true)").getAsBoolean();
						showlowerthing = object.get("Check for blocks around").getAsBoolean();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("AlchemyScrollGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new AlchemyScrollGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.85, (float) 0.75);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.book.page_turn")), SoundSource.PLAYERS, (float) 0.85, (float) 0.75, false);
					}
				}
				if (showupperthing == true) {
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
							upperblock1 = object.get("Block X+3 Y+2 ID Or Tag").getAsString();
							upperblock2 = object.get("Block X-3 Y+2 ID Or Tag").getAsString();
							upperblock3 = object.get("Block Y+2 Z+3 ID Or Tag").getAsString();
							upperblock4 = object.get("Block Y+2 Z-3 ID Or Tag").getAsString();
							upperblock5 = object.get("Block X+2 Y+2 Z+2 ID Or Tag").getAsString();
							upperblock6 = object.get("Block X-2 Y+2 Z+2 ID Or Tag").getAsString();
							upperblock7 = object.get("Block X+2 Y+2 Z-2 ID Or Tag").getAsString();
							upperblock8 = object.get("Block X-2 Y+2 Z-2 ID Or Tag").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (!(upperblock1).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock1).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(26)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(26)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock1).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(26)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock2).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock2).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(22)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(22)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock2).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(22)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock3).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock3).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(24)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(24)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock3).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(24)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock4).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock4).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(20)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(20)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock4).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(20)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock5).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock5).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(25)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(25)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock5).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(25)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock6).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock6).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(23)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(23)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock6).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(23)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock7).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock7).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(27)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(27)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock7).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(27)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(upperblock8).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((upperblock8).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(21)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(21)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((upperblock8).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(21)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					{
						boolean _setval = true;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.showupperblock = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(26)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(22)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(24)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(20)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(25)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(23)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(27)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(21)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					{
						boolean _setval = false;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.showupperblock = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (showlowerthing == true) {
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
							block1 = object.get("Block X+3 ID Or Tag").getAsString();
							block2 = object.get("Block X-3 ID Or Tag").getAsString();
							block3 = object.get("Block Z+3 ID Or Tag").getAsString();
							block4 = object.get("Block Z-3 ID Or Tag").getAsString();
							block5 = object.get("Block X+2 Z+2 ID Or Tag").getAsString();
							block6 = object.get("Block X-2 Z+2 ID Or Tag").getAsString();
							block7 = object.get("Block X+2 Z-2 ID Or Tag").getAsString();
							block8 = object.get("Block X-2 Z-2 ID Or Tag").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (!(block1).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block1).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(10)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(10)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block1).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(10)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block2).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block2).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(14)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(14)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block2).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(14)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block3).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block3).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(17)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(17)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block3).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(17)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block4).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block4).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(11)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(11)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block4).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(11)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block5).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block5).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(16)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(16)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block5).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(16)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block6).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block6).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(15)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(15)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block6).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(15)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block7).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block7).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(12)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(12)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block7).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(12)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					if (!(block8).equals("")) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((block8).toLowerCase(java.util.Locale.ENGLISH)))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(13)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(13)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack _setstack = new ItemStack(
										(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((block8).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
								_setstack.setCount(1);
								((Slot) _slots.get(13)).set(_setstack);
								_player.containerMenu.broadcastChanges();
							}
						}
					}
					{
						boolean _setval = true;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.showlowerblock = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(10)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(14)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(17)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(11)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(16)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(15)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(12)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(13)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					{
						boolean _setval = false;
						entity.getCapability(RitualsOfTheWildsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.showlowerblock = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (commandthing == false) {
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
							ritualname = object.get("Name for Alchemy Scroll").getAsString();
							result = object.get("Result item ID").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((result).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount((int) minammount);
						((Slot) _slots.get(28)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					itemstack.getOrCreateTag().putString("name_of_alchemy_recipe", ritualname);
				} else if (commandthing == true) {
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
							minammount = object.get("Min/Fixed result execution count").getAsDouble();
							result = object.get("Info about result").getAsString();
							ritualname = object.get("Name for Alchemy Scroll").getAsString();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					itemtomake = new ItemStack(RitualsOfTheWildsModItems.ABOUT_RITUAL.get());
					itemtomake.getOrCreateTag().putString("infodescription", result);
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = itemtomake.copy();
						_setstack.setCount((int) minammount);
						((Slot) _slots.get(28)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					itemstack.getOrCreateTag().putString("name_of_alchemy_recipe", ritualname);
				}
				if (fullmoonneed == true) {
					if (moonstage <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FULL_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 1) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_GIBBOUS_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 2) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LAST_QUARTER_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 3) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WANING_CRESCENT_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 4) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NEW_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 5) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_CRESCENT_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage == 6) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FIRST_QUARTER_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					} else if (moonstage >= 7) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.WAXING_GIBBOUS_MOON.get()).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(18)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(18)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				if (runesneeded == true) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.RUNIC_ALCHEMY_CAULDRON_SHOW.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(29)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.NORMAL_ALCHEMY_CAULDRON_SHOW.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(29)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				if (filling <= 0) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.EMPTY_ALCHEMY_CAULDRON_SHOW.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(19)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (filling == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FILLED_WITH_WATER_ALCHEMY_CAULDRON_SHOW.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(19)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (filling >= 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FILLED_WITH_LAVA_ALCHEMY_CAULDRON_SHOW.get()).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(19)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				if (!(ingredient1).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient1).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient1).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(0)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient2).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient2).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(1)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient2).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(1)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient3).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient3).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(2)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient3).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(2)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient4).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient4).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(3)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient4).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(3)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient5).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient5).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(4)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient5).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(4)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient6).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient6).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(5)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient6).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(5)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient7).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient7).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(6)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient7).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(6)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient8).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient8).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(7)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(7)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient8).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(7)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient9).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient9).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(8)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(8)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient9).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(8)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
				if (!(ingredient10).equals("")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((ingredient10).toLowerCase(java.util.Locale.ENGLISH)))).copy();
						_setstack.setCount(1);
						((Slot) _slots.get(9)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(9)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack _setstack = new ItemStack(
									(ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation((ingredient10).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))).copy();
							_setstack.setCount(1);
							((Slot) _slots.get(9)).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
					}
				}
			}
		}
	}
}
