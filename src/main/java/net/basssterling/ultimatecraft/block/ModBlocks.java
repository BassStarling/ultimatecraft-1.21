package net.basssterling.ultimatecraft.block;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
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
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

public class ModBlocks {
    public static final Block HEATING_AND_PRESSING_EQUIPMENT = registerBlock("heating_and_pressing_equipment",
            new HaP_Equipment(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block BAUXITE_ORE = registerBlock("bauxite_ore",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool()) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown.1"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown.2"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.1"));
                    }
                }
            });

    public static final Block BAUXITE_DEEPSLATE_ORE = registerBlock("bauxite_deepslate_ore",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown.1"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.shiftdown.2"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite"));
                        tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.1"));
                    }
                }
            });

    public static final Block RAW_BAUXITE_BLOCK = registerBlock("raw_bauxite_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block TRONA_BLOCK = registerBlock("trona_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block TRONA_ORE = registerBlock("trona_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block TRONA_DEEPSLATE_ORE = registerBlock("trona_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f)
                            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.ultimatecraft.TRONA_DEEPSLATE_ORE.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }});

    public static final Block LIME = registerBlock("lime",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.TUFF)));

    public static final Block STRAINER = registerBlock("strainer",
            new StrainerBlock(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool()){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.ultimatecraft.strainer.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }});

    public static final Block ASSEMBLY_TABLE = registerBlock("assembly_table",
            new AssemblyTable(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

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