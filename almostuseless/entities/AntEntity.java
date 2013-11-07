package almostuseless.entities;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AntEntity extends EntitySilverfish {

	private static final int targetID = 4;
	private static final int searchRadius = 3;
	private int lifeTicks = 1;
	private ArrayList<int[]> visibleBlocks;
	
	private boolean foraging = true;
	
	public AntEntity(World par1World) {
		super(par1World);
		visibleBlocks = new ArrayList<int[]>();
	}
	
	@Override
	protected void updateEntityActionState() {
		
		if (!this.worldObj.isRemote && lifeTicks > 0)
        {
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY);
			int z = MathHelper.floor_double(this.posZ);
			
			for(int i = -searchRadius; i < searchRadius; i++){
				for(int j = 0; j < searchRadius; j++){
					for(int k = -searchRadius; k < searchRadius; k++){
						System.out.println(String.format("Coordinate: (%d, %d, %d)\nBlock ID: %d", x+i, y+j, z+k, this.worldObj.getBlockId(x+i, y+j, z+k)));
						if(this.worldObj.getBlockId(x+i, y+j, z+k) == targetID){
//							visibleBlocks.add(new int[]{x+i, y+j, z+k});
//							this.moveEntity(x+i, y+j, z+k);
							this.moveEntity(2, 0, 2);
						}
					}
				}
			}
			lifeTicks--;
			System.out.println(visibleBlocks);
        }
	}

	@Override
	protected Entity findPlayerToAttack() {
		return null;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		return super.attackEntityFrom(par1DamageSource, par2);
	}
	
	@Override
	protected String getLivingSound()
    {
        return null;
    }
	
	@Override
	protected String getHurtSound()
    {
        return null;
    }

	@Override
    protected String getDeathSound()
    {
        return null;
    }
	
}
