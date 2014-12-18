package model;

import java.awt.Graphics;

public class Pirate extends GameEntity {

	public Pirate(Location2D l, Size2D s, Image2D img, PirateType type) {
		this.loc = l;
		this.size = s;
		this.image = img;
		switch (type) {
		case BASIC:
			this.speed = 1;
			this.lives = 20;
			this.damage = 2;
			break;
		case WEAK:
			this.speed = 1;
			this.lives = 10;
			this.damage = 1;
			break;
		case MEDIUM:
			this.speed = 2;
			this.lives = 50;
			this.damage = 2;
			break;
		case STRONG:
			this.speed = 2;
			this.lives = 60;
			this.damage = 4;
			break;
		case TANK:
			this.speed = 1;
			this.lives = 140;
			this.damage = 2;
		case SLOW:
			this.speed = 0.5f;
			this.lives = 20;
			this.damage = 1;
		case FAST:
			this.speed = 3;
			this.lives = 20;
			this.damage = 1;
			break;
		case SPRINTER:
			this.speed = 4.5f;
			this.lives = 20;
			this.damage = 2;
		case SHOOTING:
			break;
		}
	}

	public void tick() {
		// TODO: add the movement.
	}

	public void draw(Graphics g) {
		// TODO: add graphics
		g.fillOval((int) (loc.x + size.width), (int) (loc.y + size.height),
				(int) size.width, (int) size.height);
	}

	public float translate() {
		// TODO: add rotation
		return 0.0f;
	}
}
