package com.aussietweaks.mixin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.entity.ExperienceOrbRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ExperienceOrbRenderer.class)
public abstract class ExperienceOrbRendererMixin {

    @ModifyArgs(
            method = "vertex(Lcom/mojang/blaze3d/vertex/VertexConsumer;Lcom/mojang/blaze3d/vertex/PoseStack$Pose;FFIIIFFI)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/vertex/VertexConsumer;setColor(IIII)Lcom/mojang/blaze3d/vertex/VertexConsumer;"
            )
    )
    private static void removeOrbTint(Args args) {
        // Indices 0, 1, 2 are r, g, b (index 3 is alpha)
        args.set(0, 255);
        args.set(1, 255);
        args.set(2, 255);
    }
}