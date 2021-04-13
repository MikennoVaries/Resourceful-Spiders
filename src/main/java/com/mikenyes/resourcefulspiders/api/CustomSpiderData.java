package com.mikenyes.resourcefulspiders.api;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class CustomSpiderData {


    // custom model data

    // textures
    private String baseModelTexture = "custom_spider/base_texture";
    private String primaryLayerTexture = "custom_spider/primary_texture";
    private String secondaryLayerTexture = "custom_spider/secondary_texture";
    private String emissiveLayerTexture = "custom_spider/emissive_texture";

    // colors
    private String primaryColor = "#FFFFFF";
    private String secondaryColor = "#FFFFFF";
    private String emissiveColor = "#FFFFFF";

    // is rainbow (per part)
    private boolean isPrimaryRainbow = false;
    private boolean isSecondaryRainbow = false;
    private boolean isEmissiveRainbow = false;

    // does emissive layer show
    private boolean isEmissive = false;

    // model types
    private ModelType modelType = ModelType.DEFAULT;
    private ExtraModelType extraModelType = ExtraModelType.NONE;

    // combat stats
    private int baseHealth = 10;
    private int baseDamage = 4;

    public CustomSpiderData() {

    }

    public void setName(String name) {

    }

    public float getSizeModifier() {
        return 1.0f;
    }

    public void setEntityTypeRegistryID(ResourceLocation id) {
    }

    public void setSpawnEggItemRegistryObject(RegistryObject<Item> customSpiderSpawnEgg) {
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}
