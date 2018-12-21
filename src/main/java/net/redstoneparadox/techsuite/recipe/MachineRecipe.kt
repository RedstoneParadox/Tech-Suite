package net.redstoneparadox.techsuite.recipe

import net.minecraft.item.Item
import net.minecraft.item.ItemStack

/**
 * Created by RedstoneParadox on 12/20/2018.
 */
class MachineRecipe(private val inputOne : Item, private val inputTwo : Item? = null, private val outputOne : Item, private val outputTwo : Item? = null) {

    fun matchInput(inputOne: Item, inputTwo: Item?) : Boolean {
        if (inputOne == this.inputOne && inputTwo == this.inputTwo) {
            return true
        }

        return false
    }

    fun getOutput() : ArrayList<ItemStack> {
        val outputArrayList: ArrayList<ItemStack> = ArrayList()

        outputArrayList.add(ItemStack(outputOne, 1))
        if (outputTwo != null) {
            outputArrayList.add(ItemStack(outputTwo))
        }
        else {
            outputArrayList.add(ItemStack.EMPTY)
        }

        return outputArrayList
    }
}