package com.aussietweaks.mixin;

import java.util.Set;
import net.minecraft.advancements.AdvancementNode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AdvancementNode.class)
public interface AdvancementNodeAccessor {
    @Accessor("children")
    @Mutable
    void aussietweaks$setChildren(Set<AdvancementNode> children);
}