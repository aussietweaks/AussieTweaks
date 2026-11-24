package com.aussietweaks.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementTree;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.server.ServerAdvancementManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ServerAdvancementManager.class)
public class ServerAdvancementManagerMixin {

    @Shadow
    @Final
    @Mutable
    private Map<Identifier, AdvancementHolder> advancements;

    @Shadow
    @Final
    @Mutable
    private AdvancementTree tree;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void filterVanillaAdvancements(HolderLookup.Provider registries, CallbackInfo ci) {
        ImmutableMap.Builder<Identifier, AdvancementHolder> filtered = ImmutableMap.builder();

        this.advancements.forEach((id, holder) -> {
            // Keep non-vanilla advancements and vanilla recipe unlocks
            if (!id.getNamespace().equals("minecraft") || id.getPath().startsWith("recipes/")) {
                filtered.put(id, holder);
            }
        });

        this.advancements = filtered.buildOrThrow();

        AdvancementTree newTree = new AdvancementTree();
        newTree.addAll(this.advancements.values());
        newTree.repositionNodes();
        this.tree = newTree;
    }
}