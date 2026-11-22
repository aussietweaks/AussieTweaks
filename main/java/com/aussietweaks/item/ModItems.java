package com.aussietweaks.item;

import com.aussietweaks.AussieTweaks;
import com.aussietweaks.food.ModFoods;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    public static final Item NETHER_STAR_DUST = registerItem("nether_star_dust", Item::new);
    public static final Item NETHER_STAR_STEAK = registerItem("nether_star_steak", properties -> new Item(properties.food(ModFoods.NETHER_STAR_STEAK_PROPERTIES, ModFoods.NETHER_STAR_STEAK_CONSUMABLE)));
    public static final Item ALLAY_WING = registerItem("allay_wing", properties -> new Item(properties.food(ModFoods.ALLAY_WING_PROPERTIES, ModFoods.ALLAY_WING_CONSUMABLE)));
    public static final Item APPLE_JUICE = registerItem("apple_juice", properties -> new Item(properties.food(ModFoods.APPLE_JUICE_PROPERTIES, ModFoods.APPLE_JUICE_CONSUMABLE).usingConvertsTo(Items.GLASS_BOTTLE)));
    public static final Item SWEET_BERRY_JUICE = registerItem("sweet_berry_juice", properties -> new Item(properties.food(ModFoods.SWEET_BERRY_JUICE_PROPERTIES, ModFoods.SWEET_BERRY_JUICE_CONSUMABLE).usingConvertsTo(Items.GLASS_BOTTLE)));
    public static final Item SHULKER_MEAT = registerItem("shulker_meat", properties -> new Item(properties.food(ModFoods.SHULKER_MEAT_PROPERTIES, ModFoods.SHULKER_MEAT_CONSUMABLE)));
    public static final Item GHAST_MEAT = registerItem("ghast_meat", properties -> new Item(properties.food(ModFoods.GHAST_MEAT_PROPERTIES, ModFoods.GHAST_MEAT_CONSUMABLE)));
    public static final Item TURTLE_MEAT = registerItem("turtle_meat", properties -> new Item(properties.food(ModFoods.TURTLE_MEAT_PROPERTIES, ModFoods.TURTLE_MEAT_CONSUMABLE)));
    public static final Item NAUTILUS_MEAT = registerItem("nautilus_meat", properties -> new Item(properties.food(ModFoods.NAUTILUS_MEAT_PROPERTIES, ModFoods.NAUTILUS_MEAT_CONSUMABLE)));
    public static final Item FRIED_NAUTILUS_MEAT = registerItem("fried_nautilus_meat", properties -> new Item(properties.food(ModFoods.FRIED_NAUTILUS_PROPERTIES, ModFoods.FRIED_NAUTILUS_CONSUMABLE)));
    public static final Item FROG_LEG = registerItem("frog_leg", properties -> new Item(properties.food(ModFoods.FROG_LEG_PROPERTIES, ModFoods.FROG_LEG_CONSUMABLE)));
    public static final Item BAT_MEAT = registerItem("bat_meat", properties -> new Item(properties.food(ModFoods.BAT_PROPERTIES, ModFoods.BAT_CONSUMABLE)));
    public static final Item COOKED_BAT_MEAT = registerItem("cooked_bat_meat", properties -> new Item(properties.food(ModFoods.COOKED_BAT_PROPERTIES, ModFoods.COOKED_BAT_CONSUMABLE)));
    public static final Item SQUID_TENTACLES = registerItem("squid_tentacles", properties -> new Item(properties.food(ModFoods.SQUID_PROPERTIES, ModFoods.SQUID_CONSUMABLE)));
    public static final Item FRIED_SQUID = registerItem("fried_squid_meat", properties -> new Item(properties.food(ModFoods.FRIED_SQUID_PROPERTIES, ModFoods.FRIED_SQUID_CONSUMABLE)));
    public static final Item STRIDER_LEG = registerItem("strider_leg", properties -> new Item(properties.food(ModFoods.STRIDER_LEG_PROPERTIES, ModFoods.STRIDER_LEG_CONSUMABLE)));
    public static final Item AXOLOTL_MEAT = registerItem("axolotl_meat", properties -> new Item(properties.food(ModFoods.AXOLOTL_MEAT_PROPERTIES, ModFoods.AXOLOTL_MEAT_CONSUMABLE)));
    public static final Item FRIED_AXOLOTL = registerItem("fried_axolotl", properties -> new Item(properties.food(ModFoods.FRIED_AXOLOTL_PROPERTIES, ModFoods.FRIED_AXOLOTL_CONSUMABLE)));
    public static final Item CAMEL_MEAT = registerItem("camel_meat", properties -> new Item(properties.food(ModFoods.CAMEL_MEAT_PROPERTIES, ModFoods.CAMEL_MEAT_CONSUMABLE)));
    public static final Item CAMEL_STEAK = registerItem("camel_steak", properties -> new Item(properties.food(ModFoods.CAMEL_STEAK_PROPERTIES, ModFoods.CAMEL_STEAK_CONSUMABLE)));
    public static final Item ARMADILLO_MEAT = registerItem("armadillo_meat", properties -> new Item(properties.food(ModFoods.ARMADILLO_MEAT_PROPERTIES, ModFoods.ARMADILLO_MEAT_CONSUMABLE)));
    public static final Item COOKED_ARMADILLO_MEAT = registerItem("cooked_armadillo_meat", properties -> new Item(properties.food(ModFoods.COOKED_ARMADILLO_MEAT_PROPERTIES, ModFoods.COOKED_ARMADILLO_MEAT_CONSUMABLE)));
    public static final Item GOAT_MUTTON = registerItem("goat_mutton", properties -> new Item(properties.food(ModFoods.GOAT_PROPERTIES, ModFoods.GOAT_CONSUMABLE)));
    public static final Item COOKED_GOAT_MUTTON = registerItem("cooked_goat_mutton", properties -> new Item(properties.food(ModFoods.COOKED_GOAT_PROPERTIES, ModFoods.COOKED_GOAT_CONSUMABLE)));
    public static final Item LLAMA_MEAT = registerItem("llama_meat", properties -> new Item(properties.food(ModFoods.LLAMA_PROPERTIES, ModFoods.LLAMA_CONSUMABLE)));
    public static final Item LLAMA_STEAK = registerItem("llama_steak", properties -> new Item(properties.food(ModFoods.LLAMA_STEAK_PROPERTIES, ModFoods.LLAMA_STEAK_CONSUMABLE)));
    public static final Item PANDA_MEAT = registerItem("panda_meat", properties -> new Item(properties.food(ModFoods.PANDA_PROPERTIES, ModFoods.PANDA_CONSUMABLE)));
    public static final Item PANDA_STEAK = registerItem("panda_steak", properties -> new Item(properties.food(ModFoods.PANDA_STEAK_PROPERTIES, ModFoods.PANDA_STEAK_CONSUMABLE)));
    public static final Item POLAR_BEAR_MEAT = registerItem("polar_bear_meat", properties -> new Item(properties.food(ModFoods.POLAR_BEAR_PROPERTIES, ModFoods.POLAR_BEAR_CONSUMABLE)));
    public static final Item POLAR_BEAR_STEAK = registerItem("polar_bear_steak", properties -> new Item(properties.food(ModFoods.POLAR_BEAR_STEAK_PROPERTIES, ModFoods.POLAR_BEAR_STEAK_CONSUMABLE)));
    public static final Item SNIFFER_MEAT = registerItem("sniffer_meat", properties -> new Item(properties.food(ModFoods.SNIFFER_PROPERTIES, ModFoods.SNIFFER_CONSUMABLE)));
    public static final Item SNIFFER_STEAK = registerItem("sniffer_steak", properties -> new Item(properties.food(ModFoods.SNIFFER_STEAK_PROPERTIES, ModFoods.SNIFFER_STEAK_CONSUMABLE)));
    public static final Item STALLION_MEAT = registerItem("stallion_meat", properties -> new Item(properties.food(ModFoods.STALLION_PROPERTIES, ModFoods.STALLION_CONSUMABLE)));
    public static final Item STALLION_STEAK = registerItem("stallion_steak", properties -> new Item(properties.food(ModFoods.STALLION_STEAK_PROPERTIES, ModFoods.STALLION_STEAK_CONSUMABLE)));
    public static final Item APPLE_PIE = registerItem("apple_pie", properties -> new Item(properties.food(ModFoods.APPLE_PIE_PROPERTIES, ModFoods.APPLE_PIE_CONSUMABLE)));
    public static final Item SWEET_BERRY_PIE = registerItem("sweet_berry_pie", properties -> new Item(properties.food(ModFoods.SWEET_BERRY_PIE_PROPERTIES, ModFoods.SWEET_BERRY_PIE_CONSUMABLE)));
    public static final Item TURTLE_SOUP = registerItem("turtle_soup", properties -> new Item(properties.food(ModFoods.TURTLE_SOUP_PROPERTIES, ModFoods.TURTLE_SOUP_CONSUMABLE).stacksTo(1).usingConvertsTo(Items.BOWL)));
    public static final Item SALMON_ROLL = registerItem("salmon_roll", properties -> new Item(properties.food(ModFoods.SALMON_ROLL_PROPERTIES, ModFoods.SALMON_ROLL_CONSUMABLE)));
    public static final Item SPICY_SALMON_ROLL = registerItem("spicy_salmon_roll", properties -> new Item(properties.food(ModFoods.SPICY_SALMON_ROLL_PROPERTIES, ModFoods.SPICY_SALMON_ROLL_CONSUMABLE)));
    public static final Item AXOLOTL_ROLL = registerItem("axolotl_roll", properties -> new Item(properties.food(ModFoods.AXOLOTL_ROLL_PROPERTIES, ModFoods.AXOLOTL_ROLL_CONSUMABLE)));
    public static final Item SPICY_AXOLOTL_ROLL = registerItem("spicy_axolotl_roll", properties -> new Item(properties.food(ModFoods.SPICY_AXOLOTL_ROLL_PROPERTIES, ModFoods.SPICY_AXOLOTL_ROLL_CONSUMABLE)));
    public static final Item SQUID_ROLL = registerItem("squid_roll", properties -> new Item(properties.food(ModFoods.SQUID_ROLL_PROPERTIES, ModFoods.SQUID_ROLL_CONSUMABLE)));
    public static final Item SPICY_SQUID_ROLL = registerItem("spicy_squid_roll", properties -> new Item(properties.food(ModFoods.SPICY_SQUID_ROLL_PROPERTIES, ModFoods.SPICY_SQUID_ROLL_CONSUMABLE)));
    public static final Item STRIDER_ROLL = registerItem("strider_roll", properties -> new Item(properties.food(ModFoods.STRIDER_ROLL_PROPERTIES, ModFoods.STRIDER_ROLL_CONSUMABLE)));
    public static final Item SPICY_STRIDER_ROLL = registerItem("spicy_strider_roll", properties -> new Item(properties.food(ModFoods.SPICY_STRIDER_ROLL_PROPERTIES, ModFoods.SPICY_STRIDER_ROLL_CONSUMABLE)));
    public static final Item NAUTILUS_ROLL = registerItem("nautilus_roll", properties -> new Item(properties.food(ModFoods.NAUTILUS_ROLL_PROPERTIES, ModFoods.NAUTILUS_ROLL_CONSUMABLE)));
    public static final Item SPICY_NAUTILUS_ROLL = registerItem("spicy_nautilus_roll", properties -> new Item(properties.food(ModFoods.SPICY_NAUTILUS_ROLL_PROPERTIES, ModFoods.SPICY_NAUTILUS_ROLL_CONSUMABLE)));
    public static final Item EVERYTHING_ROLL = registerItem("everything_roll", properties -> new Item(properties.food(ModFoods.EVERYTHING_ROLL_PROPERTIES, ModFoods.EVERYTHING_ROLL_CONSUMABLE)));
    public static final Item SPICY_EVERYTHING_ROLL = registerItem("spicy_everything_roll", properties -> new Item(properties.food(ModFoods.SPICY_EVERYTHING_ROLL_PROPERTIES, ModFoods.SPICY_EVERYTHING_ROLL_CONSUMABLE)));

    public static final Item ACACIA_SWORD = registerItem("acacia_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.2F).durability(45).enchantable(15)));
    public static final Item BAMBOO_SWORD = registerItem("bamboo_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 2F, -1.8F).durability(40).enchantable(15)));
    public static final Item BIRCH_SWORD = registerItem("birch_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.4F).durability(60).enchantable(15)));
    public static final Item CHERRY_SWORD = registerItem("cherry_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 2.5F, -2.4F).durability(50).enchantable(15)));
    public static final Item CRIMSON_SWORD = registerItem("crimson_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.4F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_SWORD = registerItem("dark_oak_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.4F).durability(60).enchantable(15)));
    public static final Item JUNGLE_SWORD = registerItem("jungle_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 2.5F, -2F).durability(50).enchantable(15)));
    public static final Item MANGROVE_SWORD = registerItem("mangrove_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3.5F, -2.2F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_SWORD = registerItem("pale_oak_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.2F).durability(50).enchantable(15)));
    public static final Item POPLAR_SWORD = registerItem("poplar_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2.2F).durability(60).enchantable(15)));
    public static final Item SPRUCE_SWORD = registerItem("spruce_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3.5F, -2.6F).durability(70).enchantable(15)));
    public static final Item WARPED_SWORD = registerItem("warped_sword", properties -> new Item(properties.sword(ToolMaterial.WOOD, 3F, -2F).durability(60).enchantable(15)));

    public static final Item ACACIA_PICKAXE = registerItem("acacia_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.6F).durability(45).enchantable(15)));
    public static final Item BAMBOO_PICKAXE = registerItem("bamboo_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 1F, -2.2F).durability(40).enchantable(15)));
    public static final Item BIRCH_PICKAXE = registerItem("birch_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.8F).durability(60).enchantable(15)));
    public static final Item CHERRY_PICKAXE = registerItem("cherry_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 1.5F, -2.8F).durability(50).enchantable(15)));
    public static final Item CRIMSON_PICKAXE = registerItem("crimson_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.8F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_PICKAXE = registerItem("dark_oak_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.8F).durability(60).enchantable(15)));
    public static final Item JUNGLE_PICKAXE = registerItem("jungle_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 1.5F, -2.4F).durability(50).enchantable(15)));
    public static final Item MANGROVE_PICKAXE = registerItem("mangrove_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2.5F, -2.6F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_PICKAXE = registerItem("pale_oak_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.6F).durability(50).enchantable(15)));
    public static final Item POPLAR_PICKAXE = registerItem("poplar_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.6F).durability(60).enchantable(15)));
    public static final Item SPRUCE_PICKAXE = registerItem("spruce_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2.5F, -3F).durability(70).enchantable(15)));
    public static final Item WARPED_PICKAXE = registerItem("warped_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.WOOD, 2F, -2.4F).durability(60).enchantable(15)));

    public static final Item ACACIA_AXE = registerItem("acacia_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6.5F, -3.2F).durability(45).enchantable(15)));
    public static final Item BAMBOO_AXE = registerItem("bamboo_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 5.5F, -2.8F).durability(40).enchantable(15)));
    public static final Item BIRCH_AXE = registerItem("birch_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3.2F).durability(60).enchantable(15)));
    public static final Item CHERRY_AXE = registerItem("cherry_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3.2F).durability(50).enchantable(15)));
    public static final Item CRIMSON_AXE = registerItem("crimson_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6.5F, -3.2F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_AXE = registerItem("dark_oak_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3.2F).durability(60).enchantable(15)));
    public static final Item JUNGLE_AXE = registerItem("jungle_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 5.5F, -3F).durability(50).enchantable(15)));
    public static final Item MANGROVE_AXE = registerItem("mangrove_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6.5F, -3.2F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_AXE = registerItem("pale_oak_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3.2F).durability(50).enchantable(15)));
    public static final Item POPLAR_AXE = registerItem("poplar_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3.2F).durability(60).enchantable(15)));
    public static final Item SPRUCE_AXE = registerItem("spruce_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6.5F, -3.2F).durability(70).enchantable(15)));
    public static final Item WARPED_AXE = registerItem("warped_axe", properties -> new Item(properties.axe(ToolMaterial.WOOD, 6F, -3F).durability(60).enchantable(15)));

    public static final Item ACACIA_SHOVEL = registerItem("acacia_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1.5F, -3F).durability(45).enchantable(15)));
    public static final Item BAMBOO_SHOVEL = registerItem("bamboo_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -2.8F).durability(40).enchantable(15)));
    public static final Item BIRCH_SHOVEL = registerItem("birch_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -3F).durability(60).enchantable(15)));
    public static final Item CHERRY_SHOVEL = registerItem("cherry_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -3F).durability(50).enchantable(15)));
    public static final Item CRIMSON_SHOVEL = registerItem("crimson_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1.5F, -3F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_SHOVEL = registerItem("dark_oak_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -3F).durability(60).enchantable(15)));
    public static final Item JUNGLE_SHOVEL = registerItem("jungle_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -2.8F).durability(50).enchantable(15)));
    public static final Item MANGROVE_SHOVEL = registerItem("mangrove_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1.5F, -3F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_SHOVEL = registerItem("pale_oak_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -3F).durability(50).enchantable(15)));
    public static final Item POPLAR_SHOVEL = registerItem("poplar_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -3F).durability(60).enchantable(15)));
    public static final Item SPRUCE_SHOVEL = registerItem("spruce_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1.5F, -3F).durability(70).enchantable(15)));
    public static final Item WARPED_SHOVEL = registerItem("warped_shovel", properties -> new Item(properties.shovel(ToolMaterial.WOOD, 1F, -2.8F).durability(60).enchantable(15)));

    public static final Item ACACIA_HOE = registerItem("acacia_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0.5F, -3F).durability(45).enchantable(15)));
    public static final Item BAMBOO_HOE = registerItem("bamboo_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -2.8F).durability(40).enchantable(15)));
    public static final Item BIRCH_HOE = registerItem("birch_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -3F).durability(60).enchantable(15)));
    public static final Item CHERRY_HOE = registerItem("cherry_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -3F).durability(50).enchantable(15)));
    public static final Item CRIMSON_HOE = registerItem("crimson_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0.5F, -3F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_HOE = registerItem("dark_oak_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -3F).durability(60).enchantable(15)));
    public static final Item JUNGLE_HOE = registerItem("jungle_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -2.8F).durability(50).enchantable(15)));
    public static final Item MANGROVE_HOE = registerItem("mangrove_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0.5F, -3F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_HOE = registerItem("pale_oak_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -3F).durability(50).enchantable(15)));
    public static final Item POPLAR_HOE = registerItem("poplar_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -3F).durability(60).enchantable(15)));
    public static final Item SPRUCE_HOE = registerItem("spruce_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0.5F, -3F).durability(70).enchantable(15)));
    public static final Item WARPED_HOE = registerItem("warped_hoe", properties -> new Item(properties.hoe(ToolMaterial.WOOD, 0F, -2.8F).durability(60).enchantable(15)));

    public static final Item ACACIA_SPEAR = registerItem("acacia_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD, 0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(45).enchantable(15)));
    public static final Item BAMBOO_SPEAR = registerItem("bamboo_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(40).enchantable(15)));
    public static final Item BIRCH_SPEAR = registerItem("birch_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(60).enchantable(15)));
    public static final Item CHERRY_SPEAR = registerItem("cherry_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(50).enchantable(15)));
    public static final Item CRIMSON_SPEAR = registerItem("crimson_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(65).enchantable(15)));
    public static final Item DARK_OAK_SPEAR = registerItem("dark_oak_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(60).enchantable(15)));
    public static final Item JUNGLE_SPEAR = registerItem("jungle_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(50).enchantable(15)));
    public static final Item MANGROVE_SPEAR = registerItem("mangrove_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(65).enchantable(15)));
    public static final Item PALE_OAK_SPEAR = registerItem("pale_oak_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(50).enchantable(15)));
    public static final Item POPLAR_SPEAR = registerItem("poplar_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(60).enchantable(15)));
    public static final Item SPRUCE_SPEAR = registerItem("spruce_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(70).enchantable(15)));
    public static final Item WARPED_SPEAR = registerItem("warped_spear", properties -> new Item(properties.spear(ToolMaterial.WOOD,  0.65F, 0.7F, 0.75F, 5.0F, 14.0F, 10.0F, 5.1F, 15.0F, 4.6F).durability(60).enchantable(15)));

    public static final Item SULFUR_SWORD = registerItem("sulfur_sword", properties -> new SulfurSword(properties.sword(ToolMaterial.STONE, 3F, -2.2F).durability(100).enchantable(15)));
    public static final Item BLACKSTONE_SWORD = registerItem("blackstone_sword", properties -> new Item(properties.sword(ToolMaterial.STONE, 3.5F, -2.2F).durability(100).enchantable(15)));
    public static final Item DEEPSLATE_SWORD = registerItem("deepslate_sword", properties -> new Item(properties.sword(ToolMaterial.STONE, 3.5F, -2.6F).durability(130).enchantable(15)));
    public static final Item BLACKSTONE_PICKAXE = registerItem("blackstone_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.STONE, 2.5F, -2.6F).durability(100).enchantable(15)));
    public static final Item DEEPSLATE_PICKAXE = registerItem("deepslate_pickaxe", properties -> new Item(properties.pickaxe(ToolMaterial.STONE, 2.5F, -2.4F).durability(130).enchantable(15)));
    public static final Item BLACKSTONE_AXE = registerItem("blackstone_axe", properties -> new Item(properties.axe(ToolMaterial.STONE, 7F, -3F).durability(100).enchantable(15)));
    public static final Item DEEPSLATE_AXE = registerItem("deepslate_axe", properties -> new Item(properties.axe(ToolMaterial.STONE, 7F, -3.2F).durability(130).enchantable(15)));
    public static final Item BLACKSTONE_SHOVEL = registerItem("blackstone_shovel", properties -> new Item(properties.shovel(ToolMaterial.STONE, 1F, -3F).durability(100).enchantable(15)));
    public static final Item DEEPSLATE_SHOVEL = registerItem("deepslate_shovel", properties -> new Item(properties.shovel(ToolMaterial.STONE, 0.5F, -2.8F).durability(130).enchantable(15)));
    public static final Item BLACKSTONE_HOE = registerItem("blackstone_hoe", properties -> new Item(properties.hoe(ToolMaterial.STONE, 0F, -3F).durability(100).enchantable(15)));
    public static final Item DEEPSLATE_HOE = registerItem("deepslate_hoe", properties -> new Item(properties.hoe(ToolMaterial.STONE, 0.5F, -2.8F).durability(130).enchantable(15)));
    public static final Item BLACKSTONE_SPEAR = registerItem("blackstone_spear", properties -> new Item(properties.spear(ToolMaterial.STONE,  0.75F, 0.87F, 0.7F, 4.5F, 13.0F, 9.0F, 5.1F, 13.75F, 4.6F).durability(70).enchantable(15)));
    public static final Item DEEPSLATE_SPEAR = registerItem("deepslate_spear", properties -> new Item(properties.spear(ToolMaterial.STONE,  0.75F, 0.82F, 0.7F, 4.5F, 13.0F, 9.0F, 5.1F, 13.75F, 4.6F).durability(60).enchantable(15)));

    public static final Item COPPER_MACE = registerItem("copper_mace", MetalMace::new, new Item.Properties()
            .durability(191)
            .enchantable(13)
            .repairable(Items.COPPER_INGOT)
            .attributes(MetalMace.createCustomAttributes(2.0, -3.2))
            .component(DataComponents.WEAPON, new Weapon(1))
    );
    public static final Item IRON_MACE = registerItem("iron_mace", MetalMace::new, new Item.Properties()
            .durability(250)
            .enchantable(14)
            .repairable(Items.IRON_INGOT)
            .attributes(MetalMace.createCustomAttributes(3.0, -3.4))
            .component(DataComponents.WEAPON, new Weapon(1))
    );
    public static final Item GOLD_MACE = registerItem("gold_mace", MetalMace::new, new Item.Properties()
            .durability(32)
            .enchantable(22)
            .repairable(Items.GOLD_INGOT)
            .attributes(MetalMace.createCustomAttributes(2.0, -3.0))
            .component(DataComponents.WEAPON, new Weapon(1))
    );
    public static final Item DIAMOND_MACE = registerItem("diamond_mace", MetalMace::new, new Item.Properties()
            .durability(450)
            .enchantable(10)
            .repairable(Items.DIAMOND)
            .attributes(MetalMace.createCustomAttributes(4.0, -3.4))
            .component(DataComponents.WEAPON, new Weapon(1))
    );
    public static final Item NETHERITE_MACE = registerItem("netherite_mace", MetalMace::new, new Item.Properties()
            .durability(600)
            .enchantable(15)
            .repairable(Items.NETHERITE_INGOT)
            .attributes(MetalMace.createCustomAttributes(5.0, -3.4))
            .component(DataComponents.WEAPON, new Weapon(1))
            .fireResistant()
    );

    public static final Item ARMADILLO_HELMET = registerItem("armadillo_helmet", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ARMADILLO_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item ARMADILLO_CHESTPLATE = registerItem("armadillo_chestplate", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ARMADILLO_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item ARMADILLO_LEGGINGS = registerItem("armadillo_leggings", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ARMADILLO_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item ARMADILLO_BOOTS = registerItem("armadillo_boots", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ARMADILLO_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final Item COMPENDIUM_IRON_WEAPONS = registerItem("compendium_iron_weapons", Item::new);
    public static final Item COMPENDIUM_IRON_TOOLS = registerItem("compendium_iron_tools", Item::new);
    public static final Item COMPENDIUM_IRON_ARMOR = registerItem("compendium_iron_armor", Item::new);
    public static final Item COMPENDIUM_GOLD_WEAPONS = registerItem("compendium_gold_weapons", Item::new);
    public static final Item COMPENDIUM_GOLD_TOOLS = registerItem("compendium_gold_tools", Item::new);
    public static final Item COMPENDIUM_GOLD_ARMOR = registerItem("compendium_gold_armor", Item::new);
    public static final Item COMPENDIUM_DIAMOND_WEAPONS = registerItem("compendium_diamond_weapons", Item::new);
    public static final Item COMPENDIUM_DIAMOND_TOOLS = registerItem("compendium_diamond_tools", Item::new);
    public static final Item COMPENDIUM_DIAMOND_ARMOR = registerItem("compendium_diamond_armor", Item::new);
    public static final Item COMPENDIUM_RANGED = registerItem("compendium_ranged", Item::new);
    public static final Item COMPENDIUM_WINDSWEPT_MACE = registerItem("compendium_windswept_mace", Item::new);

    public static final Item DISPENSER_MECHANISM = registerItem("dispenser_mechanism", Item::new);
    public static final Item HANDLE = registerItem("handle", Item::new);
    public static final Item COPPER_BLADE = registerItem("copper_blade", Item::new);
    public static final Item IRON_BLADE = registerItem("iron_blade", Item::new);
    public static final Item GOLD_BLADE = registerItem("gold_blade", Item::new);
    public static final Item DIAMOND_BLADE = registerItem("diamond_blade", Item::new);
    public static final Item COPPER_SPEAR_HEAD = registerItem("copper_spear_head", Item::new);
    public static final Item IRON_SPEAR_HEAD = registerItem("iron_spear_head", Item::new);
    public static final Item GOLD_SPEAR_HEAD = registerItem("gold_spear_head", Item::new);
    public static final Item DIAMOND_SPEAR_HEAD = registerItem("diamond_spear_head", Item::new);
    public static final Item COPPER_PICKAXE_HEAD = registerItem("copper_pickaxe_head", Item::new);
    public static final Item IRON_PICKAXE_HEAD = registerItem("iron_pickaxe_head", Item::new);
    public static final Item GOLD_PICKAXE_HEAD = registerItem("gold_pickaxe_head", Item::new);
    public static final Item DIAMOND_PICKAXE_HEAD = registerItem("diamond_pickaxe_head", Item::new);
    public static final Item COPPER_CORE = registerItem("copper_core", Item::new);
    public static final Item IRON_CORE = registerItem("iron_core", Item::new);
    public static final Item GOLD_CORE = registerItem("gold_core", Item::new);
    public static final Item DIAMOND_CORE = registerItem("diamond_core", Item::new);
    public static final Item COPPER_AXE_HEAD = registerItem("copper_axe_head", Item::new);
    public static final Item IRON_AXE_HEAD = registerItem("iron_axe_head", Item::new);
    public static final Item GOLD_AXE_HEAD = registerItem("gold_axe_head", Item::new);
    public static final Item DIAMOND_AXE_HEAD = registerItem("diamond_axe_head", Item::new);
    public static final Item COPPER_SHOVEL_HEAD = registerItem("copper_shovel_head", Item::new);
    public static final Item IRON_SHOVEL_HEAD = registerItem("iron_shovel_head", Item::new);
    public static final Item GOLD_SHOVEL_HEAD = registerItem("gold_shovel_head", Item::new);
    public static final Item DIAMOND_SHOVEL_HEAD = registerItem("diamond_shovel_head", Item::new);
    public static final Item COPPER_HOE_HEAD = registerItem("copper_hoe_head", Item::new);
    public static final Item IRON_HOE_HEAD = registerItem("iron_hoe_head", Item::new);
    public static final Item GOLD_HOE_HEAD = registerItem("gold_hoe_head", Item::new);
    public static final Item DIAMOND_HOE_HEAD = registerItem("diamond_hoe_head", Item::new);


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, name)))));
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, name)
        );
        Item item = factory.apply(properties.setId(itemKey));
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    public static void registerModItems() {
        AussieTweaks.LOGGER.info("Registering Mod Items for " + AussieTweaks.MOD_ID);

    }


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
}
