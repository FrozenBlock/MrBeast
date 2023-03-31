package net.frozenblock.mrbeast.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {

	@Inject(method = "getProtocolVersion", at = @At("HEAD"), cancellable = true)
	private static void changeProtocolVersion(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(1073741901);
	}
}
