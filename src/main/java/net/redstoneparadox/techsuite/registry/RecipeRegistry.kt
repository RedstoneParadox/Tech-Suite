package net.redstoneparadox.techsuite.registry

import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.redstoneparadox.techsuite.recipe.MachineRecipe
import net.redstoneparadox.techsuite.util.Machine

/**
 * Created by RedstoneParadox on 12/19/2018.
 */
object RecipeRegistry {

    var furnaceRecipeList: ArrayList<MachineRecipe> = ArrayList()
    var blastFurnaceRecipeList : ArrayList<MachineRecipe> = ArrayList()
    var smokerRecipeList : ArrayList<MachineRecipe> = ArrayList()
    var crusherRecipeList : ArrayList<MachineRecipe> = ArrayList()
    var grinderRecipeList : ArrayList<MachineRecipe> = ArrayList()
    var mixerRecipeList : ArrayList<MachineRecipe> = ArrayList()

    val EMPTY_RECIPE : MachineRecipe = MachineRecipe(ItemStack.EMPTY.item, ItemStack.EMPTY.item, ItemStack.EMPTY.item, ItemStack.EMPTY.item)

    fun initRecipes() {
        registerRecipe(Machine.FURNACE, Blocks.IRON_ORE.item, out1 = Items.IRON_INGOT)
        registerRecipe(Machine.FURNACE, Blocks.GOLD_ORE.item, out1 = Items.GOLD_INGOT)
    }

    private fun registerRecipe(machine: Machine, in1: Item, in2: Item? = ItemStack.EMPTY.item, out1: Item, out2: Item? = ItemStack.EMPTY.item) {
        var machineRecipe : MachineRecipe = MachineRecipe(in1, in2, out1, out2)

        when (machine) {
            Machine.FURNACE -> furnaceRecipeList.add(machineRecipe)
            Machine.BLAST_FURNACE -> blastFurnaceRecipeList.add(machineRecipe)
            Machine.SMOKER -> smokerRecipeList.add(machineRecipe)
            Machine.CRUSHER -> crusherRecipeList.add(machineRecipe)
            Machine.GRINDER -> grinderRecipeList.add(machineRecipe)
            Machine.MIXER -> mixerRecipeList.add(machineRecipe)
        }
    }

    fun getRecipe(machine : Machine, in1: Item, in2: Item?) : MachineRecipe {

        val recipeList: ArrayList<MachineRecipe> = when(machine) {
            Machine.FURNACE -> furnaceRecipeList
            Machine.BLAST_FURNACE -> blastFurnaceRecipeList
            Machine.SMOKER -> smokerRecipeList
            Machine.CRUSHER -> crusherRecipeList
            Machine.GRINDER -> grinderRecipeList
            Machine.MIXER -> mixerRecipeList
        }

        for (recipe in recipeList) {

            if (recipe.matchInput(in1, in2)) {
                return recipe
            }
        }

        return EMPTY_RECIPE
    }
}