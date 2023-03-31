package net.frozenblock.mrbeast.mixin;

import net.minecraft.network.protocol.status.ServerStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerStatus.Version.class)
public class VersionMixin {

	@Inject(method = "name", at = @At("HEAD"), cancellable = true)
	private void name(CallbackInfoReturnable<String> cir) {

	}
}
