package net.basssterling.ultimatecraft;

import net.basssterling.ultimatecraft.screen.ModScreenHandlers;
import net.basssterling.ultimatecraft.screen.custom.AssemblyScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class UltimateCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ASSEMBLY_SCREEN_HANDLER, AssemblyScreen::new);
    }
}
