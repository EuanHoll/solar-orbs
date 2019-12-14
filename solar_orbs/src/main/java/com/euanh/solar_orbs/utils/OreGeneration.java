package com.euanh.solar_orbs.utils;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	
	public static void SetupOres()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, EventSubscriber.solar_ore.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 35)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, EventSubscriber.lunar_ore.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 35)));
		}
	}
	
}
