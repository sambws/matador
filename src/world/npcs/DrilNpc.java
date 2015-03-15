package world.npcs;

import systems.TextManager;
import world.Global;
import world.Player;
import main.Scene;
import graphics.Sprite;

public class DrilNpc extends NpcBase{
	
	public DrilNpc(double x, double y) {
		super(x, y);
		
		idle = Sprite.get("dril");
		walk = Sprite.get("dril");
		portrait = Sprite.get("FACE");
		
		sprite = idle;
		
		sprite.imageHeight = 64;
		sprite.imageWidth = 64;
		mask.width = 64;
		mask.height = 64;
		
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		maxtxt = 1;
		txt[0] = "may god help you if you trip your feet against my\nhandsome bulk while i am sitting on the floor\nlooking at Depression things on my tablet pc";
		
	}
	
	public void step()
	{
		if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() == 0)
		{
			//vspeed = -1;
			
		}else
		{
			vspeed = 0;
			
			Player.Current_Npc = this;
			TextManager.maxtext = maxtxt;
		}
		
		if(talk_count == 1)
		{
			maxtxt = 2;
			txt[0] = "h";
			txt[1] = "q";
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
