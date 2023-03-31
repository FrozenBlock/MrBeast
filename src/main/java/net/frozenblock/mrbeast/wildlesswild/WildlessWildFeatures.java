package net.frozenblock.mrbeast.wildlesswild;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;

public class WildlessWildFeatures {

	public static void init() {
		BiomeModifications.create(MrBeastSharedConstants.id("wildless_wild"))
			.add(ModificationPhase.REMOVALS,
				BiomeSelectors.all(),
				context -> {
					context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.FROG);
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
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEA_PICKLE);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_COLD);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_DEEP);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_DEEP_COLD);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_DEEP_WARM);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_NORMAL);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_RIVER);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_SIMPLE);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_SIMPLE);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_SWAMP);
					context.getGenerationSettings().removeFeature(AquaticPlacements.SEAGRASS_WARM);
					context.getGenerationSettings().removeFeature(AquaticPlacements.WARM_OCEAN_VEGETATION);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.ICE_PATCH);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.ICE_SPIKE);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.ICEBERG_BLUE);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.ICEBERG_PACKED);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.BLUE_ICE);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.DISK_CLAY);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.DISK_GRASS);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.DISK_GRAVEL);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.DISK_SAND);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.FREEZE_TOP_LAYER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_LOWER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_UPPER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_CLAY);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_DIRT);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_GRAVEL);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_TUFF);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_LOWER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_UPPER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_LOWER);
					context.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_LOWER);
					context.getGenerationSettings().removeFeature(CavePlacements.GLOW_LICHEN);
					context.getGenerationSettings().removeFeature(CavePlacements.CAVE_VINES);
					context.getGenerationSettings().removeFeature(CavePlacements.CLASSIC_VINES);
					context.getGenerationSettings().removeFeature(CavePlacements.SCULK_PATCH_ANCIENT_CITY);
					context.getGenerationSettings().removeFeature(CavePlacements.SCULK_PATCH_DEEP_DARK);
					context.getGenerationSettings().removeFeature(CavePlacements.SCULK_VEIN);
					context.getGenerationSettings().removeFeature(CavePlacements.AMETHYST_GEODE);
					context.getGenerationSettings().removeFeature(CavePlacements.ROOTED_AZALEA_TREE);
					context.getGenerationSettings().removeFeature(CavePlacements.LUSH_CAVES_CEILING_VEGETATION);
					context.getGenerationSettings().removeFeature(CavePlacements.LUSH_CAVES_CLAY);
					context.getGenerationSettings().removeFeature(CavePlacements.LUSH_CAVES_VEGETATION);
					context.getGenerationSettings().removeFeature(CavePlacements.DRIPSTONE_CLUSTER);
					context.getGenerationSettings().removeFeature(CavePlacements.LARGE_DRIPSTONE);
					context.getGenerationSettings().removeFeature(CavePlacements.POINTED_DRIPSTONE);
					context.getGenerationSettings().removeFeature(MiscOverworldPlacements.FOREST_ROCK);
					context.getGenerationSettings().removeFeature(VegetationPlacements.MUSHROOM_ISLAND_VEGETATION);
					context.getGenerationSettings().removeFeature(VegetationPlacements.BROWN_MUSHROOM_NETHER);
					context.getGenerationSettings().removeFeature(VegetationPlacements.BROWN_MUSHROOM_NORMAL);
					context.getGenerationSettings().removeFeature(VegetationPlacements.BROWN_MUSHROOM_OLD_GROWTH);
					context.getGenerationSettings().removeFeature(VegetationPlacements.BROWN_MUSHROOM_SWAMP);
					context.getGenerationSettings().removeFeature(VegetationPlacements.RED_MUSHROOM_NETHER);
					context.getGenerationSettings().removeFeature(VegetationPlacements.RED_MUSHROOM_NORMAL);
					context.getGenerationSettings().removeFeature(VegetationPlacements.RED_MUSHROOM_OLD_GROWTH);
					context.getGenerationSettings().removeFeature(VegetationPlacements.RED_MUSHROOM_SWAMP);
					context.getGenerationSettings().removeFeature(VegetationPlacements.RED_MUSHROOM_TAIGA);
					context.getGenerationSettings().removeFeature(VegetationPlacements.TREES_MANGROVE);
				}
			);
	}

}
