package net.frozenblock.mrbeast;

import net.fabricmc.api.ModInitializer;
import net.frozenblock.mrbeast.mod_compat.MrBeastModIntegrations;
import net.frozenblock.mrbeast.registry.RegisterEntities;
import net.frozenblock.mrbeast.registry.RegisterItems;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;
import net.frozenblock.mrbeast.wildlesswild.WildlessWildFeatures;

public class MrBeastMod implements ModInitializer {

	@Override
	public void onInitialize() {
		MrBeastSharedConstants.startMeasuring(this);

		MrBeastModIntegrations.init();
		RegisterEntities.init();
		RegisterItems.init();
		WildlessWildFeatures.init();

		MrBeastSharedConstants.stopMeasuring(this);
	}
}
