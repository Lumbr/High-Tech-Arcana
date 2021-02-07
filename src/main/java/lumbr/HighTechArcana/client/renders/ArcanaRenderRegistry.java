package lumbr.HighTechArcana.client.renders;


import lumbr.HighTechArcana.lists.EntityList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ArcanaRenderRegistry
{
	
	public static void registryEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityList.blaze_king, new BlazeKingRender.RenderFactory());
		
	}

}
