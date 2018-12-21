package net.redstoneparadox.techsuite.registry

import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.block.MachineBlock


/**
 * Created by RedstoneParadox on 12/18/2018.
 */
object BlockEntityRegistry {

    lateinit var FURNACE_MACHINE : BlockEntityType<MachineBlock.FurnaceMachineBlockEntity>
    lateinit var BLAST_FURNACE_MACHINE : BlockEntityType<MachineBlock.BlastFurnaceMachineBlockEntity>
    lateinit var SMOKER_MACHINE : BlockEntityType<MachineBlock.SmokerMachineBlockEntity>
    lateinit var CRUSHER_MACHINE : BlockEntityType<MachineBlock.CrusherMachineBlockEntity>
    lateinit var GRINDER_MACHINE : BlockEntityType<MachineBlock.GrinderMachineBlockEntity>
    lateinit var MIXER_MACHINE : BlockEntityType<MachineBlock.MixerMachineBlockEntity>

    fun initBlockEntities() {
        FURNACE_MACHINE = registerBlockEntity("powered_furnace", BlockEntityType.Builder.create { MachineBlock.FurnaceMachineBlockEntity() })
        BLAST_FURNACE_MACHINE = registerBlockEntity("powered_blast_furnace", BlockEntityType.Builder.create { MachineBlock.BlastFurnaceMachineBlockEntity() })
        SMOKER_MACHINE = registerBlockEntity("powered_smoker", BlockEntityType.Builder.create { MachineBlock.SmokerMachineBlockEntity() })
        CRUSHER_MACHINE = registerBlockEntity("powered_crusher", BlockEntityType.Builder.create { MachineBlock.CrusherMachineBlockEntity() })
        GRINDER_MACHINE = registerBlockEntity("powered_grinder", BlockEntityType.Builder.create { MachineBlock.GrinderMachineBlockEntity() })
        MIXER_MACHINE = registerBlockEntity("powered_mixer", BlockEntityType.Builder.create { MachineBlock.MixerMachineBlockEntity() })
    }

    fun <T : BlockEntity> registerBlockEntity(name : String, builder : BlockEntityType.Builder<T>) : BlockEntityType<T> {
        val blockEntityType = builder.method_11034(null)
        val identifier: Identifier = Identifier(TechSuite.MOD_ID, name)
        Registry.register(Registry.BLOCK_ENTITY, identifier, blockEntityType)
        return blockEntityType
    }
}