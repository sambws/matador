package systems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import systems.levels.TileList;

import world.Global;
import world.levels.Tile;

import main.Entity;

public class LevelControl extends Entity{

	//open the file
	static File f;
	
	//variables for getting the X and Y COORD of the player
	static int coord_x, coord_y;
	static String area;
	
	
	public LevelControl(double x, double y) {
		super(x, y);
	}
	
	public static void LoadLevel()
	{
		area = Global.area + "/";
		coord_x = Global.coord_x;
		coord_y = Global.coord_y;
		
		/*
		 * order:
		 * tileset name
		 * tilecount
		 * 
		 * tile x
		 * tile y
		 * tile id (which tile)
		 * tile depth
		 * tile solid
		 * 
		 */
		
		//load level based on coords
		f = new File("res/levels/" + area + coord_x + "_" + coord_y + ".map");
		
		try{
			//open readers
			FileReader z = new FileReader(f);
			BufferedReader r = new BufferedReader(z);
			
			//the tileset name (a string, eg. "Forest" or "Desert")
			String tile_id = r.readLine();
			
			//tile count
			int tile_count = Integer.parseInt(r.readLine());
			
			//store the tileset graphic array in a variable
			String s[] = TileList.ChooseSet(tile_id);
			
			//loop through the tiles and add them one by one
			for(int i = 0; i < tile_count; i++)
			{
				//load in the tile with the read x, y, id, and depth value
				int _x = Integer.parseInt(r.readLine());
				int _y = Integer.parseInt(r.readLine());
				int idd = Integer.parseInt(r.readLine());
				int depth = Integer.parseInt(r.readLine());
				int solid = Integer.parseInt(r.readLine());
				
				//add in the tile with the parameters
				new Tile((double)_x, (double)_y, s[idd], depth, solid);
			}
			
			//close readers
			r.close();
			z.close();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
