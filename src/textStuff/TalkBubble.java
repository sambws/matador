package textStuff;

import graphics.Sprite;
import main.Entity;

public class TalkBubble extends Entity{

	public TalkBubble(double x, double y) {
		super(x, y);
		
		sprite = Sprite.get("talk");
		orientation = Sprite.CENTERED;
		mask = sprite.mask;
		
		Math.round(x);
		Math.round(y);
		
		setDepth(Integer.MIN_VALUE);
		
	}

}
