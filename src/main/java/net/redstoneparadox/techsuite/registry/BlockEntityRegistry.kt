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

    lateinit var furnaceMachineType : BlockEntityType<MachineBlock.FurnaceMachineBlockEntity>
    lateinit var blastFurnaceMachineType : BlockEntityType<MachineBlock.BlastFurnaceMachineBlockEntity>
    lateinit var smokerMachineType : BlockEntityType<MachineBlock.SmokerMachineBlockEntity>
    lateinit var crusherMachineType : BlockEntityType<MachineBlock.CrusherMachineBlockEntity>
    lateinit var grinderMachineType : BlockEntityType<MachineBlock.GrinderMachineBlockEntity>
    lateinit var mixerMachineType : BlockEntityType<MachineBlock.MixerMachineBlockEntity>

    fun initBlockEntities() {
        furnaceMachineType = registerBlockEntity("powered_furnace", BlockEntityType.Builder.create { MachineBlock.FurnaceMachineBlockEntity() })
        blastFurnaceMachineType = registerBlockEntity("powered_blast_furnace", BlockEntityType.Builder.create { MachineBlock.BlastFurnaceMachineBlockEntity() })
        smokerMachineType = registerBlockEntity("powered_smoker", BlockEntityType.Builder.create { MachineBlock.SmokerMachineBlockEntity() })
        crusherMachineType = registerBlockEntity("powered_crusher", BlockEntityType.Builder.create { MachineBlock.CrusherMachineBlockEntity() })
        grinderMachineType = registerBlockEntity("powered_grinder", BlockEntityType.Builder.create { MachineBlock.GrinderMachineBlockEntity() })
        mixerMachineType = registerBlockEntity("powered_mixer", BlockEntityType.Builder.create { MachineBlock.MixerMachineBlockEntity() })

    }

    fun <T : BlockEntity> registerBlockEntity(name : String, builder : BlockEntityType.Builder<T>) : BlockEntityType<T> {
        val blockEntityType = builder.method_11034(null)
        val identifier: Identifier = Identifier(TechSuite.MOD_ID, name)
        Registry.register(Registry.BLOCK_ENTITY, identifier, blockEntityType)
        return blockEntityType
    }
}