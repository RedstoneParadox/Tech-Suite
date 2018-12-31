package net.redstoneparadox.techsuite.cardboardbox.gui.components

import net.minecraft.client.font.FontRenderer
import net.minecraft.client.gui.Gui

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class LabelComponent(var text : String, name : String, x: Float, y: Float) : AbstractGUIComponent(name, x, y) {

    override fun drawSelf(gui: Gui, float: Float, int1: Int, int2: Int, fontRenderer : FontRenderer) {
        fontRenderer.draw(text, x, y, 0)
    }

}