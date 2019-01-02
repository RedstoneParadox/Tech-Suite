package net.redstoneparadox.techsuite.cardboardbox.gui.nodes

import net.minecraft.client.font.FontRenderer
import net.minecraft.client.gui.Gui

/**
 * Created by RedstoneParadox on 12/30/2018.
 */

/**
 * A Gui Tree Component that draws a string to the GUI.
 *
 * @param text The text to draw to the GUI.
 */
class LabelNode(name: String, x: Float, y: Float, var text: String) : GuiNode(name, x, y) {

    override fun drawSelf(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer : FontRenderer) {
        fontRenderer.draw(text, x, y, 0)
    }

    override fun createGridCopy(xShift: Float, yShift: Float, iteration: Int) : GuiNode {
        return LabelNode(name + "_" + iteration.toString(), x + xShift, y + yShift, text)
    }
}