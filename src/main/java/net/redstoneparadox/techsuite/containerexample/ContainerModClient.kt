package net.redstoneparadox.techsuite.containerexample

import net.fabricmc.fabric.api.client.gui.GuiProviderRegistry
import net.minecraft.client.gui.ContainerGui
import net.minecraft.container.Container
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.redstoneparadox.techsuite.cardboardbox.gui.CardboardContainerGUI
import net.redstoneparadox.techsuite.cardboardbox.misc.CardboardContainer
import net.redstoneparadox.techsuite.cardboardbox.registry.ComponentTreeRegistry


/**
 * Created by RedstoneParadox on 12/29/2018.
 */
class ContainerModClient {

    lateinit var testContainerGUI : CardboardContainerGUI

    fun onInitializeClient() {
        ComponentTreeRegistry.initTrees()

        GuiProviderRegistry.INSTANCE.registerFactory<Container>(ContainerMod.EXAMPLE_CONTAINER) { CardboardContainerGUI(it as CardboardContainer) }
    }

    //A container gui that shows the block pos that was sent
    class ExampleContainerGui(var pos: BlockPos, playerEntity: PlayerEntity, container: ContainerMod.ExampleContainer) : ContainerGui(ContainerMod.ExampleContainer(pos, playerEntity)) {

        override fun drawBackground(v: Float, i: Int, i1: Int) {
            fontRenderer.draw(pos.toString(), (width / 2).toFloat(), (height / 2).toFloat(), 0)
        }
    }


    //A container gui that shows how you can take in a container provided by a GuiFactory
    class ExampleContainerGui2(container: ContainerMod.ExampleContainer) : ContainerGui(container) {

        var pos: BlockPos = container.pos

        override fun drawBackground(v: Float, i: Int, i1: Int) {
            fontRenderer.draw(pos.toString(), (width / 2).toFloat(), (height / 2).toFloat(), 0)
        }
    }

}
