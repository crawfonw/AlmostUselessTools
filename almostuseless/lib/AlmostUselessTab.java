package almostuseless.lib;

import almostuseless.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class AlmostUselessTab extends CreativeTabs {
	public AlmostUselessTab(int id, String name) {
		super(id, name);
	}

	@Override
	public int getTabIconItemIndex() {
		return Items.diamondium.itemID; 
	}
}
