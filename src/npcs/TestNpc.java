package npcs;

import textStuff.TextManager;
import world.Global;
import world.ShitBoy;
import main.Scene;
import graphics.Sprite;

public class TestNpc extends NpcBase{
	
	boolean gave_baby = false;
	boolean spin = false;
	
	public TestNpc(double x, double y) {
		
		super(x, y);
		
		sprite = Sprite.get("poop");
		mask = sprite.mask;
		orientation = Sprite.CENTERED;
		setCollisionGroup(Global.npcCol);
		
		maxtxt = 2;
		
		txt[0] = "shit";
		txt[1] = "help m out";
		
		portrait = Sprite.get("FACE");
		
	}
	
	public void step()
	{
		if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() == 0)
		{
			//hspeed = 1;
		}else
		{
			hspeed = 0;
			
			ShitBoy.Current_Npc = this;
			TextManager.maxtext = maxtxt;
		}
		
		if(talk_count == 1)
		{
			txt[0] = "?????";
			txt[1] = "why";
		}
		
		if(spin == true)
		{
			angle += 2;
		}
		
		if(talk_count >= 2)
		{
			if(ShitBoy.hasItem == false) //if you don't have the baby
			{
				if(gave_baby == false) //and you haven't gave it to them yet
				{
					maxtxt = 1;
					txt[0] = "whatever.";
				}else //if you HAVE gave them the baby.....
				{
					maxtxt = 1;
					txt[0] = "thx for baby";
				}
			}else //if you have the baby
			{
				maxtxt = 4;
				txt[0] = "HOLY SHIT.";
				txt[1] = "YOU FOUND MY BABY......";
				txt[2] = "thank.";
				txt[3] = "[He takes away your ITEM]";
				gave_baby = true;
			}
			
		}
		
		setDepth((int)-y);
		
		super.step();
	}
	
	public void perform_action() //performed at the end of every conversation
	{
		if(gave_baby == true)
		{
			ShitBoy.hasItem = false;
			spin = true;
		}
	}

}
