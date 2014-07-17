package br.com.WitchOf71.characters;

import org.unbiquitous.uImpala.engine.asset.AssetManager;

import br.com.generic2dgame.GameCharacter;

public class Bruxa extends GameCharacter{

	public Bruxa(AssetManager assetsx, boolean player) {
		super (assetsx);
		if(!player){
			this.setSpriteImgPath("img/sprite/bruxa_inv.png");
			this.setNormalClip((new int[] {837, 0,   70, 157}));
			this.setWalkingClip((new int[]{903, 0,   84, 157})); //{0, 0, 84, 149}
			this.setJumpClip((new int[]   {460, 542, 84, 120}));
		}
	}
}
