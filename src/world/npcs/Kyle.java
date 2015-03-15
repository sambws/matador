package world.npcs;

import systems.TextManager;
import world.Global;
import world.Player;
import main.Scene;
import graphics.Sprite;

public class Kyle extends NpcBase{
	
	public Kyle(double x, double y) {
		super(x, y);
		
		idle = Sprite.get("poop");
		walk = Sprite.get("poop");
		portrait = Sprite.get("FACE");
		
		sprite = idle;
		
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		maxtxt = 2;
		txt[0] = "hi i'm kyle";
		txt[1] = "kyle is ok";
		
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
		
		setDepth((int)-y);
		
		super.step();
	}

}

