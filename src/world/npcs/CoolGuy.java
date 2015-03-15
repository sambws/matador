package world.npcs;

import systems.TextManager;
import world.Global;
import world.Player;
import main.Scene;
import graphics.Sprite;

public class CoolGuy extends NpcBase{
	
	public CoolGuy(double x, double y) {
		super(x, y);
		
		//sprites
		idle = Sprite.get("poop");
		walk = Sprite.get("poop");
		portrait = Sprite.get("FACE");
		
		sprite = idle;
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		//texts
		maxtxt = 2;
		txt[0] = "i'm cool guy";
		txt[1] = "hell yeah";
		
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

		//conversations
		if(talk_count == 1)
		{
			maxtxt = 2;
			txt[0] = "cool guy is the best";
			txt[1] = "hell yeah";
		}
		if(talk_count == 2)
		{
			maxtxt = 1;
			txt[0] = "hell.... yeah";
		}
		
		setDepth((int)-y);
		
		super.step();
	}

}

