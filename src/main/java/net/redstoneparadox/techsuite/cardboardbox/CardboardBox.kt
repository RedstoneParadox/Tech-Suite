package net.redstoneparadox.techsuite.cardboardbox

import net.fabricmc.api.ModInitializer

/**
 * Created by RedstoneParadox on 12/29/2018.
 *
 * This class exists as a separate part from the rest of the mod as I intend to split it off into
 * its own API/Library at some point in the future.
 */
class CardboardBox : ModInitializer {

    override fun onInitialize() {
        println("Greetings from Cardboard Box!")
    }

}