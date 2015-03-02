package gameMain;

import graphics.Text;

import java.awt.Color;
import java.awt.Font;

import world.Root;

import main.GameEngineApplet;
import main.GameStartListener;
import main.Main;
import main.RuntimeFixer;
import main.Scene;

public class GameMain extends GameEngineApplet {
	private static final long serialVersionUID = 2864092535021560372L;

	@Override
	public void initializeApplet() {
		setup();
	}
	
	private static void setup() {
		Main.preferredWidth=832;
		Main.preferredHeight=640;
		Main.preferredProjectionWidth = Main.preferredWidth;
		Main.preferredProjectionHeight = Main.preferredHeight;
		Main.loadText = Color.decode("#FF1814");  
		Main.loadFront = Color.decode("#FFE316");
		Main.loadBack = Color.decode("#FF1814");
	    Main.loaderImageFileName = ("res/load.png");
	    Main.loadFont = new Font("Courier New", Font.PLAIN, 12);
	    Main.icon = "res/icon.png";
	    Main.title = "OKAYOKAYOKAYOKAYOKAYOKAYOKAY";
	    Scene.killOnEscape = true;
		RuntimeFixer.DEMANDED_MEMORY = 256;
		
		Scene.setGameStarter(new GameStartListener(){
			@Override
			public void gameInitialized() {
				Text.idiot = false;
				new Root();
			}
		});
	} 
 
	public static void main(String[] args){
		setup();
		Main.main(args);
	}
}