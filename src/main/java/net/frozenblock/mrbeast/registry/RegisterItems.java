package net.frozenblock.mrbeast.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class RegisterItems {

	public static final Item MRBEAST_SPAWN_EGG = register("beast_spawn_egg", new SpawnEggItem(RegisterEntities.MRBEAST, 0x000000, 0x000000, new FabricItemSettings()), CreativeModeTabs.SPAWN_EGGS);

	public static void init() {
		// NO-OP
	}

	private static Item register(String path, Item item, CreativeModeTab... tabs) {
		Registry.register(BuiltInRegistries.ITEM, MrBeastSharedConstants.id(path), item);

		FrozenCreativeTabs.add(item, tabs);
		return item;
	}
}
