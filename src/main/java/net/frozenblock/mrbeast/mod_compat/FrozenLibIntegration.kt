package net.frozenblock.mrbeast.mod_compat

import net.frozenblock.lib.FrozenSharedConstants
import net.frozenblock.lib.integration.api.ModIntegration
import net.frozenblock.mrbeast.util.MrBeastSharedConstants

class FrozenLibIntegration : ModIntegration(FrozenSharedConstants.MOD_ID) {
    override fun init() {
        MrBeastSharedConstants.log("FrozenLib integration ran!", MrBeastSharedConstants.UNSTABLE_LOGGING)
    }
}
