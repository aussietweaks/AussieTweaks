package com.aussietweaks.mixin;

import com.aussietweaks.util.LeaderAccessor;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public abstract class ZombieMixin extends Monster implements LeaderAccessor {
    @Unique
    private static final EntityDataAccessor<Boolean> IS_LEADER = SynchedEntityData.defineId(
            ZombieMixin.class, EntityDataSerializers.BOOLEAN
    );

    protected ZombieMixin(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void registerLeaderData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(IS_LEADER, false);
    }
    // Check attribute after spawn logic runs
    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void checkLeaderStatus(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData spawnData, CallbackInfoReturnable<SpawnGroupData> cir) {
        AttributeInstance attr = this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
        if (attr != null && attr.getBaseValue() >= 0.5) {
            this.entityData.set(IS_LEADER, true);
        }
    }

    @Override
    public boolean aussietweaks$isLeader() {
        return this.entityData.get(IS_LEADER);
    }
}