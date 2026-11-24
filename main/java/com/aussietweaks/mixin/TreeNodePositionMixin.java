package com.aussietweaks.mixin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import net.minecraft.advancements.AdvancementNode;
import net.minecraft.advancements.TreeNodePosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TreeNodePosition.class)
public class TreeNodePositionMixin {

    private static final List<String> CUSTOM_ORDER = List.of(
            "aussietweaks/cobblestone",
            "aussietweaks/trade",
            "aussietweaks/seed",
            "aussietweaks/sword",
            "aussietweaks/kill_a_mob"
    );

    private static final Comparator<AdvancementNode> NODE_COMPARATOR = Comparator
            .comparingInt((AdvancementNode node) -> {
                int index = CUSTOM_ORDER.indexOf(node.holder().id().getPath());
                return index == -1 ? Integer.MAX_VALUE : index;
            })
            .thenComparing(node -> node.holder().id().getPath());

    @Inject(method = "run", at = @At("HEAD"))
    private static void aussietweaks$sortChildrenDeterministically(AdvancementNode root, CallbackInfo ci) {
        if (!root.holder().id().getNamespace().equals("aussietweaks")) {
            return;
        }
        sortTree(root);
    }

    private static void sortTree(AdvancementNode node) {
        if (node.children().iterator().hasNext()) {
            List<AdvancementNode> sorted = new ArrayList<>();
            node.children().forEach(sorted::add);

            if (sorted.size() > 1) {
                sorted.sort(NODE_COMPARATOR);
                ((AdvancementNodeAccessor) node).aussietweaks$setChildren(new LinkedHashSet<>(sorted));
            }

            for (AdvancementNode child : sorted) {
                sortTree(child);
            }
        }
    }
}