package net.redstoneparadox.techsuite.cardboardbox.gui.nodes

import net.minecraft.client.gui.Gui
import net.minecraft.container.Slot
import net.redstoneparadox.techsuite.cardboardbox.container.InventoryType
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
class SlotNode(name: String, x: Float, y: Float, val type: InventoryType, val index: Int) : GuiNode(name, x, y) {

    override fun setupSelf(gui: Gui) {
        val slot : Slot = when (type) {
            InventoryType.CONTAINER -> (gui as CardboardContainerGUI).container.getSlot(index + 36)
            InventoryType.PLAYER -> (gui as CardboardContainerGUI).container.getSlot(index + 9)
            InventoryType.HOTBAR -> (gui as CardboardContainerGUI).container.getSlot(index)
        }

        slot.xPosition = x.roundToInt()
        slot.yPosition = y.roundToInt()
    }

    override fun createGridCopy(xShift: Float, yShift: Float, iteration: Int) : GuiNode {
        return SlotNode(name +  "_" + iteration.toString(), x + xShift, y + yShift, type, index + iteration)
    }

}