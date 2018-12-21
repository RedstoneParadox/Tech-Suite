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
    lateinit var ingotCopper: Item
    lateinit var ingotTin: Item
    //Gears
    lateinit var gearStone: Item
    lateinit var gearIron: Item
    lateinit var gearGold: Item
    lateinit var gearCopper: Item
    lateinit var gearTin: Item

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
        ingotCopper = registerItem(IngredientMaterial.COPPER, IngredientType.INGOT)
        ingotTin = registerItem(IngredientMaterial.TIN, IngredientType.INGOT)
        //Gears
        gearStone = registerItem(IngredientMaterial.STONE, IngredientType.GEAR)
        gearIron = registerItem(IngredientMaterial.IRON, IngredientType.GEAR)
        gearGold = registerItem(IngredientMaterial.GOLD, IngredientType.GEAR)
        gearCopper = registerItem(IngredientMaterial.COPPER, IngredientType.GEAR)
        gearTin = registerItem(IngredientMaterial.TIN, IngredientType.GEAR)
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