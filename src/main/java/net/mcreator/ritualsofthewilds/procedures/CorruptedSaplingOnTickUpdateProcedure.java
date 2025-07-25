package net.mcreator.ritualsofthewilds.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CorruptedSaplingOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double random = 0;
		boolean cans = false;
		random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 2));
		if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == false && world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() == false && world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude() == false
				&& world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude() == false && world.getBlockState(BlockPos.containing(x, y + 5, z)).canOcclude() == false
				&& world.getBlockState(BlockPos.containing(x, y + 6, z)).canOcclude() == false && world.getBlockState(BlockPos.containing(x, y + 7, z)).canOcclude() == false
				&& world.getBlockState(BlockPos.containing(x, y + 8, z)).canOcclude() == false && world.getBlockState(BlockPos.containing(x, y + 9, z)).canOcclude() == false) {
			if (random == 1) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_1"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y - 1, z - 4), BlockPos.containing(x - 4, y - 1, z - 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 2) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_2"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 7, y - 1, z - 6), BlockPos.containing(x - 7, y - 1, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 3) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_3"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 7, y - 1, z - 6), BlockPos.containing(x - 7, y - 1, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 4) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_4"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 5, y - 1, z - 9), BlockPos.containing(x - 5, y - 1, z - 9), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 5) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_5"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 7, y - 1, z - 6), BlockPos.containing(x - 7, y - 1, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 6) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_6"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y - 1, z - 4), BlockPos.containing(x - 8, y - 1, z - 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 7) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_7"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y - 1, z - 4), BlockPos.containing(x - 3, y - 1, z - 4), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (random == 8) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("rituals_of_the_wilds", "cursed_tree_8"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y - 1, z - 7), BlockPos.containing(x - 4, y - 1, z - 7), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			}
		}
	}
}
