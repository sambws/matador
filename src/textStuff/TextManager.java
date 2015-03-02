package textStuff;

import world.Global;
import npcs.NpcBase;
import graphics.Sprite;
import main.Entity;

public class TextManager extends Entity{
	
	/*
	 * [[[[HOW THE TEXT SYSTEM WORKS INCASE U FORGET]]]]:
	 * PLAYER WALKS OVER THE NPC, HIS CURRENT NPC VARIABLE GETS SET TO THAT NPC (found in player's code)
	 * PLAYER PRESSES X -> TEXT INITS AND IS TAKEN FROM THE NPC TEXT VARIABLE INTO THE TXTMANAGER TEXT VARIABLE (FOR DISPLAYING) (found in textmanager)
	 * -> TEXT IS DISPLAYED THROUGH ANOTHER ARRAY IN THE TEXTBOX
	 * -> WHEN YOU PRESS Z THE ARRAY INDEX WILL INCREMENT BY 1
	 * -> WHEN THE TEXT IS ON THE LAST INDEX, AND Z IS PRESSED, THE TEXTBOX WILL CLOSE AND THE CURRENT_TXT VAR WILL RESET
	 */
	
	static String[] text = new String[100]; //this stores all the text that's displayed in the game
	public static int maxtext;
	public static int current_txt = 0; //current text that is being displayed on the textbox
	public static Sprite portrait = Sprite.get("FACE");
	
	public TextManager(double x, double y) {
		super(x, y);
		persistent = true;
		
	}
	
	public static void InitText(NpcBase npc)
	{
		portrait = npc.portrait;
		for(int i = 0; i < npc.maxtxt; i++) //this will cycle through the npc's text, set the display text to the values, yellows are weird and i don't know what's up with them
		{
			text[i] = npc.txt[i]; //sets the text in place
		}
		if(Global.cutscene == false)
			Global.talking = true;
	}
	
	public static void displayText() //temporary, works
	{
		
		/*for(int i = 0; i < maxtext; i++) //will cycle through the texts and stop displaying them based off of the npc's maxtxt variable
		{
			System.out.println(text[i]); //displays the text that was set in the inittext function
		}*/
		
		new TextBox(0, 0); //this shows shit
		
	}
	
	
}
