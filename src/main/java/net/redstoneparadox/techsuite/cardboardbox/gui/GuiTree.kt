package net.redstoneparadox.techsuite.cardboardbox.gui

import net.minecraft.client.font.FontRenderer
import net.minecraft.client.gui.Gui
import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.cardboardbox.container.CardboardContainer
import net.redstoneparadox.techsuite.cardboardbox.gui.nodes.GuiNode

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class GuiTree(val identifier: Identifier) {

    var children : ArrayList<GuiNode> = ArrayList()

    fun setup(cardboardContainer: CardboardContainer) {

        if (children.isEmpty()) {
            return
        }

        for (child in children) {
            child.setup(cardboardContainer)
        }
    }

    fun setupClient(gui: Gui) {

        if (children.isEmpty()) {
            return
        }

        for (child in children) {
            child.setupClient(gui)
        }
    }

    fun drawChildren(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {

        if (children.isEmpty()) {
            return
        }

        for (child in children) {
            child.draw(gui, float, int1, int2, fontRenderer)
        }
    }

    fun getChild(name : String) : GuiNode? {

        for (child in children) {
            if (child.name == name) {
                return child
            }
        }

        return null
    }
}