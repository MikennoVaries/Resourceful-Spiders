package com.mikenyes.resourcefulspiders.registry;

import com.mikenyes.resourcefulspiders.api.CustomSpiderData;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpiderRegistry {
    private static final SpiderRegistry INSTANCE = new SpiderRegistry();

    public static SpiderRegistry getRegistry() {
        return INSTANCE;
    }

    private final Map<String, CustomSpiderData> spiderInfo = new LinkedHashMap<>();
    private boolean allowRegistration;

    public boolean registerSpider(String spiderType, CustomSpiderData customSpiderData) {
        if (allowRegistration && !spiderInfo.containsKey(spiderType)) {
            spiderInfo.put(spiderType, customSpiderData);
            return true;
        }
        return false;
    }

    public Map<String, CustomSpiderData> getSpiders() {
        return Collections.unmodifiableMap(spiderInfo);
    }
}
