package net.redstoneparadox.techsuite.client.mixin;

import net.minecraft.client.gui.ContainerGui;
import net.minecraft.client.gui.Gui;
import net.minecraft.container.Slot;
import net.redstoneparadox.techsuite.cardboardbox.hooks.IContainerGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by RedstoneParadox on 12/31/2018.
 */
@Mixin(ContainerGui.class)
public class ContainerGuiMixin extends Gui implements IContainerGui {

    @Shadow
    private void drawSlot(Slot slot_1) {

    }

    @Override
    public void drawContainerSlot(Slot slot) {
        drawSlot(slot);
    }

}
