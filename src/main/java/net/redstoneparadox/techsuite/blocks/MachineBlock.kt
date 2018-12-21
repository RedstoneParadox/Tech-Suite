package net.redstoneparadox.techsuite.blocks

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.RenderTypeBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.world.BlockView
import net.redstoneparadox.techsuite.blockentities.MachineBlockEntity
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/18/2018.
 */
class MachineBlock(settings: Settings?, var machine: Machine) : BlockWithEntity(settings) {

    override fun createBlockEntity(view: BlockView): BlockEntity {
        return MachineBlockEntity.FuranceMachineBlockEntity()
    }

    override fun getRenderType(var1: BlockState?): RenderTypeBlock {
        return RenderTypeBlock.MODEL
    }
}