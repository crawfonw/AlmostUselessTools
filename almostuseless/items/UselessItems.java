package almostuseless.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import almostuseless.lib.Ids;
import almostuseless.lib.Names;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class UselessItems {
	
	public static Item diamondium;
	public static Item rake;
	public static Item shell;
	
	public static void init() {
		diamondium = new Diamondium(Ids.diamondium_actual);
		rake = new Rake(Ids.rake_actual, EnumToolMaterial.IRON);
		shell = new Shell(Ids.shellSand_actual);
	}

	public static void addNames() {
		LanguageRegistry.addName(diamondium, Names.diamondium_name);
		LanguageRegistry.addName(rake, Names.rake_name);
		for(int i = 0; i < Names.shell_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(shell, 1, i), Names.shell_name[i]);
		}
	}
}
