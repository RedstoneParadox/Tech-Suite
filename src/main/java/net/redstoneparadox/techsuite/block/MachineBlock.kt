package net.redstoneparadox.techsuite.block

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.RenderTypeBlock
import net.minecraft.block.entity.BlockEntity
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
            Machine.FURNACE -> FurnaceMachineBlockEntity()
            Machine.BLAST_FURNACE -> BlastFurnaceMachineBlockEntity()
            Machine.SMOKER -> SmokerMachineBlockEntity()
            Machine.CRUSHER -> CrusherMachineBlockEntity()
            Machine.GRINDER -> GrinderMachineBlockEntity()
            Machine.MIXER -> MixerMachineBlockEntity()
        }

    }

    override fun getRenderType(var1: BlockState?): RenderTypeBlock {
        return RenderTypeBlock.MODEL
    }

    //Furnace machine block entity
    class FurnaceMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.furnaceMachineType) {
        override val machine: Machine? = Machine.FURNACE
    }

    //Blast furnace machine block entity.
    class BlastFurnaceMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.blastFurnaceMachineType) {
        override val machine: Machine? = Machine.FURNACE
    }

    //Smoker machine block entity.
    class SmokerMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.smokerMachineType) {
        override val machine : Machine? = Machine.SMOKER
    }

    //Crusher machine block entity.
    class CrusherMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.crusherMachineType) {
        override val machine : Machine? = Machine.CRUSHER
    }

    //Grinder machine block entity.
    class GrinderMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.grinderMachineType) {
        override val machine : Machine? = Machine.GRINDER
    }

    //Mixer machine block entity.
    class MixerMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.mixerMachineType) {
        override val machine : Machine? = Machine.MIXER
    }
}