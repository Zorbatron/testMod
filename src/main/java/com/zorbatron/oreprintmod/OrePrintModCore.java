package com.zorbatron.oreprintmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.zorbatron.orePrintMod.Tags;
import com.zorbatron.oreprintmod.common.CommonProxy;

import gregtech.GTInternalTags;

@Mod(modid = OrePrintModCore.MODID,
     version = OrePrintModCore.VERSION,
     name = OrePrintModCore.NAME,
     acceptedMinecraftVersions = "[1.12.2]",
     dependencies = GTInternalTags.DEP_VERSION_STRING)
public class OrePrintModCore {

    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    @SidedProxy(modId = MODID,
                serverSide = "com.zorbatron.oreprintmod.common.CommonProxy",
                clientSide = "com.zorbatron.oreprintmod.client.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
