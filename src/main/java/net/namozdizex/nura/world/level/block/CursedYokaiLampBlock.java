package net.namozdizex.nura.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.namozdizex.nura.registry.NRBlocks;

import java.util.stream.Stream;

public class CursedYokaiLampBlock extends Block {
    public CursedYokaiLampBlock(Properties properties) {
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
        return adjacentBlockState.getBlock() == NRBlocks.YOKAI_LAMP || adjacentBlockState.getBlock() == NRBlocks.TAMATSUKI_LAMP;
    }
}
