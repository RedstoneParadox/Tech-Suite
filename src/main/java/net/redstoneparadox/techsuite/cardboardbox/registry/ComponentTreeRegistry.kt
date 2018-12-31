package net.redstoneparadox.techsuite.cardboardbox.registry

import net.minecraft.util.Identifier
import net.redstoneparadox.techsuite.cardboardbox.gui.components.ComponentTree
import net.redstoneparadox.techsuite.cardboardbox.gui.components.LabelComponent
import net.redstoneparadox.techsuite.containerexample.ContainerMod

/**
 * Created by RedstoneParadox on 12/30/2018.
 */
object ComponentTreeRegistry {

    var componentTrees : ArrayList<ComponentTree> = ArrayList()

    var helloWorldTree : ComponentTree = ComponentTree(ContainerMod.EXAMPLE_CONTAINER)

    fun initTrees() {
        helloWorldTree.children.add(LabelComponent("Hello, world!", "hello_world", 20f, 20f))

        componentTrees.add(helloWorldTree)
    }

    fun getComponentTree(identifier: Identifier) : ComponentTree? {

        for (tree in componentTrees) {

            if (tree.identifier == identifier) {
                return tree
            }
        }

        return null
    }
}