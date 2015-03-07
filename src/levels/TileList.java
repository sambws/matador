package levels;

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
	
	//declare sets here
	//public static String[] set = {"set_mid", "set_left", "set_right", "set_up", "set_down", "set_nw", "set_ne", "set_sw", "set_se")
	public static String[] default_set = {"shit"};
	
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
