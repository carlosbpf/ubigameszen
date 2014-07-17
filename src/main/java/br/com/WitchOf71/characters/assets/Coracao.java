package br.com.WitchOf71.characters.assets;

import org.unbiquitous.uImpala.engine.asset.AssetManager;

import br.com.generic2dgame.GameAsset;

public class Coracao extends GameAsset{

	public Coracao(AssetManager assetsx) {
		super (assetsx);
		this.setSpriteImgPath("img/coracao.png");
		this.setClip(0, 0, 36, 35);
		
	}
}