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

    lateinit var poweredFurnace: MachineBlock
    lateinit var poweredBlastFurnace: MachineBlock
    lateinit var poweredSmoker: MachineBlock
    lateinit var poweredCrusher: MachineBlock
    lateinit var poweredGrinder: MachineBlock
    lateinit var poweredMixer: MachineBlock

    fun initBlocks() {
        poweredFurnace = registerBlock("powered_furnace", MachineBlock(constructSettings(material = Material.METAL), Machine.FURNACE)) as MachineBlock
        poweredBlastFurnace = registerBlock("powered_blast_furnace", MachineBlock(constructSettings(material = Material.METAL), Machine.BLAST_FURNACE)) as MachineBlock
        poweredSmoker = registerBlock("powered_smoker", MachineBlock(constructSettings(material = Material.METAL), Machine.SMOKER)) as MachineBlock
        poweredCrusher = registerBlock("powered_crusher", MachineBlock(constructSettings(material = Material.METAL), Machine.CRUSHER)) as MachineBlock
        poweredGrinder = registerBlock("powered_grinder", MachineBlock(constructSettings(material = Material.METAL), Machine.GRINDER)) as MachineBlock
        poweredMixer = registerBlock("powered_mixer", MachineBlock(constructSettings(material = Material.METAL), Machine.MIXER)) as MachineBlock
    }

    fun registerBlock(name : String, block: Block) : Block {
        var id = Identifier(TechSuite.MOD_ID, name)

        return Registry.register(Registry.BLOCK, id, block) as Block
    }

    fun constructSettings(
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