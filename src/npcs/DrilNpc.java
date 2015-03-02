package npcs;

import textStuff.TextManager;
import world.Global;
import world.ShitBoy;
import main.Scene;
import graphics.Sprite;

public class DrilNpc extends NpcBase{
	
	public DrilNpc(double x, double y) {
		super(x, y);
		
		sprite = Sprite.get("dril");
		sprite.imageWidth = 64;
		sprite.imageHeight = 64;
		
		mask.height = 64;
		mask.width = 64;
		
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		maxtxt = 1;
		txt[0] = "may god help you if you trip your feet against my\nhandsome bulk while i am sitting on the floor\nlooking at Depression things on my tablet pc";
		
		portrait = Sprite.get("FACE");
		
	}
	
	public void step()
	{
		if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() == 0)
		{
			//vspeed = -1;
			
		}else
		{
			vspeed = 0;
			
			ShitBoy.Current_Npc = this;
			TextManager.maxtext = maxtxt;
		}
		
		if(talk_count == 1)
		{
			maxtxt = 2;
			txt[0] = "shit";
			txt[1] = "fuck";
		}
		if(talk_count >= 2)
		{
			maxtxt = 1;
			txt[0] = "hi.";
		}
		
		setDepth((int)-y);
		
		super.step();
	}

}
