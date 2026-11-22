package com.aussietweaks.mixin;

import com.aussietweaks.util.LeaderRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> {

    @Inject(method = "scale", at = @At("TAIL"))
    private void scaleLeaderZombie(S state, PoseStack poseStack, CallbackInfo ci) {
        if (state instanceof LeaderRenderState leaderState && leaderState.aussietweaks$isLeader()) {
            float scale = 1.15F; // 15% larger visually
            poseStack.scale(1.15F, 1.15F, 1.15F);
        }
    }
}