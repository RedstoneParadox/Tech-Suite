package net.redstoneparadox.techsuite.blockentities

import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.TextComponent
import net.minecraft.util.DefaultedList
import net.minecraft.util.InventoryUtil
import net.minecraft.util.Tickable
import net.redstoneparadox.techsuite.registry.BlockEntityRegistry
import net.redstoneparadox.techsuite.registry.TSRecipies
import net.redstoneparadox.techsuite.util.Machine



/**
 * Created by RedstoneParadox on 12/18/2018.
 */
class MachineBlockEntity(type : BlockEntityType<MachineBlockEntity>) : BlockEntity(type), Tickable, Inventory{

    lateinit var machine : Machine
    private val inventory = DefaultedList.create(invSize, ItemStack.EMPTY)
    lateinit var input : ArrayList<Item?>
    lateinit var output : ArrayList<Item?>
    var ticksRemaining = 1000


    constructor(machine : Machine) : this(BlockEntityRegistry.machineBlockEntityType) {
        this.machine = machine
        input.add(null)
        input.add(null)
        setInvStack(0, ItemStack(Blocks.IRON_ORE.item, 64))
    }

    constructor() : this(BlockEntityRegistry.machineBlockEntityType)

    override fun tick() {

        val currentInput : ArrayList<Item?> = ArrayList()

        currentInput.add(getInvStack(0).item)
        currentInput.add(getInvStack(1).item)

        if (currentInput != input) {
            input = currentInput
            output = TSRecipies.getOutput(machine, getInvStack(0).item, getInvStack(1).item)
            ticksRemaining = 1000
        }
        else if(ticksRemaining > 0) {
            ticksRemaining -= 1
        }
        else {

            if (getInvStack(2).item == output[0] && getInvStack(3).item == output[1]) {
                takeInvStack(0, 1)
                takeInvStack(1, 1)
                setInvStack(2, ItemStack(output[0], 1 + getInvStack(2).amount))
                setInvStack(3, ItemStack(output[1], 1 + getInvStack(3).amount))
                print("There is " + getInvStack(0) + " iron ore remaining.")
                print("There are " + getInvStack(2) + " iron ingots in the output.")
            }
        }
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