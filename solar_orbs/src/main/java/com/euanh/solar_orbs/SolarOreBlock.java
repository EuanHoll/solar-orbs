package com.euanh.solar_orbs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SolarOreBlock extends Block{

	private Random rangeRandom = new Random();
	
	public SolarOreBlock(Block.Properties properties)
	{
	      super(properties);
	}

	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		
		return silktouch == 0 ? rangeRandom.nextInt(12) : 0;
	}
	
}
