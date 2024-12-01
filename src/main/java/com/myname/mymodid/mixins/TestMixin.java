package com.myname.mymodid.mixins;

import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = BehaviorDefaultDispenseItem.class)
public class TestMixin {

    @ModifyArgs(method = "dispenseStack",
                at = @At(value = "INVOKE",
                         target = "Lnet/minecraft/dispenser/BehaviorDefaultDispenseItem;doDispense(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;ILnet/minecraft/util/EnumFacing;Lnet/minecraft/dispenser/IPosition;)V"))
    private void changeItem(Args args) {
        ItemStack original = args.get(1);
        if (original.isItemEqual(new ItemStack(Blocks.DIAMOND_BLOCK))) {
            args.set(1, new ItemStack(Blocks.DIRT));
        }
    }
}
