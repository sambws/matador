package world;

public class Global {
	//collisions
	public static int playerCol = 0;
	public static int solidCol = 1;
	public static int npcCol = 2;
	public static int itemCol = 3;
	
	//used for player position
	public static int coord_x = 0, coord_y = 0;
	public static String area = "town";
	
	//used for dialogues and stuff
	public static boolean talking = false;
	public static boolean cutscene;
	
	//static Font font = new Font("Courier New", Font.PLAIN, 12);
}
