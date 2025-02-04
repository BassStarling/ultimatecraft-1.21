package net.basssterling.ultimatecraft.block.custom;

import net.basssterling.ultimatecraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MachiningBlock extends Block {
    public MachiningBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.0F, 1.0F);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.PIPE){
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.BONE_MEAL){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.BONE){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.BONE_BLOCK){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.ROTTEN_FLESH){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.SPIDER_EYE){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.PORKCHOP){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.RABBIT){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.PUFFERFISH){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.TROPICAL_FISH){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.SALMON){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.MUTTON){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.RABBIT_FOOT){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.RABBIT_HIDE){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.LEATHER){
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == Items.COD) {
                itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }
                if(entity instanceof ItemEntity itemEntity) {
                    if (itemEntity.getStack().getItem() == Items.CHICKEN){
                        itemEntity.setStack(new ItemStack(ModItems.PETROLEUM, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.ultimatecraft.machining_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
