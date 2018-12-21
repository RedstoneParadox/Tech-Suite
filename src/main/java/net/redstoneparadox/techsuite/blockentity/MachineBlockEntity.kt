package net.redstoneparadox.techsuite.blockentity

import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.text.TextComponent
import net.minecraft.util.DefaultedList
import net.minecraft.util.InventoryUtil
import net.minecraft.util.Tickable
import net.redstoneparadox.techsuite.recipe.MachineRecipe
import net.redstoneparadox.techsuite.registry.RecipeRegistry
import net.redstoneparadox.techsuite.util.Machine



/**
 * Created by RedstoneParadox on 12/18/2018.
 */
abstract class MachineBlockEntity(type: BlockEntityType<*>?) : BlockEntity(type), Tickable, Inventory{

    open val machine : Machine? = null
    private val inventory = DefaultedList.create(invSize, ItemStack.EMPTY)
    var ticksRemaining = 200
    var test = true
    var machineRecipe : MachineRecipe? = null

    override fun tick() {

        if (test && machine == Machine.FURNACE) {
            setInvStack(1, ItemStack(Blocks.IRON_ORE.item, 64))
            test = false
        }

        if (machineRecipe == null || machineRecipe!!.matchInput(getInvStack(1).item, getInvStack(2).item)){
            machineRecipe = RecipeRegistry.getRecipe(machine!!, getInvStack(0).item, getInvStack(1).item)
            ticksRemaining = 200
        }
        else if (ticksRemaining > 0) {
            ticksRemaining -=1
        }
        else {
            val output : ArrayList<ItemStack> = machineRecipe!!.getOutput()

            if (getInvStack(2) == ItemStack.EMPTY && getInvStack(3) == ItemStack.EMPTY) {
                craft(output)
            }
            else if (getInvStack(2) == output[0] && getInvStack(3) == output[1]) {
                craft(output)
            }
        }
    }

    fun craft(output : ArrayList<ItemStack>) {
        takeInvStack(0, 1)
        takeInvStack(1, 1)

        setInvStack(2, output[0])
        setInvStack(3, output[1])

        System.out.println("There is " + getInvStack(0).amount + " iron ore remaining.")
        System.out.println("There are " + getInvStack(2).amount + " iron ingots in the output.")
    }

    override fun markDirty() {

    }

    //Inventory functions
    override fun getInvSize(): Int {
        return 4
    }

    override fun isInvEmpty(): Boolean {
        return inventory.stream().anyMatch(ItemStack::isEmpty)
    }

    override fun getInvStack(slot: Int): ItemStack {
        return inventory[slot]
    }

    override fun takeInvStack(slot: Int, amount: Int): ItemStack {
        return InventoryUtil.splitStack(this.inventory, slot, amount)
    }

    override fun removeInvStack(slot: Int): ItemStack {
        return InventoryUtil.removeStack(this.inventory, slot)
    }

    override fun setInvStack(slot: Int, stack: ItemStack) {
        this.inventory[slot] = stack
        if (stack.amount > this.invMaxStackAmount) {
            stack.amount = this.invMaxStackAmount
        }
    }

    override fun getInvMaxStackAmount(): Int {
        return 64
    }

    override fun canPlayerUseInv(player: PlayerEntity): Boolean {
        return true
    }

    override fun onInvOpen(player : PlayerEntity) {

    }

    override fun onInvClose(player : PlayerEntity) {

    }

    override fun isValidInvStack(slot : Int, stack : ItemStack): Boolean {
        return true
    }

    override fun getInvProperty(i: Int): Int {
        return 0
    }

    override fun setInvProperty(i: Int, i1: Int) {

    }

    override fun getInvPropertyCount(): Int {
        return 0
    }

    override fun getInvHeight(): Int {
        return 2
    }

    override fun getInvWidth(): Int {
        return 2
    }

    override fun clearInv() {
       inventory.clear()
    }

    override fun getName(): TextComponent? {
        return null
    }

    override fun hasCustomName(): Boolean {
        return false
    }
}