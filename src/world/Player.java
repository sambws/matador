package world;

import graphics.Sprite;

import java.awt.event.KeyEvent;

import systems.TextManager;
import world.npcs.NpcBase;
import main.Entity;
import main.Input;
import main.Scene;

public class Player extends Entity{
	
	public static NpcBase Current_Npc = null; //used for displaying the text
	
	int spd = 3;
	int thing = 0;
	boolean pressed_z = false;
	boolean started_cutscene = false;
	public static boolean hasItem = false;

	public Player(double x, double y) {
		super(x, y);
		persistent = true;
		sprite = Sprite.get("poop");
		orientation = Sprite.CENTERED;
		setCollisionGroup(Global.playerCol);
		mask = sprite.mask;
	}
	
	
	
	private void move_code()
	{
		if(Input.checkKey(KeyEvent.VK_LEFT))
		{
			if(Scene.getCollidedEntities(this, x - 4, y, Global.solidCol).size() == 0)
			{
				x -= spd;
			}
		}
		if(Input.checkKey(KeyEvent.VK_RIGHT))
		{
			if(Scene.getCollidedEntities(this, x + 4, y, Global.solidCol).size() == 0)
			{
				x += spd;
			}
		}
		if(Input.checkKey(KeyEvent.VK_UP))
		{
			if(Scene.getCollidedEntities(this, x, y - 4, Global.solidCol).size() == 0)
			{
				y -= spd;
			}
		}
		if(Input.checkKey(KeyEvent.VK_DOWN))
		{
			if(Scene.getCollidedEntities(this, x, y + 4, Global.solidCol).size() == 0)
			{
				y += spd;
			}
		}
	}
	
	
	
	
	private void npc_interact()
	{
		if(Input.checkKey(KeyEvent.VK_Z)) //if shitboy presses x (the thing variable is there to emulate the keyboard_pressed event in game maker
		{
			if(thing == 0)
			{
				if(Scene.getCollidedEntities(this, x, y, Global.npcCol).size() == 1) //if he's colliding with an npc
				{
					TextManager.InitText(Current_Npc); //load the npc through the variable
					TextManager.displayText(); //display the text in the console
				}
				thing = 1;
			}
		}else //when you let go of x.....
		{
			thing = 0; //make it so you can initiate conversation again
		}
	}
	
	
	
	
	private void talk()
	{
		if(Input.checkKey(KeyEvent.VK_X))
		{
			if(pressed_z == false) //this emulates a key_pressed event in game maker
			{
				if(Global.talking == true) //if you're talking....
				{
					if(TextManager.current_txt < TextManager.maxtext-1){  //if you're not done with the text yet
						TextManager.current_txt += 1; //advance the text
					}else{ //if you're done with the text
						Global.talking = false; //stop talking, also destroys the textbox
						TextManager.current_txt = 0; //reset the text page
						Current_Npc.talk_count += 1;
						Current_Npc.perform_action();
					}
				}
				if(Global.cutscene == true) //if it's in a cutscene, do some slightly different shit
				{
					if(TextManager.current_txt < TextManager.maxtext-1){  //if you're not done with the text yet
						TextManager.current_txt += 1; //advance the text
					}else{ //if you're done with the text
						Global.cutscene = false; //stop talking, also destroys the textbox
						TextManager.current_txt = 0; //reset the text page
						Current_Npc.destroy();
					}
				}
				pressed_z = true;
			}
		}else{
			pressed_z = false;
		}
	}
	
	
	
	
	public void step() {
		
		if(Global.talking == false && Global.cutscene == false) //if you're not in a conversation..........
		{
			//movement
			move_code();
			//interacting with npcs
			npc_interact();
		}
		
		//talking with people (advancing text)
		talk();
		
		if(Scene.getCollidedEntities(this, x, y, Global.itemCol).size() > 0) //getting the item (baby), temporary probably (could rework into something cool, maybe along with an item system?)
		{
			hasItem  = true;
		}
		
		if(Global.cutscene == true && started_cutscene == false) //start the cutscene if the proper entity exists
		{
			TextManager.InitText(Current_Npc);
			TextManager.displayText();
			started_cutscene = true;
		}
		
		setDepth((int)-y);
		super.step();
	}
	
	public void render() {
		
		super.render();
	}

}
