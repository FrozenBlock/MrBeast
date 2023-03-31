package net.frozenblock.mrbeast;

import java.util.ArrayList;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.loader.api.FabricLoader;
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories;
import net.frozenblock.lib.mobcategory.api.entrypoint.FrozenMobCategoryEntrypoint;
import net.frozenblock.lib.mobcategory.impl.FrozenMobCategory;
import net.frozenblock.mrbeast.mod_compat.MrBeastModIntegrations;
import net.frozenblock.mrbeast.registry.RegisterEntities;
import net.frozenblock.mrbeast.registry.RegisterItems;
import net.frozenblock.mrbeast.registry.RegisterSounds;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.frozenblock.mrbeast.wildlesswild.WildlessWildFeatures;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class MrBeastMod extends FrozenMobCategoryEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		MrBeastSharedConstants.startMeasuring(this);

		if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
			throw new IllegalStateException("YOU MUST UNINSTALL WILDER WILD AT ONCE!!!!!!!!!!!! NOW!");
		}
		if (FabricLoader.getInstance().isModLoaded("modmenu")) {
			throw new IllegalStateException("did you really think you could launch the amazing frozenblock mod with mod menu? you fool! NOW REMOVE MOD MENU AEIDP ASJDIO ASJPODJIOPAP");
		}

		MrBeastModIntegrations.init();
		RegisterEntities.init();
		RegisterItems.init();
		RegisterSounds.init();
		WildlessWildFeatures.init();

		BiomeModifications.create(MrBeastSharedConstants.id("beast_spawn"))
				.add(ModificationPhase.ADDITIONS, BiomeSelectors.all(), context -> {
					context.getSpawnSettings().addSpawn(
						FrozenMobCategories.getCategory(MrBeastSharedConstants.REGISTRY_ID, "beast"),
						new MobSpawnSettings.SpawnerData(RegisterEntities.MRBEAST, 1, 1, 1)
					);
				});

		MrBeastSharedConstants.stopMeasuring(this);
	}

	@Override
	public void newCategories(ArrayList<FrozenMobCategory> context) {
		context.add(createCategory(MrBeastSharedConstants.id("beast"), 100, true, true, 100));
	}
}
