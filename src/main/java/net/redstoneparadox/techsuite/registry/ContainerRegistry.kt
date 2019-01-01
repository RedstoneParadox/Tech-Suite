package net.redstoneparadox.techsuite.registry

import net.fabricmc.fabric.api.container.ContainerProviderRegistry
import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.misc.CardboardContainer


/**
 * Created by RedstoneParadox on 12/23/2018.
 */
object ContainerRegistry {

    fun initContainers() {

        ContainerProviderRegistry.INSTANCE.registerFactory(Identifier(TechSuite.MOD_ID, "machine")) { identifier, player, buf ->
            val pos = buf.readBlockPos()
            CardboardContainer(pos, player)
        }

    }

}