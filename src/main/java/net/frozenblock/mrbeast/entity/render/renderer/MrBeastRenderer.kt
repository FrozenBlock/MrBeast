package net.frozenblock.mrbeast.entity.render.renderer

import net.frozenblock.mrbeast.entity.MrBeast
import net.frozenblock.mrbeast.entity.render.model.MrBeastModel
import net.frozenblock.mrbeast.util.MrBeastSharedConstants.id
import net.minecraft.client.model.geom.EntityModelSet
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.HumanoidMobRenderer
import net.minecraft.resources.Identifier

class MrBeastRenderer(
    context: EntityRendererProvider.Context,
    mainLayer: ModelLayerLocation,
    innerArmorLayer: ModelLayerLocation,
    outerArmorLayer: ModelLayerLocation
) : HumanoidMobRenderer<MrBeast, MrBeastRenderState, MrBeastModel>(context, createModel(context.modelSet, mainLayer), 0.5f) {
    init {
        // TODO 26.1
        /*addLayer(
            HumanoidArmorLayer<>(
                this,
                ArmorModelSet.bake(innerArmorLayer, context.modelSet, ::MrBeastModel)
                HumanoidArmorModel(context.bakeLayer(innerArmorLayer)),
                HumanoidArmorModel(context.bakeLayer(outerArmorLayer)),
                context.modelManager
            )
        )*/
    }

    override fun getTextureLocation(state: MrBeastRenderState): Identifier {
        return id("textures/entity/mrbeast.png")
    }

    override fun createRenderState(): MrBeastRenderState {
        return MrBeastRenderState()
    }

    companion object {
        private fun createModel(modelLoader: EntityModelSet, layer: ModelLayerLocation): MrBeastModel {
            return MrBeastModel(modelLoader.bakeLayer(layer))
        }
    }
}
