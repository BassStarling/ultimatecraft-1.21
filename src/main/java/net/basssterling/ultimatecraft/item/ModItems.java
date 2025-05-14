package net.basssterling.ultimatecraft.item;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.item.custom.MachiningItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item ENGIN_CYLINDER = registerItem("engin_cylinder",new Item(new Item.Settings()));

    public static final Item MELTED_BAUXITE_IN_BUCKET = registerItem("melted_bauxite_in_bucket",new Item(new Item.Settings()));

    public static final Item ALUMINIUM_OXIDE = registerItem("aluminium_oxide",new Item(new Item.Settings()));

    public static final Item ALUMINIUM_HYDROXIDE = registerItem("aluminium_hydroxide",new Item(new Item.Settings()));

    public static final Item SODIUM_HYDROXIDE_BUCKET = registerItem("sodium_hydroxide_bucket",new Item(new Item.Settings()));

    public static final Item CRYOLITE = registerItem("cryolite",new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.cryolite"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.cryolite"));
            }
        }
    });

    public static final Item TEMPORARY_ITEM_F = registerItem("temporary_item_f",new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.temp_item_f.shiftdown"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.temp_item_f.shiftdown.0"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.temp_item_f.shiftdown.1"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.temp_item_f.shiftdown.2"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.temp_item_f"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.bauxite.1"));
            }
        }
    });

    public static final Item PURE_SODIUM_ALUMINATE = registerItem("pure_sodium_aluminate",new Item(new Item.Settings()));

    public static final Item SODIUM_ALUMINATE = registerItem("sodium_aluminate",new Item(new Item.Settings()));

    public static final Item GHASTGUN = registerItem("ghastgun",new BowItem(new Item.Settings().maxDamage(100)));

    public static final Item YARI = registerItem("yari",new SwordItem(ModToolMaterials.ALUMINIUM,new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM,2,3.9f))));

    public static final Item RAW_BAUXITE = registerItem("raw_bauxite",new Item(new Item.Settings()) {
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

    public static final Item TRONA = registerItem("trona",new Item(new Item.Settings()));

    public static final Item SODIUM_CARBONATE = registerItem("sodium_carbonate",new Item(new Item.Settings()));

    public static final Item QUICK_LIME = registerItem("quick_lime",new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.quick_lime"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.quick_lime"));
            }
        }
    });

    public static final Item SLAKED_LIME = registerItem("slaked_lime",new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.slaked_lime"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.slaked_lime"));
            }
        }
    });

    public static final Item SALT = registerItem("salt",new Item(new Item.Settings()));

    public static final Item FABRIC_FILTER = registerItem("fabric_filter", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.fabric_filter"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.fabric_filter"));
            }
        }
    });

    public static final Item CYLINDER_HEAD_WITHOUT_FUNCTION = registerItem("cylinder_head_without_function", new Item(new Item.Settings()));

    public static final Item TRANSISTOR = registerItem("transistor", new Item(new Item.Settings()));

    public static final Item PLUG_CAP = registerItem("plug_cap", new Item(new Item.Settings()));

    public static final Item IGNITER = registerItem("igniter", new Item(new Item.Settings()));

    public static final Item IGNITION_COIL = registerItem("ignition_coil", new Item(new Item.Settings()));

    public static final Item VALVE = registerItem("valve", new Item(new Item.Settings()));

    public static final Item VALVE_HEAD = registerItem("valve_head", new Item(new Item.Settings()));

    public static final Item VALVE_FACE = registerItem("valve_face", new Item(new Item.Settings()));

    public static final Item VALVE_STEM = registerItem("valve_stem", new Item(new Item.Settings()));

    public static final Item VALVE_STEM_GUIDE = registerItem("valve_stem_guide", new Item(new Item.Settings()));

    public static final Item COTTA = registerItem("cotta", new Item(new Item.Settings()));

    public static final Item UPPER_SPRING_SHEET = registerItem("upper_spring_sheet", new Item(new Item.Settings()));

    public static final Item VALVE_SPRING = registerItem("valve_spring", new Item(new Item.Settings()));

    public static final Item OIL_SEAL = registerItem("oil_seal", new Item(new Item.Settings()));

    public static final Item LOWER_SPRING_SHEET = registerItem("lower_spring_sheet", new Item(new Item.Settings()));

    public static final Item VALVE_GUIDE = registerItem("valve_guide", new Item(new Item.Settings()));

    public static final Item VALVE_SEAT_RING = registerItem("valve_seat_ring", new Item(new Item.Settings()));

    public static final Item FLY_WHEEL = registerItem("fly_wheel", new Item(new Item.Settings()));

    public static final Item RING_GEAR = registerItem("ring_gear", new Item(new Item.Settings()));

    public static final Item BALANCER_MECHANISM = registerItem("balancer_mechanism", new Item(new Item.Settings()));

    public static final Item BALANCE_SHAFT_DRIVEN_GEAR = registerItem("balance_shaft_driven_gear", new Item(new Item.Settings()));

    public static final Item BALANCE_SHAFT = registerItem("balance_shaft", new Item(new Item.Settings()));

    public static final Item BALANCE_SHAFT_DRIVE_GEAR = registerItem("balance_shaft_drive_gear", new Item(new Item.Settings()));

    public static final Item THRUST_PLATE = registerItem("thrust_plate", new Item(new Item.Settings()));

    public static final Item CRANK_JOURNAL_BEARING = registerItem("crank_journal_bearing", new Item(new Item.Settings()));

    public static final Item JOURNAL_BEARING_CAP = registerItem("journal_bearing_cap", new Item(new Item.Settings()));

    public static final Item JOURNAL_BEARING = registerItem("journal_bearing", new Item(new Item.Settings()));

    public static final Item JOURNAL_END = registerItem("journal_end", new Item(new Item.Settings()));

    public static final Item BALANCEWEIGHT = registerItem("balanceweight", new Item(new Item.Settings()));

    public static final Item CRANK_JOURNAL = registerItem("crank_journal", new Item(new Item.Settings()));

    public static final Item CRANK_ARM = registerItem("crank_arm", new Item(new Item.Settings()));

    public static final Item UNFINISHED_CONNECTING_ROD = registerItem("unfinished_connecting_rod", new Item(new Item.Settings()));

    public static final Item NUT = registerItem("nut", new Item(new Item.Settings()));

    public static final Item CAPBOLT = registerItem("capbolt", new Item(new Item.Settings()));

    public static final Item ROD = registerItem("rod", new Item(new Item.Settings()));

    public static final Item SMALL_END = registerItem("small_end", new Item(new Item.Settings()));

    public static final Item BIG_END = registerItem("big_end", new Item(new Item.Settings()));

    public static final Item PISTON_BOSS = registerItem("piston_boss", new Item(new Item.Settings()));

    public static final Item CONNECTING_ROD_BEARING = registerItem("connecting_rod_bearing", new Item(new Item.Settings()));

    public static final Item CONNECTING_ROD_CAP = registerItem("connecting_rod_cap", new Item(new Item.Settings()));

    public static final Item BUSH = registerItem("bush", new Item(new Item.Settings()));

    public static final Item SIDE_RAIL = registerItem("side_rail", new Item(new Item.Settings()));

    public static final Item SPACER_EXPANDER = registerItem("spacer_expander", new Item(new Item.Settings()));

    public static final Item OIL = registerItem("oil", new Item(new Item.Settings()));

    public static final Item CRANK_PIN = registerItem("crank_pin", new Item(new Item.Settings()));

    public static final Item GUDGEON_PIN = registerItem("gudgeon_pin", new Item(new Item.Settings()));

    public static final Item SNAP_RING = registerItem("snap_ring", new Item(new Item.Settings()));

    public static final Item CRANKSHAFT = registerItem("crankshaft", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.crankshaft.shift_down"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.crankshaft.shift_down.1"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.crankshaft.shift_down.2"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.crankshaft"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.crankshaft.1"));
            }
        }
    });

    public static final Item CONNECTING_ROD = registerItem("connecting_rod", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod.shift_down"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod.shift_down.1"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod.shift_down.2"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod.shift_down.3"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.connecting_rod.1"));
            }
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item PISTON_RING_GROOVE = registerItem("piston_ring_groove", new Item(new Item.Settings()));

    public static final Item RING_GROOVE = registerItem("ring_groove", new Item(new Item.Settings()));

    public static final Item PISTON_HEAD = registerItem("piston_head", new Item(new Item.Settings()));

    public static final Item OIL_RING = registerItem("oil_ring", new Item(new Item.Settings()));

    public static final Item COMPRESSION_RING = registerItem("compression_ring", new Item(new Item.Settings()));

    public static final Item CYLINDER_HEAD_GASKET = registerItem("cylinder_head_gasket", new Item(new Item.Settings()));

    public static final Item INLET_MANIFOLD = registerItem("inlet_manifold", new Item(new Item.Settings()));

    public static final Item EXHAUST_MANIFOLD = registerItem("exhaust_manifold", new Item(new Item.Settings()));

    public static final Item PETROLEUM = registerItem("petroleum", new Item(new Item.Settings()));

    public static final Item MACHINING_TOOL = registerItem("machining_tool", new MachiningItem(new Item.Settings().maxDamage(32)));

    public static final Item PIPE = registerItem("pipe", new Item(new Item.Settings()));

    public static final Item ENGIN_PISTON = registerItem("engin_piston", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston.shift_down"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston.shift_down.1"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston.shift_down.2"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston.shift_down.3"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.engin_piston.1"));
            }
        }
    });

    public static final Item CYLINDER_HEAD_COVER = registerItem("cylinder_head_cover", new Item(new Item.Settings()));

    public static final Item GROUND_ELECTRODE = registerItem("ground_electrode", new Item(new Item.Settings()));

    public static final Item CENTER_ELECTRODE = registerItem("center_electrode", new Item(new Item.Settings()));

    public static final Item SCREW = registerItem("screw", new Item(new Item.Settings()));

    public static final Item GASKET = registerItem("gasket", new Item(new Item.Settings()));

    public static final Item HOUSING = registerItem("housing", new Item(new Item.Settings()));

    public static final Item INSULATOR = registerItem("insulator", new Item(new Item.Settings()));

    public static final Item TERMINAL = registerItem("terminal", new Item(new Item.Settings()));

    public static final Item SPARK_PLUG = registerItem("spark_plug", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.shift_down"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.shift_down.1"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.shift_down.2"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.shift_down.3"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.shift_down.4"));
            } else {
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug"));
                tooltip.add(Text.translatable("tooltip.ultimatecraft.spark_plug.2"));
            }
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item IGNITION_PLUG_ACCESSORIES = registerItem("ignition_plug_accessories", new Item(new Item.Settings()));

    public static final Item IGNITION_SYSTEM = registerItem("ignition_system", new Item(new Item.Settings()));

    public static final Item ALUMINIUM_ALLOY = registerItem("aluminium_alloy", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UltimateCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UltimateCraft.LOGGER.info("Registering items for " + UltimateCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries) -> {
            entries.add(ENGIN_PISTON);
        });
    }
}
