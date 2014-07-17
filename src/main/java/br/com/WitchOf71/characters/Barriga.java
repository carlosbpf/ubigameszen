package br.com.WitchOf71.characters;

import org.unbiquitous.uImpala.engine.asset.AssetManager;

import br.com.generic2dgame.GameCharacter;

public class Barriga extends GameCharacter{

	public Barriga(AssetManager assetsx, boolean player) {
		super (assetsx);
		if(player){
			this.setSpriteImgPath("img/sprite/barriga.png");
			this.setNormalClip((new int[]{65, 0, 49, 149}));
			this.setWalkingClip((new int[]{0, 0, 62, 149})); //{0, 0, 84, 149}
			this.setJumpClip((new int[]{98, 334, 70, 120}));
		}
	}
}