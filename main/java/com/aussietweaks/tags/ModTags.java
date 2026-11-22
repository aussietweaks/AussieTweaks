package com.aussietweaks.tags;

import com.aussietweaks.AussieTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, name));
        }
    }



    public static class Items {
        public static final TagKey<Item> COOKED_MEATS = createTag("cooked_meats");
        public static final TagKey<Item> METAL_MACE = createTag("metal_mace");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, name));
        }
    }
}
