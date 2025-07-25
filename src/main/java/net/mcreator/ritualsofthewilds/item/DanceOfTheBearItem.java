
package net.mcreator.ritualsofthewilds.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class DanceOfTheBearItem extends RecordItem {
	public DanceOfTheBearItem() {
		super(6, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("rituals_of_the_wilds:music_dance_of_the_bear")), new Item.Properties().stacksTo(1).rarity(Rarity.COMMON), 4400);
	}
}
