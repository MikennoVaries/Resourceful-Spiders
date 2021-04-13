package com.mikenyes.resourcefulspiders;

import com.mikenyes.resourcefulspiders.init.ModSetup;
import com.mikenyes.resourcefulspiders.init.SpiderSetup;
import com.mikenyes.resourcefulspiders.registry.RegistryHandler;
import com.mikenyes.resourcefulspiders.registry.SpiderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("resourcefulspiders")
public class ResourcefulSpiders {

    public static final String MOD_ID = "resourcefulspiders";

    public static final Logger LOGGER = LogManager.getLogger();

    public ResourcefulSpiders() {
        ModSetup.initialize();
        RegistryHandler.init();
        SpiderRegistry.getRegistry().allowRegistration();
        SpiderSetup.setupSpiders();
        RegistryHandler.registerDynamicSpiders();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(RegistryHandler::addEntityAttributes);
    }
}