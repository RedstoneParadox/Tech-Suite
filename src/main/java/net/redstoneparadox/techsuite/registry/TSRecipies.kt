package net.redstoneparadox.techsuite.registry

import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/19/2018.
 */
object TSRecipies {

    var furnaceRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()
    var blastFurnaceRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()
    var smokerRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()
    var crusherRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()
    var grinderRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()
    var mixerRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>> = HashMap()

    fun initRecipes() {
        registerRecipe(Machine.FURNACE, Blocks.IRON_ORE.item, out1 = Items.IRON_INGOT)
        registerRecipe(Machine.FURNACE, Blocks.GOLD_ORE.item, out1 = Items.GOLD_INGOT)
    }

    fun registerRecipe(machine: Machine,in1: Item, in2: Item = ItemStack.EMPTY.item, out1: Item, out2: Item = ItemStack.EMPTY.item) {
        var input : ArrayList<Item?> = ArrayList()
        var output : ArrayList<Item?> = ArrayList()

        input.add(in1)
        input.add(in2)
        output.add(out1)
        output.add(out2)

        when(machine) {
            Machine.FURNACE -> furnaceRecipes.put(input, output)
            Machine.BLAST_FURNACE -> TODO()
            Machine.SMOKER -> TODO()
            Machine.CRUSHER -> TODO()
            Machine.GRINDER -> TODO()
            Machine.MIXER -> TODO()
        }
    }

    fun getOutput(machine : Machine, in1: Item, in2: Item?) : ArrayList<Item?> {
        var input : ArrayList<Item?> = ArrayList()

        input.add(in1)
        if (in2 != null) {
            input.add(in2)
        }

        var output = when(machine) {
            Machine.FURNACE -> furnaceRecipes[input]
            Machine.BLAST_FURNACE -> blastFurnaceRecipes[input]
            Machine.SMOKER -> smokerRecipes[input]
            Machine.CRUSHER -> crusherRecipes[input]
            Machine.GRINDER -> grinderRecipes[input]
            Machine.MIXER -> mixerRecipes[input]
        }

        if (output == null || output.isEmpty()) {
            return ArrayList()
        }
        else {
            return output
        }
    }
}