package me.polaris120990.NoPiston;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public class NoPistonBlock extends BlockListener
{
	Block[] blocks;
	
	@SuppressWarnings("deprecation")
	public void onBlockPistonExtend(BlockPistonExtendEvent event)
	{
		blocks = event.getBlocks().toArray(new Block[]{});
		BlockFace dir = event.getDirection();
		Material bblock = event.getBlock().getFace(dir).getType();
		Material cblock = event.getBlock().getFace(dir).getFace(BlockFace.UP).getType();
		if(blocks.length > 0)
		{
			int i = 0;
			while(i < blocks.length)
			{
				Material dblock = blocks[i].getFace(dir).getFace(BlockFace.UP).getType();
				Material ablock = blocks[i].getFace(dir).getType();
				if(ablock == Material.MELON_BLOCK || ablock == Material.SUGAR_CANE_BLOCK || ablock == Material.PUMPKIN || ablock == Material.CACTUS)
				{
					event.setCancelled(true);
					return;
				}
				if(ablock == Material.AIR)
				{
					if(blocks[i].getFace(dir).getFace(dir).getType() == Material.CACTUS)
					{
						event.setCancelled(true);
						return;
					}
				}
				if(dblock == Material.SUGAR_CANE_BLOCK || dblock == Material.CACTUS)
				{
					event.setCancelled(true);
					return;
				}
				i++;
			}
		}
		if(cblock == Material.SUGAR_CANE_BLOCK || cblock == Material.CACTUS)
		{
			event.setCancelled(true);
			return;
		}
		if(bblock == Material.MELON_BLOCK || bblock == Material.SUGAR_CANE_BLOCK || bblock == Material.PUMPKIN)
		{
			event.setCancelled(true);
			return;
		}
		if(bblock == Material.AIR)
		{
			if(event.getBlock().getFace(dir).getFace(dir).getType() == Material.CACTUS)
			{
				event.setCancelled(true);
				return;
			}
		}
	}
}
