package com.zorbatron.oreprintmod.common;

import net.minecraftforge.common.config.Config;

import com.zorbatron.oreprintmod.OrePrintModCore;

@Config(modid = OrePrintModCore.MODID)
public class OrePrintModConfig {

    @Config.Name("Write the ore dict names")
    @Config.RequiresMcRestart
    @Config.Comment({ "Whether or not to actually write the names to the file",
            "Default: false" })
    public static boolean writeOreDictNames = false;

    @Config.Name("Path to the text file")
    @Config.RequiresMcRestart
    @Config.Comment({ "The path of the file to write to",
            "Default: \"/tmp/OreDict for material ore blocks.txt\"" })
    public static String filePath = "/tmp/OreDict for material ore blocks.txt";
}
