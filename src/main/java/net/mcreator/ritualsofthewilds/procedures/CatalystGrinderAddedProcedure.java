package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class CatalystGrinderAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "nbtname")).equals("")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("nbtname",
							(new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + "" + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999)) + new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))
									+ new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 9999999))));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
