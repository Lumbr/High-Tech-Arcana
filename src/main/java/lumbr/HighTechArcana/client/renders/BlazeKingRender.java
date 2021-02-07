package lumbr.HighTechArcana.client.renders;
import lumbr.HighTechArcana.HighTechArcana;
import lumbr.HighTechArcana.client.models.BlazeKingModel;
import lumbr.HighTechArcana.entities.BlazeKing;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
@OnlyIn(Dist.CLIENT)
public class BlazeKingRender extends LivingRenderer<BlazeKing, BlazeKingModel>
{

	public BlazeKingRender(EntityRendererManager rendererManager)
	{
		super(rendererManager, new BlazeKingModel(), 0f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getEntityTexture(BlazeKing entity)
	{
		// TODO Auto-generated method stub
		return HighTechArcana.RegistryEvents.location("textures/entity/blaze_king.png");
	}
	public static class RenderFactory implements IRenderFactory<BlazeKing>
	{
		@Override
		public EntityRenderer<? super BlazeKing> createRenderFor(EntityRendererManager manager)
		{
			return new BlazeKingRender(manager);
		}
		
	}

}
