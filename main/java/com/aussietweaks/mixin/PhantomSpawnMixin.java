package com.aussietweaks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public class PhantomSpawnMixin {

    private static final Identifier PHANTOM_ID = Identifier.withDefaultNamespace("phantom");

    @Inject(method = "checkMobSpawnRules", at = @At("HEAD"), cancellable = true)
    private static void restrictPhantomToNight(
            EntityType<? extends Mob> type,
            LevelAccessor level,
            EntitySpawnReason spawnReason,
            BlockPos pos,
            RandomSource random,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (BuiltInRegistries.ENTITY_TYPE.getKey(type).equals(PHANTOM_ID) && spawnReason == EntitySpawnReason.NATURAL) {
            if (level instanceof ServerLevelAccessor serverLevel) {
                if (!Monster.isDarkEnoughToSpawn(serverLevel, pos, random)) {
                    cir.setReturnValue(false);
                }
            }
        }
    }
}