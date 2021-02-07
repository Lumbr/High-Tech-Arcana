package lumbr.HighTechArcana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lumbr.HighTechArcana.client.renders.ArcanaRenderRegistry;
import lumbr.HighTechArcana.config.Config;
import lumbr.HighTechArcana.entities.BlazeKing;
import lumbr.HighTechArcana.lists.ArmorMaterialList;
import lumbr.HighTechArcana.lists.BlockList;
import lumbr.HighTechArcana.lists.EntityList;
import lumbr.HighTechArcana.lists.ItemList;
import lumbr.HighTechArcana.lists.ToolMaterialList;
import lumbr.HighTechArcana.world.gen.OreGeneration;
import net.minecraft.block.Block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("hightecharcana")
public class HighTechArcana {

	
	
	public static HighTechArcana instance;
	public static final String modid = "hightecharcana";
	public static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup arcana = new ArcanaItemGroup();
	
	public HighTechArcana() {
		
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config, "hightecharcana-client.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config, "hightecharcana-server.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
		
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("hightecharcana-client.toml").toString());
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("hightecharcana-server.toml").toString());
	

	}
	private void setup(final FMLCommonSetupEvent event) 
	{
		BlazeKing.setCustomAttributes().create();
		OreGeneration.registerOre();
		logger.info("Setup method registered");
	}
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		ArcanaRenderRegistry.registryEntityRenders();
		logger.info("clientRegisteries method registered");
	}
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll(
					
					// Plain Items
					ItemList.mcchicken = new Item(new Item.Properties().group(arcana)).setRegistryName(location("mcchicken")),
					ItemList.unrefined_mana_shard = new Item(new Item.Properties().group(arcana)).setRegistryName(location("unrefined_mana_shard")),
					
					
					// Tool Items
					ItemList.mcchicken_axe = new AxeItem(ToolMaterialList.mcchicken, 2f, -3f, new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_axe")),
					ItemList.mcchicken_pickaxe = new PickaxeItem(ToolMaterialList.mcchicken, -2, -2.8f, new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_pickaxe")),
					ItemList.mcchicken_hoe = new HoeItem(ToolMaterialList.mcchicken, -4, 0f,new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_hoe")),
					ItemList.mcchicken_shovel = new ShovelItem(ToolMaterialList.mcchicken, -4, -3f,new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_shovel")),
					ItemList.mcchicken_sword = new SwordItem(ToolMaterialList.mcchicken, 0, -2.4f,new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_sword")),
					// Armour
					ItemList.mcchicken_helmet = new ArmorItem(ArmorMaterialList.mcchicken, EquipmentSlotType.HEAD , new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_helmet")),
					ItemList.mcchicken_chestplate = new ArmorItem(ArmorMaterialList.mcchicken, EquipmentSlotType.CHEST , new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_chestplate")),
					ItemList.mcchicken_leggings = new ArmorItem(ArmorMaterialList.mcchicken, EquipmentSlotType.LEGS , new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_leggings")),
					ItemList.mcchicken_boots = new ArmorItem(ArmorMaterialList.mcchicken, EquipmentSlotType.FEET , new Item.Properties().group(arcana)).setRegistryName(location("mcchicken_boots")),
					//BlockItems
					ItemList.mcchicken_block = new BlockItem(BlockList.mcchicken_block, new Item.Properties().group(arcana)).setRegistryName(BlockList.mcchicken_block.getRegistryName()),
					ItemList.mana_crystal_ore = new BlockItem(BlockList.mana_crystal_ore, new Item.Properties().group(arcana)).setRegistryName(BlockList.mana_crystal_ore.getRegistryName())
					
					
			);
			
			EntityList.registerEntitySpawnEggs(event);
			
			logger.info("Items registered");
		}
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll(
					//ItemList.mcchicken = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("mcchicken"))
					BlockList.mcchicken_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.FUNGUS)).setRegistryName(location("mcchicken_block")),
					BlockList.mana_crystal_ore = new Block(Block.Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(4.0f, 15.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)).setRegistryName(location("mana_crystal_ore"))
			);
			
			logger.info("Blocks registered");
		}
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
			event.getRegistry().registerAll
			(
					EntityList.blaze_king
					
			);
			
			//EntityList.registerEntityWorldSpawns();
		}
		
		public static ResourceLocation location(String name) 
		{
			
			return new ResourceLocation(modid, name);
			
		}
	}
}
