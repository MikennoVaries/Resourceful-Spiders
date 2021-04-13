package com.mikenyes.resourcefulspiders.client.render.entity.models;

import com.mikenyes.resourcefulspiders.entity.neutral.ResourcefulSpiderEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ResourcefulSpiderModel<T extends ResourcefulSpiderEntity> extends AgeableModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer back;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg7;
	private final ModelRenderer leg8;

	public ResourcefulSpiderModel() {
		super(false, 0.0F, 0.0f);
		texWidth = 64;
		texHeight = 64;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 24.0F, 0.0F);
		head.texOffs(0, 12).addBox(-2.5F, -5.25F, -4.75F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		head.texOffs(0, 3).addBox(-1.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(0.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		back = new ModelRenderer(this);
		back.setPos(0.0F, 24.0F, 0.0F);
		back.texOffs(0, 0).addBox(-3.0F, -6.0F, 1.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setPos(1.0F, 22.0F, 2.5F);
		leg1.texOffs(44, 4).addBox(-10.5F, -0.5F, 0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setPos(0.0F, 24.0F, 0.0F);
		leg2.texOffs(26, 6).addBox(1.5F, -2.5F, 3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setPos(0.0F, 24.0F, 0.0F);
		leg3.texOffs(44, 2).addBox(-9.5F, -2.75F, 1.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setPos(0.0F, 24.0F, 0.0F);
		leg4.texOffs(26, 4).addBox(1.5F, -2.75F, 1.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg5 = new ModelRenderer(this);
		leg5.setPos(0.0F, 24.0F, 0.0F);
		leg5.texOffs(44, 6).addBox(-9.5F, -2.75F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg6 = new ModelRenderer(this);
		leg6.setPos(0.0F, 24.0F, 0.0F);
		leg6.texOffs(26, 2).addBox(1.5F, -2.75F, -0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg7 = new ModelRenderer(this);
		leg7.setPos(0.0F, 24.0F, 0.0F);
		leg7.texOffs(44, 0).addBox(-9.5F, -2.5F, -2.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leg8 = new ModelRenderer(this);
		leg8.setPos(0.0F, 24.0F, 0.0F);
		leg8.texOffs(26, 0).addBox(1.5F, -2.5F, -2.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		back.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		leg5.render(matrixStack, buffer, packedLight, packedOverlay);
		leg6.render(matrixStack, buffer, packedLight, packedOverlay);
		leg7.render(matrixStack, buffer, packedLight, packedOverlay);
		leg8.render(matrixStack, buffer, packedLight, packedOverlay);
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