package br.com.generic2dgame;

import java.awt.Point;

import org.unbiquitous.uImpala.engine.asset.AssetManager;
import org.unbiquitous.uImpala.engine.asset.Sprite;
import org.unbiquitous.uImpala.engine.core.GameComponents;
import org.unbiquitous.uImpala.engine.core.GameObject;
import org.unbiquitous.uImpala.engine.core.GameRenderers;
import org.unbiquitous.uImpala.engine.io.Screen;
import org.unbiquitous.uImpala.engine.time.DeltaTime;

public class GameAsset extends GameObject{

	public int getClipWidth() {
		return clipWidth;
	}
	public void setClipWidth(int clipWidth) {
		this.clipWidth = clipWidth;
	}
	public int getClipHeight() {
		return clipHeight;
	}
	public void setClipHeight(int clipHeight) {
		this.clipHeight = clipHeight;
	}
	public int getClipX() {
		return clipX;
	}
	public void setClipX(int clipX) {
		this.clipX = clipX;
	}
	public int getClipY() {
		return clipY;
	}
	public void setClipY(int clipY) {
		this.clipY = clipY;
	}
	public AssetManager getAssets() {
		return assets;
	}
	public void setAssets(AssetManager assets) {
		this.assets = assets;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * A Screen reference for rendering
	 */
	private Screen screen;
	/**
	 * The sprite image used for this character
	 */
	private Sprite sprite;
	
	/**
	 * The position on the screen for this character
	 */
	private Point position;
	
	/**
	 * The width used in the sprite clipping
	 */
	private int clipWidth;
	
	/**
	 * The height used in the sprite clipping
	 */
	private int clipHeight;
	
	/**
	 * The clipping position for the x axis 
	 */
	private int clipX;
	
	/**
	 * The clipping position for the y axis
	 */
	private int clipY;
	
	/**
	 * The path to the sprite image 
	 */
	private String spriteImgPath ;//"img/sprite/chiquinha.png";//
	
	private AssetManager assets;
	
	private boolean dead;
	private boolean hidden;
	
	
	public GameAsset(AssetManager assetsx) {
		assets = assetsx;		
	}
	public void init(){
		sprite = assets.newSprite(spriteImgPath);
		//System.out.println(clipX + " - " + clipY +" - " +clipWidth + " - " +clipHeight );
		//setClip(normalClip[0], normalClip[1], normalClip[2], normalClip[3]);
		sprite.clip(clipX, clipY, clipWidth, clipHeight);
	}
	
	
	
	


	@Override
	protected void render(GameRenderers renderers) {
		if(!hidden)
			sprite.render(screen, position.x, position.y);
		
	}

	@Override
	protected void wakeup(Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Point getPosition() {
		return position;
	}
	

	public void updateXPosition(int increment) {
		this.position.x = this.position.x + increment;
	}
	
	public void updateYPosition(int increment) {
		this.position.y = this.position.y + increment;
	}
	

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setClip(int x, int y , int w, int h){
		this.clipHeight = h;
		this.clipWidth = w;
		this.clipX = x;
		this.clipY = y;
	}

	public String getSpriteImgPath() {
		return spriteImgPath;
	}

	public void setSpriteImgPath(String spriteImgPath) {
		this.spriteImgPath = spriteImgPath;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	

}
