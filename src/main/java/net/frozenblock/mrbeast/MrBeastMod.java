package net.frozenblock.mrbeast;

import java.util.ArrayList;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MrBeastMod implements ModInitializer, FrozenMobCategoryEntrypoint {

	@Override
	public void onInitialize() {
		MrBeastSharedConstants.startMeasuring(this);

		if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
			throw new IllegalStateException("YOU MUST UNINSTALL WILDER WILD AT ONCE!!!!!!!!!!!! NOW!");
		}
		if (FabricLoader.getInstance().getAllMods().size() > 75) {
			throw new IllegalStateException("GAME TOO MODDED FOR THE AMAZING FROZENBLOCK MOD. PLEASE CONSIDERR REMOVING SOME MODS.");
		}

		MrBeastModIntegrations.init();
		RegisterEntities.init();
		RegisterItems.init();
		RegisterSounds.init();
		WildlessWildFeatures.init();

		BiomeModifications.create(MrBeastSharedConstants.id("beast_spawn"))
				.add(ModificationPhase.ADDITIONS, BiomeSelectors.all(), context ->
					context.getSpawnSettings().addSpawn(
						FrozenMobCategories.getCategory(MrBeastSharedConstants.REGISTRY_ID, "beast"),
						new MobSpawnSettings.SpawnerData(RegisterEntities.MRBEAST, 1, 1, 1)
					)
				);

		BiomeModifications.create(MrBeastSharedConstants.id("beast_music"))
				.add(ModificationPhase.POST_PROCESSING, BiomeSelectors.all(), context ->
					context.getEffects().setMusic(new Music(RegisterSounds.IN_YOUR_ROOM, 200, 400, true))
				);

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin()) {
				LootPool.Builder pool = LootPool.lootPool()
					.add(LootItem.lootTableItem(RegisterItems.MRBEAST_SPAWN_EGG).setWeight(5))
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(0F, 5F)));

				tableBuilder.withPool(pool);
			}
		});

		var spawnEggDeal = new VillagerTrades.ItemsForEmeralds(RegisterItems.MRBEAST_SPAWN_EGG, 1, 1000, 1000);

		for (var profession : BuiltInRegistries.VILLAGER_PROFESSION) {
			TradeOfferHelper.registerVillagerOffers(profession, 1, factories ->
				factories.add(spawnEggDeal));
		}
		TradeOfferHelper.registerWanderingTraderOffers(1, factories ->
			factories.add(spawnEggDeal)
		);

		MrBeastSharedConstants.stopMeasuring(this);
	}

	@Override
	public void newCategories(ArrayList<FrozenMobCategory> context) {
		context.add(FrozenMobCategoryEntrypoint.createCategory(MrBeastSharedConstants.id("beast"), 100, true, true, 100));
	}
}
