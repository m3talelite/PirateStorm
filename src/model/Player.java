package model;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameEntity {

	private boolean Up, Down, Left, Right = false; 
	
	public Player(Location2D l, Size2D s, float spee, int live) {
		this.loc = l;
		this.size = s;
		this.speed = spee;
		this.lives = live;
	}

	public void tick() {
		KeyHandler();
	}

	public void draw(Graphics g) {
		g.fillOval((int) (loc.x + size.width), (int) (loc.y + size.height), (int) size.width, (int) size.height);
// 		Set Player Cursor		
//		g.setColor(Color.yellow);
		
	}

	public void keyPressed(int k){
		if (k == KeyEvent.VK_W)
			Up = true;
		if (k == KeyEvent.VK_S)
			Down = true;
		if (k == KeyEvent.VK_A)
			Left = true;
		if (k == KeyEvent.VK_D)
			Right = true;
		
		if (k == KeyEvent.VK_SPACE)
			lives -= 20;
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_W)
			Up = false;
		if (k == KeyEvent.VK_S)
			Down = false;
		if (k == KeyEvent.VK_A)
			Left = false;
		if (k == KeyEvent.VK_D)
			Right = false;
	}
	private void KeyHandler(){
		if (Up)
			loc.y -= speed;
		if (Down)
			loc.y += speed;
		if (Left)
			loc.x -= speed;
		if (Right)
			loc.x += speed;
	}
}
