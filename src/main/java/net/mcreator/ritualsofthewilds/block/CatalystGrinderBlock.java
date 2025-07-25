
package net.mcreator.ritualsofthewilds.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.procedures.CatalystGrinderOnBlockRightClickedProcedure;
import net.mcreator.ritualsofthewilds.procedures.CatalystGrinderAddedProcedure;
import net.mcreator.ritualsofthewilds.block.entity.CatalystGrinderBlockEntity;

public class CatalystGrinderBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 11);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CatalystGrinderBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.STONE).sound(SoundType.STONE).strength(3f, 4f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				if (s.getValue(BLOCKSTATE) == 10)
					return 0;
				if (s.getValue(BLOCKSTATE) == 11)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 10) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		if (state.getValue(BLOCKSTATE) == 11) {
			return switch (state.getValue(FACING)) {
				default -> box(3, 0, 3, 14, 13, 14);
				case NORTH -> box(2, 0, 2, 13, 13, 13);
				case EAST -> box(3, 0, 2, 14, 13, 13);
				case WEST -> box(2, 0, 3, 13, 13, 14);
			};
		}
		return switch (state.getValue(FACING)) {
			default -> box(3, 0, 3, 14, 13, 14);
			case NORTH -> box(2, 0, 2, 13, 13, 13);
			case EAST -> box(3, 0, 2, 14, 13, 13);
			case WEST -> box(2, 0, 3, 13, 13, 14);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		CatalystGrinderAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		CatalystGrinderOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CatalystGrinderBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
