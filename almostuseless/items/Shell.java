package almostuseless.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import almostuseless.AlmostUseless;
import almostuseless.lib.ModInfo;
import almostuseless.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Shell extends Item {
	
	public Shell(int id) {
		super(id);
		this.setCreativeTab(AlmostUseless.autab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return Names.shell_unlocalizedName[itemstack.getItemDamage()];
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
		icons = new Icon[Names.shell_unlocalizedName.length];

		for(int i = 0; i < icons.length; i++) {
			icons[i] = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.shell_unlocalizedName[i]);
		}
	}

}
