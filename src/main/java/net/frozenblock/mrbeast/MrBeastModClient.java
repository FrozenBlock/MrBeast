package net.frozenblock.mrbeast;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.frozenblock.mrbeast.entity.render.model.MrBeastModel;
import net.frozenblock.mrbeast.entity.render.renderer.MrBeastRenderer;
import net.frozenblock.mrbeast.registry.RegisterEntities;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.minecraft.client.model.geom.ModelLayerLocation;

@Environment(EnvType.CLIENT)
public class MrBeastModClient implements ClientModInitializer {

	public static final ModelLayerLocation MRBEAST = new ModelLayerLocation(MrBeastSharedConstants.id("beast"), "main");
	public static final ModelLayerLocation MRBEAST_INNER = new ModelLayerLocation(MrBeastSharedConstants.id("beast_inner"), "main");
	public static final ModelLayerLocation MRBEAST_OUTER = new ModelLayerLocation(MrBeastSharedConstants.id("beast_outer"), "main");

    @Override
    public void onInitializeClient() {
		EntityRendererRegistry.register(RegisterEntities.MRBEAST, ctx -> new MrBeastRenderer(ctx, MRBEAST, MRBEAST_INNER, MRBEAST_OUTER));
		EntityModelLayerRegistry.registerModelLayer(MRBEAST, MrBeastModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(MRBEAST_INNER, MrBeastModel::createInnerArmorLayer);
		EntityModelLayerRegistry.registerModelLayer(MRBEAST_OUTER, MrBeastModel::createOuterArmorLayer);
    }
}
