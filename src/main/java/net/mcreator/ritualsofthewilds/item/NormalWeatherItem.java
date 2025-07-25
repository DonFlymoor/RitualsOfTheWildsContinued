
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NormalWeatherItem extends Item {
	public NormalWeatherItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
