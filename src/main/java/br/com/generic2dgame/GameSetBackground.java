package br.com.generic2dgame;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Sprite;
import org.unbiquitous.uImpala.engine.core.GameObject;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.util.Corner;

public class GameSetBackground extends GameObject{

	
	public GameSetBackground(AssetManager assetsx) {
		assets = assetsx;		
	}
	/**
	 * The background that holds the SET
	 */
	private Sprite background;
	
	private int xOffset;
	
	private Screen screen;
	
	private AssetManager assets;

	private String spriteImgPath;
	
	
	public void init(){
		background = assets.newSprite(spriteImgPath);
		xOffset = 0;
	}
	
	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void render(GameRenderers renderers) {
		background.render(screen, xOffset, 0, Corner.TOP_LEFT);
	}

	@Override
	protected void wakeup(Object... args) {
		
	}

	@Override
	protected void destroy() {
		
	}

	public Sprite getBackground() {
		return background;
	}

	public void setBackground(Sprite background) {
		this.background = background;
	}

	public int getxOffset() {
		return xOffset;
	}

	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getSpriteImgPath() {
		return spriteImgPath;
	}

	public void setSpriteImgPath(String spriteImgPath) {
		this.spriteImgPath = spriteImgPath;
	}

}
