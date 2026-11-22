package com.aussietweaks.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SulfurSword extends Item {
    public SulfurSword(Properties properties) {
        super(properties);
    }

    // OPTION A: Triggers when hitting an entity (Left-Click)
    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            // Applies Poison II for 5 seconds (100 ticks) to the target
            target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 160, 1));
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0));
        }
        super.hurtEnemy(stack, target, attacker);
    }
    
}
