package net.redstoneparadox.techsuite.cardboardbox.misc

import net.minecraft.client.gui.Gui
import net.minecraft.container.Container
import net.minecraft.container.Slot
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.util.math.BlockPos

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class CardboardContainer(var pos: BlockPos, val player : PlayerEntity) : Container() {

    init {
        println("Opened container, $pos")

        inventoryToSlots()
    }

    fun inventoryToSlots() {
        var inventory : Inventory = player.world.getBlockEntity(pos) as Inventory

        for (i in 0..(inventory.invSize - 1)) {
            addSlot(Slot(inventory, i, (20*i), 20))
        }

        for (i in 9..17) {
            addSlot(Slot(player.inventory, i, (20 * i),60))
        }

        for (i in 18..26) {
            addSlot(Slot(player.inventory, i, (20 * i), 80))
        }

        for (i in 27..35) {
            addSlot(Slot(player.inventory, i, (20 * i), 100))
        }

        for (i in 0..8) {
            addSlot(Slot(player.inventory, i, (20 * i), 120))
        }
    }

    lateinit var gui : Gui

    override fun canUse(player: PlayerEntity): Boolean {
        return true
    }
}