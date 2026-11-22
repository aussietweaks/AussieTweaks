package com.aussietweaks.mixin;

import com.aussietweaks.access.LeaderPhantomAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Phantom.class)
public abstract class PhantomLeaderMixin implements LeaderPhantomAccess {
    @Unique
    private static final EntityDataAccessor<Boolean> DATA_IS_LEADER =
            SynchedEntityData.defineId(Phantom.class, EntityDataSerializers.BOOLEAN);


    @Unique
    private static final Identifier LEADER_HEALTH_ID =
            Identifier.fromNamespaceAndPath("aussietweaks", "phantom_leader_health");

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void onDefineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(DATA_IS_LEADER, false);
    }

    @Override
    public boolean aussietweaks$isLeaderPhantom() {
        return ((Entity) (Object) this).getEntityData().get(DATA_IS_LEADER);
    }

    @Override
    public void aussietweaks$setLeaderPhantom(boolean isLeader) {
        ((Entity) (Object) this).getEntityData().set(DATA_IS_LEADER, isLeader);
    }

    // Vanilla zombies use 0.05F (5% max at peak regional difficulty).
    // Change this to set your unique max chance (e.g., 0.12F = up to 12%).
    @Unique
    private static final float UNIQUE_MAX_CHANCE = 0.12F;

    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void onFinalizeSpawn(
            ServerLevelAccessor level,
            DifficultyInstance difficulty,
            EntitySpawnReason spawnReason,
            SpawnGroupData spawnData,
            CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        if (spawnReason != EntitySpawnReason.NATURAL && spawnReason != EntitySpawnReason.EVENT) {
            return;
        }

        Phantom phantom = (Phantom) (Object) this;
        RandomSource random = level.getRandom();

        // Exact vanilla zombie leader scaling:
        // getSpecialMultiplier() is 0.0 on Easy, and 0.0 -> 1.0 on Normal/Hard based on regional difficulty.
        float leaderChance = 0.05F + difficulty.getSpecialMultiplier() * 0.10F;

        if (random.nextFloat() < leaderChance) {
            this.aussietweaks$setLeaderPhantom(true);
            phantom.setPhantomSize(1);
            AttributeInstance maxHealth = phantom.getAttribute(Attributes.MAX_HEALTH);
            if (maxHealth != null && !maxHealth.hasModifier(LEADER_HEALTH_ID)) {
                maxHealth.addPermanentModifier(new AttributeModifier(
                        LEADER_HEALTH_ID,
                        random.nextDouble() * 2.0,
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                ));
                phantom.setHealth(phantom.getMaxHealth());
            }
        }
    }

}