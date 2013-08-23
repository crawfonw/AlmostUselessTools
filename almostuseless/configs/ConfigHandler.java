package almostuseless.configs;

import java.io.File;

import net.minecraftforge.common.Configuration;
import tutorial.lib.Ids;
import tutorial.lib.Names;

public class ConfigHandler {
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		final String BOOLEANS = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "booleans";
		config.load();
		
		config.save();
	}
}
