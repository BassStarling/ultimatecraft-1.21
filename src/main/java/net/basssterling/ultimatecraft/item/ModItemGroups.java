package net.basssterling.ultimatecraft.item;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ULTIMATECRAFT_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(UltimateCraft.MOD_ID, "ultimatecraft"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENGIN_PISTON))
                    .displayName(Text.translatable("itemgroup.ultimatecraft.ultimatecraft"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALUMINIUM_ALLOY);
                        entries.add(ModItems.ENGIN_PISTON);
                        entries.add(ModItems.CYLINDER_HEAD_COVER);
                        entries.add(ModBlocks.ALUMINIUM_BLOCK);
                        entries.add(ModBlocks.CYLINDER_HEAD);
                        entries.add(ModItems.GROUND_ELECTRODE);
                        entries.add(ModItems.CENTER_ELECTRODE);
                        entries.add(ModItems.SCREW);
                        entries.add(ModItems.GASKET);
                        entries.add(ModItems.HOUSING);
                        entries.add(ModItems.INSULATOR);
                        entries.add(ModItems.TERMINAL);
                        entries.add(ModItems.SPARK_PLUG);
                        entries.add(ModItems.IGNITION_PLUG_ACCESSORIES);
                        entries.add(ModItems.IGNITION_SYSTEM);
                        entries.add(ModItems.MACHINING_TOOL);
                        entries.add(ModItems.PIPE);
                        entries.add(ModBlocks.MACHINING_BLOCK);
                        entries.add(ModItems.PETROLEUM);
                        entries.add(ModBlocks.CRUSHER);
                        entries.add(ModBlocks.SIFTER);
                        entries.add(ModItems.CONNECTING_ROD_BEARING);
                        entries.add(ModItems.CONNECTING_ROD_CAP);
                        entries.add(ModItems.BUSH);
                        entries.add(ModItems.SIDE_RAIL);
                        entries.add(ModItems.SPACER_EXPANDER);
                        entries.add(ModItems.OIL);
                        entries.add(ModItems.CRANK_PIN);
                        entries.add(ModItems.GUDGEON_PIN);
                        entries.add(ModItems.SNAP_RING);
                        entries.add(ModItems.CRANKSHAFT);
                        entries.add(ModItems.CONNECTING_ROD);
                        entries.add(ModItems.PISTON_RING_GROOVE);
                        entries.add(ModItems.RING_GROOVE);
                        entries.add(ModItems.PISTON_HEAD);
                        entries.add(ModItems.OIL_RING);
                        entries.add(ModItems.COMPRESSION_RING);
                        entries.add(ModItems.CYLINDER_HEAD_GASKET);
                        entries.add(ModItems.INLET_MANIFOLD);
                        entries.add(ModItems.EXHAUST_MANIFOLD);
                        entries.add(ModItems.PISTON_BOSS);
                        entries.add(ModItems.ROD);
                        entries.add(ModItems.SMALL_END);
                        entries.add(ModItems.BIG_END);
                        entries.add(ModItems.CAPBOLT);
                        entries.add(ModItems.NUT);
                        entries.add(ModItems.UNFINISHED_CONNECTING_ROD);
                        entries.add(ModItems.BALANCEWEIGHT);
                        entries.add(ModItems.CRANK_JOURNAL);
                        entries.add(ModItems.CRANK_ARM);
                        entries.add(ModItems.JOURNAL_END);
                        entries.add(ModItems.JOURNAL_BEARING_CAP);
                        entries.add(ModItems.JOURNAL_BEARING);
                        entries.add(ModItems.CRANK_JOURNAL_BEARING);
                        entries.add(ModItems.THRUST_PLATE);
                        entries.add(ModItems.BALANCE_SHAFT_DRIVE_GEAR);
                        entries.add(ModItems.BALANCE_SHAFT);
                        entries.add(ModItems.BALANCE_SHAFT_DRIVEN_GEAR);
                        entries.add(ModItems.BALANCER_MECHANISM);
                        entries.add(ModItems.RING_GEAR);
                        entries.add(ModItems.FLY_WHEEL);
                        entries.add(ModItems.VALVE_SEAT_RING);
                        entries.add(ModItems.VALVE);
                        entries.add(ModItems.IGNITER);
                        entries.add(ModItems.IGNITION_COIL);
                        entries.add(ModItems.PLUG_CAP);
                        entries.add(ModItems.VALVE_FACE);
                        entries.add(ModItems.VALVE_GUIDE);
                        entries.add(ModItems.VALVE_HEAD);
                        entries.add(ModItems.VALVE_SPRING);
                        entries.add(ModItems.VALVE_STEM);
                        entries.add(ModItems.VALVE_STEM_GUIDE);
                        entries.add(ModItems.COTTA);
                        entries.add(ModItems.UPPER_SPRING_SHEET);
                        entries.add(ModItems.LOWER_SPRING_SHEET);
                        entries.add(ModItems.OIL_SEAL);
                        entries.add(ModItems.TRANSISTOR);
                        entries.add(ModItems.CYLINDER_HEAD_WITHOUT_FUNCTION);
                    })
                    .build());

    public static void registerModItemGroups() {
        UltimateCraft.LOGGER.info("Registering item groups for " + UltimateCraft.MOD_ID);
    }
}
