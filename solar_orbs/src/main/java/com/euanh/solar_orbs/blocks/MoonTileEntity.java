package com.euanh.solar_orbs.blocks;

import com.euanh.solar_orbs.utils.EventSubscriber;
import com.euanh.solar_orbs.utils.TimeManager;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class MoonTileEntity extends TileEntity implements ITickableTileEntity{

	private int resets = 12;
	private int lastdaynight = 13000;
	
	private int daytime = 13000;
	
	public MoonTileEntity() {
		super(EventSubscriber.moon_tile_entity);
	}

	@Override
	public void read(CompoundNBT tag)
	{
		this.resets = tag.getInt("resets");
		this.lastdaynight = tag.getInt("lastdaynight");
		super.read(tag);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT tag)
	{
		tag.putInt("resets", this.resets);
		tag.putInt("lastdaynight", this.lastdaynight);
		return super.write(tag);
	}
	
	@Override
	public CompoundNBT getUpdateTag()
	{
		return this.write(new CompoundNBT());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
	}

	@Override
	public void tick() {
		if(world.isRemote) {
			if (resets == 0 && lastdaynight == 0)
				world.destroyBlock(this.pos, false);
			if (lastdaynight == 0)
			{
				resets--;
				lastdaynight = daytime;
			}
			if(world.isBlockPowered(pos))
			{
				world.setDayTime(17000);
				lastdaynight--;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return "Time Remaing: " + String.valueOf((resets * daytime) + lastdaynight);
	}
	
}
