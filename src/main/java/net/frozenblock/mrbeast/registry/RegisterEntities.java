package net.frozenblock.mrbeast.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories;
import net.frozenblock.mrbeast.entity.MrBeast;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public final class RegisterEntities {

	public static final EntityType<MrBeast> MRBEAST = register(
			"beast",
			FabricEntityTypeBuilder.<MrBeast>createMob()
				.spawnGroup(FrozenMobCategories.getCategory(MrBeastSharedConstants.REGISTRY_ID, "beast"))
				.entityFactory(MrBeast::new)
				.defaultAttributes(MrBeast::addAttributes)
				.dimensions(EntityDimensions.scalable(0.6F, 1.8F))
				.build()
	);

	public static void init() {
		SpawnPlacements.register(MRBEAST, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
			((entityType, serverLevelAccessor, mobSpawnType, blockPos, randomSource) -> true)
		);
	}

	private static <E extends Entity, T extends EntityType<E>> T register(String path, T entityType) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, MrBeastSharedConstants.id(path), entityType);
	}
}
