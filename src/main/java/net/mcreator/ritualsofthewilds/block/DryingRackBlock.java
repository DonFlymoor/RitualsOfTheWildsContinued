
package net.mcreator.ritualsofthewilds.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.ritualsofthewilds.procedures.DryingRackOnTickUpdateProcedure;
import net.mcreator.ritualsofthewilds.procedures.DryingRackOnBlockRightClickedProcedure;
import net.mcreator.ritualsofthewilds.procedures.DryingRackBlockAddedProcedure;
import net.mcreator.ritualsofthewilds.block.entity.DryingRackBlockEntity;

public class DryingRackBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 3);

	public DryingRackBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(2f, 3f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.BLOCK).isRedstoneConductor((bs, br, bp) -> false));
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
			return Shapes.or(box(0, 6, 0, 2, 8, 16), box(2, 6, 14, 14, 8, 16), box(2, 6, 0, 14, 8, 2), box(14, 6, 0, 16, 8, 16), box(0, 4, 0, 16, 6, 16), box(0, 2, 0, 2, 4, 16), box(2, 2, 14, 14, 4, 16), box(2, 2, 0, 14, 4, 2),
					box(14, 2, 0, 16, 4, 16), box(0, 0, 0, 16, 2, 16));
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return Shapes.or(box(0, 10, 0, 2, 12, 16), box(2, 10, 14, 14, 12, 16), box(2, 10, 0, 14, 12, 2), box(14, 10, 0, 16, 12, 16), box(0, 8, 0, 16, 10, 16), box(0, 6, 0, 2, 8, 16), box(2, 6, 14, 14, 8, 16), box(2, 6, 0, 14, 8, 2),
					box(14, 6, 0, 16, 8, 16), box(0, 4, 0, 16, 6, 16), box(0, 2, 0, 2, 4, 16), box(2, 2, 14, 14, 4, 16), box(2, 2, 0, 14, 4, 2), box(14, 2, 0, 16, 4, 16), box(0, 0, 0, 16, 2, 16));
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return Shapes.or(box(0, 14, 0, 2, 16, 16), box(2, 14, 14, 14, 16, 16), box(2, 14, 0, 14, 16, 2), box(14, 14, 0, 16, 16, 16), box(0, 12, 0, 16, 14, 16), box(0, 10, 0, 2, 12, 16), box(2, 10, 14, 14, 12, 16), box(2, 10, 0, 14, 12, 2),
					box(14, 10, 0, 16, 12, 16), box(0, 8, 0, 16, 10, 16), box(0, 6, 0, 2, 8, 16), box(2, 6, 14, 14, 8, 16), box(2, 6, 0, 14, 8, 2), box(14, 6, 0, 16, 8, 16), box(0, 4, 0, 16, 6, 16), box(0, 2, 0, 2, 4, 16), box(2, 2, 14, 14, 4, 16),
					box(2, 2, 0, 14, 4, 2), box(14, 2, 0, 16, 4, 16), box(0, 0, 0, 16, 2, 16));
		}
		return Shapes.or(box(0, 2, 0, 2, 4, 16), box(2, 2, 14, 14, 4, 16), box(2, 2, 0, 14, 4, 2), box(14, 2, 0, 16, 4, 16), box(0, 0, 0, 16, 2, 16));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BLOCKSTATE);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
		DryingRackBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		DryingRackOnTickUpdateProcedure.execute(world, x, y, z);
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
		DryingRackOnBlockRightClickedProcedure.execute(world, x, y, z, entity, hitY);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new DryingRackBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}
}
