package lumbr.HighTechArcana;

import lumbr.HighTechArcana.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArcanaItemGroup extends ItemGroup
{

	public ArcanaItemGroup()
	{
		super("arcana");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon()
	{
		// TODO Auto-generated method stub
		return new ItemStack(ItemList.mana_crystal_ore);
	}

}
