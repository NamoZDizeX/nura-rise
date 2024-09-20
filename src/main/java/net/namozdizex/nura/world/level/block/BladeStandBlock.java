package net.namozdizex.nura.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class BladeStandBlock extends Block {
    public BladeStandBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(0, 0, 4, 16, 1, 13),
            Block.box(1, 1, 6, 2, 6, 7),
            Block.box(1, 1, 10, 2, 9, 11),
            Block.box(14, 1, 10, 15, 9, 11),
            Block.box(14, 1, 6, 15, 6, 7),
            Block.box(1, -3, 6, 2, 0, 7),
            Block.box(14, -3, 6, 15, 0, 7),
            Block.box(14, -3, 11, 15, 0, 12),
            Block.box(1, -3, 11, 2, 0, 12),
            Block.box(-5, 5, 5, 20, 7, 6),
            Block.box(-5, 8, 9, 20, 10, 10)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
