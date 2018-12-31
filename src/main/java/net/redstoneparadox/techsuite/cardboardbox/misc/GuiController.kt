package net.redstoneparadox.techsuite.cardboardbox.misc

import net.minecraft.client.gui.Gui
import net.minecraft.entity.player.PlayerEntity

/**
 * Created by RedstoneParadox on 12/30/2018.
 */

/**
 * Interface to allow another class to control the GUI. Use if you need to control the GUI from a specific instance of
 * another class, otherwise extend the GUI itself and write your control code there.
 */
interface GuiController {

    /**
     * The method used by the gui to pass itself to the controller; override this to store the gui in the controller and
     * attach the ComponentTree to the gui.
     *
     *@param gui the GUI that gets passed in.
     * @param player the player that opened the GUI.
     */
    fun initController(gui: Gui, player : PlayerEntity)

}

