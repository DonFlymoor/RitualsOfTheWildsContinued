
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;

public class LavaAlchemyBottleItem extends Item {
	public LavaAlchemyBottleItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(RitualsOfTheWildsModItems.ALCHEMY_BOTTLE.get());
	}
}
