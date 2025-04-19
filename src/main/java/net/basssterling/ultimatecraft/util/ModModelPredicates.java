package net.basssterling.ultimatecraft.util;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void regiserModelPredicates() {
        registerCustomBow(ModItems.GHASTGUN);
    }
    private static void registerCustomBow(Item item){
        ModelPredicateProviderRegistry.register(Items.BOW, Identifier.ofVanilla("pull"),
                (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(
                Items.BOW,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
