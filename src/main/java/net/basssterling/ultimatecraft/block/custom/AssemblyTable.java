package net.basssterling.ultimatecraft.block.custom;

import com.mojang.serialization.MapCodec;
import net.basssterling.ultimatecraft.block.entity.custom.AssemblyBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockWithEntity;

public class AssemblyTable extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(2, 0, 2, 14, 13, 14);
    public static final MapCodec<AssemblyTable> CODEC = AssemblyTable.createCodec(AssemblyTable::new);

    public AssemblyTable(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AssemblyBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof AssemblyBlockEntity) {
                ItemScatterer.spawn(world, pos, (AssemblyBlockEntity) blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof AssemblyBlockEntity assembryBlockEntity) {
            if (assembryBlockEntity.isEmpty() && !stack.isEmpty()) {
                assembryBlockEntity.setStack(0, stack.copyWithCount(1));
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);
                stack.decrement(1);

                assembryBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if (stack.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnPedestal = assembryBlockEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnPedestal);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                assembryBlockEntity.clear();

                assembryBlockEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            } else if (player.isSneaking() && !world.isClient()) {
                player.openHandledScreen(assembryBlockEntity);
            }
        }
        return ItemActionResult.SUCCESS;
    }
//以前までgetTickerの仕事をしていた。現役で働いているcheckTypeのものも実装されてはいるが、実際には働いていない。
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        if (type == ModBlockEntities.ASSEMBLY_BE) {
//            return (world1, pos, state1, be) -> {
//                if (be instanceof AssemblyBlockEntity entity) {
//                    entity.tick(world1,pos,state1); // インスタンスメソッドとして呼び出し
//                }
//            };
//        }
//        return null;
//    }
    public static <T extends BlockEntity> boolean checkType(BlockEntityType<T> type, BlockEntityType<?> expectedType) {
        return type == expectedType;
    }
}