package com.euanh.solar_orbs;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = SolarStatics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class EventSubscriber {

	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event)
	{
		event.getRegistry().registerAll(setup(new Item(new Item.Properties()), "solar_orb"));
	}
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(SolarStatics.MOD_ID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
	
}
