package com.zorbatron.oreprintmod.mixins;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.sugar.Local;
import com.zorbatron.oreprintmod.common.OrePrintModConfig;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;

@Mixin(value = Material.Builder.class, remap = false)
public class OrePrintMixin {

    @Unique
    private static PrintStream testMod$printStream;

    @Unique
    private static void testMod$printOre(String name) {
        if (testMod$printStream == null) {
            try {
                File file = new File(OrePrintModConfig.filePath);
                if (!file.exists() || file.delete()) {
                    file.createNewFile();
                }
                testMod$printStream = new PrintStream(new FileOutputStream(file));
                System.out.println("REWRITING ORE NAMES!!!!!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String[] parts = name.split("_");
        StringBuilder formatted = new StringBuilder();
        formatted.append("ore");
        for (String str : parts) {
            formatted.append(Character.toUpperCase(str.charAt(0)))
                    .append(str.substring(1));
        }

        testMod$printStream.println(formatted);
    }

    @Inject(method = "build", at = @At(value = "RETURN"))
    private void injectPrint(CallbackInfoReturnable<Material> cir, @Local Material mat) {
        if (!OrePrintModConfig.writeOreDictNames) return;

        if (mat.hasProperty(PropertyKey.ORE)) {
            testMod$printOre(mat.getResourceLocation().getPath());
        }
    }
}
