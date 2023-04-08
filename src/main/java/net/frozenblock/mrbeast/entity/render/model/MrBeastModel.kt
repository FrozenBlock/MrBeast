package net.frozenblock.mrbeast.entity.render.model;

import net.frozenblock.mrbeast.entity.MrBeast;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class MrBeastModel<T extends MrBeast> extends HumanoidModel<T> {
	public MrBeastModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		return LayerDefinition.create(createMesh(CubeDeformation.NONE, 0.0F), 64, 64);
	}

	public static LayerDefinition createInnerArmorLayer() {
		return LayerDefinition.create(createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}

	public static LayerDefinition createOuterArmorLayer() {
		return LayerDefinition.create(createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32);
	}
}
