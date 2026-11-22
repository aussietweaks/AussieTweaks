package com.aussietweaks.mixin;

import com.aussietweaks.access.LeaderPhantomAccess;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.client.renderer.entity.state.PhantomRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.Phantom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomRenderer.class)
public abstract class PhantomRendererMixin {

    @Unique
    private static final Identifier LEADER_TEXTURE =
            Identifier.fromNamespaceAndPath("aussietweaks", "textures/entity/phantom/leader_phantom.png");

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/monster/Phantom;Lnet/minecraft/client/renderer/entity/state/PhantomRenderState;F)V", at = @At("TAIL"))
    private void onExtractRenderState(Phantom phantom, PhantomRenderState state, float partialTick, CallbackInfo ci) {
        if (phantom instanceof LeaderPhantomAccess access && state instanceof LeaderPhantomAccess stateAccess) {
            stateAccess.aussietweaks$setLeaderPhantom(access.aussietweaks$isLeaderPhantom());
        }
    }

    @Inject(method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/PhantomRenderState;)Lnet/minecraft/resources/Identifier;", at = @At("HEAD"), cancellable = true)
    private void onGetTextureLocation(PhantomRenderState state, CallbackInfoReturnable<Identifier> cir) {
        if (state instanceof LeaderPhantomAccess stateAccess && stateAccess.aussietweaks$isLeaderPhantom()) {
            cir.setReturnValue(LEADER_TEXTURE);
        }
    }
}