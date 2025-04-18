package net.basssterling.ultimatecraft.world.gen;

import net.basssterling.ultimatecraft.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER,BiomeKeys.FROZEN_RIVER), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.TROA_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH,BiomeKeys.SNOWY_BEACH,BiomeKeys.STONY_SHORE,BiomeKeys.WARM_OCEAN), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LIME_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.BAUXITE_PLACED_KEY);
    }
}