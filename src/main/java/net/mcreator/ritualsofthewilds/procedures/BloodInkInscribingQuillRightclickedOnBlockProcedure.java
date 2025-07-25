package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

public class BloodInkInscribingQuillRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_YR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_FEOH.get().defaultBlockState(), 3);
			{
				Direction _dir = ((entity.getDirection()).getOpposite());
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			if (itemstack.getDamageValue() >= 9) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_FEOH.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_JEAR.get().defaultBlockState(), 3);
			{
				Direction _dir = ((entity.getDirection()).getOpposite());
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			if (itemstack.getDamageValue() >= 9) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_JEAR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_IAR.get().defaultBlockState(), 3);
			{
				Direction _dir = ((entity.getDirection()).getOpposite());
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			if (itemstack.getDamageValue() >= 9) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RitualsOfTheWildsModBlocks.BLOOD_IAR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_YR.get().defaultBlockState(), 3);
			{
				Direction _dir = ((entity.getDirection()).getOpposite());
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			if (itemstack.getDamageValue() >= 9) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:rune_replacable"))) == true) {
			if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.UP) == true) {
				world.setBlock(BlockPos.containing(x, y + 1, z), RitualsOfTheWildsModBlocks.BLOOD_FEOH.get().defaultBlockState(), 3);
				{
					Direction _dir = ((entity.getDirection()).getOpposite());
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else {
						_property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (itemstack.getDamageValue() >= 9) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = itemstack;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(RitualsOfTheWildsModItems.INSCRIBING_QUILL.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
