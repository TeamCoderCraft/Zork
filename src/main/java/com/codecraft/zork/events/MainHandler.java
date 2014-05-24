package com.codecraft.zork.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraftforge.common.MinecraftForge;

import com.codecraft.zork.api.ZorkAPI;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;


public class MainHandler {
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new MainHandler());
	}
	
	@SubscribeEvent
	public void onTick(TickEvent event)
	{
		if (event.side == Side.CLIENT && event.phase == Phase.END)
		{
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			if (ZorkAPI.containsShake(player))
			{
				int shakeAmount = ZorkAPI.getShake(player);
				player.cameraPitch+=shakeAmount;
				player.cameraYaw+=shakeAmount;
				//System.out.println("Test");
			}
		}
	}
	
	/*@SubscribeEvent
	public void onUseItem(PlayerUseItemEvent event)
	{
		ZorkAPI.requestShake(event.entityPlayer, 10);
		//System.out.println("Test");
	}*/
	
	@SubscribeEvent
	public void onSomething(ItemPickupEvent event)
	{
		ZorkAPI.requestShake(event.player, 10);
		System.out.println("Test");
	}
	
}
