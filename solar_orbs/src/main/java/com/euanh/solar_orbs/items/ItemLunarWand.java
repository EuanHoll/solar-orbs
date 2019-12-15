package com.euanh.solar_orbs.items;

import com.euanh.solar_orbs.utils.EventSubscriber;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemLunarWand extends ToolItem
{
	
	public ItemLunarWand(Properties builder) {
		super(2f, 2f, new WandToolMaterial(25, EventSubscriber.lunar_orb), null, builder);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!playerIn.abilities.isCreativeMode) {
		    itemstack.damageItem(1, playerIn, (p_220040_1_) -> {
                p_220040_1_.sendBreakAnimation(handIn);
             });
		}
		worldIn.setDayTime(13000);
		worldIn.playSound((PlayerEntity)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
}
