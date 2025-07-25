
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VoidDustItem extends Item {
	public VoidDustItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
