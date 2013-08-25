package almostuseless.items;

/*
 * This abstraction is weirdly bugged when other classes extend it.
 * Maybe I will go back when I know what the heck is going on. :P
 */

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import almostuseless.AlmostUseless;
import almostuseless.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaItem extends Item {
	
	private static String[] unlocalizedName;
	
	public MetaItem(int id, String[] unlocalizeName) {
		super(id);
		this.setCreativeTab(AlmostUseless.autab);
		this.setHasSubtypes(true);
		this.unlocalizedName = unlocalizeName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return this.unlocalizedName[itemstack.getItemDamage()];
	}
	
	@SideOnly(Side.CLIENT)
	public static Icon[] icons;
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < icons.length; i++) {
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return icons[damage];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		icons = new Icon[this.unlocalizedName.length];

		for(int i = 0; i < icons.length; i++) {
			icons[i] = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + this.unlocalizedName[i]);
		}
	}
}
