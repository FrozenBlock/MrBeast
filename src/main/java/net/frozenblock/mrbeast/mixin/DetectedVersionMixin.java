package net.frozenblock.mrbeast.mixin;

import net.minecraft.DetectedVersion;
import net.minecraft.world.level.storage.DataVersion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DetectedVersion.class)
public class DetectedVersionMixin {

	private static final String NEW_VERSION = "23w13a_or_b_or_c_or_d_or_e_or_f_or_g";

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
	private boolean stable = false;

	@Mutable
	@Shadow
	@Final
	private DataVersion worldVersion = new DataVersion(3444, "frozenblockapril2023");
}
