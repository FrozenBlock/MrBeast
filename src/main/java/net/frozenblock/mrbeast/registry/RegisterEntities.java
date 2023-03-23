package net.frozenblock.mrbeast.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.frozenblock.mrbeast.entity.MrBeast;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;

public final class RegisterEntities {

	public static final EntityType<MrBeast> MRBEAST = register(
			"beast",
			FabricEntityTypeBuilder.<MrBeast>createMob()
					.entityFactory(MrBeast::new)
					.defaultAttributes(MrBeast::addAttributes)
					.dimensions(EntityDimensions.scalable(0.6F, 1.8F))
					.build()
	);

	public static void init() {
	}

	private static <E extends Entity, T extends EntityType<E>> T register(String path, T entityType) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, MrBeastSharedConstants.id(path), entityType);
	}
}
