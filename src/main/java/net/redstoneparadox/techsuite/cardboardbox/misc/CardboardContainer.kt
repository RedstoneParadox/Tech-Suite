package net.redstoneparadox.techsuite.cardboardbox.misc

import net.minecraft.client.gui.Gui
import net.minecraft.container.Container
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
class CardboardContainer(var pos: BlockPos, val player : PlayerEntity) : Container() {

    init {
        println("Opened container, $pos")
    }

    lateinit var gui : Gui

    override fun canUse(player: PlayerEntity): Boolean {
        return true
    }
}