package textStuff;

import world.Global;
import world.Player;
import npcs.NpcBase;
import graphics.Sprite;

/*THIS SHIT IS WEIRD
 * it's basically an npc, except it automatically activates and doesn't have a physical body
 * it destroys itself after the cutscene is over
 */

public class CutsceneThing extends NpcBase{

	public CutsceneThing(double x, double y) {
		super(x, y);
		
		maxtxt = 5;
		txt[0] = "a.";
		txt[1] = "b.";
		txt[2] = "c.";
		txt[3] = "d.";
		txt[4] = "e.";
		
		Player.Current_Npc = this;
		Global.cutscene = true;
		TextManager.maxtext = maxtxt;
		
		portrait = Sprite.get("FACE");
	}
	
	public void step()
	{
		if(TextManager.current_txt == 2 || TextManager.current_txt == 4)
		{
			TextManager.portrait = Sprite.get("FACE2");
		}else
		{
			TextManager.portrait = Sprite.get("FACE");
		}
		
		super.step();
	}

}
