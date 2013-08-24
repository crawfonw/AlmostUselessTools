package almostuseless.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import almostuseless.blocks.UselessBlocks;
import almostuseless.lib.Names;

public class ItemRake extends ItemTool {
	
	public static final Block[] blocksEffectiveAgainst = {};
	
	public ItemRake(int id, EnumToolMaterial material) {
		super(id, 8F, material, blocksEffectiveAgainst);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!player.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			if (world.getBlockId(par4, par5, par6) == UselessBlocks.shellSand.blockID) {
				// This is shady
				UseHoeEvent event = new UseHoeEvent(player, par1ItemStack, world, par4, par5, par6);

				if (MinecraftForge.EVENT_BUS.post(event)) {
					return false;
				}

				if (event.getResult() == Result.ALLOW) {
					par1ItemStack.damageItem(1, player);
					return true;
				}

				int i1 = world.getBlockId(par4, par5, par6);
				boolean air = world.isAirBlock(par4, par5 + 1, par6);

				if (par7 != 0 && air && i1 == UselessBlocks.shellSand.blockID) {
					Block block = Block.sand;
					world.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
					if (world.isRemote) {
						return true;
					} else {
						world.setBlock(par4, par5, par6, block.blockID);
						
						Random generator = new Random();
						int meta = generator.nextInt(Names.shell_unlocalizedName.length);
						EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(UselessItems.shell.itemID, 1, meta));
						world.spawnEntityInWorld(entityitem);
						if (!(player instanceof FakePlayer))
			                entityitem.onCollideWithPlayer(player);
						
						par1ItemStack.damageItem(1, player);
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
