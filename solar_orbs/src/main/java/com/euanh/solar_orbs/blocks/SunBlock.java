package com.euanh.solar_orbs.blocks;

import com.euanh.solar_orbs.utils.SolarStatics;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SunBlock extends Block{
	
	public SunBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean hasTileEntity(final BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(final BlockState state, final IBlockReader world)
	{
		return new SunTileEntity();
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (worldIn.isRemote())
		{
			TileEntity te = (SunTileEntity)worldIn.getTileEntity(pos);
			SolarStatics.SendToPlayer(player, te.toString());
		}
		return true;
	}
	
	@Override
	public boolean addDestroyEffects(BlockState state, World world, BlockPos pos, ParticleManager manager) {
		if (world instanceof ClientWorld)
		{
			LightningBoltEntity bolt = new LightningBoltEntity(world, pos.getX(), pos.getY(), pos.getZ(), true);
			bolt.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0.0F);
			((ClientWorld)world).addLightning(bolt);
			for (PlayerEntity player : world.getPlayers()) {
				if (world.isPlayerWithin(pos.getX(), pos.getY(), pos.getZ(), 5f))
					world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 0.5F, 0.8F);
			}
		}
		return super.addDestroyEffects(state, world, pos, manager);
	}
	
}
