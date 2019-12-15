package com.euanh.solar_orbs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.brigadier.Message;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TextComponentUtils;

public class SolarStatics {

	public static final String MOD_ID = "solar_orbs";
	public static final String MOD_NAME = "Solar Orbs";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	public static void SendToPlayer(PlayerEntity player, String message)
	{
		player.sendMessage(TextComponentUtils.toTextComponent(new Message() {
			
			@Override
			public String getString() {
				return message;
			}
		}));
	}
	
}
