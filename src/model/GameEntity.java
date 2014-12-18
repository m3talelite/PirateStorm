package model;

import java.awt.Dimension;

public abstract class GameEntity {

	public static final long serialVersionUID = 1L;
	public int lives;
	public int damage;
	protected Image2D image;
	protected float x, y;
	protected float speed;
	protected Size2D size;
	protected Location2D loc;
	
	public boolean checkCollision(GameEntity gE1, GameEntity gE2){
		float dx, dy;
		dx = (gE1.loc.x > gE2.loc.x) ? gE1.loc.x - gE2.loc.x : gE2.loc.x - gE1.loc.x;
		dy = (gE1.loc.y > gE2.loc.y) ? gE1.loc.y - gE2.loc.y : gE2.loc.y - gE1.loc.y;
		
		double s = (dx * dx) + (dy * dy);
		s = Math.sqrt(s);
	
		if (s > (gE1.size.height/2))
				return true;
		return false;
	}
	
	public enum PirateType{
		BASIC,
		WEAK,
		MEDIUM,
		STRONG,
		TANK,
		SLOW,
		FAST,
		SPRINTER,
		
		SHOOTING
	
	}
	
}
