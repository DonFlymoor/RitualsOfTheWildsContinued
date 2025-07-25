package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class TakenItemFromSlot1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack durabilit1 = ItemStack.EMPTY;
		ItemStack durabilit2 = ItemStack.EMPTY;
		durabilit1 = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 13));
		durabilit2 = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 14));
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 0;
				final int _amount = 1;
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						ItemStack _stk = capability.getStackInSlot(_slotid).copy();
						_stk.shrink(_amount);
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
					}
				});
			}
		}
		{
			ItemStack _ist = durabilit1;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		{
			ItemStack _ist = durabilit2;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 13;
				final ItemStack _setstack = durabilit1.copy();
				_setstack.setCount(1);
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 14;
				final ItemStack _setstack = durabilit2.copy();
				_setstack.setCount(1);
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.step")), SoundSource.BLOCKS, 1, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bamboo.step")), SoundSource.BLOCKS, 1, (float) 0.5, false);
			}
		}
	}
}
