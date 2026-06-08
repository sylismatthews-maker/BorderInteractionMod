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
        // Core initialization
    }

    @Mixin(MultiPlayerGameMode.class)
    public static class BorderMixin {
        @Inject(method = "isPlayerOutsideBorder", at = @At("HEAD"), cancellable = true)
        private void forceAllowPackets(CallbackInfoReturnable<Boolean> cir) {
            cir.setReturnValue(false);
        }
    }
}
