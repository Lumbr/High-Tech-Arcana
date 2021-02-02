package lumbr.HighTechArcana.lists;

import lumbr.HighTechArcana.HighTechArcana;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	mcchicken("mcchicken", 400, new int[] {8,10,9,7}, 25, ItemList.mcchicken, "block.bell.use" , 0.0f, 1.0f);
	
	public static final int[] max_damage_array = new int[] {13,15,16,11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	private float knockbackResistance;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness, float knockbackResistance) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
	}
	@Override
	public int getDurability(EquipmentSlotType slot)
	{
		// TODO Auto-generated method stub
		return max_damage_array[slot.getIndex()] * this.durability;
	}
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot)
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}
	@Override
	public int getEnchantability()
	{
		// TODO Auto-generated method stub
		return this.enchantability;
	}
	@Override
	public SoundEvent getSoundEvent()
	{
		// TODO Auto-generated method stub
		return new SoundEvent(new ResourceLocation(equipSound));
	}
	@Override
	public Ingredient getRepairMaterial()
	{
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairItem);
	}
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return HighTechArcana.modid + ":" + this.name;
	}
	@Override
	public float getToughness()
	{
		// TODO Auto-generated method stub
		return this.toughness;
	}
	@Override
	public float getKnockbackResistance()
	{
		// TODO Auto-generated method stub
		return this.knockbackResistance;
	}
}
