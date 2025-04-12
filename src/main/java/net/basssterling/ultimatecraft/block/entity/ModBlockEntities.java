package net.basssterling.ultimatecraft.block.entity;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.ModBlocks;
import net.basssterling.ultimatecraft.block.entity.custom.AssemblyBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<AssemblyBlockEntity> ASSEMBLY_BE =
    Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("ultimatecraft","assembly_be"),
                    BlockEntityType.Builder.create(AssemblyBlockEntity::new, ModBlocks.ASSEMBLY_TABLE).build(null)
                    );

    public static void registerBlockEntities() {
        UltimateCraft.LOGGER.info("Registering Block Entities for + " + UltimateCraft.MOD_ID);
    }
}
