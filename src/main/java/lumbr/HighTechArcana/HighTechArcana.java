package lumbr.HighTechArcana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lumbr.HighTechArcana.lists.ArmorMaterialList;
import lumbr.HighTechArcana.lists.BlockList;
import lumbr.HighTechArcana.lists.ItemList;
import lumbr.HighTechArcana.lists.ToolMaterialList;
import net.minecraft.block.Block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
	
	public static final ItemGroup arcana = new ArcanaItemGroup();
	
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
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll(
					
					// Plain Items
					ItemList.mcchicken = new Item(new Item.Properties().group(arcana)).setRegistryName(location("mcchicken")),
					
					
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
			
			logger.info("Items registered");
		}
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll(
					//ItemList.mcchicken = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("mcchicken"))
					BlockList.mcchicken_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.FUNGUS)).setRegistryName(location("mcchicken_block")),
					BlockList.mana_crystal_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).setRegistryName(location("mana_crystal_ore"))
			);
			
			logger.info("Blocks registered");
		}
		private static ResourceLocation location(String name) {
			
			return new ResourceLocation(modid, name);
			
		}
	}
}
