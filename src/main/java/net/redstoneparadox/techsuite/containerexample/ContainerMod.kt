package net.redstoneparadox.techsuite.containerexample

import net.fabricmc.fabric.api.container.ContainerProviderRegistry
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.container.Container
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.misc.CardboardContainer
import net.redstoneparadox.techsuite.registry.BlockEntityRegistry
import net.redstoneparadox.techsuite.registry.BlockRegistry




/**
 * Created by RedstoneParadox on 12/29/2018.
 */
class ContainerMod {

    companion object {
        val EXAMPLE_CONTAINER = Identifier(TechSuite.MOD_ID, "example_container")
        lateinit var containerBlock: Block
        lateinit var containerBlockEntity: BlockEntityType<ContainerBlockEntity>
    }

    fun onInitialize() {
        //Registers a basic server side command that shows that the openContainer works from the server side.


        //Registers a container factory that opens our example Container, this reads the block pos from the buffer
        ContainerProviderRegistry.INSTANCE.registerFactory(EXAMPLE_CONTAINER) { identifier, player, buf ->
            val pos = buf.readBlockPos()
            CardboardContainer(pos, player)
        }

        //Register the block
        containerBlock = BlockRegistry.registerBlock("container_block", ContainerBlock(BlockRegistry.constructSettings()))

        //Register the BlockEntity
        containerBlockEntity = BlockEntityRegistry.registerBlockEntity("container_block_entity", BlockEntityType.Builder.create { ContainerBlockEntity() })
    }

    //A basic container that prints to console when opened, this should print on the client + server
    class ExampleContainer(var pos: BlockPos, playerEntity: PlayerEntity) : Container() {

        init {
            println("Opened container, $pos")
        }

        override fun canUse(playerEntity: PlayerEntity): Boolean {
            return true
        }
    }

}
