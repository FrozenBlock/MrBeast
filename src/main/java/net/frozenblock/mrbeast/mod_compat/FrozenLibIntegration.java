package net.frozenblock.mrbeast.mod_compat;

import net.frozenblock.lib.integration.api.ModIntegration;
import net.frozenblock.mrbeast.util.MrBeastSharedConstants;

public class FrozenLibIntegration extends ModIntegration {
	public FrozenLibIntegration() {
		super("frozenlib");
	}

	@Override
	public void init() {
		MrBeastSharedConstants.log("FrozenLib integration ran!", MrBeastSharedConstants.UNSTABLE_LOGGING);
	}
}
