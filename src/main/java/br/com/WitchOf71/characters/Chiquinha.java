package br.com.WitchOf71.characters;

import java.awt.Point;

import org.unbiquitous.uImpala.engine.asset.AssetManager;

import br.com.generic2dgame.GameCharacter;

public class Chiquinha extends GameCharacter{

	public Chiquinha(AssetManager assetsx, boolean player) {
		super (assetsx);
		if(!player){
			this.setSpriteImgPath("img/sprite/chiquinha_inv.png");
			this.setNormalClip((new int[] {837, 0,   50, 157}));
			this.setWalkingClip((new int[]{890, 0,   50, 157})); //{0, 0, 84, 149}
			this.setJumpClip((new int[]   {542, 200, 84, 100}));
		}
	}
	private boolean walkingLeft = true;
	private int walkingFramesLeft = 20;
	private int walkingFramesRight = 541;
	
	protected void update() {
		Point a = this.getPosition();
		
			if(a.x > walkingFramesLeft && a.x < walkingFramesRight){
				if(walkingLeft){
					this.updateXPosition(-5);
					this.walkLeft();
					
				}
				else{
					this.updateXPosition(+5);
					this.walkRight();
				}
				
			}else{
				if(walkingLeft){
					this.updateXPosition(+5);
					this.walkRight();
					walkingLeft = false;
				}else{
					this.updateXPosition(-5);
					this.walkLeft();
					walkingLeft = true;
				}
			}
	}
}
