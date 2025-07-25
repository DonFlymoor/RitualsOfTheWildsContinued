package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.RitualsOfTheWildsMod;

public class InscribingQuillRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.BLOOD_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.BLOOD_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.ASH_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.ASH_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.BLOOM_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.BLOOM_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.ELDRITCH_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.ELDRITCH_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.EMBER_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.EMBER_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.FROST_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.FROST_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.LUNAR_SAP_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.LUNAR_SAP_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.MOONLIGHT_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.MOONLIGHT_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.MUSHROOM_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.MUSHROOM_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.PALE_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.PALE_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.ROOT_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.ROOT_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.ROT_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.ROT_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.SHADOW_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.SHADOW_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.SPIRIT_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.SPIRIT_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.STORM_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.STORM_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.TIDE_INK_BOTTLE.get()) {
			itemstack.shrink(1);
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			RitualsOfTheWildsMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.TIDE_INK_INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		}
	}
}
