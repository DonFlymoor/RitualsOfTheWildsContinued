
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NullHeartItem extends Item {
	public NullHeartItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
