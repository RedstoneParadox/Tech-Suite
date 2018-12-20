package net.redstoneparadox.techsuite

import net.fabricmc.api.ModInitializer
import net.redstoneparadox.techsuite.registry.TSRecipies
import net.redstoneparadox.techsuite.registry.BlockEntityRegistry
import net.redstoneparadox.techsuite.registry.TSBlocks
import net.redstoneparadox.techsuite.registry.TSItems

/**
 * Created by RedstoneParadox on 12/17/2018.
 */
class TechSuite : ModInitializer {

    override fun onInitialize() {
        TSBlocks.initBlocks()
        TSItems.initItems()
        BlockEntityRegistry.initBlockEntities()
        TSRecipies.initRecipes()
    }

    companion object {
        var MOD_ID = "tech_suite"
    }

}