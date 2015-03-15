package world;

import graphics.Graphics;
import graphics.Sprite;

import javax.media.opengl.GL2;

import levels.LevelControl;
import main.Entity;
import main.Scene;

public class Root extends Entity{
	public static String room = "";

	public Root() {
		super(0, 0);
		
		Graphics.setAlpha(1);
		
		setDepth(Integer.MAX_VALUE);
		GL2 gl = Scene.gl; 
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glEnable (GL2.GL_BLEND); 
        gl.glBlendFunc (GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
       
        persistent = true;
        visible = true;
        
        sprite = Sprite.get("test");
        
        changeRoom(Global.coord_x + "" + Global.coord_y);
        
        //handles levels
        new LevelControl(0, 0);
	}
	
	public static void changeRoom(String rm){
		room = rm;
		killEveryone();
		LevelControl.LoadLevel();
		
		
		if(rm.equals("00")){
			
			new Player(128, 320); //you shouldn't need this in every level declaration. the player should be persisent, and only deleted in specific events
			
		}
	}
	
	public static void killEveryone(){
		Entity[] instances = Scene.getInstances();
		
		for(int i=0; i<instances.length; i++)
		{
			Entity e = instances[i];
			if (!e.persistent)
			e.roomDestroy();
		}
	}
	
	public void render(){
		GL2 gl = Scene.gl;
		
		//Set camera
		gl.glViewport(Scene.viewportX, Scene.viewportY, Scene.viewportWidth, Scene.viewportHeight);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, Scene.projectionWidth, Scene.projectionHeight, 0, -1,1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
		//Clear background
		gl.glClearColor(1f,1f,1f,1);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT|GL2.GL_DEPTH_BUFFER_BIT);
	}

}
