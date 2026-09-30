package dev.starryacat.bettercombatvanillas;

import dev.starryacat.bettercombatvanillas.mixin.WeaponRegistryAccessor;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public final class VanillaItemExclusions {
    // A future config can replace this one source of item IDs without changing the injection.
    private static final Set<ResourceLocation> EXCLUDED_ITEMS = Set.of(
            ResourceLocation.fromNamespaceAndPath("minecraft", "mace"),
            // Backported Spears uses the same minecraft IDs as vanilla Spears.
            ResourceLocation.fromNamespaceAndPath("minecraft", "wooden_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "stone_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "copper_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "iron_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "golden_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "diamond_spear"),
            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_spear")
    );

    private VanillaItemExclusions() {
    }

    public static void removeFromBetterCombatRegistry() {
        for (ResourceLocation itemId : EXCLUDED_ITEMS) {
            WeaponRegistryAccessor.bettercombatVanillas$getContainers().remove(itemId);
            WeaponRegistryAccessor.bettercombatVanillas$getRegistrations().remove(itemId);
        }
    }
}
