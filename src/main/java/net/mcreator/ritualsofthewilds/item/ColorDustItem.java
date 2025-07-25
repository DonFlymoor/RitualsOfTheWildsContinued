
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ColorDustItem extends Item {
	public ColorDustItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
