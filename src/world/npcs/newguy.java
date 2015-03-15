package world.npcs;

import systems.TextManager;
import world.Global;
import world.Player;
import main.Scene;
import graphics.Sprite;

public class newguy extends NpcBase{
	
	public newguy(double x, double y) {
		super(x, y);
		
		//sprites
		idle = Sprite.get("poop");
		walk = Sprite.get("poop");
		portrait = Sprite.get("FACE");
		
		sprite = idle;
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		//text
		maxtxt = 1;
		txt[0] = "..............";
		
	}
	
	public void step()
	{
		//collision with player
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
			maxtxt = 1;
			txt[0] = "um";
		}
		if(talk_count == 2)
		{
			maxtxt = 1;
			txt[0] = "ok";
		}
		
		setDepth((int)-y);
		
		super.step();
	}

}

