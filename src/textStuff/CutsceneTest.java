package textStuff;

import world.Global;
import world.Player;
import npcs.NpcBase;
import graphics.Sprite;

/*THIS SHIT IS WEIRD
 * it's basically an npc, except it automatically activates and doesn't have a physical body
 * it destroys itself after the cutscene is over
 */

public class CutsceneTest extends NpcBase{

	public CutsceneTest(double x, double y) {
		super(x, y);
		
		maxtxt = 2;
		txt[0] = "oh my god";
		txt[1] = "blaraghgh";
		
		Player.Current_Npc = this;
		Global.cutscene = true;
		TextManager.maxtext = maxtxt;
		
		portrait = Sprite.get("FACE");
	}
	
	public void step()
	{
		//face snippet goes here
		if(TextManager.current_txt == 1)
		{
			TextManager.portrait = Sprite.get("FACE");
		}else
		{
			TextManager.portrait = Sprite.get("FACE2");
		}


		super.step();
	}

}
