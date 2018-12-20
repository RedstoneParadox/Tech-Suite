package net.redstoneparadox.techsuite.blocks

import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.entity.BlockEntity
import net.minecraft.world.BlockView
import net.redstoneparadox.techsuite.blockentities.MachineBlockEntity
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/18/2018.
 */
class MachineBlock(settings: Settings?, var machine: Machine) : Block(settings), BlockEntityProvider {

    override fun createBlockEntity(var1: BlockView?): BlockEntity? {
         return MachineBlockEntity(machine)
    }
}