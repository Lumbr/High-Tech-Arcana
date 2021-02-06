package lumbr.HighTechArcana.client.renders;
import lumbr.HighTechArcana.client.models.BlazeKingModel;
import lumbr.HighTechArcana.entities.BlazeKing;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
public class BlazeKingRender extends LivingRenderer<BlazeKing, BlazeKingModel>
{

	public BlazeKingRender(EntityRendererManager rendererManager, BlazeKingModel entityModelIn, float shadowSizeIn)
	{
		super(rendererManager, entityModelIn, shadowSizeIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getEntityTexture(BlazeKing entity)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
