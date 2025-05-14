package net.basssterling.ultimatecraft.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.GameEventListener;
import org.spongepowered.asm.logging.Level;

public record StrainerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<StrainerRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(StrainerRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(StrainerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width,int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STRAINER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.STRAINER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<StrainerRecipe> {
        public static final MapCodec<StrainerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(StrainerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(StrainerRecipe::output)
        ).apply(inst, StrainerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, StrainerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, StrainerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, StrainerRecipe::output,
                        StrainerRecipe::new);

        @Override
        public MapCodec<StrainerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, StrainerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
