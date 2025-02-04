package net.basssterling.ultimatecraft.block.custom;

import net.basssterling.ultimatecraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sifter extends Block {
    public Sifter(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.GRAVEL) {
                itemEntity.setStack(new ItemStack(ModItems.ALUMINIUM_ALLOY, itemEntity.getStack().getCount()));
            }
        }
    }
}