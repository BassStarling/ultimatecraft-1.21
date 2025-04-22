package net.basssterling.ultimatecraft.screen;

import net.basssterling.ultimatecraft.UltimateCraft;
import net.basssterling.ultimatecraft.screen.custom.AssemblyScreenHandler;
import net.basssterling.ultimatecraft.screen.custom.StrainerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<AssemblyScreenHandler> ASSEMBLY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(UltimateCraft.MOD_ID, "assembly_screen_handler"),
                    new ExtendedScreenHandlerType<>(AssemblyScreenHandler::new,BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<StrainerScreenHandler> STRAINER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(UltimateCraft.MOD_ID, "strainer_screen_handler"),
                    new ExtendedScreenHandlerType<>(StrainerScreenHandler::new,BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        UltimateCraft.LOGGER.info("Registering Screen Handlers for " + UltimateCraft.MOD_ID);
    }
}
