package net.redstoneparadox.techsuite.blockentity

import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.gui.Gui
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.nbt.CompoundTag
import net.minecraft.text.TextComponent
import net.minecraft.util.DefaultedList
import net.minecraft.util.Identifier
import net.minecraft.util.InventoryUtil
import net.minecraft.util.Tickable
import net.redstoneparadox.techsuite.TechSuite
import net.redstoneparadox.techsuite.cardboardbox.gui.CardboardContainerGUI
import net.redstoneparadox.techsuite.cardboardbox.gui.GuiTree
import net.redstoneparadox.techsuite.cardboardbox.misc.GuiController
import net.redstoneparadox.techsuite.cardboardbox.registry.CardboardGuiTreeRegistry
import net.redstoneparadox.techsuite.energy.IEnergyUser
import net.redstoneparadox.techsuite.recipe.MachineRecipe
import net.redstoneparadox.techsuite.registry.RecipeRegistry
import net.redstoneparadox.techsuite.util.Machine



/**
 * Created by RedstoneParadox on 12/18/2018.
 */
abstract class MachineBlockEntity(type: BlockEntityType<*>) : BlockEntity(type), Tickable, Inventory, IEnergyUser, GuiController{

    open val machine : Machine? = null
    val inventory : DefaultedList<ItemStack> = DefaultedList.create(invSize, ItemStack.EMPTY)
    var ticksRemaining = 200
    var machineRecipe : MachineRecipe = RecipeRegistry.EMPTY_RECIPE

    var test : Boolean = true

    var gui : CardboardContainerGUI? = null

    override fun tick() {

        if (test) {
            setInvStack(0, ItemStack(Blocks.IRON_ORE.item, 64))
            test = false
        }

        if (!machineRecipe.matchInput(getInvStack(0).item, getInvStack(1).item)){
            machineRecipe = RecipeRegistry.getRecipe(machine!!, getInvStack(0).item, getInvStack(1).item)
            ticksRemaining = 200
        }
        else if (ticksRemaining > 0) {

            if (machineRecipe == RecipeRegistry.EMPTY_RECIPE) {
                ticksRemaining = 200
            }
            else {
                ticksRemaining -= 1
            }
        }
        else {
            val output : ArrayList<ItemStack> = machineRecipe.getOutput()

            if (getInvStack(2) == ItemStack.EMPTY && getInvStack(3) == ItemStack.EMPTY) {
                craft(output)
            }
            else if (getInvStack(2).item == output[0].item && getInvStack(3).item == output[1].item && canOutput()) {
                craft(output)
            }
        }

        this.markDirty()
    }

    fun craft(output : ArrayList<ItemStack>) {
        takeInvStack(0, 1)
        takeInvStack(1, 1)

        if (getInvStack(2).isEmpty) {
            setInvStack(2, output[0])
        }
        else {
            val outputStack = output[0]
            outputStack.amount = outputStack.amount + getInvStack(2).amount
            setInvStack(2, outputStack)
        }

        if (getInvStack(3).isEmpty) {
            setInvStack(3, output[1])
        }
        else {
            val outputStack = output[1]
            outputStack.amount + getInvStack(3).amount
            setInvStack(3, outputStack)
        }

        ticksRemaining = 200

    }

    fun canOutput() : Boolean {
        if (getInvStack(2).amount < invMaxStackAmount && getInvStack(3).amount < invMaxStackAmount) {
            return true
        }

        return false
    }

    override fun setup(gui: Gui, player: PlayerEntity): GuiTree {
        this.gui = (gui as CardboardContainerGUI)
        return CardboardGuiTreeRegistry.getComponentTree(Identifier(TechSuite.MOD_ID, "machine"))!!
    }

    override fun fromTag(tag: CompoundTag) {
        var machineData : CompoundTag = CompoundTag()
        var inventoryData : CompoundTag = CompoundTag()

        if (tag.containsKey("machine_data")) {
            machineData = tag.getCompound("machine_data")
            ticksRemaining = machineData.getInt("ticks_remaining")

            if (machineData.containsKey("test")) {
                test = machineData.getBoolean("test")
            }
        }

        if (tag.containsKey("inventory")) {
            inventoryData = tag.getCompound("inventory")

            var inputData = inventoryData.getCompound("input")
            var outputData = inventoryData.getCompound("output")

            var inputStackOne : ItemStack = ItemStack.fromTag(inputData.getCompound("0"))
            var inputStackTwo : ItemStack = ItemStack.fromTag(inputData.getCompound("1"))
            var outputStackOne : ItemStack = ItemStack.fromTag(outputData.getCompound("0"))
            var outputStackTwo : ItemStack = ItemStack.fromTag(outputData.getCompound("1"))

            setInvStack(0, inputStackOne)
            setInvStack(1, inputStackTwo)
            setInvStack(2, outputStackOne)
            setInvStack(3, outputStackTwo)
        }
        super.fromTag(tag)
    }

    override fun toTag(tag: CompoundTag): CompoundTag {
        energyNode.tick()

        val machineData : CompoundTag = CompoundTag()

        machineData.putInt("ticks_remaining", ticksRemaining)
        machineData.putBoolean("test", test)
        tag.put("machine_data", machineData)

        val inputData : CompoundTag = CompoundTag()
        val outputData : CompoundTag = CompoundTag()
        val inventoryData : CompoundTag = CompoundTag()

        val airStack : ItemStack = ItemStack(Items.AIR)

        if (getInvStack(0).isEmpty) {
            inputData.put("0", airStack.toTag(CompoundTag()))
        }
        else {
            inputData.put("0", getInvStack(0).toTag(CompoundTag()))
        }

        if (getInvStack(1).isEmpty) {
            inputData.put("1", airStack.toTag(CompoundTag()))
        }
        else {
            inputData.put("1", getInvStack(1).toTag(CompoundTag()))
        }
        inventoryData.put("input", inputData)

        if (getInvStack(2).isEmpty) {
            outputData.put("0", airStack.toTag(CompoundTag()))
        }
        else {
            outputData.put("0", getInvStack(2).toTag(CompoundTag()))
        }

        if (getInvStack(3).isEmpty) {
            outputData.put("1", airStack.toTag(CompoundTag()))
        }
        else {
            outputData.put("1", getInvStack(3).toTag(CompoundTag()))
        }
        inventoryData.put("output", outputData)
        tag.put("inventory", inventoryData)

        return super.toTag(tag)
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