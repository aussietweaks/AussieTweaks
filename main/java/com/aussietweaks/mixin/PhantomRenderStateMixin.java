package com.aussietweaks.mixin;

import com.aussietweaks.access.LeaderPhantomAccess;
import net.minecraft.client.renderer.entity.state.PhantomRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PhantomRenderState.class)
public abstract class PhantomRenderStateMixin implements LeaderPhantomAccess {

    @Unique
    private boolean aussietweaks$isLeader = false;

    @Override
    public boolean aussietweaks$isLeaderPhantom() {
        return this.aussietweaks$isLeader;
    }

    @Override
    public void aussietweaks$setLeaderPhantom(boolean isLeader) {
        this.aussietweaks$isLeader = isLeader;
    }
}
