package net.redstoneparadox.techsuite.containerexample

import net.fabricmc.fabric.api.container.ContainerProviderRegistry
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.World


/**
 * Created by RedstoneParadox on 12/29/2018.
 */
class ContainerBlock(settings: Settings?) : BlockWithEntity(settings) {

    override fun createBlockEntity(view: BlockView?): BlockEntity? {
        return ContainerBlockEntity()
    }

    override fun activate(blockState: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, direction: Direction, float_1: Float, float_2: Float, float_3: Float): Boolean {
        if (!world.isClient() && hasBlockEntity()) {
            ContainerProviderRegistry.INSTANCE.openContainer(ContainerMod.EXAMPLE_CONTAINER, player) { it.writeBlockPos(pos) }
        }

        return super.activate(blockState, world, pos, player, hand, direction, float_1, float_2, float_3)
    }
}