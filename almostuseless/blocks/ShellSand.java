package almostuseless.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import almostuseless.AlmostUseless;
import almostuseless.lib.ModInfo;
import almostuseless.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShellSand extends BlockSand {
	
	public ShellSand(int id) {
		super(id);
		
		this.setUnlocalizedName(Names.shellSand_unlocalizedName);
		this.setCreativeTab(AlmostUseless.autab);
		
		this.setStepSound(Block.soundSandFootstep);
		this.setHardness(0.5F);
		this.setResistance(2.5F);
	}
	
	@SideOnly(Side.CLIENT)
	public static Icon blockIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.shellSand_unlocalizedName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		return blockIcon;
	}
	
	public int idDropped(int par1, Random random, int zero) {
        return Block.sand.blockID;
	}
	
}