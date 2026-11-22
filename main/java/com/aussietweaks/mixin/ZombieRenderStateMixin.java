package com.aussietweaks.mixin;

import com.aussietweaks.util.LeaderRenderState;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ZombieRenderState.class)
public class ZombieRenderStateMixin implements LeaderRenderState {
    @Unique
    private boolean isLeader = false;

    @Override
    public boolean aussietweaks$isLeader() {
        return this.isLeader;
    }

    @Override
    public void aussietweaks$setLeader(boolean leader) {
        this.isLeader = leader;
    }
}