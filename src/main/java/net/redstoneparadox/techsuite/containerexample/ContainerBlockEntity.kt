package net.redstoneparadox.techsuite.containerexample

import net.minecraft.block.entity.BlockEntity
import net.minecraft.client.gui.Gui
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.Tickable
import net.redstoneparadox.techsuite.cardboardbox.gui.CardboardContainerGUI
import net.redstoneparadox.techsuite.cardboardbox.gui.components.LabelComponent
import net.redstoneparadox.techsuite.cardboardbox.misc.GuiController
import net.redstoneparadox.techsuite.cardboardbox.registry.ComponentTreeRegistry

/**
 * Created by RedstoneParadox on 12/29/2018.
 */
class ContainerBlockEntity : BlockEntity(ContainerMod.containerBlockEntity), GuiController, Tickable {

    var gui: CardboardContainerGUI? = null
    var countdown : Int = 20

    var text : String = "Hello, world!"

    override fun tick() {
        if (countdown > 0) {
            countdown -= 1
        }
        else {
            if (text == "Hello, world!") {
                text = "Goodbye, world!"
            }
            else {
                text = "Hello, world!"
            }

            if (world.isClient && gui != null) {
                if (gui!!.componentTree != null) {
                    val label: LabelComponent = gui!!.getChild("hello_world") as LabelComponent

                    label.text = this.text
                }
            }
            countdown = 10
        }
    }

    override fun initController(gui: Gui, player : PlayerEntity) {
        this.gui = (gui as CardboardContainerGUI)
        gui.componentTree = ComponentTreeRegistry.getComponentTree(ContainerMod.EXAMPLE_CONTAINER)!!
        gui.updateGui()
    }
}