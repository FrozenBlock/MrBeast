package net.frozenblock.mrbeast.registry;

import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class RegisterSounds {

	public static final SoundEvent MRBEAST_AMBIENT = register("entity.beast.ambient");
	public static final SoundEvent MRBEAST_HURT = register("entity.beast.hurt");
	public static final SoundEvent MRBEAST_SPAWN = register("entity.beast.spawn");
	public static final SoundEvent MRBEAST_STEP = register("entity.beast.step");

	private static Holder.Reference<SoundEvent> registerForHolder(String string) {
		return registerForHolder(MrBeastSharedConstants.id(string));
	}

	private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation resourceLocation) {
		return registerForHolder(resourceLocation, resourceLocation);
	}

	public static SoundEvent register(String path) {
		var id = MrBeastSharedConstants.id(path);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}

	private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, resourceLocation, SoundEvent.createVariableRangeEvent(resourceLocation2));
	}

	public static void init() {
		MrBeastSharedConstants.log("Registering MRBEAST SoundEvents", MrBeastSharedConstants.UNSTABLE_LOGGING);
	}
}
