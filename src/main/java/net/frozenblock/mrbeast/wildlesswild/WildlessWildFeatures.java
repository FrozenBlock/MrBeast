package net.frozenblock.mrbeast.wildlesswild;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.data.worldgen.placement.VegetationPlacements;

public class WildlessWildFeatures {

	public static void init() {
		BiomeModifications.create(MrBeastSharedConstants.id("wildless_wild"))
				.add(ModificationPhase.REMOVALS,
						BiomeSelectors.all(),
						(context) -> {
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_DEFAULT);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_FLOWER_FOREST);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_FOREST_FLOWERS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_MEADOW);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_CHERRY);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_PLAINS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_SWAMP);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FLOWER_WARM);
							context.getGenerationSettings().removeFeature(VegetationPlacements.FOREST_FLOWERS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_SUNFLOWER);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_BADLANDS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_FOREST);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_JUNGLE);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_NORMAL);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_PLAIN);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_SAVANNA);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_TAIGA);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_GRASS_TAIGA_2);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_TALL_GRASS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_TALL_GRASS_2);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_LARGE_FERN);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_SUGAR_CANE);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_SUGAR_CANE_BADLANDS);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_SUGAR_CANE_DESERT);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_BERRY_COMMON);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_BERRY_RARE);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_PUMPKIN);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_MELON);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_MELON_SPARSE);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_WATERLILY);
							context.getGenerationSettings().removeFeature(VegetationPlacements.VINES);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_CACTUS_DECORATED);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_CACTUS_DESERT);
							context.getGenerationSettings().removeFeature(VegetationPlacements.BAMBOO_VEGETATION);
							context.getGenerationSettings().removeFeature(VegetationPlacements.BAMBOO_LIGHT);
							context.getGenerationSettings().removeFeature(VegetationPlacements.BAMBOO);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_DEAD_BUSH);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_DEAD_BUSH_2);
							context.getGenerationSettings().removeFeature(VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS);
						}
				);
	}

}
