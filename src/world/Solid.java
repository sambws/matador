package world;

import graphics.Sprite;
import main.Entity;

public class Solid extends Entity{

	public Solid(double x, double y) {
		super(x, y);
		sprite = Sprite.get("solid");
		orientation = Sprite.NORTHWEST;
		setCollisionGroup(Global.solidCol);
		mask = sprite.mask;
	}

}
