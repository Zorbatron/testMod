package com.myname.mymodid.mixins;

import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = BlockTallGrass.class, remap = false)
public class TestMixin {

    @ModifyArg(method = "getDrops",
               at = @At(value = "INVOKE", target = "Lnet/minecraft/util/NonNullList;add(Ljava/lang/Object;)Z"))
    public Object getDrops(Object par1) {
        return new ItemStack(Blocks.DIAMOND_BLOCK);
    }
}
