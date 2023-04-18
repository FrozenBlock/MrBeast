package net.frozenblock.mrbeast.util

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.block.Block
import org.slf4j.LoggerFactory

object MrBeastSharedConstants {

    const val MOD_ID = "mrbeast"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)
    var DEV_LOGGING = false

    /**
     * Used for features that may be unstable and crash in public builds.
     *
     *
     * It's smart to use this for at least registries.
     */
    var UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment
    val MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow()
    var areConfigsInit = false

    /**
     * Used for datafixers.
     *
     *
     * Is not necessary for a normal mod, but can be useful in some cases.
     */
    const val DATA_VERSION = 0

    // LOGGING
    fun log(string: String?, shouldLog: Boolean) {
        if (shouldLog) {
            LOGGER.info(string)
        }
    }

    fun log(entity: Entity, string: String, shouldLog: Boolean) {
        if (shouldLog) {
            LOGGER.info(entity.toString() + " : " + string + " : " + entity.position())
        }
    }

    fun log(block: Block, string: String, shouldLog: Boolean) {
        if (shouldLog) {
            LOGGER.info("$block : $string : ")
        }
    }

    fun log(block: Block, pos: BlockPos, string: String, shouldLog: Boolean) {
        if (shouldLog) {
            LOGGER.info("$block : $string : $pos")
        }
    }

    fun logMod(string: String, shouldLog: Boolean) {
        if (shouldLog) {
            LOGGER.info(string + " " + MOD_ID)
        }
    }

    // MEASURING
    val INSTANT_MAP: MutableMap<Any, Long> = HashMap()
    fun startMeasuring(`object`: Any) {
        val started = System.nanoTime()
        val name = `object`.javaClass.name
        LOGGER.info("Started measuring {}", name.substring(name.lastIndexOf(".") + 1))
        INSTANT_MAP[`object`] = started
    }

    fun stopMeasuring(`object`: Any) {
        if (INSTANT_MAP.containsKey(`object`)) {
            val name = `object`.javaClass.name
            LOGGER.info(
                "{} took {} nanoseconds",
                name.substring(name.lastIndexOf(".") + 1),
                System.nanoTime() - INSTANT_MAP[`object`]!!
            )
            INSTANT_MAP.remove(`object`)
        }
    }

    fun id(path: String): ResourceLocation {
        return ResourceLocation(MOD_ID, path)
    }

    fun vanillaId(path: String): ResourceLocation {
        return ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, path)
    }

    fun string(path: String): String {
        return id(path).toString()
    }
}
