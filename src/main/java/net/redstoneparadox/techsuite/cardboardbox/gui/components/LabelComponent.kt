package net.redstoneparadox.techsuite.cardboardbox.gui.components

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
class LabelComponent(name: String, x: Float, y: Float, var text: String) : GuiTreeComponent(name, x, y) {

    override fun drawSelf(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer : FontRenderer) {
        fontRenderer.draw(text, x, y, 0)
    }

}