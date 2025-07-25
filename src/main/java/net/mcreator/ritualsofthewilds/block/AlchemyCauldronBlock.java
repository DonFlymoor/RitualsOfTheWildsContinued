
package net.mcreator.ritualsofthewilds.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
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
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.BiomeColors;

import net.mcreator.ritualsofthewilds.procedures.AlchemyCauldronOnTickUpdateProcedure;
import net.mcreator.ritualsofthewilds.procedures.AlchemyCauldronOnBlockRightClickedProcedure;
import net.mcreator.ritualsofthewilds.procedures.AlchemyCauldronBlockAddedProcedure;
import net.mcreator.ritualsofthewilds.init.RitualsOfTheWildsModBlocks;
import net.mcreator.ritualsofthewilds.block.entity.AlchemyCauldronBlockEntity;

public class AlchemyCauldronBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 5);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public AlchemyCauldronBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.METAL).sound(SoundType.METAL).strength(2f, 10f).lightLevel(s -> (new Object() {
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
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.BLOCK).isRedstoneConductor((bs, br, bp) -> false));
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
				default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
						box(12, 11, 4, 14, 14, 12));
				case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
						box(2, 11, 4, 4, 14, 12));
				case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
						box(4, 11, 2, 12, 14, 4));
				case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
						box(4, 11, 12, 12, 14, 14));
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
						box(12, 11, 4, 14, 14, 12));
				case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
						box(2, 11, 4, 4, 14, 12));
				case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
						box(4, 11, 2, 12, 14, 4));
				case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
						box(4, 11, 12, 12, 14, 14));
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
						box(12, 11, 4, 14, 14, 12));
				case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
						box(2, 11, 4, 4, 14, 12));
				case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
						box(4, 11, 2, 12, 14, 4));
				case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
						box(4, 11, 12, 12, 14, 14));
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
						box(12, 11, 4, 14, 14, 12));
				case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
						box(2, 11, 4, 4, 14, 12));
				case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
						box(4, 11, 2, 12, 14, 4));
				case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
						box(4, 11, 12, 12, 14, 14));
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
						box(12, 11, 4, 14, 14, 12));
				case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
						box(2, 11, 4, 4, 14, 12));
				case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
						box(4, 11, 2, 12, 14, 4));
				case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
						box(4, 11, 12, 12, 14, 14));
			};
		}
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(2, 1, 1, 14, 11, 2), box(1, 1, 2, 2, 11, 14), box(14, 1, 2, 15, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 0, 2, 14, 1, 14), box(2, 11, 4, 4, 14, 12), box(4, 11, 2, 12, 14, 4), box(4, 11, 12, 12, 14, 14),
					box(12, 11, 4, 14, 14, 12));
			case NORTH -> Shapes.or(box(2, 1, 14, 14, 11, 15), box(14, 1, 2, 15, 11, 14), box(1, 1, 2, 2, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 0, 2, 14, 1, 14), box(12, 11, 4, 14, 14, 12), box(4, 11, 12, 12, 14, 14), box(4, 11, 2, 12, 14, 4),
					box(2, 11, 4, 4, 14, 12));
			case EAST -> Shapes.or(box(1, 1, 2, 2, 11, 14), box(2, 1, 14, 14, 11, 15), box(2, 1, 1, 14, 11, 2), box(14, 1, 2, 15, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 12, 12, 14, 14), box(2, 11, 4, 4, 14, 12), box(12, 11, 4, 14, 14, 12),
					box(4, 11, 2, 12, 14, 4));
			case WEST -> Shapes.or(box(14, 1, 2, 15, 11, 14), box(2, 1, 1, 14, 11, 2), box(2, 1, 14, 14, 11, 15), box(1, 1, 2, 2, 11, 14), box(2, 0, 2, 14, 1, 14), box(4, 11, 2, 12, 14, 4), box(12, 11, 4, 14, 14, 12), box(2, 11, 4, 4, 14, 12),
					box(4, 11, 12, 12, 14, 14));
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
		world.scheduleTick(pos, this, 1);
		AlchemyCauldronBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		AlchemyCauldronOnTickUpdateProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 1);
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
		AlchemyCauldronOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AlchemyCauldronBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof AlchemyCauldronBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageWaterColor(world, pos) : -1;
		}, RitualsOfTheWildsModBlocks.ALCHEMY_CAULDRON.get());
	}
}
