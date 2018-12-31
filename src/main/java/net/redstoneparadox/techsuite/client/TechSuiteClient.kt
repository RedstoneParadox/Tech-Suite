package net.redstoneparadox.techsuite.client

import net.fabricmc.api.ClientModInitializer
import net.redstoneparadox.techsuite.containerexample.ContainerModClient

/**
 * Created by RedstoneParadox on 12/23/2018.
 */
class TechSuiteClient : ClientModInitializer {

    val containerModClient : ContainerModClient = ContainerModClient()

    override fun onInitializeClient() {
        println("Greetings from Tech Suite Client!")
        containerModClient.onInitializeClient()
    }
}