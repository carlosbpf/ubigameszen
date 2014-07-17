package br.com.WitchOf71.sets;

import java.awt.Point;

import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.io.KeyboardEvent;
import org.unbiquitous.uImpala.engine.io.KeyboardSource;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.io.ScreenManager;
import org.unbiquitous.uImpala.util.observer.Event;
import org.unbiquitous.uImpala.util.observer.Observation;
import org.unbiquitous.uImpala.util.observer.Subject;

import br.com.WitchOf71.GameController;
import br.com.WitchOf71.characters.Chaves;
import br.com.WitchOf71.characters.Chiquinha;
import br.com.WitchOf71.characters.assets.Coracao;
import br.com.generic2dgame.GameCharacter;
import br.com.generic2dgame.GameSet;
import br.com.generic2dgame.GameSetBackground;

public class Set1 extends GameSet {

	public Set1(){
		super();
		Screen screen = GameComponents.get(ScreenManager.class).create();
		//GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		screen.open("71", 600, 322, false, null);
		
		GameComponents.put(Screen.class, screen);
		
		this.screen = GameComponents.get(Screen.class);
		
		
		
		player = new Chaves(assets,true); 
		player.setPosition(new Point( 40, 220));
		player.setScreen(screen);
		player.init();
		
		GameController.player = player;
		
		gameSetBackground = new GameSetBackground(assets);
		gameSetBackground.setSpriteImgPath("img/entrada_da_vila_set.png");
		gameSetBackground.init();
		
		this.enemy = new Chiquinha(assets,false);
		this.enemy.setPosition(new Point( 540, 220));
		this.enemy.setScreen(screen);
		this.enemy.init();
		
		add(gameSetBackground);
		
		Coracao coracao = null;
		for(int j = 0; j < GameController.numberOfLives; j++){
			coracao = new Coracao(assets);
			coracao.setPosition(new Point( j*45 + 20, 20));
			coracao.setScreen(screen);
			coracao.init();
			coracoes.add(j,coracao);
			add(coracao);
		}
		
		add(player);
		add(this.enemy);
		
		KeyboardSource keyBoardSource;
		keyBoardSource = screen.getKeyboard();
		keyBoardSource.connect(KeyboardSource.EVENT_KEY_DOWN, new Observation(this, "keyUp"));
		keyBoardSource.connect(KeyboardSource.EVENT_KEY_UP, new Observation(this, "keyUp"));
	}
	
	public void update(){
		super.update();
		
		if(player.getPosition().x > 600){
			GameComponents.get(org.unbiquitous.uImpala.engine.core.Game.class).change(new Set2());
		}
		if (screen.isCloseRequested()) {
			GameComponents.get(org.unbiquitous.uImpala.engine.core.Game.class).quit();
		}
	}
	protected void keyUp(Event event, Subject subject) {
	    KeyboardEvent e = (KeyboardEvent)event;
	    
	    if(e.getKey() == 200){
	    	//up
	    	player.jump();
	    }
	    if(e.getKey() == 208){
	    	//down
	    	player.squat();
	    }
	    if(e.getKey() == 203){
	    	//left
	    	player.walkLeft();
	    	player.updateXPosition(-10);
	    }
	    if(e.getKey() == 205){
	    	//right
	    	player.walkRight();
	    	player.updateXPosition(10);
	    }
	 }
	
}
