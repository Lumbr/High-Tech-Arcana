package lumbr.HighTechArcana.world.gen;

import java.util.ArrayList;

import lumbr.HighTechArcana.HighTechArcana;
import lumbr.HighTechArcana.lists.BlockList;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGeneration
{
	
	private static final ArrayList<ConfiguredFeature<?,?>> overworldOres = new ArrayList<ConfiguredFeature<?,?>>();
	private static final ArrayList<ConfiguredFeature<?,?>> netherOres = new ArrayList<ConfiguredFeature<?,?>>();
	private static final ArrayList<ConfiguredFeature<?,?>> endOres = new ArrayList<ConfiguredFeature<?,?>>();
	
	public static void registerOre()
	{
		overworldOres.add(register("mana_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockList.mana_crystal_ore.getDefaultState(), 6))
				.range(64).square() // height at which it begins to spawn
				.func_242731_b(10) // how many veins per chunk
				
				));
	}
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void gen(BiomeLoadingEvent event)
	{
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if(event.getCategory().equals(Biome.Category.NETHER))
		{
			for(ConfiguredFeature<?,?> ore : netherOres)
			{
				if(ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
		if(event.getCategory().equals(Biome.Category.THEEND))
		{
			for(ConfiguredFeature<?,?> ore : endOres)
			{
				if(ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
			}
		}
		
		for(ConfiguredFeature<?,?> ore : overworldOres)
		{
			if(ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
		}
		
	}
	
	
	private static <FC extends IFeatureConfig> ConfiguredFeature <FC, ?> register (String name, ConfiguredFeature <FC , ?> configuredFeature) 
	{
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, HighTechArcana.modid + ":" + name, configuredFeature);
	}
}
