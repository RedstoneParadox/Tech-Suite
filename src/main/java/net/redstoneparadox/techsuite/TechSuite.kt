package net.redstoneparadox.techsuite

import net.fabricmc.api.ModInitializer
import net.redstoneparadox.techsuite.registry.RecipeRegistry
import net.redstoneparadox.techsuite.registry.BlockEntityRegistry
import net.redstoneparadox.techsuite.registry.BlockRegistry
import net.redstoneparadox.techsuite.registry.ItemRegistry

/**
 * Created by RedstoneParadox on 12/17/2018.
 */
class TechSuite : ModInitializer {

    override fun onInitialize() {
        BlockRegistry.initBlocks()
        ItemRegistry.initItems()
        BlockEntityRegistry.initBlockEntities()
        RecipeRegistry.initRecipes()
    }

    companion object {
        var MOD_ID = "tech_suite"
    }

}