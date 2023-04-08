package net.frozenblock.mrbeast.mod_compat

import net.frozenblock.lib.integration.api.ModIntegration
import net.frozenblock.lib.integration.api.ModIntegrationSupplier
import net.frozenblock.lib.integration.api.ModIntegrations
import net.frozenblock.mrbeast.util.MrBeastSharedConstants
import java.util.function.Supplier

class MrBeastModIntegrations private constructor() {
    init {
        throw UnsupportedOperationException("MrBeastModIntegrations contains only static declarations.")
    }

    companion object {
        val FROZENLIB_INTEGRATION = registerAndGet(
            { FrozenLibIntegration() }, "frozenlib"
        )

        fun init() {}
        fun register(
            integration: Supplier<out ModIntegration?>?,
            modID: String?
        ): ModIntegrationSupplier<out ModIntegration> {
            return ModIntegrations.register(integration, MrBeastSharedConstants.MOD_ID, modID)
        }

        fun <T : ModIntegration?> register(
            integration: Supplier<T>?,
            unloadedIntegration: Supplier<T>?,
            modID: String?
        ): ModIntegrationSupplier<T> {
            return ModIntegrations.register(integration, unloadedIntegration, MrBeastSharedConstants.MOD_ID, modID)
        }

        fun <T : ModIntegration?> registerAndGet(integration: Supplier<T>?, modID: String?): ModIntegration {
            return ModIntegrations.register(integration, MrBeastSharedConstants.MOD_ID, modID).integration
        }
    }
}
