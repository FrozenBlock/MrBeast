package net.frozenblock.mrbeast

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.biome.v1.ModificationPhase
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories
import net.frozenblock.lib.mobcategory.api.entrypoint.FrozenMobCategoryEntrypoint
import net.frozenblock.lib.mobcategory.impl.FrozenMobCategory
import net.frozenblock.mrbeast.mod_compat.MrBeastModIntegrations
import net.frozenblock.mrbeast.registry.RegisterEntities
import net.frozenblock.mrbeast.registry.RegisterItems
import net.frozenblock.mrbeast.registry.RegisterSounds
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.sounds.Music
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData

class MrBeastMod : FrozenMobCategoryEntrypoint(), ModInitializer {
    override fun onInitialize() {
        MrBeastSharedConstants.startMeasuring(this)

        MrBeastModIntegrations.init()
        RegisterEntities.init()
        RegisterItems.init()
        RegisterSounds.init()
        BiomeModifications.create(MrBeastSharedConstants.id("beast_spawn"))
            .add(
                ModificationPhase.ADDITIONS, BiomeSelectors.all()
            ) { context: BiomeModificationContext ->
                context.spawnSettings.addSpawn(
                    FrozenMobCategories.getCategory(MrBeastSharedConstants.MOD_ID, "mrbeast"),
                    SpawnerData(RegisterEntities.MRBEAST, 1, 1, 1)
                )
            }

        MrBeastSharedConstants.stopMeasuring(this)
    }

    override fun newCategories(context: ArrayList<FrozenMobCategory>) {
        context.add(createCategory(MrBeastSharedConstants.id("mrbeast"), 100, true, true, 100))
    }
}
