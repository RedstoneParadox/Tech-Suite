package net.redstoneparadox.techsuite

import net.fabricmc.api.ModInitializer
import net.redstoneparadox.techsuite.registry.*

/**
 * Created by RedstoneParadox on 12/17/2018.
 */
class TechSuite : ModInitializer {

    override fun onInitialize() {
        ContainerRegistry.initContainers()
        BlockEntityRegistry.initBlockEntities()
        BlockRegistry.initBlocks()
        ItemRegistry.initItems()
        RecipeRegistry.initRecipes()
    }

    companion object {
        var MOD_ID = "tech_suite"
    }

}