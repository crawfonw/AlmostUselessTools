package almostuseless.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import almostuseless.lib.Ids;
import almostuseless.lib.Names;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class UselessItems {
	
	public static Item diamondium;
	public static Item diamondillium;
	public static Item rake;
	public static Item shell;
	public static Item gemstone;
	
	public static void init() {
		diamondium = new Diamondium(Ids.diamondium_actual);
		diamondillium = new Diamondillium(Ids.diamondillium_actual);
		rake = new Rake(Ids.rake_actual, EnumToolMaterial.IRON);
		shell = new Shell(Ids.shell_actual);
		gemstone = new Gemstone(Ids.gemstone_actual);
	}

	public static void addNames() {
		LanguageRegistry.addName(diamondium, Names.diamondium_name);
		LanguageRegistry.addName(diamondillium, Names.diamondillium_name);
		LanguageRegistry.addName(rake, Names.rake_name);
		for(int i = 0; i < Names.shell_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(shell, 1, i), Names.shell_name[i]);
		}
		for(int i = 0; i < Names.gemstone_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(gemstone, 1, i), Names.gemstone_name[i]);
		}
	}
}
