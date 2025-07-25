
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ClayRuneBaseItem extends Item {
	public ClayRuneBaseItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
