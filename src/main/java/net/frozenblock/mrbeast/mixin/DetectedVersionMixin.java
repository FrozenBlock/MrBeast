package net.frozenblock.mrbeast.mixin;

import net.minecraft.DetectedVersion;
import net.minecraft.world.level.storage.DataVersion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DetectedVersion.class)
public class DetectedVersionMixin {

	private static final String NEW_VERSION = "1.19.4.1.2.3.4.5.6.7";

	@Mutable
	@Shadow
	@Final
	private String id = NEW_VERSION;

	@Mutable
	@Shadow
	@Final
	private String name = NEW_VERSION;

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
