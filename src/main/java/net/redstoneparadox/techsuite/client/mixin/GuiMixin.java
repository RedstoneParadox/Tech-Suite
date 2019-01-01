package net.redstoneparadox.techsuite.client.mixin;

import net.minecraft.client.gui.Gui;
import net.redstoneparadox.techsuite.cardboardbox.hooks.IGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Created by RedstoneParadox on 1/1/2019.
 */
@Mixin(Gui.class)
public class GuiMixin implements IGui {

    @Inject(method = "draw", at = @At("HEAD"))
    public void draw(int int_1, int int_2, float float_1, CallbackInfo ci) {
        setup();
    }

    @Override
    public void setup() {

    }
}
