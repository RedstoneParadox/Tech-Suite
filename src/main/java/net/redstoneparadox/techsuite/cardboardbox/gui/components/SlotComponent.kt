package net.redstoneparadox.techsuite.cardboardbox.gui.components

import net.minecraft.client.gui.Gui
import net.minecraft.container.Slot
import net.redstoneparadox.techsuite.cardboardbox.gui.CardboardContainerGUI
import kotlin.math.roundToInt

/**
 * Created by RedstoneParadox on 12/31/2018.
 */

/**
 * A helper component for drawing inventory slots on the screen.
 *
 * @param index the index of the slot to draw.
 */
class SlotComponent(name: String, x: Float, y: Float, val index : Int) : GuiTreeComponent(name, x, y) {

    override fun setupSelf(gui: Gui) {
        val slot : Slot = (gui as CardboardContainerGUI).container.getSlot(index)

        slot.xPosition = x.roundToInt()
        slot.yPosition = y.roundToInt()
    }

}