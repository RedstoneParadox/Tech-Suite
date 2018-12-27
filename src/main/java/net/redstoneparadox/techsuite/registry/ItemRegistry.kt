package net.redstoneparadox.techsuite.registry

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.block.BlockItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.redstoneparadox.techsuite.TechSuite

/**
 * Created by RedstoneParadox on 12/17/2018.
 */
object ItemRegistry {

    //Ingots
    lateinit var COPPER_INGOT: Item
    lateinit var TIN_INGOT: Item
    lateinit var ALUMINUM_INGOT: Item
    lateinit var LEAD_INGOT: Item
    //Gears
    lateinit var STONE_GEAR: Item
    lateinit var IRON_GEAR: Item
    lateinit var GOLD_GEAR: Item
    lateinit var COPPER_GEAR: Item
    lateinit var TIN_GEAR: Item
    lateinit var ALUMINUM_GEAR: Item
    lateinit var LEAD_GEAR: Item
    //Plates
    lateinit var IRON_PLATE: Item
    lateinit var GOLD_PLATE: Item
    lateinit var COPPER_PLATE: Item
    lateinit var TIN_PLATE: Item
    lateinit var ALUMINUM_PLATE: Item
    lateinit var LEAD_PLATE: Item
    //Nuggets
    lateinit var COPPER_NUGGET: Item
    lateinit var TIN_NUGGET: Item
    lateinit var ALUMINUM_NUGGET: Item
    lateinit var LEAD_NUGGET: Item
    //
    //Machines
    lateinit var POWERED_FURNACE: Item
    lateinit var POWERED_BLAST_FURNACE: Item
    lateinit var POWERED_SMOKER: Item
    lateinit var POWERED_CRUSHER: Item
    lateinit var POWERED_GRINDER: Item
    lateinit var POWERED_MIXER: Item

    enum class IngredientType(val suffix: String) {
        INGOT("_ingot"),
        NUGGET("_nugget"),
        PLATE("_plate"),
        GEAR("_gear")
    }

    enum class Material(val prefix: String) {
        STONE("stone"),
        IRON("iron"),
        GOLD("gold"),
        DIAMOND("diamond"),
        COPPER("copper"),
        TIN("tin"),
        ALUMINUM("aluminum"),
        LEAD("lead"),
    }

    fun initItems() {
        //Ingots
        COPPER_INGOT = registerItem(Material.COPPER, IngredientType.INGOT)
        TIN_INGOT = registerItem(Material.TIN, IngredientType.INGOT)
        ALUMINUM_INGOT = registerItem(Material.ALUMINUM, IngredientType.INGOT)
        LEAD_INGOT = registerItem(Material.LEAD, IngredientType.INGOT)
        //Nuggets
        COPPER_NUGGET = registerItem(Material.COPPER, IngredientType.NUGGET)
        TIN_NUGGET = registerItem(Material.TIN, IngredientType.NUGGET)
        ALUMINUM_NUGGET = registerItem(Material.ALUMINUM, IngredientType.NUGGET)
        LEAD_NUGGET = registerItem(Material.LEAD, IngredientType.NUGGET)
        //Plates
        IRON_PLATE = registerItem(Material.IRON, IngredientType.PLATE)
        GOLD_PLATE = registerItem(Material.GOLD, IngredientType.PLATE)
        COPPER_PLATE = registerItem(Material.COPPER, IngredientType.PLATE)
        TIN_PLATE = registerItem(Material.TIN, IngredientType.PLATE)
        ALUMINUM_PLATE = registerItem(Material.ALUMINUM, IngredientType.PLATE)
        LEAD_PLATE = registerItem(Material.LEAD, IngredientType.PLATE)
        //Gears
        STONE_GEAR = registerItem(Material.STONE, IngredientType.GEAR)
        IRON_GEAR = registerItem(Material.IRON, IngredientType.GEAR)
        GOLD_GEAR = registerItem(Material.GOLD, IngredientType.GEAR)
        COPPER_GEAR = registerItem(Material.COPPER, IngredientType.GEAR)
        TIN_GEAR = registerItem(Material.TIN, IngredientType.GEAR)
        ALUMINUM_GEAR = registerItem(Material.ALUMINUM, IngredientType.GEAR)
        LEAD_GEAR = registerItem(Material.LEAD, IngredientType.GEAR)
        //
        //Machines
        POWERED_FURNACE = registerBlockItem(BlockRegistry.POWERED_FURNACE, ItemGroup.REDSTONE)
        POWERED_BLAST_FURNACE = registerBlockItem(BlockRegistry.POWERED_BLAST_FURNACE, ItemGroup.REDSTONE)
        POWERED_SMOKER = registerBlockItem(BlockRegistry.POWERED_SMOKER, ItemGroup.REDSTONE)
        POWERED_CRUSHER = registerBlockItem(BlockRegistry.POWERED_CRUSHER, ItemGroup.REDSTONE)
        POWERED_GRINDER = registerBlockItem(BlockRegistry.POWERED_GRINDER, ItemGroup.REDSTONE)
        POWERED_MIXER = registerBlockItem(BlockRegistry.POWERED_MIXER, ItemGroup.REDSTONE)
    }

    fun registerItem(name: String, item: Item) : Item {
        var id = Identifier(TechSuite.MOD_ID, name)

        if (item is BlockItem) {
            item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item)
        }

        return Registry.register(Registry.ITEM, id, item)
    }

    fun registerItem(material : Material, type : IngredientType) : Item {
        var identifier : Identifier = Identifier(TechSuite.MOD_ID, (material.prefix + type.suffix))
        return Registry.register(Registry.ITEM, identifier, Item(Item.Settings().itemGroup(ItemGroup.MISC)))
    }

    //TODO Rewrite this to be more concise.
    fun registerBlockItem(block : Block, itemGroup: ItemGroup): Item {
        return register(BlockItem(block, (Item.Settings()).itemGroup(itemGroup)))
    }

    fun register(blockItem: BlockItem): Item {
        return register(blockItem.block as Block, blockItem)
    }

    fun register(block: Block, item: Item): Item {
        return registerItem(Registry.BLOCK.getId(block).path, item)
    }
}