package net.redstoneparadox.techsuite.block

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.RenderTypeBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.world.BlockView
import net.redstoneparadox.techsuite.blockentity.MachineBlockEntity
import net.redstoneparadox.techsuite.registry.BlockEntityRegistry
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/18/2018.
 */
class MachineBlock(settings: Settings?, var machine: Machine) : BlockWithEntity(settings) {

    override fun createBlockEntity(view: BlockView): BlockEntity {

        return when (machine) {
            Machine.FURNACE -> FuranceMachineBlockEntity(BlockEntityRegistry.furnaceMachineType)
            Machine.BLAST_FURNACE -> TODO()
            Machine.SMOKER -> TODO()
            Machine.CRUSHER -> TODO()
            Machine.GRINDER -> TODO()
            Machine.MIXER -> TODO()
        }

    }

    override fun getRenderType(var1: BlockState?): RenderTypeBlock {
        return RenderTypeBlock.MODEL
    }

    //Furnace
    class FuranceMachineBlockEntity(type : BlockEntityType<*>?) : MachineBlockEntity(type) {
        override val machine: Machine? = Machine.FURNACE
    }
}