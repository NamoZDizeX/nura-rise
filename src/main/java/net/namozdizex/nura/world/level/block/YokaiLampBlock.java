package net.namozdizex.nura.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.namozdizex.nura.registry.NRBlocks;

import java.util.stream.Stream;

public class YokaiLampBlock extends Block implements SimpleWaterloggedBlock{
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    
    public YokaiLampBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(3, 1, 3, 13, 15, 13), Block.box(4, 0, 4, 12, 1, 12), Block.box(4, 15, 4, 12, 16, 12)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
    @Override
    public boolean skipRendering(BlockState blockState, BlockState adjacentBlockState, Direction direction)
    {
        return adjacentBlockState.getBlock() == NRBlocks.YOKAI_LAMP || adjacentBlockState.getBlock() == NRBlocks.UNFIRE_YOKAI_LAMP;
    }
    
    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos)
    {
        var direction = blockState.getValue(FACING);
        var blockPos2 = blockPos.relative(direction.getOpposite());
        return level.getBlockState(blockPos2).isFaceSturdy(level, blockPos2, direction);
    }
    
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos)
    {
        if (blockState.getValue(WATERLOGGED))
        {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return direction == blockState.getValue(FACING).getOpposite() && !blockState.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, neighborState, level, currentPos, neighborPos);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        var levelAccessor = context.getLevel();
        var blockPos = context.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER).setValue(FACING, context.getClickedFace());
    }
    
    public FluidState getFluidState(BlockState blockState)
    {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED, FACING);
    }
}
