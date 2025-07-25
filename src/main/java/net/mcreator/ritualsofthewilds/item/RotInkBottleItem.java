
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.ritualsofthewilds.procedures.RotInkBottleRightclickedOnBlockProcedure;

public class RotInkBottleItem extends Item {
	public RotInkBottleItem() {
		super(new Item.Properties().durability(5).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		RotInkBottleRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
