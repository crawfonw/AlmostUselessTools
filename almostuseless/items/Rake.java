package almostuseless.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import almostuseless.AlmostUseless;
import almostuseless.lib.ModInfo;
import almostuseless.lib.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class Rake extends ItemRake {

	public Rake(int par1, EnumToolMaterial material) {
		super(par1, material);
		this.setCreativeTab(AlmostUseless.autab);
		this.setUnlocalizedName(Names.rake_unlocalizedName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		itemIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.rake_unlocalizedName);
	}
	

}
