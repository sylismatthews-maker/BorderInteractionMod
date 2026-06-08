package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Initialization logic if needed
    }

    @Mixin(MultiPlayerGameMode.class)
    public static class MultiPlayerGameModeMixin {
        @Inject(method = "isPlayerOutsideBorder", at = @At("HEAD"), cancellable = true)
        private void forceAllowPacketsOutsideBorder(CallbackInfoReturnable<Boolean> cir) {
            // Force the game client to believe the player is inside the border, preventing packet blocks
            cir.setReturnValue(false);
        }
    }
}
