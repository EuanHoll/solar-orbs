package com.euanh.solar_orbs.utils;


import com.euanh.solar_orbs.blocks.SolarOreBlock;
import com.euanh.solar_orbs.items.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = SolarStatics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class EventSubscriber {
	
	//Item Properties
	private static Item.Properties solar_orb_properties = new Item.Properties();
	private static Item.Properties lunar_orb_properties = new Item.Properties();
	
	//Block Properties
	private static Block.Properties solar_ore_properties = Block.Properties.create(Material.ROCK);
	private static Block.Properties lunar_ore_properties = Block.Properties.create(Material.ROCK);
	private static Block.Properties solar_block_properties = Block.Properties.create(Material.ROCK);
	private static Block.Properties lunar_block_properties = Block.Properties.create(Material.ROCK);
	
	//Items
	public static Item solar_orb = null;
	public static Item lunar_orb = null;
	private static Item solar_orb_shard = null;
	private static Item lunar_orb_shard = null;
	private static Item solar_wand = null;
	private static Item lunar_wand = null;
	
	//Blocks
	public static Block solar_ore = null;
	public static Block lunar_ore = null;
	private static Block solar_block = null;
	private static Block lunar_block = null;
	
	//ItemBlocks
	private static BlockItem solar_ore_bItem = null;
	private static BlockItem lunar_ore_bItem = null;
	private static BlockItem solar_block_bItem = null;
	private static BlockItem lunar_block_bItem = null;
	
	//ItemGroups
	private static final ItemGroup GROUP = new ModItemGroup(SolarStatics.MOD_ID, () -> new ItemStack(solar_orb));
	
	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event)
	{
		//Setting Item Properties
		solar_orb_properties = solar_orb_properties.group(GROUP);
		lunar_orb_properties = lunar_orb_properties.group(GROUP);
		
		//Creating Items
		solar_orb = new ItemSolarOrb(solar_orb_properties);
		lunar_orb = new ItemLunarOrb(lunar_orb_properties);
		solar_orb_shard = new Item(new Item.Properties().group(GROUP));
		lunar_orb_shard = new Item(new Item.Properties().group(GROUP));
		solar_wand = new ItemSolarWand(new Item.Properties().group(GROUP));
		lunar_wand = new ItemLunarWand(new Item.Properties().group(GROUP));
		
		//Creating Block Items
		solar_ore_bItem = new BlockItem(solar_ore, new Item.Properties().group(GROUP));
		lunar_ore_bItem = new BlockItem(lunar_ore, new Item.Properties().group(GROUP));
		solar_block_bItem = new BlockItem(solar_block, new Item.Properties().group(GROUP));
		lunar_block_bItem = new BlockItem(lunar_block, new Item.Properties().group(GROUP));
		
		//Registering Items
		event.getRegistry().registerAll(setup(solar_orb, "solar_orb"));
		event.getRegistry().registerAll(setup(lunar_orb, "lunar_orb"));
		event.getRegistry().registerAll(setup(solar_orb_shard, "solar_orb_shard"));
		event.getRegistry().registerAll(setup(lunar_orb_shard, "lunar_orb_shard"));
		event.getRegistry().registerAll(setup(solar_wand, "solar_wand"));
		event.getRegistry().registerAll(setup(lunar_wand, "lunar_wand"));
		
		//Registering Block Items
		event.getRegistry().registerAll(setup(solar_ore_bItem, "solar_ore"));
		event.getRegistry().registerAll(setup(lunar_ore_bItem, "lunar_ore"));
		event.getRegistry().registerAll(setup(solar_block_bItem, "solar_block"));
		event.getRegistry().registerAll(setup(lunar_block_bItem, "lunar_block"));
		
		SolarStatics.LOGGER.info("Registered Items");
	}
	
	@SubscribeEvent
	public static void onRegisterBlocks(Register<Block> event)
	{
		//Block Properties
		solar_ore_properties = solar_ore_properties.hardnessAndResistance(3f, 3f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(5);
		lunar_ore_properties = lunar_ore_properties.hardnessAndResistance(3f,  3f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(5);
		solar_block_properties = solar_block_properties.hardnessAndResistance(3f, 3f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(15);
		lunar_block_properties = lunar_block_properties.hardnessAndResistance(3f, 3f).harvestLevel(2).harvestTool(ToolType.PICKAXE).lightValue(15);

		//Creating Blocks
		solar_ore = new SolarOreBlock(solar_ore_properties);
		lunar_ore = new SolarOreBlock(lunar_ore_properties);
		solar_block = new Block(solar_block_properties);
		lunar_block = new Block(lunar_block_properties);
		
		//Registering Blocks
		event.getRegistry().registerAll(setup(solar_ore, "solar_ore"));
		event.getRegistry().registerAll(setup(lunar_ore, "lunar_ore"));
		event.getRegistry().registerAll(setup(solar_block, "solar_block"));
		event.getRegistry().registerAll(setup(lunar_block, "lunar_block"));
	
		SolarStatics.LOGGER.info("Registered Blocks");
	}

	@SubscribeEvent
	public static void onCommonSetup(final FMLCommonSetupEvent event)
	{
		OreGeneration.SetupOres();
		SolarStatics.LOGGER.info("Registered Generators");
	}
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(SolarStatics.MOD_ID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
	
}
