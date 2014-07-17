package br.com.generic2dgame;

import java.util.ArrayList;
import java.util.List;

import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObjectTreeScene;
import org.unbiquitous.uImpala.engine.io.Screen;

import br.com.WitchOf71.GameController;
import br.com.WitchOf71.characters.assets.Coracao;

public class GameSet extends GameObjectTreeScene{

	protected Screen screen;
	
	protected GameSetBackground gameSetBackground;
	
	protected GameCharacter player;
	
	protected GameCharacter enemy;

	public GameSetBackground getGameSetBackground() {
		return gameSetBackground;
	}

	public void setGameSetBackground(GameSetBackground gameSetBackground) {
		this.gameSetBackground = gameSetBackground;
	}

	public GameCharacter getPlayer() {
		return player;
	}

	public void setPlayer(GameCharacter player) {
		this.player = player;
	}

	public GameCharacter getEnemy() {
		return enemy;
	}

	public void setEnemy(GameCharacter enemy) {
		this.enemy = enemy;
	}
	protected List<Coracao> coracoes = new ArrayList<Coracao>();
	
	
	int immortalTime = 0;
	int immortalTimeStamp = 200;
	public void update(){
		super.update();
		if(hasHitEnemy() && immortalTime == 0){
			System.out.println(" - " + GameController.numberOfLives);
			if(GameController.numberOfLives == 0){
				GameComponents.get(org.unbiquitous.uImpala.engine.core.Game.class).quit();
				return;
			}else{
				this.coracoes.get(3 - GameController.numberOfLives + 1).setHidden(true);
			}
			immortalTime = immortalTimeStamp;
		}
		if(immortalTime> 0)
			immortalTime--;
	}
	
	public boolean hasHitEnemy() {
		
		if(player==null||
		   player.getPosition()==null||
		   enemy==null||
		   enemy.getPosition()==null){
			return false;
		}
		
		int r1x1 = player.getPosition().x ,
			r1x2 = (player.getClipWidth() + player.getPosition().x), 
			r1y1 = player.getPosition().y - player.getClipHeight() ,
			r1y2 = player.getPosition().y; 
		
		int r2x1 = enemy.getPosition().x ,
			r2x2 = (enemy.getClipWidth() + enemy.getPosition().x), 
			r2y1 = enemy.getPosition().y - enemy.getClipHeight() ,
			r2y2 = enemy.getPosition().y; 
	
		
		boolean isOverLap = ((r1x1 < r2x2) && (r1x2 > r2x1) &&  (r1y1 < r2y2) && (r1y2 > r2y1));
		
		return isOverLap;
	}
	
	
}
