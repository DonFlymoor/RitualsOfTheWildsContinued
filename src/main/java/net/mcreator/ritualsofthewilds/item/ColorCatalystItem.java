
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ColorCatalystItem extends Item {
	public ColorCatalystItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
