package net.frozenblock.mrbeast.entity.render.renderer

import net.frozenblock.mrbeast.entity.MrBeast
import net.frozenblock.mrbeast.entity.render.model.MrBeastModel
import net.frozenblock.mrbeast.util.MrBeastSharedConstants.id
import net.minecraft.client.model.HumanoidArmorModel
import net.minecraft.client.model.geom.EntityModelSet
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.HumanoidMobRenderer
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
import net.minecraft.resources.ResourceLocation

class MrBeastRenderer(
    context: EntityRendererProvider.Context,
    mainLayer: ModelLayerLocation,
    innerArmorLayer: ModelLayerLocation,
    outerArmorLayer: ModelLayerLocation
) : HumanoidMobRenderer<MrBeast, MrBeastModel<MrBeast?>?>(context, createModel(context.modelSet, mainLayer), 0.5f) {
    init {
        addLayer(
            HumanoidArmorLayer<MrBeast?, MrBeastModel<MrBeast?>?, HumanoidArmorModel<MrBeast?>>(
                this,
                HumanoidArmorModel(context.bakeLayer(innerArmorLayer)),
                HumanoidArmorModel(context.bakeLayer(outerArmorLayer)),
                context.modelManager
            )
        )
    }

    override fun getTextureLocation(entity: MrBeast): ResourceLocation {
        return id("textures/entity/beast.png")
    }

    companion object {
        private fun createModel(modelLoader: EntityModelSet, layer: ModelLayerLocation): MrBeastModel<MrBeast?> {
            return MrBeastModel(modelLoader.bakeLayer(layer))
        }
    }
}
