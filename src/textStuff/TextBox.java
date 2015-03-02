package textStuff;

import java.awt.Font;

import world.Global;
import graphics.GLFont;
import graphics.Graphics;
import graphics.Shape;
import graphics.Sprite;
import main.Entity;

public class TextBox extends Entity{

	GLFont g = new GLFont("Courier New", Font.PLAIN, 12);
	Sprite portrait;
	
	public TextBox(double x, double y) {
		super(x, y);
		setDepth(Integer.MIN_VALUE);
	}
	
	public void render()
	{
		Graphics.setColor(255, 255, 0);
		Shape.drawRectangle(32, 448, 800, 640); //find out the x and y values my mayne
		
		g.setColor(0, 0, 0, 1);
		g.render(TextManager.text[TextManager.current_txt], 224, 480, 2, 0, 0);
		
		portrait.render(0, 64, 480);
		
		super.render();
	}
	
	public void step()
	{
		if(Global.talking == false && Global.cutscene == false) //if you're not talking/in a cutscene
		{
			destroy();
		}
		
		portrait = TextManager.portrait;
	}

}
