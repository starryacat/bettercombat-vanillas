package dev.starryacat.bettercombatvanillas.mixin;

import net.bettercombat.api.AttributesContainer;
import net.bettercombat.api.WeaponAttributes;
import net.bettercombat.logic.WeaponRegistry;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = WeaponRegistry.class, remap = false)
public interface WeaponRegistryAccessor {
    @Accessor(value = "containers", remap = false)
    static Map<ResourceLocation, AttributesContainer> bettercombatVanillas$getContainers() {
        throw new AssertionError("Mixin accessor was not applied");
    }

    @Accessor(value = "registrations", remap = false)
    static Map<ResourceLocation, WeaponAttributes> bettercombatVanillas$getRegistrations() {
        throw new AssertionError("Mixin accessor was not applied");
    }
}
