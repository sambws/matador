package levels;

import world.Global;
import graphics.Sprite;
import main.Entity;

public class Tile extends Entity{
	
	/*simple entity that is spawned when LevelControl loads a level
	 * it's depth and sprite can be customized (spr/depth vars)
	 */
	
	int d;
	
	/* @param x the x position of the tile
	 * @param y the y position of the tile
	 * @param spr the tile's sprite, gotten from it's tileset aray
	 * @param depth the depth (z coordinate) of the tile
	 * @solid determines whether or not the tile acts like a wall towards the player*/

	public Tile(double x, double y, String spr, int depth, int solid) {
		super(x, y);
		
		//set inherited vars
		sprite = Sprite.get(spr);
		orientation = Sprite.NORTHWEST;
		mask = sprite.mask;
		
		if(solid == 1){
			setCollisionGroup(Global.solidCol);
		}
		
		setDepth(d);
	}
	

}


