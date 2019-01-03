package net.redstoneparadox.techsuite.cardboardbox.gui

import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.cardboardbox.gui.nodes.GuiNode

/**
 * Created by RedstoneParadox on 1/2/2019.
 */

/**
 * Helper class for building Gui Trees.
 *
 * @param identifier The identifier for the built tree.
 */
class GuiTreeBuilder(val identifier: Identifier) {

    private val tree : GuiTree = GuiTree(identifier)

    /**
     * Adds a node to the root of the tree.
     *
     * @param node the node to add.
     */
    fun addNode(node : GuiNode) : GuiTreeBuilder {
        tree.children.add(node)
        return this
    }

    /**
     * Adds a node as a child of the node specified in the path.
     *
     * @param node the node to add.
     * @param path the path of the parent node in the tree.
     */
    fun addNode(node : GuiNode, path : String) {
        TODO("Figure out how paths will work.")
    }

    /**
     * Creates a grid of the same type of node.
     *
     * @param node the node to add to the the tree and be copied into a grid.
     * @param rows the number of rows in the grid.
     * @param columns the number of columns in the grid.
     * @param rowSize the height of each row.
     * @param columnSize the width of each column.
     */
    fun addNodeGrid(node: GuiNode, rows : Int, columns : Int, rowSize : Float, columnSize : Float) : GuiTreeBuilder {
        var iteration : Int = 0

        for (j in 0 until rows) {

            for (i in 0 until columns) {

                if (iteration == 0) {
                    node.name = node.name + "_0"
                    tree.children.add(node)
                    iteration = 1
                }
                else {
                    tree.children.add(node.createGridCopy((columnSize * i), (rowSize * j), iteration))
                    iteration += 1
                }
            }
        }

        return this
    }

    /**
     * Creates a grid of the same type of node as children of the node specified in the path.
     *
     * @param node the node to add to the the tree and be copied into a grid.
     * @param rows the number of rows in the grid.
     * @param columns the number of columns in the grid.
     * @param rowSize the height of each row.
     * @param columnSize the width of each column.
     * @param path the path of the parent node in the tree.
     */
    fun addNodeGrid(node: GuiNode, rows : Int, columns : Int, rowSize : Float, columnSize : Float, path: String) {
        TODO("Figure out how paths will work.")
    }

    /**
     * Builds the tree.
     */
    fun build() : GuiTree {
        return tree
    }
}