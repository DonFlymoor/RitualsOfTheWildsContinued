package net.mcreator.ritualsofthewilds.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModItems;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PotTheFlowerProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.BLOOD_FERN.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.BLOOD_FERN_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.DREAM_VINE.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.DREAM_VINE_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.EMBER_LEAF_BERRY.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.EMBER_LEAF_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.ETHERGRASS.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.ETHER_GRASS_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.MISTCAP_MUSHROOM.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.MISTCAP_MUSHROOM_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.MOONPETAL.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.MOON_PETAL_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.SPIRITBLOOM.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SPIRIT_BLOOM_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.SUNS_TEAR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.SUNS_TEAR_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.THORNBLOOM.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.THORN_BLOOM_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.VOIDROOT.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.VOIDROOT_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModItems.WITCHTHORN.get()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.WITCH_THORN_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RitualsOfTheWildsModBlocks.CORRUPTED_SAPLING.get().asItem()) {
			world.setBlock(BlockPos.containing(x, y, z), RitualsOfTheWildsModBlocks.CORRUPTED_SAPLING_POT.get().defaultBlockState(), 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		}
	}
}
