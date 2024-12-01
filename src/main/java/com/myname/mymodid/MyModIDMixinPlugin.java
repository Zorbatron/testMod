package com.myname.mymodid;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.Name;

import org.jetbrains.annotations.Nullable;

import zone.rong.mixinbooter.IEarlyMixinLoader;

@Name("MyModIDMixinPlugin")
@MCVersion(ForgeVersion.mcVersion)
public class MyModIDMixinPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public List<String> getMixinConfigs() {
        System.out.println("Loading mymodid mixins!");

        return Collections.singletonList("mixins.mymodid.json");
    }
}
