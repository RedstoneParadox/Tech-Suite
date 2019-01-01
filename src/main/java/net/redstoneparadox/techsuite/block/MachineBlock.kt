package net.redstoneparadox.techsuite.block

import net.fabricmc.fabric.api.container.ContainerProviderRegistry
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.blockentity.MachineBlockEntity
import net.redstoneparadox.techsuite.energy.EnergyNode
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

    override fun getRenderType(var1: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun activate(blockState: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, direction: Direction, float_1: Float, float_2: Float, float_3: Float): Boolean {
        if (!world.isClient() && hasBlockEntity()) {
            ContainerProviderRegistry.INSTANCE.openContainer(Identifier(TechSuite.MOD_ID, "machine"), player) { it.writeBlockPos(pos) }
        }

        return super.activate(blockState, world, pos, player, hand, direction, float_1, float_2, float_3)
    }

    //Furnace machine block entity
    class FurnaceMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.FURNACE_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine: Machine? = Machine.FURNACE
    }

    //Blast furnace machine block entity.
    class BlastFurnaceMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.BLAST_FURNACE_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine: Machine? = Machine.FURNACE
    }

    //Smoker machine block entity.
    class SmokerMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.SMOKER_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine : Machine? = Machine.SMOKER
    }

    //Crusher machine block entity.
    class CrusherMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.CRUSHER_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine : Machine? = Machine.CRUSHER
    }

    //Grinder machine block entity.
    class GrinderMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.GRINDER_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine : Machine? = Machine.GRINDER
    }

    //Mixer machine block entity.
    class MixerMachineBlockEntity : MachineBlockEntity(BlockEntityRegistry.MIXER_MACHINE) {
        override var energyNode: EnergyNode = EnergyNode(0)
        override val machine : Machine? = Machine.MIXER
    }
}