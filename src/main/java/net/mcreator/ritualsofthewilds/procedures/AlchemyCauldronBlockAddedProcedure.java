package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AlchemyCauldronBlockAddedProcedure {
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
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon minecraft:armor_stand ~ ~0.75 ~ {DisabledSlots:4144959, Invulnerable:true, NoGravity:1b,Invisible:1b,Tags:[\"" + "" + ((new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fly1") + "\", \"cauldron\"]}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon minecraft:armor_stand ~ ~0.75 ~ {DisabledSlots:4144959, Invulnerable:true, NoGravity:1b,Invisible:1b,Tags:[\"" + "" + ((new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "nbtname")) + "fly2") + "\", \"cauldron\"]}"));
		}
	}
}
