
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EmptyAlchemyCauldronShowItem extends Item {
	public EmptyAlchemyCauldronShowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
