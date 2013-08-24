package almostuseless.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import almostuseless.AlmostUseless;
import almostuseless.lib.ModInfo;
import almostuseless.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Diamondium extends Item {

	public Diamondium(int id) {
		super(id);
		this.setCreativeTab(AlmostUseless.autab);
		this.setUnlocalizedName(Names.diamondium_unlocalizedName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.diamondium_unlocalizedName);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(Names.diamondium_tooltip);
	}
}
