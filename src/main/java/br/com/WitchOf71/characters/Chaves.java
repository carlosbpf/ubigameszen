package br.com.WitchOf71.characters;

import org.unbiquitous.uImpala.engine.asset.AssetManager;

import br.com.generic2dgame.GameCharacter;

public class Chaves extends GameCharacter{

	public Chaves(AssetManager assetsx,boolean player) {
		super (assetsx);
		if(player){
			this.setSpriteImgPath("img/sprite/chaves.png");
			this.setNormalClip((new int[]{84, 0, 70, 149}));
			this.setWalkingClip((new int[]{0, 0, 84, 149})); //{0, 0, 84, 149}
			this.setJumpClip((new int[]{147, 474, 70, 120}));
		}
	}
}
