package net.frozenblock.mrbeast

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.frozenblock.mrbeast.entity.render.model.MrBeastModel
import net.frozenblock.mrbeast.entity.render.renderer.MrBeastRenderer
import net.frozenblock.mrbeast.registry.RegisterEntities
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.renderer.entity.EntityRendererProvider

@Environment(EnvType.CLIENT)
class MrBeastModClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRendererRegistry.register(RegisterEntities.MRBEAST) { ctx: EntityRendererProvider.Context? ->
            MrBeastRenderer(
                ctx,
                MRBEAST,
                MRBEAST_INNER,
                MRBEAST_OUTER
            )
        }
        EntityModelLayerRegistry.registerModelLayer(MRBEAST) { MrBeastModel.createBodyLayer() }
        EntityModelLayerRegistry.registerModelLayer(MRBEAST_INNER) { MrBeastModel.createInnerArmorLayer() }
        EntityModelLayerRegistry.registerModelLayer(MRBEAST_OUTER) { MrBeastModel.createOuterArmorLayer() }
    }

    companion object {
        val MRBEAST = ModelLayerLocation(MrBeastSharedConstants.id("mrbeast"), "main")
        val MRBEAST_INNER = ModelLayerLocation(MrBeastSharedConstants.id("mrbeast_inner"), "main")
        val MRBEAST_OUTER = ModelLayerLocation(MrBeastSharedConstants.id("mrbeast_outer"), "main")
    }
}
