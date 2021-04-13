package com.mikenyes.resourcefulspiders.api;

public class SpiderData {


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

    public SpiderData() {

    }
}
