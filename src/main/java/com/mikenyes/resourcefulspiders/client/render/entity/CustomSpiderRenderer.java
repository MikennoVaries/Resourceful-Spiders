package com.mikenyes.resourcefulspiders.client.render.entity;

import com.mikenyes.resourcefulspiders.api.CustomSpiderData;
import com.mikenyes.resourcefulspiders.client.render.entity.models.ResourcefulSpiderModel;
import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class CustomSpiderRenderer extends MobRenderer<ResourcefulSpiderEntity, ResourcefulSpiderModel<ResourcefulSpiderEntity>> {

    CustomSpiderData data;

    public CustomSpiderRenderer(EntityRendererManager manager, CustomSpiderData data) {
        super(manager, new ResourcefulSpiderModel(), 0.4f);
        this.data = data;
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull ResourcefulSpiderEntity entity) {
        return data.getBaseTexture();
    }
}
