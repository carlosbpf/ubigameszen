package br.com.WitchOf71;

import java.util.Arrays;

import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameSettings;
import org.unbiquitous.uImpala.engine.io.KeyboardManager;
import org.unbiquitous.uImpala.engine.io.MouseManager;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.jse.impl.core.Game;

import br.com.WitchOf71.sets.Set1;
import br.com.WitchOf71.sets.Set2;
import br.com.generic2dgame.GameCharacter;
import br.com.generic2dgame.GameSet;

public class GameController {

	public static boolean gameOver = false;
	
	public static int numberOfLives = 3;
	
	public static GameCharacter player = null;
	
	public static GameSet current = null;
	
	@SuppressWarnings({ "unchecked", "serial" })
	public static void main(String[] args) {
		
		
		Game.run(new GameSettings() {
			{ 
				
				put("first_scene", Set1.class);
				//put("current_scene",Set1.class);
				
				put("input_managers", Arrays.asList(MouseManager.class, KeyboardManager.class));
				put("output_managers", Arrays.asList(ScreenManager.class));
			}
		});
		
		//GameComponents.get(Game.class).change(scene);
	}
}
