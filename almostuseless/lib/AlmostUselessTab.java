package almostuseless.lib;

import almostuseless.items.UselessItems;
import net.minecraft.creativetab.CreativeTabs;

public class AlmostUselessTab extends CreativeTabs {
	public AlmostUselessTab(int id, String name) {
		super(id, name);
	}

	@Override
	public int getTabIconItemIndex() {
		return UselessItems.diamondium.itemID; 
	}
}
