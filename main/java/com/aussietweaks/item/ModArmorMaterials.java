package com.aussietweaks.item;

import com.aussietweaks.AussieTweaks;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> ARMADILLO_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(AussieTweaks.MOD_ID, "armadillo"));

    public static final ArmorMaterial ARMADILLO_ARMOR_MATERIAL = new ArmorMaterial(750,
            ArmorMaterials.makeDefense(2, 4, 5, 2, 10),
            20, SoundEvents.ARMOR_EQUIP_CHAIN, 0, 0.1F, ItemTags.REPAIRS_WOLF_ARMOR, ARMADILLO_KEY);

}