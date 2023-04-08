package net.frozenblock.mrbeast.entity.render.model

import net.frozenblock.mrbeast.entity.MrBeast
import net.minecraft.client.model.HumanoidModel
import net.minecraft.client.model.geom.LayerDefinitions
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.model.geom.builders.CubeDeformation
import net.minecraft.client.model.geom.builders.LayerDefinition

class MrBeastModel<T : MrBeast?>(root: ModelPart?) : HumanoidModel<T>(root!!) {
    companion object {
        fun createBodyLayer(): LayerDefinition {
            return LayerDefinition.create(createMesh(CubeDeformation.NONE, 0.0f), 64, 64)
        }

        fun createInnerArmorLayer(): LayerDefinition {
            return LayerDefinition.create(createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0f), 64, 32)
        }

        fun createOuterArmorLayer(): LayerDefinition {
            return LayerDefinition.create(createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0f), 64, 32)
        }
    }
}
