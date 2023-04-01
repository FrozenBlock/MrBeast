package net.frozenblock.mrbeast.mixin;

import net.minecraft.DetectedVersion;
import net.minecraft.world.level.storage.DataVersion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DetectedVersion.class)
public class DetectedVersionMixin {

	@Mutable
	@Shadow
	@Final
	private String id = "1.19.0.1.2.3.4.5.6.7";

	@Mutable
	@Shadow
	@Final
	private String name = "1.19.0.1.2.3.4.5.6.7";

	@Mutable
	@Shadow
	@Final
	private int protocolVersion = 1073741901;

	@Mutable
	@Shadow
	@Final
	private boolean stable = false;

	@Mutable
	@Shadow
	@Final
	private DataVersion worldVersion = new DataVersion(3076, "frozenblockapril2023");
}
