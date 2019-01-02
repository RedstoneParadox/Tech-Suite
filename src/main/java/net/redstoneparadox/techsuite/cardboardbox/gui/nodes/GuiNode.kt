package net.redstoneparadox.techsuite.cardboardbox.gui.nodes

import net.minecraft.client.font.FontRenderer
import net.minecraft.client.gui.Gui

/**
 * Created by RedstoneParadox on 12/30/2018.
 */

/**
 * The base component for all other GUI tree nodes.
 *
 * @param name the specific name of the component in the tree.
 * @param x The x position on screen.
 * @param y The y position on screen.
 *
 * Unless otherwise noted in child classes, all constructor parameters here have the same uses.
 */
open class GuiNode(var name : String, var x : Float, var y : Float) {

    var children : ArrayList<GuiNode> = ArrayList()

    fun setup(gui : Gui) {
        setupSelf(gui)
        setupChildren(gui)
    }

    open fun setupSelf(gui: Gui) {

    }

    private fun setupChildren(gui : Gui) {

        if (children.isEmpty()) {
            return
        }

        for (child in children) {
            child.setup(gui)
        }
    }

    fun draw(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {
        drawSelf(gui, float, int1, int2, fontRenderer)
        drawChildren(gui, float, int1, int2, fontRenderer)
    }

    open fun drawSelf(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {

    }

    open fun createGridCopy(xShift: Float, yShift: Float, iteration: Int): GuiNode {
        return GuiNode(name + "_" + iteration.toString(), x + xShift, y + yShift)
    }

    private fun drawChildren(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {

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