package lumbr.HighTechArcana.lists;

import lumbr.HighTechArcana.HighTechArcana;
import lumbr.HighTechArcana.entities.BlazeKing;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;

@SuppressWarnings("unused")
public class EntityList
{
	
	
	@SuppressWarnings("unchecked")
	public static final EntityType<BlazeKing> blaze_king = (EntityType<BlazeKing>) EntityType.Builder.create(BlazeKing::new, EntityClassification.MONSTER).build(HighTechArcana.modid + ":blaze_king").setRegistryName(HighTechArcana.RegistryEvents.location("blaze_king"));
	
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			ItemList.blaze_king_egg = registerEntitySpawnEgg(blaze_king, 0xff9900, 0xff3c00, "blaze_king_egg")
				
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		//registerEntityWorldSpawn(BLAZE_KING, EntityClassification.CREATURE, Biome<>);
	}
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(HighTechArcana.arcana));
		item.setRegistryName(HighTechArcana.RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification ,Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				//biome.getMobSpawnInfo().getSpawners(classification).add(new MobSpawnInfo.Spawners(entity, 10, 1,1));
				
			}
		}
	}
}
