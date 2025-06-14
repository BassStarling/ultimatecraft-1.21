package net.basssterling.ultimatecraft.world;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> TROA_ORE_KEY = registerKey("troa_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> LIME_KEY = registerKey("lime");
    public static final RegistryKey<ConfiguredFeature<?,?>> BAUXITE_KEY = registerKey("bauxite");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest clayReplacebles = new BlockMatchRuleTest(Blocks.CLAY);
        RuleTest limeReplacebles = new BlockMatchRuleTest(Blocks.GRAVEL);
        RuleTest bauxiteReplacebles = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTroaOres =
                List.of(OreFeatureConfig.createTarget(clayReplacebles, ModBlocks.TRONA_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldLimes =
                List.of(OreFeatureConfig.createTarget(limeReplacebles, ModBlocks.LIME.getDefaultState()));
        List<OreFeatureConfig.Target> overworldBauxites =
                List.of(OreFeatureConfig.createTarget(bauxiteReplacebles, ModBlocks.BAUXITE_ORE.getDefaultState()));

        register(context, TROA_ORE_KEY,Feature.ORE, new OreFeatureConfig(overworldTroaOres,40));
        register(context, LIME_KEY,Feature.ORE,new OreFeatureConfig(overworldLimes,40));
        register(context, BAUXITE_KEY,Feature.ORE,new OreFeatureConfig(overworldBauxites,9));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(UltimateCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC featureconfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureconfig));
    }
}
