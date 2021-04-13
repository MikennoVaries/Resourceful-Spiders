package com.mikenyes.resourcefulspiders.registry;

import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpiderEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModEntities {

    private static final Map<String, RegistryObject<EntityType<? extends ResourcefulSpiderEntity>>> MOD_SPIDERS = new HashMap<>();

    public static Map<String, RegistryObject<EntityType<? extends ResourcefulSpiderEntity>>> getModSpiders() {
        return MOD_SPIDERS;
    }
}
