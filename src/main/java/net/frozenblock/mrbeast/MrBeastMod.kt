package net.frozenblock.mrbeast

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.biome.v1.ModificationPhase
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.fabricmc.loader.api.FabricLoader
import net.frozenblock.lib.mobcategory.api.FrozenMobCategories
import net.frozenblock.lib.mobcategory.api.entrypoint.FrozenMobCategoryEntrypoint
import net.frozenblock.lib.mobcategory.impl.FrozenMobCategory
import net.frozenblock.mrbeast.mod_compat.MrBeastModIntegrations
import net.frozenblock.mrbeast.registry.RegisterEntities
import net.frozenblock.mrbeast.registry.RegisterItems
import net.frozenblock.mrbeast.registry.RegisterSounds
import net.frozenblock.mrbeast.util.CoolObject
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.resources.ResourceManager
import net.minecraft.sounds.Music
import net.minecraft.world.entity.npc.VillagerTrades
import net.minecraft.world.entity.npc.VillagerTrades.ItemsForEmeralds
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.LootTables
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator

class MrBeastMod : FrozenMobCategoryEntrypoint(), ModInitializer {
    override fun onInitialize() {
        CoolObject
        MrBeastSharedConstants.startMeasuring(this)
        check(
            !FabricLoader.getInstance().isModLoaded("wilderwild")
        ) { "YOU MUST UNINSTALL WILDER WILD AT ONCE!!!!!!!!!!!! NOW!" }
        check(FabricLoader.getInstance().allMods.size <= 75) { "GAME TOO MODDED FOR THE AMAZING FROZENBLOCK MOD. PLEASE CONSIDERR REMOVING SOME MODS." }
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
        BiomeModifications.create(MrBeastSharedConstants.id("mrbeast_music"))
            .add(
                ModificationPhase.POST_PROCESSING, BiomeSelectors.all()
            ) { context: BiomeModificationContext ->
                context.effects.setMusic(
                    Music(
                        RegisterSounds.IN_YOUR_ROOM,
                        200,
                        400,
                        true
                    )
                )
            }
        LootTableEvents.MODIFY.register(Modify { resourceManager: ResourceManager?, lootManager: LootTables?, id: ResourceLocation?, tableBuilder: LootTable.Builder, source: LootTableSource ->
            if (source.isBuiltin) {
                val pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(RegisterItems.MRBEAST_SPAWN_EGG).setWeight(5))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0f, 5f)))
                tableBuilder.withPool(pool)
            }
        })
        val spawnEggDeal = ItemsForEmeralds(RegisterItems.MRBEAST_SPAWN_EGG, 1, 1000, 1000)
        for (profession in BuiltInRegistries.VILLAGER_PROFESSION) {
            TradeOfferHelper.registerVillagerOffers(
                profession,
                1
            ) { factories: MutableList<VillagerTrades.ItemListing?> -> factories.add(spawnEggDeal) }
        }
        TradeOfferHelper.registerWanderingTraderOffers(
            1
        ) { factories: MutableList<VillagerTrades.ItemListing?> -> factories.add(spawnEggDeal) }
        MrBeastSharedConstants.stopMeasuring(this)
    }

    override fun newCategories(context: ArrayList<FrozenMobCategory>) {
        context.add(createCategory(MrBeastSharedConstants.id("mrbeast"), 100, true, true, 100))
    }
}
