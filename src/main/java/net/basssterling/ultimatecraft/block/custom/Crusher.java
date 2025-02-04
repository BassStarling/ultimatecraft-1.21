package net.basssterling.ultimatecraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Crusher extends Block {
    public Crusher(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.COBBLED_DEEPSLATE){
                itemEntity.setStack(new ItemStack(Items.GRAVEL, itemEntity.getStack().getCount()));
            }
        }
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.COBBLESTONE){
                itemEntity.setStack(new ItemStack(Items.GRAVEL, itemEntity.getStack().getCount()));
            }
        }
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.ultimatecraft.crusher.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.ultimatecraft.crusher"));
            tooltip.add(Text.translatable("tooltip.ultimatecraft.crusher.1"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}