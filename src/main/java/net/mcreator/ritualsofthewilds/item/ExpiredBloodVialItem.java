
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ExpiredBloodVialItem extends Item {
	public ExpiredBloodVialItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
