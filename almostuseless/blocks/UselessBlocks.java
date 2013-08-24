package almostuseless.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import almostuseless.lib.Ids;
import almostuseless.lib.Names;

public class UselessBlocks {

	public static Block shellSand;
	
	public static void init() {
		shellSand = new ShellSand(Ids.shellSand_actual);
		GameRegistry.registerBlock(shellSand, Names.shellSand_name);
	}

	public static void addNames() {
		LanguageRegistry.addName(shellSand, Names.shellSand_name);
	}

}