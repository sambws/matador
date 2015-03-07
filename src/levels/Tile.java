package levels;

import world.Global;
import graphics.Sprite;
import main.Entity;

public class Tile extends Entity{
	
	/*simple entity that is spawned when LevelControl loads a level
	 * it's depth and sprite can be customized (spr/depth vars)
	 */
	
	int d;

	public Tile(double x, double y, String spr, int depth, int solid) {
		super(x, y);
		sprite = Sprite.get(spr);
		orientation = Sprite.NORTHWEST;
		mask = sprite.mask;
		
		if(solid == 1){
			setCollisionGroup(Global.solidCol);
		}
		
		d = depth;
		
	}
	
	public void step()
	{
		setDepth(d);
	}

}
