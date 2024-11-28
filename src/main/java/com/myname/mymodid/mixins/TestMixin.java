package com.myname.mymodid.mixins;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandTP;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = CommandTP.class)
public abstract class TestMixin extends CommandBase {

    @Redirect(method = "execute",
              at = @At(value = "INVOKE_ASSIGN",
                      target = "Lnet/minecraft/command/CommandTP;parseCoordinate(DLjava/lang/String;Z)Lnet/minecraft/command/CommandBase$CoordinateArg;",
                       ordinal = 1))
    private CoordinateArg moveOneUp(CommandTP self, double posZ, String arg, boolean centerBlock) {
        return null;
    }
}
