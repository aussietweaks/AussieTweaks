package com.aussietweaks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
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
        if (BuiltInRegistries.ENTITY_TYPE.getKey(type).equals(PHANTOM_ID)) {
            if (spawnReason == EntitySpawnReason.NATURAL || spawnReason == EntitySpawnReason.CHUNK_GENERATION) {
                if (level instanceof ServerLevelAccessor serverLevelAccessor) {
                    ServerLevel serverLevel = serverLevelAccessor.getLevel();
                    // Cancel spawn if it is daytime and not thundering
                    if (serverLevel.isBrightOutside() && !serverLevel.isThundering()) {
                        cir.setReturnValue(false);
                    }
                }
            }
        }
    }
}