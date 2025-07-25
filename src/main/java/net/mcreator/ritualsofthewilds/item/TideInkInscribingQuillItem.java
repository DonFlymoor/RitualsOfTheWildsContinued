
package net.mcreator.ritualsofthewilds.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.ritualsofthewilds.procedures.TideInkInscribingQuillRightclickedOnBlockProcedure;

public class TideInkInscribingQuillItem extends Item {
	public TideInkInscribingQuillItem() {
		super(new Item.Properties().durability(10).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TideInkInscribingQuillRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
