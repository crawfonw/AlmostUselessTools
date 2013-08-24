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
		
		config.save();
	}
}
