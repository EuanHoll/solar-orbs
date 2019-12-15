package com.euanh.solar_orbs.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public class WandToolMaterial implements IItemTier{

	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	public WandToolMaterial(int durability, Item repairMaterial) 
	{
		this.attackDamage = 2f;
		this.efficiency = 2f;
		this.durability = durability;
		this.harvestLevel = 2;
		this.enchantability = 0;
		this.repairMaterial = repairMaterial;
	}
	
	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}

}
