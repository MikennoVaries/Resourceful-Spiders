package com.mikenyes.resourcefulspiders.registry;

import com.mikenyes.resourcefulspiders.ResourcefulSpiders;
import com.mikenyes.resourcefulspiders.api.CustomSpiderData;
import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpiderEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ResourcefulSpiders.MOD_ID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ENTITY_TYPES.register(bus);
    }

    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        ModEntities.getModSpiders().forEach((s, customBee) -> event.put(customBee.get(), ResourcefulSpiderEntity.createSpiderAttributes(s).build()));
    }

    public static void registerDynamicSpiders() {
        SpiderRegistry.getRegistry().getSpiders().forEach((name, customSpider) -> {
            registerSpider(name, customSpider);
        });
    }

    private static void registerSpider(String name, CustomSpiderData customSpiderData) {
        final RegistryObject<EntityType<? extends ResourcefulSpiderEntity>> customSpiderEntity = ENTITY_TYPES.register(name + "_spider", () -> EntityType.Builder
                .<ResourcefulSpiderEntity>of((type, world) -> new ResourcefulSpiderEntity(type, world, customSpiderData), EntityClassification.CREATURE)
                .sized(0.7F * customSpiderData.getSizeModifier(), 0.6F * customSpiderData.getSizeModifier())
                .build(name + "_spider"));
/*
        final RegistryObject<Item> customSpiderSpawnEgg = ModItems.ITEMS.register(name + "_spider_spawn_egg",
                () -> new SpiderSpawnEggItem(customSpiderEntity, Color.parseInt(SpiderConstants.VANILLA_SPIDER_COLOR), 0x303030, customSpiderData.getColorData(), new Item.Properties().tab(ItemGroupResourcefulSpiders.RESOURCEFUL_SPIDERS)));
*/
        ModEntities.getModSpiders().put(name, customSpiderEntity);
        customSpiderData.setEntityTypeRegistryID(customSpiderEntity.getId());
//        customSpiderData.setSpawnEggItemRegistryObject(customSpiderSpawnEgg);
    }
}
