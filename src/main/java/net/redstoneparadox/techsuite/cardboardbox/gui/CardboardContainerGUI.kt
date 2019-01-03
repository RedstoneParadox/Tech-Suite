package net.redstoneparadox.techsuite.cardboardbox.gui

import net.minecraft.client.gui.ContainerGui
import net.redstoneparadox.techsuite.cardboardbox.container.CardboardContainer
import net.redstoneparadox.techsuite.cardboardbox.gui.nodes.GuiNode
import net.redstoneparadox.techsuite.cardboardbox.hooks.IGui

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class CardboardContainerGUI(cardboardContainer: CardboardContainer) : ContainerGui(cardboardContainer), IGui {

    var float: Float = 0f
    var int1: Int = 0
    var int2: Int = 0
    private var guiTree : GuiTree = cardboardContainer.guiTree

    override fun setup() {
        guiTree.setupClient(this)
    }

    override fun drawBackground(p0: Float, p1: Int, p2: Int) {

        this.float = p0
        this.int1 = p1
        this.int2 = p2

        guiTree.drawChildren(this, p0, p1, p2, fontRenderer)

    }

    fun getChild(name : String) : GuiNode? {
        return guiTree.getChild(name)
    }
}