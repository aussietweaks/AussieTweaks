package com.aussietweaks.datagen;

import com.aussietweaks.item.ModItems;
import com.aussietweaks.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }


    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.COOKED_MEATS)
                .add(ModItems.getRK(ModItems.CAMEL_STEAK))
                .add(ModItems.getRK(ModItems.COOKED_ARMADILLO_MEAT))
                .add(ModItems.getRK(ModItems.COOKED_BAT_MEAT))
                .add(ModItems.getRK(ModItems.COOKED_GOAT_MUTTON))
                .add(ModItems.getRK(ModItems.FRIED_AXOLOTL))
                .add(ModItems.getRK(ModItems.FRIED_SQUID))
                .add(ModItems.getRK(ModItems.FRIED_NAUTILUS_MEAT))
                .add(ModItems.getRK(ModItems.LLAMA_STEAK))
                .add(ModItems.getRK(ModItems.PANDA_STEAK))
                .add(ModItems.getRK(ModItems.POLAR_BEAR_STEAK))
                .add(ModItems.getRK(ModItems.SNIFFER_STEAK))
                .add(ModItems.getRK(ModItems.STALLION_STEAK))
                .add(ItemIds.COOKED_BEEF)
                .add(ItemIds.COOKED_RABBIT)
                .add(ItemIds.COOKED_CHICKEN)
                .add(ItemIds.COOKED_PORKCHOP)
                .add(ItemIds.COOKED_MUTTON)
                .add(ItemIds.COOKED_COD)
                .add(ItemIds.COOKED_SALMON);

        tag(ModTags.Items.METAL_MACE)
                .add(ModItems.getRK(ModItems.COPPER_MACE))
                .add(ModItems.getRK(ModItems.IRON_MACE))
                .add(ModItems.getRK(ModItems.GOLD_MACE))
                .add(ModItems.getRK(ModItems.DIAMOND_MACE))
                .add(ModItems.getRK(ModItems.NETHERITE_MACE));

        tag(ItemTags.MACE_ENCHANTABLE)
                .addTag(ModTags.Items.METAL_MACE);

        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(ModItems.ACACIA_SWORD))
                .add(ModItems.getRK(ModItems.BAMBOO_SWORD))
                .add(ModItems.getRK(ModItems.BIRCH_SWORD))
                .add(ModItems.getRK(ModItems.CHERRY_SWORD))
                .add(ModItems.getRK(ModItems.DARK_OAK_SWORD))
                .add(ModItems.getRK(ModItems.JUNGLE_SWORD))
                .add(ModItems.getRK(ModItems.CRIMSON_SWORD))
                .add(ModItems.getRK(ModItems.MANGROVE_SWORD))
                .add(ModItems.getRK(ModItems.PALE_OAK_SWORD))
                .add(ModItems.getRK(ModItems.POPLAR_SWORD))
                .add(ModItems.getRK(ModItems.SPRUCE_SWORD))
                .add(ModItems.getRK(ModItems.WARPED_SWORD))
                .add(ModItems.getRK(ModItems.BLACKSTONE_SWORD))
                .add(ModItems.getRK(ModItems.DEEPSLATE_SWORD))
                .add(ModItems.getRK(ModItems.SULFUR_SWORD));

        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.ACACIA_PICKAXE))
                .add(ModItems.getRK(ModItems.BAMBOO_PICKAXE))
                .add(ModItems.getRK(ModItems.BIRCH_PICKAXE))
                .add(ModItems.getRK(ModItems.CHERRY_PICKAXE))
                .add(ModItems.getRK(ModItems.DARK_OAK_PICKAXE))
                .add(ModItems.getRK(ModItems.JUNGLE_PICKAXE))
                .add(ModItems.getRK(ModItems.CRIMSON_PICKAXE))
                .add(ModItems.getRK(ModItems.MANGROVE_PICKAXE))
                .add(ModItems.getRK(ModItems.PALE_OAK_PICKAXE))
                .add(ModItems.getRK(ModItems.POPLAR_PICKAXE))
                .add(ModItems.getRK(ModItems.SPRUCE_PICKAXE))
                .add(ModItems.getRK(ModItems.WARPED_PICKAXE))
                .add(ModItems.getRK(ModItems.BLACKSTONE_PICKAXE))
                .add(ModItems.getRK(ModItems.DEEPSLATE_PICKAXE));

        tag(ItemTags.AXES)
                .add(ModItems.getRK(ModItems.ACACIA_AXE))
                .add(ModItems.getRK(ModItems.BAMBOO_AXE))
                .add(ModItems.getRK(ModItems.BIRCH_AXE))
                .add(ModItems.getRK(ModItems.CHERRY_AXE))
                .add(ModItems.getRK(ModItems.DARK_OAK_AXE))
                .add(ModItems.getRK(ModItems.JUNGLE_AXE))
                .add(ModItems.getRK(ModItems.CRIMSON_AXE))
                .add(ModItems.getRK(ModItems.MANGROVE_AXE))
                .add(ModItems.getRK(ModItems.PALE_OAK_AXE))
                .add(ModItems.getRK(ModItems.POPLAR_AXE))
                .add(ModItems.getRK(ModItems.SPRUCE_AXE))
                .add(ModItems.getRK(ModItems.WARPED_AXE))
                .add(ModItems.getRK(ModItems.BLACKSTONE_AXE))
                .add(ModItems.getRK(ModItems.DEEPSLATE_AXE));

        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(ModItems.ACACIA_SHOVEL))
                .add(ModItems.getRK(ModItems.BAMBOO_SHOVEL))
                .add(ModItems.getRK(ModItems.BIRCH_SHOVEL))
                .add(ModItems.getRK(ModItems.CHERRY_SHOVEL))
                .add(ModItems.getRK(ModItems.DARK_OAK_SHOVEL))
                .add(ModItems.getRK(ModItems.JUNGLE_SHOVEL))
                .add(ModItems.getRK(ModItems.CRIMSON_SHOVEL))
                .add(ModItems.getRK(ModItems.MANGROVE_SHOVEL))
                .add(ModItems.getRK(ModItems.PALE_OAK_SHOVEL))
                .add(ModItems.getRK(ModItems.POPLAR_SHOVEL))
                .add(ModItems.getRK(ModItems.SPRUCE_SHOVEL))
                .add(ModItems.getRK(ModItems.WARPED_SHOVEL))
                .add(ModItems.getRK(ModItems.BLACKSTONE_SHOVEL))
                .add(ModItems.getRK(ModItems.DEEPSLATE_SHOVEL));

        tag(ItemTags.HOES)
                .add(ModItems.getRK(ModItems.ACACIA_HOE))
                .add(ModItems.getRK(ModItems.BAMBOO_HOE))
                .add(ModItems.getRK(ModItems.BIRCH_HOE))
                .add(ModItems.getRK(ModItems.CHERRY_HOE))
                .add(ModItems.getRK(ModItems.DARK_OAK_HOE))
                .add(ModItems.getRK(ModItems.JUNGLE_HOE))
                .add(ModItems.getRK(ModItems.CRIMSON_HOE))
                .add(ModItems.getRK(ModItems.MANGROVE_HOE))
                .add(ModItems.getRK(ModItems.PALE_OAK_HOE))
                .add(ModItems.getRK(ModItems.POPLAR_HOE))
                .add(ModItems.getRK(ModItems.SPRUCE_HOE))
                .add(ModItems.getRK(ModItems.WARPED_HOE))
                .add(ModItems.getRK(ModItems.BLACKSTONE_HOE))
                .add(ModItems.getRK(ModItems.DEEPSLATE_HOE));

        tag(ItemTags.SPEARS)
                .add(ModItems.getRK(ModItems.ACACIA_SPEAR))
                .add(ModItems.getRK(ModItems.BAMBOO_SPEAR))
                .add(ModItems.getRK(ModItems.BIRCH_SPEAR))
                .add(ModItems.getRK(ModItems.CHERRY_SPEAR))
                .add(ModItems.getRK(ModItems.DARK_OAK_SPEAR))
                .add(ModItems.getRK(ModItems.JUNGLE_SPEAR))
                .add(ModItems.getRK(ModItems.CRIMSON_SPEAR))
                .add(ModItems.getRK(ModItems.MANGROVE_SPEAR))
                .add(ModItems.getRK(ModItems.PALE_OAK_SPEAR))
                .add(ModItems.getRK(ModItems.POPLAR_SPEAR))
                .add(ModItems.getRK(ModItems.SPRUCE_SPEAR))
                .add(ModItems.getRK(ModItems.WARPED_SPEAR))
                .add(ModItems.getRK(ModItems.BLACKSTONE_SPEAR))
                .add(ModItems.getRK(ModItems.DEEPSLATE_SPEAR));

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.getRK(ModItems.ARMADILLO_HELMET));

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.getRK(ModItems.ARMADILLO_HELMET));

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.getRK(ModItems.ARMADILLO_HELMET));

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.getRK(ModItems.ARMADILLO_HELMET));


    }



}
