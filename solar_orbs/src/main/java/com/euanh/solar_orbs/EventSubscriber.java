package com.euanh.solar_orbs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = SolarStatics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class EventSubscriber {
	
	//Item Properties
	private static Item.Properties solar_orb_properties = new Item.Properties();
	private static Item.Properties lunar_orb_properties = new Item.Properties();
	
	//Block Properties
	private static Block.Properties solar_ore_properties = Block.Properties.create(Material.ROCK);
	private static Block.Properties lunar_ore_properties = Block.Properties.create(Material.ROCK);
	
	//Items
	private static Item solar_orb = null;
	private static Item lunar_orb = null;
	private static Item solar_orb_shard = null;
	private static Item lunar_orb_shard = null;
	
	//Blocks
	private static Block solar_ore = null;
	private static Block lunar_ore = null;
	
	//ItemBlocks
	private static BlockItem solar_ore_bItem = null;
	private static BlockItem lunar_ore_bItem = null;
	
	//ItemGroups
	private static final ItemGroup GROUP = new ModItemGroup(SolarStatics.MOD_ID, () -> new ItemStack(solar_orb));
	
	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event)
	{
		//Setting Item Properties
		solar_orb_properties = solar_orb_properties.group(GROUP);
		lunar_orb_properties = lunar_orb_properties.group(GROUP);
		
		//Creating Items
		solar_orb = new Item(solar_orb_properties);
		lunar_orb = new Item(lunar_orb_properties);
		solar_orb_shard = new Item(new Item.Properties().group(GROUP));
		lunar_orb_shard = new Item(new Item.Properties().group(GROUP));
		solar_ore_bItem = new BlockItem(solar_ore, new Item.Properties().group(GROUP));
		lunar_ore_bItem = new BlockItem(lunar_ore, new Item.Properties().group(GROUP));
		
		//Registering Items
		event.getRegistry().registerAll(setup(solar_orb, "solar_orb"));
		event.getRegistry().registerAll(setup(lunar_orb, "lunar_orb"));
		event.getRegistry().registerAll(setup(solar_orb_shard, "solar_orb_shard"));
		event.getRegistry().registerAll(setup(lunar_orb_shard, "lunar_orb_shard"));
		event.getRegistry().registerAll(setup(solar_ore_bItem, "solar_ore"));
		event.getRegistry().registerAll(setup(lunar_ore_bItem, "lunar_ore"));
		
		SolarStatics.LOGGER.debug("Registered Items");
	}
	
	@SubscribeEvent
	public static void onRegisterBlocks(Register<Block> event)
	{
		//Block Properties
		solar_ore_properties = solar_ore_properties.hardnessAndResistance(3f, 3f);
		lunar_ore_properties = lunar_ore_properties.hardnessAndResistance(3f,  3f);
		
		//Creating Blocks
		solar_ore = new Block(solar_ore_properties);
		lunar_ore = new Block(lunar_ore_properties);
		
		//Registering Blocks
		event.getRegistry().registerAll(setup(solar_ore, "solar_ore"));
		event.getRegistry().registerAll(setup(lunar_ore, "lunar_ore"));
		
		SolarStatics.LOGGER.debug("Registered Blocks");
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(SolarStatics.MOD_ID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
	
}
