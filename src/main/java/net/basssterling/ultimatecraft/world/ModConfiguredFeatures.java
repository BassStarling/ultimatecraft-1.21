package net.basssterling.ultimatecraft.world;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
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

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest clayReplacebles = new BlockMatchRuleTest(Blocks.CLAY);
        RuleTest limeReplacebles = new BlockMatchRuleTest(Blocks.GRAVEL);

        List<OreFeatureConfig.Target> overworldTroaOres =
                List.of(OreFeatureConfig.createTarget(clayReplacebles, ModBlocks.TRONA_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldLimes =
                List.of(OreFeatureConfig.createTarget(limeReplacebles, ModBlocks.LIME.getDefaultState()));


        register(context, TROA_ORE_KEY,Feature.ORE, new OreFeatureConfig(overworldTroaOres,12));
        register(context, LIME_KEY,Feature.ORE,new OreFeatureConfig(overworldLimes,12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(UltimateCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
