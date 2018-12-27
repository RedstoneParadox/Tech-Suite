package net.redstoneparadox.techsuite.registry

import net.fabricmc.fabric.api.client.gui.GuiProviderRegistry
import net.fabricmc.fabric.api.container.ContainerProviderRegistry
import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.blockentity.MachineBlockEntity


/**
 * Created by RedstoneParadox on 12/23/2018.
 */
object ContainerRegistry {

    fun initContainers() {

    }

    fun registerContainer(name : String) {
        ContainerProviderRegistry.INSTANCE.registerFactory(Identifier("assembly", "grinder")) { identifier, playerEntity, packetByteBuf ->
            val pos = packetByteBuf.readBlockPos()
            val blockEntity = playerEntity.world.getBlockEntity(pos)
            if (blockEntity is MachineBlockEntity) {
                return@registerFactory (blockEntity as MachineBlockEntity).createContainer(playerEntity)
            }
            null
        }

        GuiProviderRegistry.INSTANCE.registerFactory(Identifier("assembly", "grinder"), null)
    }
}