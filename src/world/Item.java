package world;

import graphics.Sprite;
import main.Entity;
import main.Scene;

public class Item extends Entity{

	public Item(double x, double y) {
		super(x, y);
		sprite = Sprite.get("item");
		mask = sprite.mask;
		orientation = Sprite.CENTERED;
		setCollisionGroup(Global.itemCol);
	}
	
	public void step()
	{
		if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() > 0)
		{
			destroy();
		}
		
		angle += 0.5;
	}

}
