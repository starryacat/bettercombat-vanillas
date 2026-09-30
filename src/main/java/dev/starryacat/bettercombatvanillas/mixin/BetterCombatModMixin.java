package dev.starryacat.bettercombatvanillas.mixin;

import dev.starryacat.bettercombatvanillas.VanillaItemExclusions;
import net.bettercombat.BetterCombatMod;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BetterCombatMod.class, remap = false)
public abstract class BetterCombatModMixin {
    @Inject(
            method = "loadWeaponAttributes(Lnet/minecraft/server/MinecraftServer;)V",
            at = @At(value = "INVOKE", target = "Lnet/bettercombat/logic/WeaponRegistry;encodeRegistry()V", remap = false),
            remap = false
    )
    private static void bettercombatVanillas$beforeRegistryEncode(MinecraftServer server, CallbackInfo ci) {
        VanillaItemExclusions.removeFromBetterCombatRegistry();
    }
}
