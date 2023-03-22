package net.frozenblock.mrbeast.mixin.wildlesswild;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class NoNewBiomesMixin {

	@Inject(method = "addSurfaceBiome", at = @At("HEAD"), cancellable = true)
	private void MrBeast$HatesTheWildUpdatesBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, float weirdness, ResourceKey<Biome> key, CallbackInfo info) {
		if (
				key.equals(Biomes.MANGROVE_SWAMP) || key.equals(Biomes.DEEP_DARK)
				|| key.equals(Biomes.SNOWY_BEACH) || key.equals(Biomes.SNOWY_SLOPES) || key.equals(Biomes.GROVE) || key.equals(Biomes.STONY_PEAKS) || key.equals(Biomes.STONY_SHORE) || key.equals(Biomes.BEACH) || key.equals(Biomes.JAGGED_PEAKS) || key.equals(Biomes.FROZEN_PEAKS) || new LegacyRandomSource(2).nextBoolean()
		) {
			info.cancel();
		}
	}

}
