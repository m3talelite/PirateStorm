package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import control.GamePanel;

public class LevelSelectState extends GameState {

	private int indexer;
	private String[] levels = { "1", "2", "3", "4", "5" };
	private int radius;

	public LevelSelectState(GameStateManager gaStMa) {
		this.gameStateManager = gaStMa;
		indexer = 0;
		radius = 50;
	}

	public void init() {
	}

	public void tick() {
	}

	public void draw(Graphics g) {
		for (int i = 0; i < levels.length; ++i) {
			if (i == indexer) {
				g.setColor(Color.red);
				g.fillOval((radius * 2) * (i + 1) - 5,
						GamePanel.HEIGHT / 2 - (64 * (i % 2)) - 5, radius + 10, radius + 10);
			}
			g.setColor(Color.white);
			g.fillOval((radius * 2) * (i + 1), GamePanel.HEIGHT / 2 - (64 * (i % 2) ),
					radius, radius);
			g.setFont(new Font("Arial", Font.BOLD, 32));
			g.setColor(Color.red);
			g.drawString(levels[i].toString(), (radius * 2) * (i + 1) + (16),
					GamePanel.HEIGHT / 2 - 25);

		}
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_RIGHT)
			indexer = indexer + 1 >= levels.length ? 0 : ++indexer;
		if (key == KeyEvent.VK_LEFT)
			indexer = indexer - 1 < 0 ? levels.length - 1 : --indexer;
		if (key == KeyEvent.VK_ENTER)
			SelectOptions();
	}

	public void keyReleased(int key) {
	}

	private void SelectOptions() {
		switch (indexer) {
		case 0:
			GameStateManager.states.push(new WaveState(gameStateManager,
					indexer));
			break;
		}
	}
}
