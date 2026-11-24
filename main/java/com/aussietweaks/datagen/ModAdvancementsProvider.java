package com.aussietweaks.datagen;

import com.aussietweaks.AussieTweaks;
import com.aussietweaks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.predicates.*;
import net.minecraft.advancements.predicates.entity.EntityEquipmentPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentExactPredicate;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.feline.CatVariant;
import net.minecraft.world.entity.animal.feline.CatVariants;
import net.minecraft.world.entity.animal.golem.CopperGolem;
import net.minecraft.world.entity.animal.wolf.WolfVariant;
import net.minecraft.world.entity.animal.wolf.WolfVariants;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.ibm.icu.impl.CurrencyData.provider;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    List<ResourceKey<Recipe<?>>> trimRecipes = List.of(
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("spire_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("snout_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("rib_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("ward_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("silence_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("vex_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("tide_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("wayfinder_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("shaper_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("raiser_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("host_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("flow_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("bolt_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("coast_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("dune_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("eye_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("sentry_armor_trim_smithing_template_smithing_trim")),
            ResourceKey.create(Registries.RECIPE, Identifier.withDefaultNamespace("wild_armor_trim_smithing_template_smithing_trim"))
    );


    @Override
    public void generateAdvancement(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
        var items = registries.lookupOrThrow(Registries.ITEM);
        var blocks = registries.lookupOrThrow(Registries.BLOCK);

        AdvancementHolder root = Advancement.Builder.advancement()
                .rootDisplay(
                        Items.GRASS_BLOCK,
                        Component.translatable("advancements.aussietweaks.root.title"),
                        Component.translatable("advancements.aussietweaks.root.description"),
                        Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion(
                        "in_overworld",
                        PlayerTrigger.TriggerInstance.located(
                                LocationPredicate.Builder.inDimension(Level.OVERWORLD)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/root"));

        AdvancementHolder cobblestone = Advancement.Builder.advancement()
                .parent(root)
                .display(Items.WOODEN_PICKAXE,
                        Component.translatable("advancements.aussietweaks.cobblestone.title"),
                        Component.translatable("advancements.aussietweaks.cobblestone.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("get_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ItemTags.STONE_TOOL_MATERIALS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/cobblestone"));

        AdvancementHolder stone_pickaxe = Advancement.Builder.advancement()
                .parent(cobblestone)
                .display(Items.STONE_PICKAXE,
                        Component.translatable("advancements.aussietweaks.stone_pickaxe.title"),
                        Component.translatable("advancements.aussietweaks.stone_pickaxe.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("stone_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.STONE_PICKAXE)))
                .addCriterion("blackstone_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.BLACKSTONE_PICKAXE)))
                .addCriterion("deepslate_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.DEEPSLATE_PICKAXE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/stone_pickaxe"));

        AdvancementHolder copper_ingot = Advancement.Builder.advancement()
                .parent(stone_pickaxe)
                .display(Items.COPPER_INGOT,
                        Component.translatable("advancements.aussietweaks.copper_ingot.title"),
                        Component.translatable("advancements.aussietweaks.copper_ingot.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.COPPER_INGOT)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/copper_ingot"));

        net.minecraft.core.HolderGetter entityTypes =
                registries.lookupOrThrow(net.minecraft.core.registries.Registries.ENTITY_TYPE);


        AdvancementHolder copper_golem = Advancement.Builder.advancement()
                .parent(copper_ingot)
                .display(
                        Items.COPPER_GOLEM_STATUE.weathering().unaffected(),
                        Component.translatable("advancements.aussietweaks.copper_golem.title"),
                        Component.translatable("advancements.aussietweaks.copper_golem.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion(
                        "summon_copper_golem",
                        net.minecraft.advancements.triggers.SummonedEntityTrigger.TriggerInstance.summonedEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.COPPER_GOLEM)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/copper_golem"));

        AdvancementHolder copper_armor = Advancement.Builder.advancement()
                .parent(copper_ingot)
                .display(Items.COPPER_HELMET,
                        Component.translatable("advancements.aussietweaks.copper_armor.title"),
                        Component.translatable("advancements.aussietweaks.copper_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("copper_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.COPPER_HELMET)))
                .addCriterion("copper_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.COPPER_CHESTPLATE)))
                .addCriterion("copper_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.COPPER_LEGGINGS)))
                .addCriterion("copper_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.COPPER_BOOTS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/copper_armor"));

        AdvancementHolder brush = Advancement.Builder.advancement()
                .parent(copper_ingot)
                .display(Items.BRUSH,
                        Component.translatable("advancements.aussietweaks.brush.title"),
                        Component.translatable("advancements.aussietweaks.brush.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("brush", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.BRUSH)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/brush"));

        AdvancementHolder archeology = Advancement.Builder.advancement()
                .parent(brush)
                .display(Items.PRIZE_POTTERY_SHERD,
                        Component.translatable("advancements.aussietweaks.archeology.title"),
                        Component.translatable("advancements.aussietweaks.archeology.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("archeology", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location(),
                        ItemPredicate.Builder.item().of(items, Items.BRUSH.asItem())))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/archeology"));

        AdvancementHolder iron_ingot = Advancement.Builder.advancement()
                .parent(stone_pickaxe)
                .display(Items.IRON_INGOT,
                        Component.translatable("advancements.aussietweaks.iron_ingot.title"),
                        Component.translatable("advancements.aussietweaks.iron_ingot.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_INGOT)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/iron_ingot"));

        AdvancementHolder shears = Advancement.Builder.advancement()
                .parent(iron_ingot)
                .display(Items.SHEARS,
                        Component.translatable("advancements.aussietweaks.shears.title"),
                        Component.translatable("advancements.aussietweaks.shears.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("shears", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.SHEARS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/shears"));

        AdvancementHolder shield = Advancement.Builder.advancement()
                .parent(iron_ingot)
                .display(Items.SHIELD,
                        Component.translatable("advancements.aussietweaks.shield.title"),
                        Component.translatable("advancements.aussietweaks.shield.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("shield", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.SHIELD)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/shield"));

        AdvancementHolder iron_pickaxe = Advancement.Builder.advancement()
                .parent(iron_ingot)
                .display(Items.IRON_PICKAXE,
                        Component.translatable("advancements.aussietweaks.iron_pickaxe.title"),
                        Component.translatable("advancements.aussietweaks.iron_pickaxe.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("iron_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_PICKAXE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/iron_pickaxe"));

        AdvancementHolder iron_armor = Advancement.Builder.advancement()
                .parent(iron_ingot)
                .display(Items.IRON_HELMET,
                        Component.translatable("advancements.aussietweaks.iron_armor.title"),
                        Component.translatable("advancements.aussietweaks.iron_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("iron_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_HELMET)))
                .addCriterion("iron_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_CHESTPLATE)))
                .addCriterion("iron_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_LEGGINGS)))
                .addCriterion("iron_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.IRON_BOOTS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/iron_armor"));

        HolderGetter<Recipe<?>> recipeLookup = registries.lookupOrThrow(Registries.RECIPE);

        HolderSet<Recipe<?>> trimRecipeHolders = HolderSet.direct(
                trimRecipes.stream()
                        .map(recipeLookup::getOrThrow)
                        .toList()
        );

        AdvancementHolder smithing = Advancement.Builder.advancement()
                .parent(iron_ingot)
                .display(
                        Items.SMITHING_TABLE,
                        Component.translatable("advancements.aussietweaks.smithing.title"),
                        Component.translatable("advancements.aussietweaks.smithing.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "trimmed_armor",
                        RecipeCraftedTrigger.TriggerInstance.craftedItem(trimRecipeHolders)
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/smithing"));

        AdvancementHolder diamonds = Advancement.Builder.advancement()
                .parent(iron_pickaxe)
                .display(Items.DIAMOND,
                        Component.translatable("advancements.aussietweaks.diamonds.title"),
                        Component.translatable("advancements.aussietweaks.diamonds.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("diamonds", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/diamonds"));

        AdvancementHolder diamond_pickaxe = Advancement.Builder.advancement()
                .parent(diamonds)
                .display(Items.DIAMOND_PICKAXE,
                        Component.translatable("advancements.aussietweaks.diamond_pickaxe.title"),
                        Component.translatable("advancements.aussietweaks.diamond_pickaxe.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("diamond_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND_PICKAXE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/diamond_pickaxe"));

        AdvancementHolder jukebox = Advancement.Builder.advancement()
                .parent(diamonds)
                .display(Items.JUKEBOX,
                        Component.translatable("advancements.aussietweaks.jukebox.title"),
                        Component.translatable("advancements.aussietweaks.jukebox.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("jukebox", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.JUKEBOX)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/jukebox"));

        AdvancementHolder allay_delivery = Advancement.Builder.advancement()
                .parent(jukebox)
                .display(Items.COOKIE,
                        Component.translatable("advancements.aussietweaks.allay_delivery.title"),
                        Component.translatable("advancements.aussietweaks.allay_delivery.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("allay_delivery",
                        net.minecraft.advancements.triggers.PickedUpItemTrigger.TriggerInstance.thrownItemPickedUpByPlayer(Optional.empty(), Optional.empty(),
                                Optional.of(EntityPredicate.wrap(net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity().of(entityTypes, net.minecraft.world.entity.EntityTypes.ALLAY)))))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/allay_delivery"));

        AdvancementHolder diamond_armor = Advancement.Builder.advancement()
                .parent(diamonds)
                .display(Items.DIAMOND_HELMET,
                        Component.translatable("advancements.aussietweaks.diamond_armor.title"),
                        Component.translatable("advancements.aussietweaks.diamond_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("diamond_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND_HELMET)))
                .addCriterion("diamond_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND_CHESTPLATE)))
                .addCriterion("diamond_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND_LEGGINGS)))
                .addCriterion("diamond_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DIAMOND_BOOTS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/diamond_armor"));

        AdvancementHolder obsidian = Advancement.Builder.advancement()
                .parent(diamond_pickaxe)
                .display(Items.OBSIDIAN,
                        Component.translatable("advancements.aussietweaks.obsidian.title"),
                        Component.translatable("advancements.aussietweaks.obsidian.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("obsidian", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.OBSIDIAN)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/obsidian"));

        AdvancementHolder enchanting_table = Advancement.Builder.advancement()
                .parent(obsidian)
                .display(Items.ENCHANTING_TABLE,
                        Component.translatable("advancements.aussietweaks.enchanting_table.title"),
                        Component.translatable("advancements.aussietweaks.enchanting_table.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("enchanting_table", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.ENCHANTING_TABLE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/enchanting_table"));

        AdvancementHolder enchant = Advancement.Builder.advancement()
                .parent(enchanting_table)
                .display(Items.ENCHANTED_BOOK,
                        Component.translatable("advancements.aussietweaks.enchant.title"),
                        Component.translatable("advancements.aussietweaks.enchant.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("enchanting_table", EnchantedItemTrigger.TriggerInstance.enchantedItem())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/enchant"));

        AdvancementHolder nether = Advancement.Builder.advancement()
                .parent(obsidian)
                .display(Items.NETHERRACK,
                        Component.translatable("advancements.aussietweaks.nether.title"),
                        Component.translatable("advancements.aussietweaks.nether.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("entered_nether", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.NETHER))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/nether"));

        AdvancementHolder respawn_anchor = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.RESPAWN_ANCHOR,
                        Component.translatable("advancements.aussietweaks.respawn_anchor.title"),
                        Component.translatable("advancements.aussietweaks.respawn_anchor.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("respawn_anchor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.RESPAWN_ANCHOR)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/respawn_anchor"));

        AdvancementHolder dried_ghast = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.DRIED_GHAST,
                        Component.translatable("advancements.aussietweaks.dried_ghast.title"),
                        Component.translatable("advancements.aussietweaks.dried_ghast.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("dried_ghast", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DRIED_GHAST)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/dried_ghast"));

        AdvancementHolder harness_happy_ghast = Advancement.Builder.advancement()
                .parent(dried_ghast)
                .display(
                        Items.HARNESS.blue(),
                        Component.translatable("advancements.aussietweaks.harness_happy_ghast.title"),
                        Component.translatable("advancements.aussietweaks.harness_happy_ghast.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "harnessed_happy_ghast",
                        net.minecraft.advancements.triggers.PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
                                        .of(items, net.minecraft.tags.ItemTags.HARNESSES),
                                java.util.Optional.of(
                                        net.minecraft.advancements.predicates.entity.EntityPredicate.wrap(
                                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.HAPPY_GHAST)
                                        )
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/harness_happy_ghast"));

        net.minecraft.core.HolderGetter<net.minecraft.world.damagesource.DamageType> damageTypes =
                registries.lookupOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE);
        net.minecraft.core.HolderSet<net.minecraft.world.damagesource.DamageType> isProjectile =
                damageTypes.getOrThrow(net.minecraft.tags.DamageTypeTags.IS_PROJECTILE);

        AdvancementHolder return_to_sender = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.FIRE_CHARGE,
                        Component.translatable("advancements.aussietweaks.return_to_sender.title"),
                        Component.translatable("advancements.aussietweaks.return_to_sender.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false)
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(50))
                .addCriterion("killed_ghast", net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity
                        (net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity().of(entityTypes, net.minecraft.world.entity.EntityTypes.GHAST),
                                net.minecraft.advancements.predicates.DamageSourcePredicate.Builder.damageType()
                                        .tag(net.minecraft.advancements.predicates.TagPredicate.is(isProjectile))
                                        .direct(
                                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.FIREBALL)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/return_to_sender"));

        AdvancementHolder oh_shiny = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.GOLD_INGOT,
                        Component.translatable("advancements.aussietweaks.oh_shiny.title"),
                        Component.translatable("advancements.aussietweaks.oh_shiny.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(net.minecraft.advancements.AdvancementRequirements.Strategy.OR)
                .addCriterion(
                        "distract_piglins_with_gold",
                        net.minecraft.advancements.triggers.PickedUpItemTrigger.TriggerInstance.thrownItemPickedUpByEntity(
                                Optional.empty(),
                                Optional.of(
                                        net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
                                                .of(items, net.minecraft.tags.ItemTags.PIGLIN_LOVED)
                                                .build()
                                ),
                                Optional.of(
                                        net.minecraft.advancements.predicates.entity.EntityPredicate.wrap(
                                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.PIGLIN)
                                                        .flags(
                                                                net.minecraft.advancements.predicates.entity.EntityFlagsPredicate.Builder.flags()
                                                                        .setIsBaby(false)
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "distract_piglin_directly",
                        net.minecraft.advancements.triggers.PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                Optional.empty(),
                                net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
                                        .of(items, net.minecraft.world.entity.monster.piglin.PiglinAi.BARTERING_ITEM),
                                Optional.of(
                                        net.minecraft.advancements.predicates.entity.EntityPredicate.wrap(
                                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.PIGLIN)
                                                        .flags(
                                                                net.minecraft.advancements.predicates.entity.EntityFlagsPredicate.Builder.flags()
                                                                        .setIsBaby(false)
                                                        )
                                        )
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/oh_shiny"));

        net.minecraft.core.HolderGetter<net.minecraft.world.level.levelgen.structure.Structure> structures =
                registries.lookupOrThrow(net.minecraft.core.registries.Registries.STRUCTURE);

        AdvancementHolder bastion = Advancement.Builder.advancement()
                .parent(oh_shiny)
                .display(Items.POLISHED_BLACKSTONE_BRICKS,
                        Component.translatable("advancements.aussietweaks.bastion.title"),
                        Component.translatable("advancements.aussietweaks.bastion.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "bastion",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(net.minecraft.world.level.levelgen.structure.BuiltinStructures.BASTION_REMNANT)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/bastion"));

        net.minecraft.core.HolderGetter<net.minecraft.world.level.storage.loot.LootTable> lootTables =
                registries.lookupOrThrow(net.minecraft.core.registries.Registries.LOOT_TABLE);

        AdvancementHolder loot_bastion = Advancement.Builder.advancement()
                .parent(bastion)
                .display(Items.CHEST,
                        Component.translatable("advancements.aussietweaks.loot_bastion.title"),
                        Component.translatable("advancements.aussietweaks.loot_bastion.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion(
                        "loot_bastion_other",
                        net.minecraft.advancements.triggers.LootTableTrigger.TriggerInstance.lootTableUsed(
                                lootTables.getOrThrow(net.minecraft.world.level.storage.loot.BuiltInLootTables.BASTION_OTHER)
                        )
                )
                .addCriterion(
                        "loot_bastion_treasure",
                        net.minecraft.advancements.triggers.LootTableTrigger.TriggerInstance.lootTableUsed(
                                lootTables.getOrThrow(net.minecraft.world.level.storage.loot.BuiltInLootTables.BASTION_TREASURE)
                        )
                )
                .addCriterion(
                        "loot_bastion_hoglin_stable",
                        net.minecraft.advancements.triggers.LootTableTrigger.TriggerInstance.lootTableUsed(
                                lootTables.getOrThrow(net.minecraft.world.level.storage.loot.BuiltInLootTables.BASTION_HOGLIN_STABLE)
                        )
                )
                .addCriterion(
                        "loot_bastion_bridge",
                        net.minecraft.advancements.triggers.LootTableTrigger.TriggerInstance.lootTableUsed(
                                lootTables.getOrThrow(net.minecraft.world.level.storage.loot.BuiltInLootTables.BASTION_BRIDGE)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/loot_bastion"));

        AdvancementHolder ancient_debris = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.ANCIENT_DEBRIS,
                        Component.translatable("advancements.aussietweaks.ancient_debris.title"),
                        Component.translatable("advancements.aussietweaks.ancient_debris.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("ancient_debris", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.ANCIENT_DEBRIS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ancient_debris"));

        AdvancementHolder netherite_armor = Advancement.Builder.advancement()
                .parent(ancient_debris)
                .display(Items.NETHERITE_HELMET,
                        Component.translatable("advancements.aussietweaks.netherite_armor.title"),
                        Component.translatable("advancements.aussietweaks.netherite_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("netherite_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.NETHERITE_HELMET)))
                .addCriterion("netherite_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.NETHERITE_CHESTPLATE)))
                .addCriterion("netherite_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.NETHERITE_LEGGINGS)))
                .addCriterion("netherite_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.NETHERITE_BOOTS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/netherite_armor"));

        AdvancementHolder netherite_pickaxe = Advancement.Builder.advancement()
                .parent(ancient_debris)
                .display(Items.NETHERITE_PICKAXE,
                        Component.translatable("advancements.aussietweaks.netherite_pickaxe.title"),
                        Component.translatable("advancements.aussietweaks.netherite_pickaxe.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("netherite_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.NETHERITE_PICKAXE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/netherite_pickaxe"));

        AdvancementHolder nether_fortress = Advancement.Builder.advancement()
                .parent(nether)
                .display(Items.NETHER_BRICK,
                        Component.translatable("advancements.aussietweaks.nether_fortress.title"),
                        Component.translatable("advancements.aussietweaks.nether_fortress.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "nether_fortress",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(BuiltinStructures.FORTRESS)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/nether_fortress"));

        AdvancementHolder wither_skull = Advancement.Builder.advancement()
                .parent(nether_fortress)
                .display(Items.WITHER_SKELETON_SKULL,
                        Component.translatable("advancements.aussietweaks.wither_skull.title"),
                        Component.translatable("advancements.aussietweaks.wither_skull.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("wither_skull", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.WITHER_SKELETON_SKULL)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/wither_skull"));

        AdvancementHolder wither = Advancement.Builder.advancement()
                .parent(wither_skull)
                .display(
                        Items.NETHER_STAR,
                        Component.translatable("advancements.aussietweaks.wither.title"),
                        Component.translatable("advancements.aussietweaks.wither.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "summon_wither",
                        net.minecraft.advancements.triggers.SummonedEntityTrigger.TriggerInstance.summonedEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.WITHER)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/wither"));

        AdvancementHolder beacon = Advancement.Builder.advancement()
                .parent(wither)
                .display(
                        Items.BEACON,
                        Component.translatable("advancements.aussietweaks.beacon.title"),
                        Component.translatable("advancements.aussietweaks.beacon.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("beacon", net.minecraft.advancements.triggers.ConstructBeaconTrigger.TriggerInstance.constructedBeacon(MinMaxBounds.Ints.atLeast(1)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/wither"));

        AdvancementHolder max_beacon = Advancement.Builder.advancement()
                .parent(beacon)
                .display(
                        Items.BEACON,
                        Component.translatable("advancements.aussietweaks.max_beacon.title"),
                        Component.translatable("advancements.aussietweaks.max_beacon.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion("beacon", net.minecraft.advancements.triggers.ConstructBeaconTrigger.TriggerInstance.constructedBeacon(MinMaxBounds.Ints.atLeast(4)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/max_beacon"));

        AdvancementHolder blaze_rod = Advancement.Builder.advancement()
                .parent(nether_fortress)
                .display(Items.BLAZE_ROD,
                        Component.translatable("advancements.aussietweaks.blaze_rod.title"),
                        Component.translatable("advancements.aussietweaks.blaze_rod.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("blaze_rod", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.BLAZE_ROD)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/blaze_rod"));

        AdvancementHolder potions = Advancement.Builder.advancement()
                .parent(blaze_rod)
                .display(Items.POTION,
                        Component.translatable("advancements.aussietweaks.potions.title"),
                        Component.translatable("advancements.aussietweaks.potions.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("potion", net.minecraft.advancements.triggers.BrewedPotionTrigger.TriggerInstance.brewedPotion())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/potions"));

        AdvancementHolder cure_villager = Advancement.Builder.advancement()
                .parent(potions)
                .display(Items.GOLDEN_APPLE,
                        Component.translatable("advancements.aussietweaks.cure_villager.title"),
                        Component.translatable("advancements.aussietweaks.cure_villager.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion("cured_zombie", net.minecraft.advancements.triggers.CuredZombieVillagerTrigger.TriggerInstance.curedZombieVillager())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/cure_villager"));

        AdvancementHolder stronghold = Advancement.Builder.advancement()
                .parent(blaze_rod)
                .display(Items.MOSSY_STONE_BRICKS,
                        Component.translatable("advancements.aussietweaks.stronghold.title"),
                        Component.translatable("advancements.aussietweaks.stronghold.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "stronghold",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(BuiltinStructures.STRONGHOLD)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/stronghold"));

        AdvancementHolder end = Advancement.Builder.advancement()
                .parent(stronghold)
                .display(Items.END_STONE,
                        Component.translatable("advancements.aussietweaks.end.title"),
                        Component.translatable("advancements.aussietweaks.end.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("entered_end", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.END))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/end"));

        AdvancementHolder kill_dragon = Advancement.Builder.advancement()
                .parent(end)
                .display(
                        Items.DRAGON_HEAD,
                        Component.translatable("advancements.aussietweaks.kill_dragon.title"),
                        Component.translatable("advancements.aussietweaks.kill_dragon.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_dragon",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, net.minecraft.world.entity.EntityTypes.ENDER_DRAGON)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_dragon"));

        AdvancementHolder dragon_egg = Advancement.Builder.advancement()
                .parent(kill_dragon)
                .display(Items.DRAGON_EGG,
                        Component.translatable("advancements.aussietweaks.dragon_egg.title"),
                        Component.translatable("advancements.aussietweaks.dragon_egg.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("dragon_egg", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DRAGON_EGG)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/dragon_egg"));

        AdvancementHolder dragon_breath = Advancement.Builder.advancement()
                .parent(kill_dragon)
                .display(Items.DRAGON_BREATH,
                        Component.translatable("advancements.aussietweaks.dragon_breath.title"),
                        Component.translatable("advancements.aussietweaks.dragon_breath.description"),
                        AdvancementType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("dragon_breath", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.DRAGON_BREATH)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/dragon_breath"));

        AdvancementHolder respawn_dragon = Advancement.Builder.advancement()
                .parent(kill_dragon)
                .display(Items.END_CRYSTAL,
                        Component.translatable("advancements.aussietweaks.respawn_dragon.title"),
                        Component.translatable("advancements.aussietweaks.respawn_dragon.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "summon_ender_dragon",
                        net.minecraft.advancements.triggers.SummonedEntityTrigger.TriggerInstance.summonedEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.ENDER_DRAGON)
                        )
                )                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/respawn_dragon"));

        AdvancementHolder escape_island = Advancement.Builder.advancement()
                .parent(kill_dragon)
                .display(Items.ENDER_PEARL,
                        Component.translatable("advancements.aussietweaks.escape_island.title"),
                        Component.translatable("advancements.aussietweaks.escape_island.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "escape_island",
                        net.minecraft.advancements.triggers.EnterBlockTrigger.TriggerInstance.entersBlock(
                                blocks,
                                net.minecraft.world.level.block.Blocks.END_GATEWAY
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/escape_island"));

        AdvancementHolder end_city = Advancement.Builder.advancement()
                .parent(escape_island)
                .display(Items.PURPUR_BLOCK,
                        Component.translatable("advancements.aussietweaks.end_city.title"),
                        Component.translatable("advancements.aussietweaks.end_city.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "end_city",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(BuiltinStructures.END_CITY)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/end_city"));

        AdvancementHolder elytra = Advancement.Builder.advancement()
                .parent(end_city)
                .display(Items.ELYTRA,
                        Component.translatable("advancements.aussietweaks.elytra.title"),
                        Component.translatable("advancements.aussietweaks.elytra.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("elytra", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.ELYTRA)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/elytra"));

        AdvancementHolder trade = Advancement.Builder.advancement()
                .parent(root)
                .display(Items.EMERALD,
                        Component.translatable("advancements.aussietweaks.trade.title"),
                        Component.translatable("advancements.aussietweaks.trade.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("trade", net.minecraft.advancements.triggers.TradeTrigger.TriggerInstance.tradedWithVillager())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/trade"));

        AdvancementHolder iron_golem = Advancement.Builder.advancement()
                .parent(trade)
                .display(Items.IRON_BLOCK,
                        Component.translatable("advancements.aussietweaks.iron_golem.title"),
                        Component.translatable("advancements.aussietweaks.iron_golem.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("iron_golem",
                        net.minecraft.advancements.triggers.SummonedEntityTrigger.TriggerInstance.summonedEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.IRON_GOLEM)
                        ))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/iron_golem"));

        AdvancementHolder hero = Advancement.Builder.advancement()
                .parent(trade)
                .display(Items.IRON_AXE,
                        Component.translatable("advancements.aussietweaks.hero.title"),
                        Component.translatable("advancements.aussietweaks.hero.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false)
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(100))
                .addCriterion("hero_of_the_village", net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.raidWon())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/hero"));

        AdvancementHolder outpost = Advancement.Builder.advancement()
                .parent(trade)
                .display(Items.GOAT_HORN,
                        Component.translatable("advancements.aussietweaks.outpost.title"),
                        Component.translatable("advancements.aussietweaks.outpost.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "loot_pillager_outpost",
                        net.minecraft.advancements.triggers.LootTableTrigger.TriggerInstance.lootTableUsed(
                                lootTables.getOrThrow(BuiltInLootTables.PILLAGER_OUTPOST)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/outpost"));

        AdvancementHolder mansion = Advancement.Builder.advancement()
                .parent(outpost)
                .display(Items.DARK_OAK_PLANKS,
                        Component.translatable("advancements.aussietweaks.mansion.title"),
                        Component.translatable("advancements.aussietweaks.mansion.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "mansion",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(BuiltinStructures.WOODLAND_MANSION)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/mansion"));

        net.minecraft.core.HolderGetter mobEntityTypes =
                registries.lookupOrThrow(net.minecraft.core.registries.Registries.ENTITY_TYPE);

        Advancement.Builder monsterHunterBuilder = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        Items.IRON_SWORD,
                        Component.translatable("advancements.aussietweaks.monster_hunter.title"),
                        Component.translatable("advancements.aussietweaks.monster_hunter.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .requirements(AdvancementRequirements.Strategy.OR);

        net.minecraft.world.entity.EntityType<?>[] hostileMobs = {
                net.minecraft.world.entity.EntityTypes.BLAZE,
                net.minecraft.world.entity.EntityTypes.BOGGED,
                net.minecraft.world.entity.EntityTypes.BREEZE,
                net.minecraft.world.entity.EntityTypes.CAVE_SPIDER,
                net.minecraft.world.entity.EntityTypes.CREAKING,
                net.minecraft.world.entity.EntityTypes.CREEPER,
                net.minecraft.world.entity.EntityTypes.DROWNED,
                net.minecraft.world.entity.EntityTypes.ELDER_GUARDIAN,
                net.minecraft.world.entity.EntityTypes.ENDER_DRAGON,
                net.minecraft.world.entity.EntityTypes.ENDERMAN,
                net.minecraft.world.entity.EntityTypes.ENDERMITE,
                net.minecraft.world.entity.EntityTypes.EVOKER,
                net.minecraft.world.entity.EntityTypes.GHAST,
                net.minecraft.world.entity.EntityTypes.GUARDIAN,
                net.minecraft.world.entity.EntityTypes.HOGLIN,
                net.minecraft.world.entity.EntityTypes.HUSK,
                net.minecraft.world.entity.EntityTypes.MAGMA_CUBE,
                net.minecraft.world.entity.EntityTypes.PHANTOM,
                net.minecraft.world.entity.EntityTypes.PIGLIN,
                net.minecraft.world.entity.EntityTypes.PIGLIN_BRUTE,
                net.minecraft.world.entity.EntityTypes.PILLAGER,
                net.minecraft.world.entity.EntityTypes.RAVAGER,
                net.minecraft.world.entity.EntityTypes.SHULKER,
                net.minecraft.world.entity.EntityTypes.SILVERFISH,
                net.minecraft.world.entity.EntityTypes.SKELETON,
                net.minecraft.world.entity.EntityTypes.SLIME,
                net.minecraft.world.entity.EntityTypes.SPIDER,
                net.minecraft.world.entity.EntityTypes.STRAY,
                net.minecraft.world.entity.EntityTypes.VEX,
                net.minecraft.world.entity.EntityTypes.VINDICATOR,
                net.minecraft.world.entity.EntityTypes.WITCH,
                net.minecraft.world.entity.EntityTypes.WITHER,
                net.minecraft.world.entity.EntityTypes.WITHER_SKELETON,
                net.minecraft.world.entity.EntityTypes.ZOGLIN,
                net.minecraft.world.entity.EntityTypes.ZOMBIE,
                net.minecraft.world.entity.EntityTypes.ZOMBIE_VILLAGER,
                net.minecraft.world.entity.EntityTypes.ZOMBIFIED_PIGLIN
        };

        for (int i = 0; i < hostileMobs.length; i++) {
            monsterHunterBuilder.addCriterion(
                    "kill_mob_" + i,
                    net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                            net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                    .of(mobEntityTypes, hostileMobs[i])
                    )
            );
        }

        AdvancementHolder monster_hunter = monsterHunterBuilder.save(
                output,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_a_mob")
        );

        AdvancementHolder kill_creeper = Advancement.Builder.advancement()
                .parent(monster_hunter)
                .display(
                        Items.GUNPOWDER,
                        Component.translatable("advancements.aussietweaks.kill_creeper.title"),
                        Component.translatable("advancements.aussietweaks.kill_creeper.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_creeper",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.CREEPER)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_creeper"));

        AdvancementHolder kill_enderman = Advancement.Builder.advancement()
                .parent(kill_creeper)
                .display(
                        Items.ENDER_PEARL,
                        Component.translatable("advancements.aussietweaks.kill_enderman.title"),
                        Component.translatable("advancements.aussietweaks.kill_enderman.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_enderman",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.ENDERMAN)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_enderman"));

        AdvancementHolder kill_elderguardian = Advancement.Builder.advancement()
                .parent(kill_enderman)
                .display(
                        Items.PRISMARINE_CRYSTALS,
                        Component.translatable("advancements.aussietweaks.kill_elderguardian.title"),
                        Component.translatable("advancements.aussietweaks.kill_elderguardian.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_elderguardian",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.ELDER_GUARDIAN)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_elderguardian"));

        AdvancementHolder kill_breeze = Advancement.Builder.advancement()
                .parent(kill_elderguardian)
                .display(
                        Items.WIND_CHARGE,
                        Component.translatable("advancements.aussietweaks.kill_breeze.title"),
                        Component.translatable("advancements.aussietweaks.kill_breeze.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_breeze",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.BREEZE)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_breeze"));

        AdvancementHolder kill_ravager = Advancement.Builder.advancement()
                .parent(kill_breeze)
                .display(
                        Items.SADDLE,
                        Component.translatable("advancements.aussietweaks.kill_ravager.title"),
                        Component.translatable("advancements.aussietweaks.kill_ravager.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_ravager",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.RAVAGER)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_ravager"));

        AdvancementHolder kill_evoker = Advancement.Builder.advancement()
                .parent(kill_ravager)
                .display(
                        Items.TOTEM_OF_UNDYING,
                        Component.translatable("advancements.aussietweaks.kill_evoker.title"),
                        Component.translatable("advancements.aussietweaks.kill_evoker.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_evoker",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.EVOKER)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_evoker"));

        AdvancementHolder kill_brute = Advancement.Builder.advancement()
                .parent(kill_evoker)
                .display(
                        Items.GOLDEN_AXE,
                        Component.translatable("advancements.aussietweaks.kill_brute.title"),
                        Component.translatable("advancements.aussietweaks.kill_brute.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_brute",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.PIGLIN_BRUTE)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_brute"));

        AdvancementHolder kill_wither = Advancement.Builder.advancement()
                .parent(kill_brute)
                .display(
                        Items.WITHER_ROSE,
                        Component.translatable("advancements.aussietweaks.kill_wither.title"),
                        Component.translatable("advancements.aussietweaks.kill_wither.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "killed_wither",
                        net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                                net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                        .of(entityTypes, EntityTypes.WITHER)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_wither"));

        Advancement.Builder monstersHuntedBuilder = Advancement.Builder.advancement()
                .parent(kill_wither)
                .display(
                        Items.DIAMOND_SWORD,
                        Component.translatable("advancements.aussietweaks.monsters_hunted.title"),
                        Component.translatable("advancements.aussietweaks.monsters_hunted.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(100))
                .requirements(AdvancementRequirements.Strategy.AND);

        for (int i = 0; i < hostileMobs.length; i++) {
            monstersHuntedBuilder.addCriterion(
                    "kill_mob_" + i,
                    net.minecraft.advancements.triggers.KilledTrigger.TriggerInstance.playerKilledEntity(
                            net.minecraft.advancements.predicates.entity.EntityPredicate.Builder.entity()
                                    .of(mobEntityTypes, hostileMobs[i])
                    )
            );
        }

        AdvancementHolder monsters_hunted = monstersHuntedBuilder.save(
                output,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/kill_all_mobs")
        );

        AdvancementHolder trial = Advancement.Builder.advancement()
                .parent(monster_hunter)
                .display(Items.CUT_COPPER.weathering().unaffected(),
                        Component.translatable("advancements.aussietweaks.trial.title"),
                        Component.translatable("advancements.aussietweaks.trial.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "trial",
                        net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance.located(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.inStructure(
                                        structures.getOrThrow(BuiltinStructures.TRIAL_CHAMBERS)
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/trial"));

        AdvancementHolder vault = Advancement.Builder.advancement()
                .parent(trial)
                .display(Items.TRIAL_KEY,
                        Component.translatable("advancements.aussietweaks.vault.title"),
                        Component.translatable("advancements.aussietweaks.vault.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "vault",
                        net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.location()
                                        .setBlock(
                                                net.minecraft.advancements.predicates.BlockPredicate.Builder.block()
                                                        .of(blocks, net.minecraft.world.level.block.Blocks.VAULT)
                                                        .setProperties(
                                                                net.minecraft.advancements.predicates.StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(net.minecraft.world.level.block.VaultBlock.OMINOUS, false)
                                                        )
                                        ),
                                net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
                                        .of(items, Items.TRIAL_KEY)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/vault"));

        AdvancementHolder ominous_vault = Advancement.Builder.advancement()
                .parent(vault)
                .display(Items.OMINOUS_TRIAL_KEY,
                        Component.translatable("advancements.aussietweaks.ominous_vault.title"),
                        Component.translatable("advancements.aussietweaks.ominous_vault.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "ominous_vault",
                        net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                                net.minecraft.advancements.predicates.LocationPredicate.Builder.location()
                                        .setBlock(
                                                net.minecraft.advancements.predicates.BlockPredicate.Builder.block()
                                                        .of(blocks, net.minecraft.world.level.block.Blocks.VAULT)
                                                        .setProperties(
                                                                net.minecraft.advancements.predicates.StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(net.minecraft.world.level.block.VaultBlock.OMINOUS, true)
                                                        )
                                        ),
                                net.minecraft.advancements.predicates.ItemPredicate.Builder.item()
                                        .of(items, Items.OMINOUS_TRIAL_KEY)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ominous_vault"));

        AdvancementHolder sword = Advancement.Builder.advancement()
                .parent(root)
                .display(Items.COPPER_SWORD,
                        Component.translatable("advancements.aussietweaks.sword.title"),
                        Component.translatable("advancements.aussietweaks.sword.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("sword", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ItemTags.SWORDS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/sword"));

        AdvancementHolder spear = Advancement.Builder.advancement()
                .parent(sword)
                .display(Items.IRON_SPEAR,
                        Component.translatable("advancements.aussietweaks.spear.title"),
                        Component.translatable("advancements.aussietweaks.spear.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("spear", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ItemTags.SPEARS)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/spear"));

        AdvancementHolder trident = Advancement.Builder.advancement()
                .parent(sword)
                .display(Items.TRIDENT,
                        Component.translatable("advancements.aussietweaks.trident.title"),
                        Component.translatable("advancements.aussietweaks.trident.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("trident", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.TRIDENT)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/trident"));

        AdvancementHolder mace = Advancement.Builder.advancement()
                .parent(sword)
                .display(Items.MACE,
                        Component.translatable("advancements.aussietweaks.mace.title"),
                        Component.translatable("advancements.aussietweaks.mace.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("mace", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.MACE)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/mace"));

        AdvancementHolder crossbow = Advancement.Builder.advancement()
                .parent(sword)
                .display(Items.CROSSBOW,
                        Component.translatable("advancements.aussietweaks.crossbow.title"),
                        Component.translatable("advancements.aussietweaks.crossbow.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("crossbow", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.CROSSBOW)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/crossbow"));

        AdvancementHolder bow = Advancement.Builder.advancement()
                .parent(sword)
                .display(Items.BOW,
                        Component.translatable("advancements.aussietweaks.bow.title"),
                        Component.translatable("advancements.aussietweaks.bow.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("bow", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.BOW)))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/bow"));

        HolderGetter<Block> blockLookup = BuiltInRegistries.BLOCK;

        AdvancementHolder seed = Advancement.Builder.advancement()
                .parent(root)
                .display(Items.STONE_HOE,
                        Component.translatable("advancements.aussietweaks.seed.title"),
                        Component.translatable("advancements.aussietweaks.seed.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion("wheat", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.WHEAT))
                .addCriterion("pumpkin_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.PUMPKIN_STEM))
                .addCriterion("melon_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.MELON_STEM))
                .addCriterion("beetroots", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.BEETROOTS))
                .addCriterion("nether_wart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.NETHER_WART))
                .addCriterion("torchflower", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.TORCHFLOWER_CROP))
                .addCriterion("pitcher_pod", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.PITCHER_CROP))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/seed"));

        AdvancementHolder all_seed = Advancement.Builder.advancement()
                .parent(seed)
                .display(Items.DIAMOND_HOE,
                        Component.translatable("advancements.aussietweaks.all_seed.title"),
                        Component.translatable("advancements.aussietweaks.all_seed.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false)
                .requirements(AdvancementRequirements.Strategy.AND)
                .addCriterion("wheat", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.WHEAT))
                .addCriterion("pumpkin_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.PUMPKIN_STEM))
                .addCriterion("melon_stem", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.MELON_STEM))
                .addCriterion("beetroots", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.BEETROOTS))
                .addCriterion("nether_wart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.NETHER_WART))
                .addCriterion("torchflower", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.TORCHFLOWER_CROP))
                .addCriterion("pitcher_pod", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blockLookup, Blocks.PITCHER_CROP))
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/all_seed"));

        AdvancementHolder breed = Advancement.Builder.advancement()
                .parent(seed)
                .display(
                        Items.WHEAT,
                        Component.translatable("advancements.aussietweaks.breed.title"),
                        Component.translatable("advancements.aussietweaks.breed.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("breed", BredAnimalsTrigger.TriggerInstance.bredAnimals())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/breed"));

        HolderGetter<EntityType<?>> entityLookup = BuiltInRegistries.ENTITY_TYPE;

        List<EntityType<?>> breedableAnimals = List.of(
                EntityTypes.ARMADILLO,
                EntityTypes.AXOLOTL,
                EntityTypes.BEE,
                EntityTypes.CAMEL,
                EntityTypes.CAT,
                EntityTypes.CHICKEN,
                EntityTypes.COW,
                EntityTypes.DONKEY,
                EntityTypes.FOX,
                EntityTypes.FROG,
                EntityTypes.GOAT,
                EntityTypes.HOGLIN,
                EntityTypes.HORSE,
                EntityTypes.LLAMA,
                EntityTypes.MOOSHROOM,
                EntityTypes.MULE,
                EntityTypes.OCELOT,
                EntityTypes.PANDA,
                EntityTypes.PIG,
                EntityTypes.RABBIT,
                EntityTypes.SHEEP,
                EntityTypes.SNIFFER,
                EntityTypes.STRIDER,
                EntityTypes.TURTLE,
                EntityTypes.WOLF
        );

        Advancement.Builder builder = Advancement.Builder.advancement()
                .parent(breed)
                .display(
                        Items.GOLDEN_CARROT,
                        Component.translatable("advancements.aussietweaks.breed_all.title"),
                        Component.translatable("advancements.aussietweaks.breed_all.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                );

        for (EntityType<?> animal : breedableAnimals) {
            String key = BuiltInRegistries.ENTITY_TYPE.getKey(animal).getPath();
            builder.addCriterion(
                    key,
                    BredAnimalsTrigger.TriggerInstance.bredAnimals(
                            Optional.empty(),
                            Optional.empty(),
                            Optional.of(EntityPredicate.Builder.entity().of(entityLookup, animal).build())
                    )
            );
        }

        AdvancementHolder breed_all = builder.save(
                output,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/breed_all")
        );

        AdvancementHolder tamed_animal = Advancement.Builder.advancement()
                .parent(breed)
                .display(
                        Items.BOWL,
                        Component.translatable("advancements.aussietweaks.tamed_animal.title"),
                        Component.translatable("advancements.aussietweaks.tamed_animal.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("tamed_animal", TameAnimalTrigger.TriggerInstance.tamedAnimal())
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/tamed_animal"));

        AdvancementHolder wolf = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.BONE,
                        Component.translatable("advancements.aussietweaks.wolf.title"),
                        Component.translatable("advancements.aussietweaks.wolf.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "wolf",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.WOLF)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/wolf"));

        HolderGetter<Item> itemLookup = BuiltInRegistries.ITEM;

        AdvancementHolder wolf_armor = Advancement.Builder.advancement()
                .parent(wolf)
                .display(
                        Items.WOLF_ARMOR,
                        Component.translatable("advancements.aussietweaks.wolf_armor.title"),
                        Component.translatable("advancements.aussietweaks.wolf_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "equip_wolf_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.WOLF_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.WOLF)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.WOLF_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/wolf_armor"));

        HolderLookup.RegistryLookup<WolfVariant> wolfVariantLookup = registries.lookupOrThrow(Registries.WOLF_VARIANT);

        List<ResourceKey<WolfVariant>> wolfVariants = List.of(
                WolfVariants.PALE,
                WolfVariants.SPOTTED,
                WolfVariants.SNOWY,
                WolfVariants.BLACK,
                WolfVariants.WOODS,
                WolfVariants.CHESTNUT,
                WolfVariants.STRIPED,
                WolfVariants.RUSTY,
                WolfVariants.ASHEN
        );

        Advancement.Builder wolvesBuilder = Advancement.Builder.advancement()
                .parent(wolf)
                .display(
                        Items.BONE,
                        Component.translatable("advancements.aussietweaks.tamed_all_wolves.title"),
                        Component.translatable("advancements.aussietweaks.tamed_all_wolves.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                );

        for (ResourceKey<WolfVariant> variant : wolfVariants) {
            String key = variant.identifier().getPath();
            wolvesBuilder.addCriterion(
                    key,
                    TameAnimalTrigger.TriggerInstance.tamedAnimal(
                            EntityPredicate.Builder.entity()
                                    .of(entityLookup, EntityTypes.WOLF)
                                    .components(
                                            DataComponentMatchers.Builder.components()
                                                    .exact(
                                                            DataComponentExactPredicate.expect(
                                                                    DataComponents.WOLF_VARIANT,
                                                                    wolfVariantLookup.getOrThrow(variant)
                                                            )
                                                    )
                                                    .build()
                                    )
                    )
            );
        }

        AdvancementHolder tamed_all_wolves = wolvesBuilder.save(
                output,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/tamed_all_wolves")
        );

        AdvancementHolder cat = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.SALMON,
                        Component.translatable("advancements.aussietweaks.cat.title"),
                        Component.translatable("advancements.aussietweaks.cat.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "cat",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.CAT)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/cat"));

        HolderLookup.RegistryLookup<CatVariant> catVariantLookup = registries.lookupOrThrow(Registries.CAT_VARIANT);

        List<ResourceKey<CatVariant>> catVariants = List.of(
                CatVariants.TABBY,
                CatVariants.BLACK,
                CatVariants.RED,
                CatVariants.SIAMESE,
                CatVariants.BRITISH_SHORTHAIR,
                CatVariants.CALICO,
                CatVariants.PERSIAN,
                CatVariants.RAGDOLL,
                CatVariants.WHITE,
                CatVariants.JELLIE,
                CatVariants.ALL_BLACK
        );

        Advancement.Builder catsBuilder = Advancement.Builder.advancement()
                .parent(cat)
                .display(
                        Items.COD,
                        Component.translatable("advancements.aussietweaks.tamed_all_cats.title"),
                        Component.translatable("advancements.aussietweaks.tamed_all_cats.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                );

        for (ResourceKey<CatVariant> variant : catVariants) {
            String key = variant.identifier().getPath();
            catsBuilder.addCriterion(
                    key,
                    TameAnimalTrigger.TriggerInstance.tamedAnimal(
                            EntityPredicate.Builder.entity()
                                    .of(entityLookup, EntityTypes.CAT)
                                    .components(
                                            DataComponentMatchers.Builder.components()
                                                    .exact(
                                                            DataComponentExactPredicate.expect(
                                                                    DataComponents.CAT_VARIANT,
                                                                    catVariantLookup.getOrThrow(variant)
                                                            )
                                                    )
                                                    .build()
                                    )
                    )
            );
        }

        AdvancementHolder tamed_all_cats = catsBuilder.save(
                output,
                Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/tamed_all_cats")
        );

        AdvancementHolder nautilus = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.NAUTILUS_SHELL,
                        Component.translatable("advancements.aussietweaks.nautilus.title"),
                        Component.translatable("advancements.aussietweaks.nautilus.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "nautilus",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.NAUTILUS)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/nautilus"));

        AdvancementHolder zombie_nautilus = Advancement.Builder.advancement()
                .parent(nautilus)
                .display(
                        Items.HORN_CORAL,
                        Component.translatable("advancements.aussietweaks.zombie_nautilus.title"),
                        Component.translatable("advancements.aussietweaks.zombie_nautilus.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "zombie_nautilus",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.ZOMBIE_NAUTILUS)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/zombie_nautilus"));

        AdvancementHolder nautilus_armor = Advancement.Builder.advancement()
                .parent(nautilus)
                .display(
                        Items.DIAMOND_NAUTILUS_ARMOR,
                        Component.translatable("advancements.aussietweaks.nautilus_armor.title"),
                        Component.translatable("advancements.aussietweaks.nautilus_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion(
                        "copper_nautilus_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.COPPER_NAUTILUS_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.NAUTILUS)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.COPPER_NAUTILUS_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "iron_nautilus_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.IRON_NAUTILUS_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.NAUTILUS)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.IRON_NAUTILUS_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "gold_nautilus_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.GOLDEN_NAUTILUS_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.NAUTILUS)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.GOLDEN_NAUTILUS_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "diamond_nautilus_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.DIAMOND_NAUTILUS_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.NAUTILUS)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.DIAMOND_NAUTILUS_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "netherite_nautilus_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.NETHERITE_NAUTILUS_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.NAUTILUS)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.NETHERITE_NAUTILUS_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/nautilus_armor"));

        AdvancementHolder parrot = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.FEATHER,
                        Component.translatable("advancements.aussietweaks.parrot.title"),
                        Component.translatable("advancements.aussietweaks.parrot.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "parrot",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.PARROT)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/parrot"));

        AdvancementHolder axolotl = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.AXOLOTL_BUCKET,
                        Component.translatable("advancements.aussietweaks.axolotl.title"),
                        Component.translatable("advancements.aussietweaks.axolotl.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "axolotl",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.AXOLOTL)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/axolotl"));

        AdvancementHolder horse = Advancement.Builder.advancement()
                .parent(tamed_animal)
                .display(
                        Items.SADDLE,
                        Component.translatable("advancements.aussietweaks.horse.title"),
                        Component.translatable("advancements.aussietweaks.horse.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "horse",
                        TameAnimalTrigger.TriggerInstance.tamedAnimal(
                                EntityPredicate.Builder.entity().of(entityLookup, EntityTypes.HORSE)
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/horse"));

        AdvancementHolder horse_armor = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.DIAMOND_HORSE_ARMOR,
                        Component.translatable("advancements.aussietweaks.horse_armor.title"),
                        Component.translatable("advancements.aussietweaks.horse_armor.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .requirements(AdvancementRequirements.Strategy.OR)
                .addCriterion(
                        "copper_horse_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.COPPER_HORSE_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.HORSE)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.COPPER_HORSE_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "iron_horse_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.IRON_HORSE_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.HORSE)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.IRON_HORSE_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "gold_horse_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.GOLDEN_HORSE_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.HORSE)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.GOLDEN_HORSE_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "diamond_horse_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.DIAMOND_HORSE_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.HORSE)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.DIAMOND_HORSE_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .addCriterion(
                        "netherite_horse_armor",
                        PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(
                                ItemPredicate.Builder.item().of(itemLookup, Items.NETHERITE_HORSE_ARMOR),
                                Optional.of(
                                        EntityPredicate.wrap(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.HORSE)
                                                        .equipment(
                                                                EntityEquipmentPredicate.Builder.equipment()
                                                                        .body(ItemPredicate.Builder.item().of(itemLookup, Items.NETHERITE_HORSE_ARMOR))
                                                        )
                                        )
                                )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/horse_armor"));

        AdvancementHolder ride_zombie_horse = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.RED_MUSHROOM,
                        Component.translatable("advancements.aussietweaks.ride_zombie_horse.title"),
                        Component.translatable("advancements.aussietweaks.ride_zombie_horse.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_zombie_horse",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.ZOMBIE_HORSE)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_zombie_horse"));

        AdvancementHolder ride_skeleton_horse = Advancement.Builder.advancement()
                .parent(ride_zombie_horse)
                .display(
                        Items.BONE,
                        Component.translatable("advancements.aussietweaks.ride_skeleton_horse.title"),
                        Component.translatable("advancements.aussietweaks.ride_skeleton_horse.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_skeleton_horse",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.SKELETON_HORSE)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_skeleton_horse"));

        AdvancementHolder ride_camel = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.LEATHER,
                        Component.translatable("advancements.aussietweaks.ride_camel.title"),
                        Component.translatable("advancements.aussietweaks.ride_camel.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_camel",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.CAMEL)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_camel"));

        AdvancementHolder ride_camel_husk = Advancement.Builder.advancement()
                .parent(ride_camel)
                .display(
                        Items.RABBIT_FOOT,
                        Component.translatable("advancements.aussietweaks.ride_camel_husk.title"),
                        Component.translatable("advancements.aussietweaks.ride_camel_husk.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_camel_husk",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.CAMEL_HUSK)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_camel_husk"));

        AdvancementHolder ride_llama = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.CHEST,
                        Component.translatable("advancements.aussietweaks.llama.title"),
                        Component.translatable("advancements.aussietweaks.llama.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_llama",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.LLAMA)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_llama"));

        AdvancementHolder ride_pig = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.PORKCHOP,
                        Component.translatable("advancements.aussietweaks.ride_pig.title"),
                        Component.translatable("advancements.aussietweaks.ride_pig.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_pig",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.PIG)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_pig"));

        AdvancementHolder ride_strider = Advancement.Builder.advancement()
                .parent(horse)
                .display(
                        Items.LAVA_BUCKET,
                        Component.translatable("advancements.aussietweaks.ride_strider.title"),
                        Component.translatable("advancements.aussietweaks.ride_strider.description"),
                        AdvancementType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion(
                        "ride_strider",
                        StartRidingTrigger.TriggerInstance.playerStartsRiding(
                                EntityPredicate.Builder.entity()
                                        .vehicle(
                                                EntityPredicate.Builder.entity()
                                                        .of(entityLookup, EntityTypes.STRIDER)
                                        )
                        )
                )
                .save(output, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "aussietweaks/ride_strider"));
    }
}


