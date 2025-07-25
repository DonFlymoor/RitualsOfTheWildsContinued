
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ThunderNeededItem extends Item {
	public ThunderNeededItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
