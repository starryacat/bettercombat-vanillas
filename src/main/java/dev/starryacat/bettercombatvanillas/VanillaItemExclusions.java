package dev.starryacat.bettercombatvanillas;

import dev.starryacat.bettercombatvanillas.mixin.WeaponRegistryAccessor;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public final class VanillaItemExclusions {
    // A future config can replace this one source of item IDs without changing the injection.
    private static final Set<ResourceLocation> EXCLUDED_ITEMS = Set.of(
            ResourceLocation.fromNamespaceAndPath("minecraft", "mace")
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
