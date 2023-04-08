package net.frozenblock.mrbeast.registry

import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent

object RegisterSounds {
    @JvmField
    val MRBEAST_AMBIENT = register("entity.mrbeast.ambient")
    @JvmField
    val MRBEAST_DEATH = register("entity.mrbeast.death")
    @JvmField
    val MRBEAST_HURT = register("entity.mrbeast.hurt")
    @JvmField
    val MRBEAST_SPAWN = register("entity.mrbeast.spawn")
    @JvmField
    val MRBEAST_STEP = register("entity.mrbeast.step")

    private fun registerForHolder(string: String): Holder.Reference<SoundEvent> {
        return registerForHolder(MrBeastSharedConstants.id(string))
    }

    fun register(path: String?): SoundEvent {
        val id = MrBeastSharedConstants.id(path)
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id))
    }

    private fun registerForHolder(
        resourceLocation: ResourceLocation,
        resourceLocation2: ResourceLocation = resourceLocation
    ): Holder.Reference<SoundEvent> {
        return Registry.registerForHolder(
            BuiltInRegistries.SOUND_EVENT,
            resourceLocation,
            SoundEvent.createVariableRangeEvent(resourceLocation2)
        )
    }

    fun init() {
        MrBeastSharedConstants.log("Registering MrBeast SoundEvents", MrBeastSharedConstants.UNSTABLE_LOGGING)
    }
}
