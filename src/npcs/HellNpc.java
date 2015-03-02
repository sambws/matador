package npcs;

import textStuff.TextManager;
import world.Global;
import world.Player;
import main.Scene;
import graphics.Sprite;

public class HellNpc extends NpcBase{

	public HellNpc(double x, double y) {
		super(x, y);
		
		sprite = Sprite.get("shit");
		orientation = Sprite.CENTERED;
		
		setCollisionGroup(Global.npcCol);
		
		maxtxt = 5;
		
		txt[0] = "hell....";
		txt[1] = "hell!!!!!";
		txt[2] = "......";
		txt[3] = "fuck";
		txt[4] = "whatever";
		
		portrait = Sprite.get("FACE2");
	}
	
	public void step()
	{
		if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() == 0)
		{
			
		}else
		{
			hspeed = 0;
			
			Player.Current_Npc = this;
			TextManager.maxtext = maxtxt;
		}
		
		//multiple conversations
		if(talk_count == 1)
		{
			maxtxt = 1;
			txt[0] = "just feeling weird, you know.";
		}
		if(talk_count >= 2)
		{
			maxtxt = 1;
			txt[0] = "i'll get over it, though.";
		}
		
		setDepth((int)-y);
		
		super.step();
	}

}
