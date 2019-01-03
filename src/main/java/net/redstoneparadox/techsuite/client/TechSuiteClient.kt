package net.redstoneparadox.techsuite.client

import net.fabricmc.api.ClientModInitializer
import net.redstoneparadox.techsuite.client.registry.GuiRegistry

/**
 * Created by RedstoneParadox on 12/23/2018.
 */
class TechSuiteClient : ClientModInitializer {

    override fun onInitializeClient() {
        GuiRegistry.initGUIs()
    }
}