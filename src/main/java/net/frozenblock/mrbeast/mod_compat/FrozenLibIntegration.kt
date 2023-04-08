package net.frozenblock.mrbeast.mod_compat

import net.frozenblock.lib.FrozenMain
import net.frozenblock.lib.integration.api.ModIntegration
import net.frozenblock.mrbeast.util.MrBeastSharedConstants

class FrozenLibIntegration : ModIntegration(FrozenMain.MOD_ID) {
    override fun init() {
        MrBeastSharedConstants.log("FrozenLib integration ran!", MrBeastSharedConstants.UNSTABLE_LOGGING)
    }
}
