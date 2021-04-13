package com.mikenyes.resourcefulspiders.init;

import com.mikenyes.resourcefulspiders.api.CustomSpiderData;
import com.mikenyes.resourcefulspiders.client.render.entity.CustomSpiderRenderer;
import com.mikenyes.resourcefulspiders.registry.ModEntities;
import com.mikenyes.resourcefulspiders.registry.SpiderRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientEventHandlers {

    public static void clientStuff() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientEventHandlers::doClientStuff);
    }

    private static void doClientStuff(final FMLClientSetupEvent event) {
        ModEntities.getModSpiders().forEach((s, customSpider) -> RenderingRegistry.registerEntityRenderingHandler(customSpider.get(), manager -> {
            CustomSpiderData data = SpiderRegistry.getRegistry().getSpiderData(s);
            return new CustomSpiderRenderer(manager, data);
        }));
    }
}
