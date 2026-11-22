package com.aussietweaks.worldgen.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModWorldGeneration {

    @SuppressWarnings("unchecked")
    public static void generateModWorldGen() {
        // Must be EntityType<Phantom>, NOT EntityType<?>
        EntityType<Phantom> phantomType = (EntityType<Phantom>) BuiltInRegistries.ENTITY_TYPE.getValue(
                Identifier.withDefaultNamespace("phantom")
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST, Biomes.MEADOW, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.STONY_PEAKS, Biomes.WINDSWEPT_SAVANNA, Biomes.SUNFLOWER_PLAINS, Biomes.PLAINS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST),
                MobCategory.MONSTER,
                phantomType,
                10,
                3,
                4
        );
    }
}