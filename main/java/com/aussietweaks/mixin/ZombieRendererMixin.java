package com.aussietweaks.mixin;

import com.aussietweaks.util.LeaderAccessor;
import com.aussietweaks.util.LeaderRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractZombieRenderer.class)
public abstract class ZombieRendererMixin<T extends Zombie, S extends ZombieRenderState, M extends ZombieModel<S>> extends HumanoidMobRenderer<T, S, M> {

    protected ZombieRendererMixin(EntityRendererProvider.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void extractLeaderState(T zombie, S state, float partialTick, CallbackInfo ci) {
        if (zombie instanceof LeaderAccessor accessor && state instanceof LeaderRenderState leaderState) {
            leaderState.aussietweaks$setLeader(accessor.aussietweaks$isLeader());
        }
    }


}