package com.mikenyes.resourcefulspiders;

import com.mikenyes.resourcefulspiders.init.ModSetup;
import com.mikenyes.resourcefulspiders.init.SpiderSetup;
import com.mikenyes.resourcefulspiders.registry.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("resourcefulspiders")
public class ResourcefulSpiders {

    public static final String MOD_ID = "resourcefulspiders";

    public static final Logger LOGGER = LogManager.getLogger();

    public ResourcefulSpiders() {
        ModSetup.initialize();
        SpiderSetup.setupSpiders();
        RegistryHandler.registerDynamicSpiders();
    }
}