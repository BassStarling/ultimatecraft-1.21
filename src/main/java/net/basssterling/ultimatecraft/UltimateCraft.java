package net.basssterling.ultimatecraft;

import net.basssterling.ultimatecraft.block.ModBlocks;
import net.basssterling.ultimatecraft.item.ModItemGroups;
import net.basssterling.ultimatecraft.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltimateCraft implements ModInitializer {
	public static final String MOD_ID = "ultimatecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.PETROLEUM, 20000);
	}
}