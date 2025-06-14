package net.basssterling.ultimatecraft.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class HaP_Equipment extends HorizontalFacingBlock {
    public static final MapCodec<HaP_Equipment> CODEC = Block.createCodec(HaP_Equipment::new);

    public HaP_Equipment(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HaP_Equipment> getCodec() {
        return CODEC;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(0.0f, 0.1f, 0.0f, 1.0f, 2.0f, 1.0f);
            case SOUTH -> VoxelShapes.cuboid(0.0f, 0.1f, 0.0f, 1.0f, 2.0f, 1.0f);
            case EAST -> VoxelShapes.cuboid(0.0f, 0.1f, 0.0f, 1.0f, 2.0f, 1.0f);
            case WEST -> VoxelShapes.cuboid(0.0f, 0.1f, 0.0f, 1.0f, 2.0f, 1.0f);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

}
