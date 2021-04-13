package com.mikenyes.resourcefulspiders.registry;

import com.mikenyes.resourcefulspiders.api.CustomSpiderData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpiderRegistry {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final SpiderRegistry INSTANCE = new SpiderRegistry();

    public static SpiderRegistry getRegistry() {
        return INSTANCE;
    }

    private final Map<String, CustomSpiderData> spiderInfo = new LinkedHashMap<>();
    private boolean allowRegistration;

    public void allowRegistration() {
        this.allowRegistration = true;
        LOGGER.info("Spider Registration Enabled...");
    }

    public void denyRegistration() {
        this.allowRegistration = false;
        LOGGER.info("Spider Registration Disabled...");
    }

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

    public CustomSpiderData getSpiderData(String key) {
        return spiderInfo.get(key);
    }
}
