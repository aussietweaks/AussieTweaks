package com.aussietweaks.loot;

import com.aussietweaks.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.advancements.predicates.entity.EntityFlagsPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider) {

        HolderLookup.RegistryLookup<Enchantment> enchantments = provider.lookupOrThrow(Registries.ENCHANTMENT);

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/camel"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.8f))
                    .add(LootItem.lootTableItem(ModItems.CAMEL_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))

                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 5)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/allay"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.ALLAY_WING))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/armadillo"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.5f))
                    .add(LootItem.lootTableItem(ModItems.ARMADILLO_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/bat"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.75f))
                    .add(LootItem.lootTableItem(ModItems.BAT_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 1)).build());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/frog"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.25f))
                    .add(LootItem.lootTableItem(ModItems.FROG_LEG))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/ghast"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.5f))
                    .add(LootItem.lootTableItem(ModItems.GHAST_MEAT))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/goat"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.5f))
                    .add(LootItem.lootTableItem(ModItems.GOAT_MUTTON))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/llama"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.LLAMA_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/nautilus"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.4f))
                    .add(LootItem.lootTableItem(ModItems.NAUTILUS_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/panda"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.PANDA_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/polar_bear"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.POLAR_BEAR_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 4)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/squid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.7f))
                    .add(LootItem.lootTableItem(ModItems.SQUID_TENTACLES))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/glow_squid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.7f))
                    .add(LootItem.lootTableItem(ModItems.SQUID_TENTACLES))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/horse"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.STALLION_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/mule"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.STALLION_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/donkey"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.6f))
                    .add(LootItem.lootTableItem(ModItems.STALLION_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/strider"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.4f))
                    .add(LootItem.lootTableItem(ModItems.STRIDER_LEG))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/turtle"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.4f))
                    .add(LootItem.lootTableItem(ModItems.TURTLE_MEAT))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }

        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/sniffer"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.8f))
                    .add(LootItem.lootTableItem(ModItems.SNIFFER_MEAT))
                    .apply(SmeltItemFunction.smelted().when(
                            LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.entity().flags(
                                            EntityFlagsPredicate.Builder.flags().setOnFire(true)
                                    )
                            )
                    ))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 6)).build())
                    .apply(EnchantedCountIncreaseFunction.lootingMultiplier(enchantments, ContextFloatProviders.exactly(1.0F)))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/skeleton"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.02f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/skeleton"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/skeleton"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/pillager"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/vindicator"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.07f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/piglin_brute"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.2f, 0.05f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.02f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombified_piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.02f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombified_piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.02f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombified_piglin"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.02f, 0.02f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());

            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/stray"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/stray"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/stray"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/bogged"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/bogged"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/bogged"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/parched"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/parched"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/parched"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/husk"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.02f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/husk"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/husk"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie_villager"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.02f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie_villager"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.05f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/zombie_villager"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.01f, 0.01f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(key.identifier().equals(Identifier.withDefaultNamespace("entities/breeze"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.05f, 0.03f))
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_WINDSWEPT_MACE))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build())
                    .when(LootItemKilledByPlayerCondition.killedByPlayer());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ANCIENT_CITY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.05f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ANCIENT_CITY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.05f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ANCIENT_CITY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.05f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_CAMP_COMMON_CHEST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_CAMP_BARREL.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_CAMP_SECRET_CHEST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_OTHER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_OTHER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_OTHER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_OTHER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BURIED_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BURIED_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.BURIED_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.DESERT_PYRAMID.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.JUNGLE_TEMPLE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.NETHER_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.PILLAGER_OUTPOST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.PILLAGER_OUTPOST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.PILLAGER_OUTPOST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.PILLAGER_OUTPOST.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.75f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.RUINED_PORTAL.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.RUINED_PORTAL.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.RUINED_PORTAL.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_GOLD_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.RUINED_PORTAL.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SHIPWRECK_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SHIPWRECK_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SHIPWRECK_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SHIPWRECK_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.SIMPLE_DUNGEON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CROSSING.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CROSSING.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CROSSING.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_CROSSING.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_LIBRARY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.12f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_LIBRARY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.12f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_LIBRARY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.12f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.STRONGHOLD_LIBRARY.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.12f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.UNDERWATER_RUIN_BIG.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.UNDERWATER_RUIN_BIG.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.UNDERWATER_RUIN_BIG.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.WOODLAND_MANSION.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.WOODLAND_MANSION.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.WOODLAND_MANSION.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.WOODLAND_MANSION.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.VILLAGE_ARMORER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.VILLAGE_FLETCHER.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_RANGED))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.VILLAGE_TOOLSMITH.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.VILLAGE_WEAPONSMITH.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.1f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.08f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.06f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_DIAMOND_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_MINESHAFT.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_ARMOR))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_MINESHAFT.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.04f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_WEAPONS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
        if(BuiltInLootTables.ABANDONED_MINESHAFT.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.15f)) // Drops 100% of the time
                    .add(LootItem.lootTableItem(ModItems.COMPENDIUM_IRON_TOOLS))
                    .apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)).build());
            builder.pool(poolBuilder.build());
        }
}}
