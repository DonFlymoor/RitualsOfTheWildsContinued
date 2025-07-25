
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RainNeededItem extends Item {
	public RainNeededItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
