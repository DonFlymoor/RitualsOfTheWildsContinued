
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.ritualsofthewilds.procedures.BloodVialItemInInventoryTickProcedure;

public class BloodVialItem extends Item {
	public BloodVialItem() {
		super(new Item.Properties().durability(2400).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BloodVialItemInInventoryTickProcedure.execute(entity, itemstack);
	}
}
