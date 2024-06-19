package net.frozenblock.mrbeast.registry

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories
import net.frozenblock.mrbeast.entity.MrBeast
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityDimensions
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.SpawnPlacementTypes
import net.minecraft.world.entity.SpawnPlacements
import net.minecraft.world.level.Level
import net.minecraft.world.level.levelgen.Heightmap

object RegisterEntities {
    @JvmField
    val MRBEAST = register<MrBeast, EntityType<MrBeast>>(
        "mrbeast",
        FabricEntityTypeBuilder.createMob<MrBeast>()
            .spawnGroup(FrozenMobCategories.getCategory(MrBeastSharedConstants.MOD_ID, "mrbeast"))
            .entityFactory { entityType: EntityType<MrBeast>, level: Level ->
                MrBeast(
                    entityType,
                    level
                )
            }
            .defaultAttributes { MrBeast.addAttributes() }
            .dimensions(EntityDimensions.scalable(0.6f, 1.8f))
            .build()
    )

    fun init() {
        SpawnPlacements.register(
            MRBEAST,
            SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            MrBeast::checkSpawnRules
        )
    }

    private fun <E : Entity?, T : EntityType<E>?> register(path: String, entityType: T & Any): T {
        return Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            MrBeastSharedConstants.id(path),
            entityType
        )
    }
}
