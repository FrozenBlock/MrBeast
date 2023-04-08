package net.frozenblock.mrbeast.registry

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.frozenblock.lib.item.api.FrozenCreativeTabs
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.item.SpawnEggItem

object RegisterItems {
    val MRBEAST_SPAWN_EGG = register(
        "beast_spawn_egg",
        SpawnEggItem(RegisterEntities.MRBEAST, 0xB07C34, 0x5894AC, FabricItemSettings()),
        CreativeModeTabs.SPAWN_EGGS
    )

    fun init() {
        // NO-OP
    }

    private fun register(path: String, item: Item, vararg tabs: CreativeModeTab): Item {
        Registry.register(BuiltInRegistries.ITEM, MrBeastSharedConstants.id(path), item)
        FrozenCreativeTabs.add(item, *tabs)
        return item
    }
}
