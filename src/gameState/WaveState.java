package gameState;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Queue;

import model.GameEntity;
import model.GameEntity.PirateType;
import model.Location2D;
import model.Pirate;
import model.Player;
import model.Size2D;
import control.GamePanel;

public class WaveState extends GameState {

	private Player player;
	private ArrayList<GameEntity> entities;
	public Queue<GameEntity> pirates;
	
	public WaveState(GameStateManager gsm, int level){
		gameStateManager = gsm;
		init();
	}
	
	public void init(){
		player = new Player(new Location2D(GamePanel.WIDTH / 2 - 25, GamePanel.HEIGHT / 2 - 25),new Size2D(50, 50), 2, 100);
		entities = new ArrayList<GameEntity>();
		for(int i = 0; i < 10; ++i)
			entities.add(new Pirate(new Location2D(10 * i, 10 * i), new Size2D(30, 30), null, PirateType.BASIC));
	
	}

	public void tick() {
		player.tick();
		if (player.lives <= 0){
			//Stop thread method
			GameStateManager.states.push(new GameOverState(gameStateManager));
		}
	}

	public void draw(Graphics g) {
		g.setColor(new Color(156, 93, 82));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.blue);
		
		player.draw(g);
		g.setColor(Color.RED);
		g.fill3DRect(10, 10, player.lives * 2, 20, true);
	}

	public void keyPressed(int key) {
		player.keyPressed(key);
	}

	public void keyReleased(int key) {
		player.keyReleased(key);
	}

}
