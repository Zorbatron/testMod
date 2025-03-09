package com.zorbatron.oreprintmod.common;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zorbatron.oreprintmod.OrePrintModCore;

public class CommonProxy {

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(OrePrintModCore.MODID)) {
            ConfigManager.sync(OrePrintModCore.MODID, Config.Type.INSTANCE);
        }
    }
}
