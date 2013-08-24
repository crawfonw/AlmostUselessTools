package almostuseless;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import almostuseless.blocks.UselessBlocks;
import almostuseless.configs.ConfigHandler;
import almostuseless.items.UselessItems;
import almostuseless.lib.AlmostUselessTab;
import almostuseless.lib.LogHelper;
import almostuseless.lib.ModInfo;
import almostuseless.lib.Recipes;
import almostuseless.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = true)
public class AlmostUseless {
	
	public static CreativeTabs autab = new AlmostUselessTab(CreativeTabs.getNextID(), ModInfo.NAME);
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		LogHelper.log(Level.INFO, "Loading items");
		UselessItems.init();
		UselessItems.addNames();
		LogHelper.log(Level.INFO, "Items loaded");
		
		LogHelper.log(Level.INFO, "Loading blocks");
		UselessBlocks.init();
		UselessBlocks.addNames();
		LogHelper.log(Level.INFO, "Blocks loaded");

		LogHelper.log(Level.INFO, "Loading recipes");
		Recipes.init();
		LogHelper.log(Level.INFO, "Recipes loaded");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup." + ModInfo.NAME, "en_US", ModInfo.NAME);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}	
}
