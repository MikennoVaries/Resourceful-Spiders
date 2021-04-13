package com.mikenyes.resourcefulspiders.client.render.entity;

import com.mikenyes.resourcefulspiders.client.render.entity.models.ResourcefulSpiderEntity;
import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpider;
import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.state.StateHolder;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

public class CustomSpiderRenderer extends MobRenderer<ResourcefulSpider, ResourcefulSpiderEntity<ResourcefulSpider>> {

    public CustomSpiderRenderer(EntityRendererManager manager) {
        super(manager, new ResourcefulSpiderEntity(), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(ResourcefulSpider p_110775_1_) {
        return null;
    }
}
