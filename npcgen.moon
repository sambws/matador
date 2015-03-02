wr = ->
	f = io.open(name .. ".txt", "w")
	
	io.write("package npcs;

		import textStuff.TextManager;
		import world.Global;
		import world.Player;
		import main.Scene;
		import graphics.Sprite;

		public class" .. name ..  "extends NpcBase{
			
			public" .. name .. "(double x, double y) {
				super(x, y);

				s_idle = Sprite.get(" .. i_sprite .. ")
				s_walk = Sprite.get(" .. w_sprite .. ")
				s_portrait = Sprite.get(" .. p_sprite .. ")
				
				sprite = s_idle
				
				orientation = Sprite.CENTERED;
				
				setCollisionGroup(Global.npcCol);
				
				maxtxt = 3;
				txt[0] = "d1";
				txt[1] = "d2";
				txt[2] = "d3";

				
			}
			
			public void step()
			{
				if(Scene.getCollidedEntities(this, x, y, Global.playerCol).size() == 0)
				{
					//vspeed = -1;
					
				}else
				{
					vspeed = 0;
					
					Player.Current_Npc = this;
					TextManager.maxtext = maxtxt;
				}
				
				if(talk_count == 1)
				{
					//MORE CONVOS!
				}
				if(talk_count >= 2)
				{
					//MORE CONVOS!
				}
				
				setDepth((int)-y);
				
				super.step();
			}

		}")

	io.close(f)

func = ->

	export name, i_sprite, w_sprite, p_sprite, d1, d2, d3

	io.write "enter name of npc: \n"
	name = io.read()

	io.write "enter idle sprite name: \n"
	i_sprite = io.read()
	io.write "enter walk sprite name: \n"
	w_sprite = io.read()
	io.write "enter portrait name: \n"
	p_sprite = io.read()

	io.write "enter first dialogue: \n"
	d1 = io.read()

	io.write "enter second dialogue: \n"
	
	if io.read() != "/nil" then
		d2 = io.read()
	else
		d2 = ""

	io.write "enter third dialogue: \n"

	if io.read() != "/nil" then
		d3 = io.read()
	else
		d3 = ""

	wr!

func!