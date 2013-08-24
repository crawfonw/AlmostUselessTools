package almostuseless.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import almostuseless.lib.Ids;
import almostuseless.lib.Names;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	
	public static Item diamondium;
	public static Item rake;
	
	public static void init() {
		diamondium = new Diamondium(Ids.diamondium_actual);
		rake = new Rake(Ids.rake_actual, EnumToolMaterial.IRON);
	}

	public static void addNames() {
		LanguageRegistry.addName(diamondium, Names.diamondium_name);
		LanguageRegistry.addName(rake, Names.rake_name);
	}
}
