package net.redstoneparadox.techsuite.cardboardbox.gui.components

import net.minecraft.client.font.FontRenderer
import net.minecraft.client.gui.Gui

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
abstract class AbstractGUIComponent(var name : String, var x : Float, var y : Float) {

    var children : ArrayList<AbstractGUIComponent> = ArrayList()

    fun draw(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {
        drawSelf(gui, float, int1, int2, fontRenderer)
        drawChildren(gui, float, int1, int2, fontRenderer)
    }

    abstract fun drawSelf(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer)

    private fun drawChildren(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer: FontRenderer) {

        if (children.isEmpty()) {
            return
        }

        for (child in children) {
            child.draw(gui, float, int1, int2, fontRenderer)
        }
    }

    fun getChild(name : String) : AbstractGUIComponent? {

        for (child in children) {
            if (child.name == name) {
                return child
            }
        }

        return null
    }
}