package net.redstoneparadox.techsuite.cardboardbox.gui

import net.minecraft.client.gui.ContainerGui
import net.redstoneparadox.techsuite.cardboardbox.gui.components.AbstractGUIComponent
import net.redstoneparadox.techsuite.cardboardbox.gui.components.ComponentTree
import net.redstoneparadox.techsuite.cardboardbox.misc.CardboardContainer
import net.redstoneparadox.techsuite.cardboardbox.misc.GuiController

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class CardboardContainerGUI(cardboardContainer: CardboardContainer) : ContainerGui(cardboardContainer) {

    var float: Float = 0f
    var int1: Int = 0
    var int2: Int = 0

    init {

        var blockEntityController : GuiController = cardboardContainer.player.world.getBlockEntity(cardboardContainer.pos) as GuiController

        blockEntityController.initController(this, cardboardContainer.player)
    }

    var componentTree : ComponentTree? = null

    fun updateGui() {
        drawBackground(float, int1, int2)
    }

    override fun drawBackground(p0: Float, p1: Int, p2: Int) {
        if (componentTree != null && fontRenderer != null) {
            componentTree!!.drawChildren(this, p0, p1, p2, fontRenderer)
        }
    }

    fun getChild(name : String) : AbstractGUIComponent? {
        if (componentTree != null) {
            return componentTree!!.getChild(name)
        }

        else return null
    }
}