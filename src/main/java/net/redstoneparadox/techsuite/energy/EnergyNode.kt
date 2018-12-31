package net.redstoneparadox.techsuite.energy

import net.minecraft.util.math.Direction

/**
 * Created by RedstoneParadox on 12/28/2018.
 */
class EnergyNode(var maxEnergy: Int) {

    var desiredEnergy : Int = 0
    var currentEnergy : Int = 0
        set(value) {
            desiredEnergy = maxEnergy - currentEnergy
            field = value
        }

    private var northConnection : EnergyNode? = null
    private var southConnection : EnergyNode? = null
    private var eastConnection : EnergyNode? = null
    private var westConnection : EnergyNode? = null
    private var upConnection : EnergyNode? = null
    private var downConnection : EnergyNode? = null


    fun tick() {

    }

    fun addConnection(direction: Direction, node: EnergyNode) {

        when (direction) {
            Direction.NORTH -> {northConnection = node}
            Direction.SOUTH -> {southConnection = node}
            Direction.EAST -> {eastConnection = node}
            Direction.WEST -> {westConnection = node}
            Direction.UP -> {upConnection = node}
            Direction.DOWN -> {downConnection = node}
        }
    }

    fun removeConnection(direction: Direction) {

        when (direction) {
            Direction.NORTH -> {northConnection = null}
            Direction.SOUTH -> {southConnection = null}
            Direction.EAST -> {eastConnection = null}
            Direction.WEST -> {westConnection = null}
            Direction.UP -> {upConnection = null}
            Direction.DOWN -> {downConnection = null}
        }
    }
}