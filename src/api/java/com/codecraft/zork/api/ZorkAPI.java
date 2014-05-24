package com.codecraft.zork.api;

import java.util.HashMap;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;

public class ZorkAPI {
	
	private static final HashMap<UUID, Integer> shakes = new HashMap<UUID, Integer>();
	
	public static final void requestShake(EntityPlayer player, int amount)
	{
		shakes.put(player.getUniqueID(), amount);
	}
	
	public static final int getShake(EntityPlayer player)
	{
		return shakes.get(player.getUniqueID());
	}
	
	public static final boolean containsShake(EntityPlayer player)
	{
		return shakes.containsKey(player.getUniqueID());
	}
	
	public static final void removeShake(EntityPlayer player)
	{
		shakes.remove(player.getUniqueID());
	}
	
	public static final int numShakes()
	{
		return shakes.size();
	}
	
}
