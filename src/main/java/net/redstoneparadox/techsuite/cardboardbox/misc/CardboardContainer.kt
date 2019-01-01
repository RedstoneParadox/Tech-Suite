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
    }

    fun inventroyToSlots() {
        var inventory : Inventory = player.world.getBlockEntity(pos) as Inventory

        for (i in 1..(inventory.invSize)) {
            slotList.add((i-1), Slot(inventory, (i-1), (20*i), 20))
        }
    }

    lateinit var gui : Gui

    override fun canUse(player: PlayerEntity): Boolean {
        return true
    }
}