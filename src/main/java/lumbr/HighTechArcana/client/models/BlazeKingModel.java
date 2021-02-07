package lumbr.HighTechArcana.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import lumbr.HighTechArcana.entities.BlazeKing;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class BlazeKingModel extends EntityModel<BlazeKing>
{

	private final ModelRenderer bone;
	private final ModelRenderer Head;
	private final ModelRenderer Crown;
	private final ModelRenderer Body;
	private final ModelRenderer Body2;
	private final ModelRenderer Shields;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public BlazeKingModel() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.5F, -16.5F, 0.5F);
		bone.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		Crown = new ModelRenderer(this);
		Crown.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Crown);
		Crown.setTextureOffset(35, 12).addBox(1.5F, -2.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(12, 36).addBox(-1.5F, -3.5F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(20, 13).addBox(0.5F, -3.5F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(8, 36).addBox(-3.5F, -3.5F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(4, 36).addBox(-3.5F, -3.5F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(0, 36).addBox(-3.5F, -3.5F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(35, 30).addBox(-3.5F, -3.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(28, 34).addBox(-1.5F, -3.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(24, 34).addBox(0.5F, -3.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(20, 34).addBox(2.5F, -3.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(32, 28).addBox(2.5F, -3.5F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(28, 13).addBox(2.5F, -3.5F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(24, 13).addBox(2.5F, -3.5F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 14).addBox(-0.5F, -2.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 10).addBox(-2.5F, -2.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 8).addBox(-3.5F, -2.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 6).addBox(-3.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 4).addBox(-3.5F, -2.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 2).addBox(-2.5F, -2.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(36, 0).addBox(-0.5F, -2.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(35, 36).addBox(1.5F, -2.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(35, 27).addBox(2.5F, -2.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Crown.setTextureOffset(35, 22).addBox(2.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		Crown.setTextureOffset(35, 17).addBox(2.5F, -2.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -10.0F, 0.0F);
		bone.addChild(Body);
		Body.setTextureOffset(16, 34).addBox(2.0F, -1.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(32, 13).addBox(2.0F, -1.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(32, 23).addBox(5.0F, -3.0F, 4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(32, 32).addBox(5.0F, -3.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(32, 18).addBox(0.0F, 1.0F, 5.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(28, 29).addBox(0.0F, 3.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, -10.0F, 0.0F);
		bone.addChild(Body2);
		Body2.setTextureOffset(24, 29).addBox(-5.0F, -1.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(20, 29).addBox(-3.0F, -4.0F, -6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(16, 29).addBox(-5.0F, -4.0F, 4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(16, 10).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(15, 0).addBox(-1.0F, 2.0F, 2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(0, 0).addBox(-1.0F, 1.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Shields = new ModelRenderer(this);
		Shields.setRotationPoint(0.5F, -14.0F, 0.5F);
		bone.addChild(Shields);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5F, 5.0F, -9.5F);
		Shields.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.4363F, 3.1416F, 0.0F);
		cube_r1.setTextureOffset(16, 16).addBox(-3.5F, -6.0F, -0.5F, 7.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(9.5F, 5.0F, -0.5F);
		Shields.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.4363F, -1.5708F, 0.0F);
		cube_r2.setTextureOffset(20, 0).addBox(-3.5F, -6.0F, -0.5F, 7.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-9.0F, 5.0F, 0.0F);
		Shields.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.4363F, 1.5708F, 0.0F);
		cube_r3.setTextureOffset(0, 10).addBox(-3.5F, -6.0F, -0.5F, 7.0F, 12.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 5.0F, 8.0F);
		Shields.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.4363F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(0, 23).addBox(-3.5F, -6.0F, -0.5F, 7.0F, 12.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(BlazeKing entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch)
	{
		// TODO Auto-generated method stub
		
	}

}
