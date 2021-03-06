package systems.levels;

import world.Global;
import main.Entity;

public class TileList extends Entity{
	
	/*order the tiles should go in:
	 * -middle
	 * -left
	 * -right
	 * -up
	 * -down
	 * -northwest
	 * -northeast
	 * -southwest
	 * -southeast
	 */
	
	//declare sets (full of image names) here
	//public static String[] set = {"set_mid", "set_left", "set_right", "set_up", "set_down", "set_nw", "set_ne", "set_sw", "set_se")
	
	//this is broken as of now; ask hubol about subdirectories inside of the sprites folder
	public static String path = "/tiles/" + Global.area + "/";
	public static String[] default_set = {"0", "1", "2"}; //load in 0.png, 1.png, and 2.png into the tileset
	
	public TileList(double x, double y) {
		super(x, y);
		
		persistent = true;
	}

	
	//this will return the set array that is assigned to it based on a string
	public static String[] ChooseSet(String id) {
		if(id == "debug")
		{
			return default_set;
		}else
		{
			return default_set;
		}
		
	}

	
	
	
}
