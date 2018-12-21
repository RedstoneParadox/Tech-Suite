package net.redstoneparadox.techsuite.registry

import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.blockentities.MachineBlockEntity


/**
 * Created by RedstoneParadox on 12/18/2018.
 */
object BlockEntityRegistry {

    lateinit var furnaceMachineType : BlockEntityType<MachineBlockEntity.FuranceMachineBlockEntity>

    fun initBlockEntities() {
        //poweredFuranceType = registerBlockEntity("powered_furnace", BlockEntityType.Builder.create { MachineBlockEntity(null, Machine.FURNACE) }.method_11034(null)!!)
        furnaceMachineType = registerBlockEntity("powered_furnace", BlockEntityType.Builder.create {MachineBlockEntity.FuranceMachineBlockEntity() }.method_11034((null)))
    }

    fun <T : BlockEntity> registerBlockEntity(name : String, blockEntityType : BlockEntityType<T>) : BlockEntityType<T> {
        val identifier: Identifier = Identifier(TechSuite.MOD_ID, name)
        Registry.register(Registry.BLOCK_ENTITY, identifier, blockEntityType)
        return blockEntityType
    }
}