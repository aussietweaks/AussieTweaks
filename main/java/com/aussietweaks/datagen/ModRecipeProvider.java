package com.aussietweaks.datagen;

import com.aussietweaks.item.ModItems;
import com.aussietweaks.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        BootstrapContext<Advancement> BootstrapContext = advancements;
        return new RecipeProvider(recipes, BootstrapContext) {
            @Override
            public void buildRecipes() {

                oreSmelting(
                        List.of(ModItems.AXOLOTL_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.FRIED_AXOLOTL, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.ARMADILLO_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.COOKED_ARMADILLO_MEAT, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.BAT_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.COOKED_BAT_MEAT, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.CAMEL_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.CAMEL_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.GOAT_MUTTON), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.COOKED_GOAT_MUTTON, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.LLAMA_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.LLAMA_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.NAUTILUS_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.FRIED_NAUTILUS_MEAT, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.SQUID_TENTACLES), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.FRIED_SQUID, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.PANDA_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.PANDA_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.POLAR_BEAR_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.POLAR_BEAR_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.SNIFFER_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.SNIFFER_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );
                oreSmelting(
                        List.of(ModItems.STALLION_MEAT), // Inputs
                        RecipeCategory.FOOD, // Category
                        CookingBookCategory.FOOD, // Category
                        ModItems.STALLION_STEAK, // Output
                        0.1f, // Experience
                        300, // Cooking time
                        "" // group
                );

                shapeless(RecipeCategory.FOOD, ModItems.NETHER_STAR_STEAK) // You can also specify an int to produce more than one
                        .requires(ModItems.NETHER_STAR_DUST) // You can also specify an int to require more than one, or a tag to accept multiple things
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        .requires(ModTags.Items.COOKED_MEATS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.NETHER_STAR_DUST), has(ModItems.NETHER_STAR_DUST))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SALMON_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_SALMON_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON))
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.AXOLOTL_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_AXOLOTL)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.AXOLOTL_MEAT), has(ModItems.AXOLOTL_MEAT))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_AXOLOTL_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_AXOLOTL)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.AXOLOTL_MEAT), has(ModItems.AXOLOTL_MEAT))
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.NAUTILUS_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_NAUTILUS_MEAT)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.NAUTILUS_MEAT), has(ModItems.NAUTILUS_MEAT))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_NAUTILUS_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_NAUTILUS_MEAT)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.NAUTILUS_MEAT), has(ModItems.NAUTILUS_MEAT))
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SQUID_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_SQUID)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.SQUID_TENTACLES), has(ModItems.SQUID_TENTACLES))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_SQUID_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_SQUID)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .unlockedBy(getHasName(ModItems.SQUID_TENTACLES), has(ModItems.SQUID_TENTACLES))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.STRIDER_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.STRIDER_LEG)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.STRIDER_LEG), has(ModItems.STRIDER_LEG))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_STRIDER_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.STRIDER_LEG)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.STRIDER_LEG), has(ModItems.STRIDER_LEG))
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.EVERYTHING_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_NAUTILUS_MEAT)
                        .requires(ModItems.FRIED_AXOLOTL)
                        .requires(ModItems.FRIED_SQUID)
                        .requires(Items.DRIED_KELP)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SPICY_EVERYTHING_ROLL) // You can also specify an int to produce more than one
                        .requires(Items.SALMON)
                        .requires(ModItems.FRIED_NAUTILUS_MEAT)
                        .requires(ModItems.FRIED_AXOLOTL)
                        .requires(ModItems.FRIED_SQUID)
                        .requires(Items.DRIED_KELP)
                        .requires(Items.MAGMA_CREAM)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SALMON), has(Items.SALMON))
                        .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.TURTLE_SOUP) // You can also specify an int to produce more than one
                        .requires(Items.BOWL)
                        .requires(ModItems.TURTLE_MEAT)
                        .requires(ItemTags.MUSHROOMS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.TURTLE_MEAT), has(ModItems.TURTLE_MEAT))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.APPLE_PIE) // You can also specify an int to produce more than one
                        .requires(Items.SUGAR)
                        .requires(Items.APPLE)
                        .requires(ItemTags.EGGS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_PIE) // You can also specify an int to produce more than one
                        .requires(Items.SUGAR)
                        .requires(Items.SWEET_BERRIES)
                        .requires(Items.SWEET_BERRIES)
                        .requires(ItemTags.EGGS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.APPLE_JUICE) // You can also specify an int to produce more than one
                        .requires(Items.GLASS_BOTTLE)
                        .requires(Items.APPLE)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                        .save(output);

                shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_JUICE) // You can also specify an int to produce more than one
                        .requires(Items.GLASS_BOTTLE)
                        .requires(Items.SWEET_BERRIES)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.NETHER_STAR_DUST, 2) // You can also specify an int to produce more than one
                        .requires(Items.NETHER_STAR)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ACACIA_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_sword")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.BAMBOO_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_sword")
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.BIRCH_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.CHERRY_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DARK_OAK_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.JUNGLE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.CRIMSON_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.MANGROVE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.PALE_OAK_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.POPLAR_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SPRUCE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WARPED_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DEEPSLATE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.BLACKSTONE_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_sword")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SULFUR_SWORD)
                        .pattern("R")
                        .pattern("R")
                        .pattern("X")
                        .define('R', Items.POTENT_SULFUR)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POTENT_SULFUR), has(Items.POTENT_SULFUR))
                        .group("stone_sword")
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_IRON_WEAPONS, 2) // You can also specify an int to produce more than one
                        .requires(Items.IRON_INGOT)
                        .requires(Items.IRON_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_IRON_WEAPONS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_IRON_WEAPONS), has(ModItems.COMPENDIUM_IRON_WEAPONS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_IRON_TOOLS, 2) // You can also specify an int to produce more than one
                        .requires(Items.IRON_INGOT)
                        .requires(Items.IRON_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_IRON_TOOLS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_IRON_TOOLS), has(ModItems.COMPENDIUM_IRON_TOOLS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_IRON_ARMOR, 2) // You can also specify an int to produce more than one
                        .requires(Items.IRON_INGOT)
                        .requires(Items.IRON_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_IRON_ARMOR)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_IRON_ARMOR), has(ModItems.COMPENDIUM_IRON_ARMOR))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_GOLD_WEAPONS, 2) // You can also specify an int to produce more than one
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_GOLD_WEAPONS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_GOLD_WEAPONS), has(ModItems.COMPENDIUM_GOLD_WEAPONS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_GOLD_TOOLS, 2) // You can also specify an int to produce more than one
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_GOLD_TOOLS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_GOLD_TOOLS), has(ModItems.COMPENDIUM_GOLD_TOOLS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_GOLD_ARMOR, 2) // You can also specify an int to produce more than one
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.GOLD_INGOT)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_GOLD_ARMOR)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_GOLD_ARMOR), has(ModItems.COMPENDIUM_GOLD_ARMOR))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_DIAMOND_WEAPONS, 2) // You can also specify an int to produce more than one
                        .requires(Items.DIAMOND)
                        .requires(Items.DIAMOND)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_DIAMOND_WEAPONS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_DIAMOND_WEAPONS), has(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_DIAMOND_TOOLS, 2) // You can also specify an int to produce more than one
                        .requires(Items.DIAMOND)
                        .requires(Items.DIAMOND)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_DIAMOND_TOOLS)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_DIAMOND_TOOLS), has(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_DIAMOND_ARMOR, 2) // You can also specify an int to produce more than one
                        .requires(Items.DIAMOND)
                        .requires(Items.DIAMOND)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_DIAMOND_ARMOR)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_DIAMOND_ARMOR), has(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_RANGED, 2) // You can also specify an int to produce more than one
                        .requires(Items.STRING)
                        .requires(Items.STICK)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_RANGED)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_RANGED), has(ModItems.COMPENDIUM_RANGED))
                        .save(output);
                shapeless(RecipeCategory.MISC, ModItems.COMPENDIUM_WINDSWEPT_MACE, 2) // You can also specify an int to produce more than one
                        .requires(Items.BREEZE_ROD)
                        .requires(Items.BREEZE_ROD)
                        .requires(Items.BOOK)
                        .requires(ModItems.COMPENDIUM_WINDSWEPT_MACE)
                        // Create an advancement that gives you the recipe
                        .unlockedBy(getHasName(ModItems.COMPENDIUM_WINDSWEPT_MACE), has(ModItems.COMPENDIUM_WINDSWEPT_MACE))
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DISPENSER_MECHANISM)
                        .pattern(" RS")
                        .pattern(" RS")
                        .pattern(" RS")
                        .define('R', Items.STICK)
                        .define('S', Items.STRING)
                        .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.HANDLE)
                        .pattern("  R")
                        .pattern(" R ")
                        .pattern("R  ")
                        .define('R', Items.STICK)
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_BLADE)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern("RRR")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("blade")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_BLADE)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern("RRR")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("blade")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_BLADE)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern("RRR")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("blade")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_BLADE)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern("RRR")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("blade")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_SPEAR_HEAD)
                        .pattern(" R ")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("spear_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_SPEAR_HEAD)
                        .pattern(" R ")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("spear_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_SPEAR_HEAD)
                        .pattern(" R ")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("spear_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_SPEAR_HEAD)
                        .pattern(" R ")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("spear_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_PICKAXE_HEAD)
                        .pattern("RRR")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("pickaxe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_PICKAXE_HEAD)
                        .pattern("RRR")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("pickaxe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_PICKAXE_HEAD)
                        .pattern("RRR")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("pickaxe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_PICKAXE_HEAD)
                        .pattern("RRR")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("pickaxe_head")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ARMADILLO_HELMET)
                        .pattern("RRR")
                        .pattern("R R")
                        .define('R', Items.ARMADILLO_SCUTE)
                        .unlockedBy(getHasName(Items.ARMADILLO_SCUTE), has(Items.ARMADILLO_SCUTE))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ARMADILLO_CHESTPLATE)
                        .pattern("R R")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', Items.ARMADILLO_SCUTE)
                        .unlockedBy(getHasName(Items.ARMADILLO_SCUTE), has(Items.ARMADILLO_SCUTE))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ARMADILLO_LEGGINGS)
                        .pattern("RRR")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.ARMADILLO_SCUTE)
                        .unlockedBy(getHasName(Items.ARMADILLO_SCUTE), has(Items.ARMADILLO_SCUTE))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ARMADILLO_BOOTS)
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', Items.ARMADILLO_SCUTE)
                        .unlockedBy(getHasName(Items.ARMADILLO_SCUTE), has(Items.ARMADILLO_SCUTE))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.COPPER_MACE)
                        .pattern("R")
                        .pattern("S")
                        .define('R', ModItems.COPPER_CORE)
                        .define('S', ModItems.HANDLE)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_CORE)
                        .pattern(" R ")
                        .pattern("RRR")
                        .pattern(" R ")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("core")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.IRON_MACE)
                        .pattern("R")
                        .pattern("S")
                        .pattern("X")
                        .define('R', ModItems.IRON_CORE)
                        .define('S', ModItems.HANDLE)
                        .define('X', ModItems.COMPENDIUM_IRON_WEAPONS)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_CORE)
                        .pattern(" R ")
                        .pattern("RRR")
                        .pattern(" R ")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("core")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.GOLD_MACE)
                        .pattern("R")
                        .pattern("S")
                        .pattern("X")
                        .define('R', ModItems.GOLD_CORE)
                        .define('S', ModItems.HANDLE)
                        .define('X', ModItems.COMPENDIUM_GOLD_WEAPONS)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_CORE)
                        .pattern(" R ")
                        .pattern("RRR")
                        .pattern(" R ")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("core")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_MACE)
                        .pattern("R")
                        .pattern("S")
                        .pattern("X")
                        .define('R', ModItems.DIAMOND_CORE)
                        .define('S', ModItems.HANDLE)
                        .define('X', ModItems.COMPENDIUM_DIAMOND_WEAPONS)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_CORE)
                        .pattern(" R ")
                        .pattern("RRR")
                        .pattern(" R ")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("core")
                        .save(output);
                SmithingTransformRecipeBuilder.smithing(
                                Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                                Ingredient.of(ModItems.DIAMOND_MACE),
                                Ingredient.of(Items.NETHERITE_INGOT),
                                RecipeCategory.COMBAT,
                                ModItems.NETHERITE_MACE
                        );
                shaped(RecipeCategory.MISC, ModItems.COPPER_AXE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .pattern("  R")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("axe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_AXE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .pattern("  R")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("axe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_AXE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .pattern("  R")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("axe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_AXE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .pattern("  R")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("axe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_SHOVEL_HEAD)
                        .pattern(" R ")
                        .pattern(" RR")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("shovel_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_SHOVEL_HEAD)
                        .pattern(" R ")
                        .pattern(" RR")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("shovel_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_SHOVEL_HEAD)
                        .pattern(" R ")
                        .pattern(" RR")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("shovel_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_SHOVEL_HEAD)
                        .pattern(" R ")
                        .pattern(" RR")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("shovel_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COPPER_HOE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .define('R', Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .group("hoe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.IRON_HOE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .define('R', Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .group("hoe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.GOLD_HOE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .define('R', Items.GOLD_INGOT)
                        .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                        .group("hoe_head")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.DIAMOND_HOE_HEAD)
                        .pattern("RRR")
                        .pattern("  R")
                        .define('R', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .group("hoe_head")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.ACACIA_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BAMBOO_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BIRCH_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CHERRY_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DARK_OAK_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.JUNGLE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CRIMSON_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.MANGROVE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.PALE_OAK_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.POPLAR_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SPRUCE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.WARPED_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_PICKAXE)
                        .pattern("RRR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_pickaxe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.ACACIA_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BAMBOO_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BIRCH_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CHERRY_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DARK_OAK_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.JUNGLE_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CRIMSON_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.MANGROVE_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.PALE_OAK_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.POPLAR_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SPRUCE_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.WARPED_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_AXE)
                        .pattern(" RR")
                        .pattern(" XR")
                        .pattern(" X ")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_axe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.ACACIA_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BAMBOO_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BIRCH_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CHERRY_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DARK_OAK_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.JUNGLE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CRIMSON_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.MANGROVE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.PALE_OAK_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.POPLAR_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SPRUCE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.WARPED_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_SHOVEL)
                        .pattern(" R ")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_shovel")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.ACACIA_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BAMBOO_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BIRCH_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CHERRY_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DARK_OAK_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.JUNGLE_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.CRIMSON_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.MANGROVE_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.PALE_OAK_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.POPLAR_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.SPRUCE_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.WARPED_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_hoe")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_HOE)
                        .pattern(" RR")
                        .pattern(" X ")
                        .pattern(" X ")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_hoe")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ACACIA_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.ACACIA_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.BAMBOO_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.BAMBOO_PLANKS)
                        .define('X', Items.BAMBOO)
                        .unlockedBy(getHasName(Items.BAMBOO_PLANKS), has(Items.BAMBOO_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.BIRCH_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.BIRCH_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.CHERRY_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.CHERRY_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CHERRY_PLANKS), has(Items.CHERRY_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DARK_OAK_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.DARK_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.JUNGLE_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.JUNGLE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.CRIMSON_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.CRIMSON_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.MANGROVE_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.MANGROVE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.MANGROVE_PLANKS), has(Items.MANGROVE_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.PALE_OAK_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.PALE_OAK_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.PALE_OAK_PLANKS), has(Items.PALE_OAK_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.POPLAR_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.POPLAR_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.POPLAR_PLANKS), has(Items.POPLAR_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.SPRUCE_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.SPRUCE_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.WARPED_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.WARPED_PLANKS)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                        .group("wooden_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.BLACKSTONE_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.BLACKSTONE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.BLACKSTONE), has(Items.BLACKSTONE))
                        .group("stone_spear")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.DEEPSLATE_SPEAR)
                        .pattern("  R")
                        .pattern(" X ")
                        .pattern("X  ")
                        .define('R', Items.COBBLED_DEEPSLATE)
                        .define('X', Items.STICK)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .group("stone_spear")
                        .save(output);
            }

        };
    }

}

