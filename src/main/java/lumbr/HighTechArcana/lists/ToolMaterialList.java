package lumbr.HighTechArcana.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	mcchicken(10f,9f,800,3,25,ItemList.mcchicken);
	
	
	
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}
	@Override
	public int getMaxUses()
	{
		// TODO Auto-generated method stub
		return this.durability;
	}
	@Override
	public float getEfficiency()
	{
		// TODO Auto-generated method stub
		return this.efficiency;
	}
	@Override
	public float getAttackDamage()
	{
		// TODO Auto-generated method stub
		return this.attackDamage;
	}
	@Override
	public int getHarvestLevel()
	{
		// TODO Auto-generated method stub
		return this.harvestLevel;
	}
	@Override
	public int getEnchantability()
	{
		// TODO Auto-generated method stub
		return this.enchantability;
	}
	@Override
	public Ingredient getRepairMaterial()
	{
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairMaterial);
	}
}
