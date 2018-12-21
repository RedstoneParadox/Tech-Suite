package net.redstoneparadox.techsuite.registry

import net.minecraft.item.Item
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
    //Gears
    lateinit var STONE_GEAR: Item
    lateinit var IRON_GEAR: Item
    lateinit var GOLD_GEAR: Item
    lateinit var COPPER_GEAR: Item
    lateinit var TIN_GEAR: Item

    enum class IngredientType(val suffix: String) {
        INGOT("_ingot"),
        GEAR("_gear"),
        PLATE("_plate"),
        NUGGET("_nugget")
    }

    enum class IngredientMaterial(val prefix: String) {
        STONE("stone"),
        IRON("iron"),
        GOLD("gold"),
        DIAMOND("diamond"),
        COPPER("copper"),
        TIN("tin")
    }

    fun initItems() {
        //Ingots
        COPPER_INGOT = registerItem(IngredientMaterial.COPPER, IngredientType.INGOT)
        TIN_INGOT = registerItem(IngredientMaterial.TIN, IngredientType.INGOT)
        //Gears
        STONE_GEAR = registerItem(IngredientMaterial.STONE, IngredientType.GEAR)
        IRON_GEAR = registerItem(IngredientMaterial.IRON, IngredientType.GEAR)
        GOLD_GEAR = registerItem(IngredientMaterial.GOLD, IngredientType.GEAR)
        COPPER_GEAR = registerItem(IngredientMaterial.COPPER, IngredientType.GEAR)
        TIN_GEAR = registerItem(IngredientMaterial.TIN, IngredientType.GEAR)
    }

    fun registerItem(name: String, item: Item) : Item {
        var id = Identifier(TechSuite.MOD_ID, name)

        return Registry.register(Registry.ITEM, id, item)
    }

    fun registerItem(material : IngredientMaterial, type : IngredientType) : Item {
        var identifier : Identifier

        when (type) {
            IngredientType.INGOT ->
                identifier = Identifier(TechSuite.MOD_ID, material.prefix + type.suffix)
            IngredientType.GEAR ->
                identifier = Identifier(TechSuite.MOD_ID, material.prefix + type.suffix)
            IngredientType.PLATE ->
                identifier = Identifier(TechSuite.MOD_ID, material.prefix + type.suffix)
            IngredientType.NUGGET ->
                identifier = Identifier(TechSuite.MOD_ID, material.prefix + type.suffix)
        }

        return Registry.register(Registry.ITEM, identifier, Item(Item.Settings()))
    }
}