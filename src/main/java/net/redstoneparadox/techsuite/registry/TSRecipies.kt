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

    lateinit var furnaceRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>
    lateinit var blastFurnaceRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>
    lateinit var smokerRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>
    lateinit var crusherRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>
    lateinit var grinderRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>
    lateinit var mixerRecipes : HashMap<ArrayList<Item?>, ArrayList<Item?>>

    fun initRecipes() {
        registerRecipe(Blocks.IRON_ORE.item, out1 = Items.IRON_INGOT)
        registerRecipe(Blocks.GOLD_ORE.item, out1 = Items.GOLD_INGOT)
    }

    fun registerRecipe(in1: Item, in2: Item = ItemStack.EMPTY.item, out1: Item, out2: Item = ItemStack.EMPTY.item) {
        var input : ArrayList<Item> = ArrayList()
        var output : ArrayList<Item> = ArrayList()

        input.add(in1)
        input.add(in2)
        output.add(out1)
        output.add(out2)
    }

    fun getOutput(machine : Machine, in1: Item, in2: Item? = ItemStack.EMPTY.item) : ArrayList<Item?> {
        var input : ArrayList<Item?> = ArrayList()

        input.add(in1)
        input.add(in2)

        return when(machine) {
            Machine.FURNACE -> furnaceRecipes[input]
            Machine.BLAST_FURNACE -> blastFurnaceRecipes[input]
            Machine.SMOKER -> smokerRecipes[input]
            Machine.CRUSHER -> crusherRecipes[input]
            Machine.GRINDER -> grinderRecipes[input]
            Machine.MIXER -> mixerRecipes[input]
        } as ArrayList
    }
}