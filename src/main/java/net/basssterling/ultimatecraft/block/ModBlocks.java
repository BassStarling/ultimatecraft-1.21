package net.basssterling.ultimatecraft.block;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.custom.Crusher;
import net.basssterling.ultimatecraft.block.custom.MachiningBlock;
import net.basssterling.ultimatecraft.block.custom.Sifter;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBlocks {

    public static final Block CHARGED_LIGHTNING_ROD = registerBlock("charged_lightning_rod",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block MACHINING_BLOCK = registerBlock("machining_block",
            new MachiningBlock(AbstractBlock.Settings.create().strength(5f)
            .requiresTool()));

    public static final Block ALUMINIUM_BLOCK = registerBlock("aluminium_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
            .requiresTool()){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.ultimatecraft.aluminium_block.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }});

    public static final Block CYLINDER_HEAD = registerBlock("cylinder_head",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool()){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.ultimatecraft.cylinder_head.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }});

    public static final Block CRUSHER = registerBlock("crusher",
            new Crusher(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block SIFTER = registerBlock("sifter",
            new Sifter(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
            tooltip.add(Text.translatable("tooltip.ultimatecraft.sifter.tooltip"));
            super.appendTooltip(stack, context, tooltip, options);
        }});

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(UltimateCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(UltimateCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        UltimateCraft.LOGGER.info("Registering Mod Blocks for " + UltimateCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModBlocks.ALUMINIUM_BLOCK);
        });
    }
}