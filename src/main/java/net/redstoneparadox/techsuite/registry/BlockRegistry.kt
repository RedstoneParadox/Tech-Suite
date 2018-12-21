package net.redstoneparadox.techsuite.registry

import net.fabricmc.fabric.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.MaterialColor
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.block.MachineBlock
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/17/2018.
 */
object BlockRegistry {

    lateinit var myFirstBlock: Block

    lateinit var POWERED_FURNACE: MachineBlock
    lateinit var POWERED_BLAST_FURNACE: MachineBlock
    lateinit var POWERED_SMOKER: MachineBlock
    lateinit var POWERED_CRUSHER: MachineBlock
    lateinit var POWERED_GRINDER: MachineBlock
    lateinit var POWERED_MIXER: MachineBlock

    fun initBlocks() {
        POWERED_FURNACE = registerBlock("powered_furnace", MachineBlock(constructSettings(material = Material.METAL), Machine.FURNACE)) as MachineBlock
        POWERED_BLAST_FURNACE = registerBlock("powered_blast_furnace", MachineBlock(constructSettings(material = Material.METAL), Machine.BLAST_FURNACE)) as MachineBlock
        POWERED_SMOKER = registerBlock("powered_smoker", MachineBlock(constructSettings(material = Material.METAL), Machine.SMOKER)) as MachineBlock
        POWERED_CRUSHER = registerBlock("powered_crusher", MachineBlock(constructSettings(material = Material.METAL), Machine.CRUSHER)) as MachineBlock
        POWERED_GRINDER = registerBlock("powered_grinder", MachineBlock(constructSettings(material = Material.METAL), Machine.GRINDER)) as MachineBlock
        POWERED_MIXER = registerBlock("powered_mixer", MachineBlock(constructSettings(material = Material.METAL), Machine.MIXER)) as MachineBlock
    }

    private fun registerBlock(name : String, block: Block) : Block {
        var id = Identifier(TechSuite.MOD_ID, name)

        return Registry.register(Registry.BLOCK, id, block) as Block
    }

    private fun constructSettings(
            material: Material = Material.AIR,
            color: MaterialColor = MaterialColor.AIR,
            collidable : Boolean = true,
            soundGroup: BlockSoundGroup = BlockSoundGroup.STONE,
            luminance: Int = 0,
            hardness: Float = 6.0f,
            resistance: Float = 1.5f,
            randomTicks: Boolean = false,
            slipperiness: Float = 0.6f,
            dropTableName : String = "missingno"
    )
            : Block.Settings {
        var settings : FabricBlockSettings = FabricBlockSettings.of(material, color)

        settings = settings.collidable(collidable)
        settings = settings.sounds(soundGroup)
        settings = settings.lightLevel(luminance)
        settings = settings.strength(hardness, resistance)

        if (randomTicks) {
            settings.ticksRandomly()
        }

        settings = settings.friction(slipperiness)

        if (dropTableName == "missingno") {
            settings = settings.dropsNothing()
        }
        else {
            settings = settings.drops(Identifier(TechSuite.MOD_ID, dropTableName))
        }

        var builtSettings : Block.Settings = settings.build()
        return builtSettings
    }
}