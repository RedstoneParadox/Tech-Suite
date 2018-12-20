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

    private lateinit var machineBlockEntity : BlockEntityType<MachineBlockEntity> set

    val machineBlockEntityType : BlockEntityType<MachineBlockEntity> = BlockEntityType.Builder.create(::MachineBlockEntity).method_11034(null)!!

    fun initBlockEntities() {
        machineBlockEntity = registerBlockEntity("machine", machineBlockEntityType)
    }

    fun <T : BlockEntity> registerBlockEntity(name : String, blockEntityType : BlockEntityType<T>) : BlockEntityType<T> {
        val identifier: Identifier = Identifier(TechSuite.MOD_ID, name)
        Registry.register(Registry.BLOCK_ENTITY, identifier, blockEntityType)
        return blockEntityType
    }
}