package com.euanh.solar_orbs;

import com.euanh.solar_orbs.utils.SolarStatics;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(SolarStatics.MOD_ID)
public final class SolarOrbs {

	public SolarOrbs() {
		SolarStatics.LOGGER.debug("Starting " + SolarStatics.MOD_NAME);
	}
	
	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event)
	{
		
	}
	
}
