package com.mikenyes.resourcefulspiders.client.render.entity.models;

import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpiderEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ResourcefulSpiderModel<T extends ResourcefulSpiderEntity> extends AgeableModel<T> {
	private final ModelRenderer rightlegs;
	private final ModelRenderer leftlegs;
	private final ModelRenderer spider;
	private final int textureWidth;
	private final int textureHeight;

	public ResourcefulSpiderModel() {
		textureWidth = 64;
		textureHeight = 64;

		rightlegs = new ModelRenderer(this);
		rightlegs.setPos(-8.0F, 24.0F, 2.0F);
		rightlegs.texOffs(0, 12).addBox(-1.5F, -2.5F, -4.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.texOffs(0, 16).addBox(-1.5F, -2.75F, -0.75F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.texOffs(0, 18).addBox(-1.5F, -2.5F, 1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.texOffs(0, 14).addBox(-1.5F, -2.75F, -2.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leftlegs = new ModelRenderer(this);
		leftlegs.setPos(1.0F, 22.0F, 2.5F);
		leftlegs.texOffs(18, 12).addBox(0.5F, -0.5F, -4.75F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.texOffs(18, 14).addBox(0.5F, -0.75F, -3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.texOffs(18, 16).addBox(0.5F, -0.75F, -1.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.texOffs(18, 18).addBox(0.5F, -0.5F, 0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spider = new ModelRenderer(this);
		spider.setPos(0.0F, 24.0F, 0.0F);
		spider.texOffs(0, 0).addBox(-3.0F, -6.0F, 1.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);
		spider.texOffs(26, 0).addBox(-2.5F, -5.25F, -4.75F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		spider.texOffs(0, 0).addBox(-1.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		spider.texOffs(0, 3).addBox(0.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rightlegs.render(matrixStack, buffer, packedLight, packedOverlay);
		leftlegs.render(matrixStack, buffer, packedLight, packedOverlay);
		spider.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return null;
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return null;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}