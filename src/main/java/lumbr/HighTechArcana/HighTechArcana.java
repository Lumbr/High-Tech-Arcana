package lumbr.HighTechArcana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lumbr.HighTechArcana.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hightecharcana")
public class HighTechArcana {

	
	
	public static HighTechArcana instance;
	public static final String modid = "hightecharcana";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public HighTechArcana() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	

	}
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered");
	}
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("clientRegisteries method registered");
	}
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
					ItemList.mcchicken = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("mcchicken"))
			);
			
			logger.info("Items registered");
		}
		private static ResourceLocation location(String name) {
			
			return new ResourceLocation(modid, name);
			
		}
	}
}
