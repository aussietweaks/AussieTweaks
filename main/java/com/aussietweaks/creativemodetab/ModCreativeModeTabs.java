package com.aussietweaks.creativemodetab;

import com.aussietweaks.AussieTweaks;
import com.aussietweaks.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.impl.client.creativetab.FabricCreativeGuiComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab MOD_FOOD_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "mod_foods"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHER_STAR_STEAK))
                    .title(Component.translatable("creativemodetab.aussietweaks.mod_foods"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.APPLE_JUICE);
                        output.accept(ModItems.SWEET_BERRY_JUICE);
                        output.accept(ModItems.APPLE_PIE);
                        output.accept(ModItems.SWEET_BERRY_PIE);
                        output.accept(ModItems.ALLAY_WING);
                        output.accept(ModItems.ARMADILLO_MEAT);
                        output.accept(ModItems.COOKED_ARMADILLO_MEAT);
                        output.accept(ModItems.AXOLOTL_MEAT);
                        output.accept(ModItems.FRIED_AXOLOTL);
                        output.accept(ModItems.BAT_MEAT);
                        output.accept(ModItems.COOKED_BAT_MEAT);
                        output.accept(ModItems.CAMEL_MEAT);
                        output.accept(ModItems.CAMEL_STEAK);
                        output.accept(ModItems.GOAT_MUTTON);
                        output.accept(ModItems.COOKED_GOAT_MUTTON);
                        output.accept(ModItems.FROG_LEG);
                        output.accept(ModItems.GHAST_MEAT);
                        output.accept(ModItems.LLAMA_MEAT);
                        output.accept(ModItems.LLAMA_STEAK);
                        output.accept(ModItems.NAUTILUS_MEAT);
                        output.accept(ModItems.FRIED_NAUTILUS_MEAT);
                        output.accept(ModItems.PANDA_MEAT);
                        output.accept(ModItems.PANDA_STEAK);
                        output.accept(ModItems.POLAR_BEAR_MEAT);
                        output.accept(ModItems.POLAR_BEAR_STEAK);
                        output.accept(ModItems.SNIFFER_MEAT);
                        output.accept(ModItems.SNIFFER_STEAK);
                        output.accept(ModItems.SQUID_TENTACLES);
                        output.accept(ModItems.FRIED_SQUID);
                        output.accept(ModItems.STALLION_MEAT);
                        output.accept(ModItems.STALLION_STEAK);
                        output.accept(ModItems.STRIDER_LEG);
                        output.accept(ModItems.TURTLE_MEAT);
                        output.accept(ModItems.TURTLE_SOUP);
                        output.accept(ModItems.AXOLOTL_ROLL);
                        output.accept(ModItems.SPICY_AXOLOTL_ROLL);
                        output.accept(ModItems.EVERYTHING_ROLL);
                        output.accept(ModItems.SPICY_EVERYTHING_ROLL);
                        output.accept(ModItems.SALMON_ROLL);
                        output.accept(ModItems.SPICY_SALMON_ROLL);
                        output.accept(ModItems.SQUID_ROLL);
                        output.accept(ModItems.SPICY_SQUID_ROLL);
                        output.accept(ModItems.STRIDER_ROLL);
                        output.accept(ModItems.SPICY_STRIDER_ROLL);
                        output.accept(ModItems.NAUTILUS_ROLL);
                        output.accept(ModItems.SPICY_NAUTILUS_ROLL);
                        output.accept(ModItems.NETHER_STAR_DUST);
                        output.accept(ModItems.NETHER_STAR_STEAK);
                    }).build());

    public static final CreativeModeTab MOD_ARMOR_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "mod_armor"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ARMADILLO_HELMET))
                    .title(Component.translatable("creativemodetab.aussietweaks.mod_armor"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COMPENDIUM_IRON_ARMOR);
                        output.accept(ModItems.COMPENDIUM_GOLD_ARMOR);
                        output.accept(ModItems.COMPENDIUM_DIAMOND_ARMOR);
                        output.accept(ModItems.ARMADILLO_HELMET);
                        output.accept(ModItems.ARMADILLO_CHESTPLATE);
                        output.accept(ModItems.ARMADILLO_LEGGINGS);
                        output.accept(ModItems.ARMADILLO_BOOTS);

                    }).build());

    public static final CreativeModeTab MOD_WEAPONS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "mod_weapons"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLACKSTONE_SWORD))
                    .title(Component.translatable("creativemodetab.aussietweaks.mod_weapons"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COMPENDIUM_IRON_WEAPONS);
                        output.accept(ModItems.COMPENDIUM_GOLD_WEAPONS);
                        output.accept(ModItems.COMPENDIUM_DIAMOND_WEAPONS);
                        output.accept(ModItems.COMPENDIUM_RANGED);
                        output.accept(ModItems.COMPENDIUM_WINDSWEPT_MACE);
                        output.accept(ModItems.ACACIA_SWORD);
                        output.accept(ModItems.BAMBOO_SWORD);
                        output.accept(ModItems.BIRCH_SWORD);
                        output.accept(ModItems.CHERRY_SWORD);
                        output.accept(ModItems.CRIMSON_SWORD);
                        output.accept(ModItems.DARK_OAK_SWORD);
                        output.accept(ModItems.JUNGLE_SWORD);
                        output.accept(ModItems.MANGROVE_SWORD);
                        output.accept(ModItems.PALE_OAK_SWORD);
                        output.accept(ModItems.POPLAR_SWORD);
                        output.accept(ModItems.SPRUCE_SWORD);
                        output.accept(ModItems.WARPED_SWORD);
                        output.accept(ModItems.ACACIA_SPEAR);
                        output.accept(ModItems.BAMBOO_SPEAR);
                        output.accept(ModItems.BIRCH_SPEAR);
                        output.accept(ModItems.CHERRY_SPEAR);
                        output.accept(ModItems.CRIMSON_SPEAR);
                        output.accept(ModItems.DARK_OAK_SPEAR);
                        output.accept(ModItems.JUNGLE_SPEAR);
                        output.accept(ModItems.MANGROVE_SPEAR);
                        output.accept(ModItems.PALE_OAK_SPEAR);
                        output.accept(ModItems.POPLAR_SPEAR);
                        output.accept(ModItems.SPRUCE_SPEAR);
                        output.accept(ModItems.WARPED_SPEAR);
                        output.accept(ModItems.SULFUR_SWORD);
                        output.accept(ModItems.DEEPSLATE_SWORD);
                        output.accept(ModItems.BLACKSTONE_SWORD);
                        output.accept(ModItems.DEEPSLATE_SPEAR);
                        output.accept(ModItems.BLACKSTONE_SPEAR);
                        output.accept(ModItems.COPPER_MACE);
                        output.accept(ModItems.IRON_MACE);
                        output.accept(ModItems.GOLD_MACE);
                        output.accept(ModItems.DIAMOND_MACE);
                        output.accept(ModItems.NETHERITE_MACE);

                    }).build());

    public static final CreativeModeTab MOD_TOOLS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "mod_tools"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DARK_OAK_PICKAXE))
                    .title(Component.translatable("creativemodetab.aussietweaks.mod_tools"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COMPENDIUM_IRON_TOOLS);
                        output.accept(ModItems.COMPENDIUM_GOLD_TOOLS);
                        output.accept(ModItems.COMPENDIUM_DIAMOND_TOOLS);
                        output.accept(ModItems.ACACIA_PICKAXE);
                        output.accept(ModItems.BAMBOO_PICKAXE);
                        output.accept(ModItems.BIRCH_PICKAXE);
                        output.accept(ModItems.CHERRY_PICKAXE);
                        output.accept(ModItems.CRIMSON_PICKAXE);
                        output.accept(ModItems.DARK_OAK_PICKAXE);
                        output.accept(ModItems.JUNGLE_PICKAXE);
                        output.accept(ModItems.MANGROVE_PICKAXE);
                        output.accept(ModItems.PALE_OAK_PICKAXE);
                        output.accept(ModItems.POPLAR_PICKAXE);
                        output.accept(ModItems.SPRUCE_PICKAXE);
                        output.accept(ModItems.WARPED_PICKAXE);
                        output.accept(ModItems.ACACIA_AXE);
                        output.accept(ModItems.BAMBOO_AXE);
                        output.accept(ModItems.BIRCH_AXE);
                        output.accept(ModItems.CHERRY_AXE);
                        output.accept(ModItems.CRIMSON_AXE);
                        output.accept(ModItems.DARK_OAK_AXE);
                        output.accept(ModItems.JUNGLE_AXE);
                        output.accept(ModItems.MANGROVE_AXE);
                        output.accept(ModItems.PALE_OAK_AXE);
                        output.accept(ModItems.POPLAR_AXE);
                        output.accept(ModItems.SPRUCE_AXE);
                        output.accept(ModItems.WARPED_AXE);
                        output.accept(ModItems.ACACIA_SHOVEL);
                        output.accept(ModItems.BAMBOO_SHOVEL);
                        output.accept(ModItems.BIRCH_SHOVEL);
                        output.accept(ModItems.CHERRY_SHOVEL);
                        output.accept(ModItems.CRIMSON_SHOVEL);
                        output.accept(ModItems.DARK_OAK_SHOVEL);
                        output.accept(ModItems.JUNGLE_SHOVEL);
                        output.accept(ModItems.MANGROVE_SHOVEL);
                        output.accept(ModItems.PALE_OAK_SHOVEL);
                        output.accept(ModItems.POPLAR_SHOVEL);
                        output.accept(ModItems.SPRUCE_SHOVEL);
                        output.accept(ModItems.WARPED_SHOVEL);
                        output.accept(ModItems.ACACIA_HOE);
                        output.accept(ModItems.BAMBOO_HOE);
                        output.accept(ModItems.BIRCH_HOE);
                        output.accept(ModItems.CHERRY_HOE);
                        output.accept(ModItems.CRIMSON_HOE);
                        output.accept(ModItems.DARK_OAK_HOE);
                        output.accept(ModItems.JUNGLE_HOE);
                        output.accept(ModItems.MANGROVE_HOE);
                        output.accept(ModItems.PALE_OAK_HOE);
                        output.accept(ModItems.POPLAR_HOE);
                        output.accept(ModItems.SPRUCE_HOE);
                        output.accept(ModItems.WARPED_HOE);
                        output.accept(ModItems.DEEPSLATE_PICKAXE);
                        output.accept(ModItems.BLACKSTONE_PICKAXE);
                        output.accept(ModItems.DEEPSLATE_AXE);
                        output.accept(ModItems.BLACKSTONE_AXE);
                        output.accept(ModItems.DEEPSLATE_SHOVEL);
                        output.accept(ModItems.BLACKSTONE_SHOVEL);
                        output.accept(ModItems.DEEPSLATE_HOE);
                        output.accept(ModItems.BLACKSTONE_HOE);

                    }).build());

    public static final CreativeModeTab MOD_UTILITY_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "mod_utility"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_CORE))
                    .title(Component.translatable("creativemodetab.aussietweaks.mod_utility"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.HANDLE);
                        output.accept(ModItems.COPPER_BLADE);
                        output.accept(ModItems.IRON_BLADE);
                        output.accept(ModItems.GOLD_BLADE);
                        output.accept(ModItems.DIAMOND_BLADE);
                        output.accept(ModItems.COPPER_SPEAR_HEAD);
                        output.accept(ModItems.IRON_SPEAR_HEAD);
                        output.accept(ModItems.GOLD_SPEAR_HEAD);
                        output.accept(ModItems.DIAMOND_SPEAR_HEAD);
                        output.accept(ModItems.COPPER_CORE);
                        output.accept(ModItems.IRON_CORE);
                        output.accept(ModItems.GOLD_CORE);
                        output.accept(ModItems.DIAMOND_CORE);
                        output.accept(ModItems.COPPER_PICKAXE_HEAD);
                        output.accept(ModItems.IRON_PICKAXE_HEAD);
                        output.accept(ModItems.GOLD_PICKAXE_HEAD);
                        output.accept(ModItems.DIAMOND_PICKAXE_HEAD);
                        output.accept(ModItems.COPPER_AXE_HEAD);
                        output.accept(ModItems.IRON_AXE_HEAD);
                        output.accept(ModItems.GOLD_AXE_HEAD);
                        output.accept(ModItems.DIAMOND_AXE_HEAD);
                        output.accept(ModItems.COPPER_SHOVEL_HEAD);
                        output.accept(ModItems.IRON_SHOVEL_HEAD);
                        output.accept(ModItems.GOLD_SHOVEL_HEAD);
                        output.accept(ModItems.DIAMOND_SHOVEL_HEAD);
                        output.accept(ModItems.COPPER_HOE_HEAD);
                        output.accept(ModItems.IRON_HOE_HEAD);
                        output.accept(ModItems.GOLD_HOE_HEAD);
                        output.accept(ModItems.DIAMOND_HOE_HEAD);

                        output.accept(ModItems.DISPENSER_MECHANISM);

                    }).build());



    public static void registerModCreativeModeTabs() {
        AussieTweaks.LOGGER.info("Registering Creative Mode Tabs for " +AussieTweaks.MOD_ID);
    }
}
