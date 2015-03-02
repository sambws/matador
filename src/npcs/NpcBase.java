package npcs;

import graphics.Sprite;
import main.Entity;

public class NpcBase extends Entity{
	
	/*
	 * NPCs: they're fucking cool
	 * maxtxt is the max amount of text lines (or "pages") that they have
	 * their txt array holds all of their text "pages"
	 * talk_count checks how many times you've talked to the npc, which allows you to do cool dark souls type stuff (exhausting dialogue)
	 * the perform_action function is kind of complicated so let's go:
	 * 	-> it is executed whenever you end a conversation
	 * 	-> you can check the talk_count along with other shit (like player variables) to do things like take away items from the player
	 * 	-> eg:
	 * 	
	 * 	public void perform_action()
	 * 	{
	 * 		if(ShitBoy.hasItem == true && talk_count >= 2) --if you've talked to the npc twice and you have the item...
	 * 		{
	 * 			ShitBoy.hasItem = false; --take the item away from the player
	 * 		}
	 * 	}
	 * 	
	 * 
	 */
	
	
	public int maxtxt = 100; //the max amount of text is set to some bullshit number bc why not
	public String[] txt = new String[maxtxt]; //this stores all the text in the npc
	public int talk_count = 0;
	public Sprite portrait, idle, walk;
	
	public NpcBase(double x, double y) {
		super(x, y);
		
	}

	public void perform_action() {
		// TODO Auto-generated method stub
		
	}

}
