package net.frozenblock.mrbeast.entity.render.renderer;

import net.frozenblock.mrbeast.entity.MrBeast;
import net.frozenblock.mrbeast.entity.render.model.MrBeastModel;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class MrBeastRenderer extends HumanoidMobRenderer<MrBeast, MrBeastModel<MrBeast>> {
	public MrBeastRenderer(EntityRendererProvider.Context context, ModelLayerLocation mainLayer, ModelLayerLocation innerArmorLayer, ModelLayerLocation outerArmorLayer) {
		super(context, createModel(context.getModelSet(), mainLayer), 0.5F);
		this.addLayer(
				new HumanoidArmorLayer<>(
						this,
						new HumanoidArmorModel<>(context.bakeLayer(innerArmorLayer)),
						new HumanoidArmorModel<>(context.bakeLayer(outerArmorLayer)),
						context.getModelManager()
				)
		);
	}

	private static MrBeastModel<MrBeast> createModel(EntityModelSet modelLoader, ModelLayerLocation layer) {
		return new MrBeastModel<>(modelLoader.bakeLayer(layer));
	}

	@Override
	public ResourceLocation getTextureLocation(MrBeast entity) {
		return MrBeastSharedConstants.id("textures/entity/beast.png");
	}
}
