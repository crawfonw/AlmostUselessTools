package almostuseless.configs;

import java.io.File;

import net.minecraftforge.common.Configuration;
import almostuseless.lib.Ids;
import almostuseless.lib.Names;

public class ConfigHandler {
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		final String BOOLEANS = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "booleans";
		config.load();
		
		Ids.diamondium_actual = config.getItem(config.CATEGORY_ITEM, Names.diamondium_name, Ids.diamondium_default).getInt() - 256;
		Ids.rake_actual = config.getItem(config.CATEGORY_ITEM, Names.rake_name, Ids.rake_default).getInt() - 256;
		Ids.shell_actual = config.getItem(config.CATEGORY_ITEM, Names.shellItems, Ids.shell_default).getInt() - 256;
		
		Ids.shellSand_actual = config.getBlock(config.CATEGORY_BLOCK, Names.shellSand_name, Ids.shellSand_default).getInt();
		
		config.save();
	}
}
