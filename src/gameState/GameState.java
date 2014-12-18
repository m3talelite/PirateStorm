package gameState;

import java.awt.Graphics;

public abstract class GameState {
	protected GameStateManager gameStateManager;
//	protected ArrayList<Enemy> enemys;
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);
	
}
