package net.basssterling.ultimatecraft.block.entity.custom;

import net.basssterling.ultimatecraft.block.entity.ImplementedInventory;
import net.basssterling.ultimatecraft.block.entity.ModBlockEntities;
import net.basssterling.ultimatecraft.item.ModItems;
import net.basssterling.ultimatecraft.screen.custom.AssemblyScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AssemblyBlockEntity extends BlockEntity implements BlockEntityTicker,ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public AssemblyBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ASSEMBLY_BE, pos, state);
    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("assembly.ultimatecraft.displayname");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AssemblyScreenHandler(syncId,playerInventory, this.pos);
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity, AssemblyBlockEntity be) {
        System.out.println("TICKING at " + pos);
        if (world.isClient()) return;

        ItemStack internalStack = be.getInventory().getFirst(); // スロット内のアイテムA

        if (internalStack.getItem() == ModItems.ALUMINIUM_ALLOY) {
            List<ItemEntity> itemsAbove = world.getEntitiesByClass(
                    ItemEntity.class,
                    new Box(pos.up()),
                    itemEntity -> itemEntity.getStack().getItem() == ModItems.ALUMINIUM_ALLOY
            );

            if (!itemsAbove.isEmpty()) {
                // A → C に変換
                be.getInventory().set(0, new ItemStack(ModItems.PIPE));
                // Bを消す（1個）
                ItemEntity bItemEntity = itemsAbove.getFirst();
                ItemStack stack = bItemEntity.getStack();
                stack.decrement(1);
                if (stack.isEmpty()) {
                    bItemEntity.discard();
                }
            }
        }
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
    }
}