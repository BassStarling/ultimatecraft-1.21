package net.basssterling.ultimatecraft.recipe;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<StrainerRecipe> STRAINER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(UltimateCraft.MOD_ID,"strainer"),
            new StrainerRecipe.Serializer());
    public static final RecipeType<StrainerRecipe> STRAINER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(UltimateCraft.MOD_ID, "strainer"), new RecipeType<StrainerRecipe>() {
                @Override
                public String toString() {
                    return "strainer";
                }
            }
    );
    public static void registerRecipes() {
        UltimateCraft.LOGGER.info("Registering Custom Recipes for " + UltimateCraft.MOD_ID);
    }
}
