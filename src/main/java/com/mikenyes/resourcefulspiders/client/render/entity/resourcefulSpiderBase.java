// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class resourcefulSpiderBase extends EntityModel<Entity> {
	private final ModelRenderer rightlegs;
	private final ModelRenderer leftlegs;
	private final ModelRenderer bb_main;

	public resourcefulSpiderBase() {
		textureWidth = 64;
		textureHeight = 64;

		rightlegs = new ModelRenderer(this);
		rightlegs.setRotationPoint(-8.0F, 24.0F, 2.0F);
		rightlegs.setTextureOffset(0, 12).addBox(-1.5F, -2.5F, -4.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.setTextureOffset(0, 16).addBox(-1.5F, -2.75F, -0.75F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.setTextureOffset(0, 18).addBox(-1.5F, -2.5F, 1.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		rightlegs.setTextureOffset(0, 14).addBox(-1.5F, -2.75F, -2.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leftlegs = new ModelRenderer(this);
		leftlegs.setRotationPoint(1.0F, 22.0F, 2.5F);
		leftlegs.setTextureOffset(18, 12).addBox(0.5F, -0.5F, -4.75F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.setTextureOffset(18, 14).addBox(0.5F, -0.75F, -3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.setTextureOffset(18, 16).addBox(0.5F, -0.75F, -1.25F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		leftlegs.setTextureOffset(18, 18).addBox(0.5F, -0.5F, 0.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, 1.0F, 6.0F, 5.0F, 7.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 0).addBox(-2.5F, -5.25F, -4.75F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 3).addBox(0.5F, -2.5F, -5.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rightlegs.render(matrixStack, buffer, packedLight, packedOverlay);
		leftlegs.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}