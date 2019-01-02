package net.redstoneparadox.techsuite.client.registry

import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.gui.GuiTree
import net.redstoneparadox.techsuite.cardboardbox.gui.components.SlotComponent
import net.redstoneparadox.techsuite.cardboardbox.registry.CardboardGuiTreeRegistry

/**
 * Created by RedstoneParadox on 12/31/2018.
 */
object GuiTreeRegistry {

    var machineTree : GuiTree = GuiTree(Identifier(TechSuite.MOD_ID, "machine"))

    fun initGuiTrees() {
        machineTree.children.add(SlotComponent("slot_0", 20f, 80f, 0))
        machineTree.children.add(SlotComponent("slot_1", 20f, 100f, 1))
        machineTree.children.add(SlotComponent("slot_2", 60f, 80f, 2))
        machineTree.children.add(SlotComponent("slot_3", 60f, 100f, 3))
        CardboardGuiTreeRegistry.registerTree(machineTree)
    }
}