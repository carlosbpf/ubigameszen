package br.com.WitchOf71;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Arrays;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Sprite;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObjectTreeScene;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.core.GameSettings;
import org.unbiquitous.uImpala.engine.io.KeyboardEvent;
import org.unbiquitous.uImpala.engine.io.KeyboardManager;
import org.unbiquitous.uImpala.engine.io.KeyboardSource;
import org.unbiquitous.uImpala.engine.io.MouseManager;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.engine.time.DeltaTime;
import org.unbiquitous.uImpala.jse.impl.core.Game;
import org.unbiquitous.uImpala.util.observer.Event;
import org.unbiquitous.uImpala.util.observer.Observation;
import org.unbiquitous.uImpala.util.observer.Subject;

import br.com.WitchOf71.characters.Barriga;
import br.com.WitchOf71.characters.Bruxa;
import br.com.WitchOf71.characters.Chaves;
import br.com.WitchOf71.characters.Chiquinha;
import br.com.generic2dgame.GameCharacter;
import br.com.generic2dgame.GameSet;
import br.com.generic2dgame.GameSetBackground;

/**
 * Hello world!
 *
 */
public class App extends GameObjectTreeScene{
	private Screen screen;
	
	private Sprite sprite;
	
	private Sprite testeChaves;
	
	private KeyboardSource keyBoardSource;
	
	GameCharacter player1 = null;
	
	GameSetBackground background = null;
	
	public App() {
		DeltaTime deltaTime = GameComponents.get(DeltaTime.class);
		//deltaTime.setUPS(10);
		
		screen = GameComponents.get(ScreenManager.class).create();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		screen.open("71", 600, 322, false, null);
		
		
		
		
		//set1.setGameSetBackground(background);
		
		player1 = new Chaves(assets,true);
		player1.setPosition(new Point( 40, 220));
		player1.setScreen(screen);
		player1.init();
		//set1.setPlayer(player1);
		
		
		//set1.setEnemy(player1);
		
		//add(set1);
		//testeChaves.clip(0, 0, 84, 140);
		GameComponents.put(Screen.class, screen);
		GameComponents.put(AssetManager.class,assets);
		keyBoardSource = screen.getKeyboard();
		keyBoardSource.connect(KeyboardSource.EVENT_KEY_DOWN, new Observation(this, "keyUp"));
		keyBoardSource.connect(KeyboardSource.EVENT_KEY_UP, new Observation(this, "keyUp"));
	}
	
	void keyUp(Event event, Subject subject) {
	    KeyboardEvent e = (KeyboardEvent)event;
	    if(e.getKey() == 200){
	    	//up
	    	player1.jump();
	    }
	    if(e.getKey() == 208){
	    	//down
	    	player1.squat();
	    }
	    if(e.getKey() == 203){
	    	//left
	    	player1.walkLeft();
	    	player1.updateXPosition(-10);
	    }
	    if(e.getKey() == 205){
	    	//right
	    	player1.walkRight();
	    	player1.updateXPosition(10);
	    }
	 }
	
	
	@SuppressWarnings({ "unchecked", "serial" })
	public static void main(String[] args) {
		Game.run(new GameSettings() {
			{ 
				put("first_scene", App.class);
				put("input_managers", Arrays.asList(MouseManager.class, KeyboardManager.class));
				put("output_managers", Arrays.asList(ScreenManager.class));
			}
		});
		//GameComponents.get(Game.class).change(scene);
	}
	
	

	
	protected void render(GameRenderers renderers) {
		
	}
	@Override
	public void update() {
		
		super.update();
		if (screen.isCloseRequested()) {
			GameComponents.get(org.unbiquitous.uImpala.engine.core.Game.class).quit();
		}
	}
}
