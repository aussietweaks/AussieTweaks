package com.aussietweaks;

import com.aussietweaks.creativemodetab.ModCreativeModeTabs;
import com.aussietweaks.item.ModItems;
import com.aussietweaks.loot.ModLootTableModifiers;
import com.aussietweaks.worldgen.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AussieTweaks implements ModInitializer {
	public static final String MOD_ID = "aussietweaks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();

		LOGGER.info("Hello Fabric world!");

		LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTables);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
