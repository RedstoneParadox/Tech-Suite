package net.redstoneparadox.techsuite.client.registry

import net.fabricmc.fabric.api.client.gui.GuiProviderRegistry
import net.minecraft.container.Container
import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.gui.CardboardContainerGUI
import net.redstoneparadox.techsuite.cardboardbox.misc.CardboardContainer

/**
 * Created by RedstoneParadox on 12/31/2018.
 */
object GuiRegistry {

    fun initGUIs() {

        GuiProviderRegistry.INSTANCE.registerFactory<Container>(Identifier(TechSuite.MOD_ID, "machine")) { CardboardContainerGUI(it as CardboardContainer) }
    }
}