package levels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.Entity;

public class LevelControl extends Entity{

	//open the file
	static File f = new File("test.txt");
	
	//unused as for now, used for loading the right file
	int coord_x = 0, coord_y = 0;
	
	public LevelControl(double x, double y) {
		super(x, y);
		persistent = true;
		
		new TileList(0, 0);
		
		LoadLevel();
	}
	
	public void LoadLevel()
	{
		//load level based on coords
		f = new File("res/levels/" + coord_x + "_" + coord_y + ".map");
		
		try{
			//open readers
			FileReader z = new FileReader(f);
			BufferedReader r = new BufferedReader(z);
			
			//the tile family name
			String tile_id = r.readLine();
			
			//amount of tiles in the level
			int tile_count = Integer.parseInt(r.readLine());
			
			//store the tileset array in a variable
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
