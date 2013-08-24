package almostuseless.items;

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

public class ItemRake extends ItemTool {
	
	public static final Block[] blocksEffectiveAgainst = {};
	
	public ItemRake(int id, EnumToolMaterial material) {
		super(id, 8F, material, blocksEffectiveAgainst);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!player.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			if (world.getBlockId(par4, par5, par6) == Block.sand.blockID) {
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

				if (par7 != 0 && air && i1 == Block.sand.blockID) {
					if (world.isRemote) {
						return true;
					} else {
						EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(Items.diamondium.itemID, 1, 1));
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
