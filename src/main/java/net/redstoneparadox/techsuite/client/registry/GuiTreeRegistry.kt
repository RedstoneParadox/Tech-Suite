package net.redstoneparadox.techsuite.client.registry

import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.container.InventoryType
import net.redstoneparadox.techsuite.cardboardbox.gui.GuiTree
import net.redstoneparadox.techsuite.cardboardbox.gui.GuiTreeBuilder
import net.redstoneparadox.techsuite.cardboardbox.gui.nodes.SlotNode

/**
 * Created by RedstoneParadox on 12/31/2018.
 */
object GuiTreeRegistry {

    lateinit var machineTree : GuiTree

    fun initGuiTrees() {

        machineTree = GuiTreeBuilder(Identifier(TechSuite.MOD_ID, "machine"))
                .addNode(SlotNode("slot_0", 20f, 20f, InventoryType.CONTAINER, 0))
                .addNode(SlotNode("slot_1", 20f, 40f, InventoryType.CONTAINER, 1))
                .addNode(SlotNode("slot_2", 60f, 20f, InventoryType.CONTAINER, 2))
                .addNode(SlotNode("slot_3", 60f, 40f, InventoryType.CONTAINER, 3))
                .addNodeGrid(SlotNode("player_slot", 0f, 60f, InventoryType.PLAYER, 0), 3, 9, 20f, 20f)
                .addNodeGrid(SlotNode("hotbar_slot", 0f, 125f, InventoryType.HOTBAR, 0), 1, 9, 20f, 20f)
                .build()

    }
}