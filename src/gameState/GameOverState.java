package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import control.GamePanel;

public class GameOverState extends GameState {

	private String[] options = { "Main Menu", "Retry", "Quit" };
	private int indexer;

	public GameOverState(GameStateManager gsm) {
		this.gameStateManager = gsm;
		this.indexer = 0;
	}

	public void init() {

	}

	public void tick() {

	}

	public void draw(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 48));
		for (int i = 0; i < options.length; ++i) {
			if (i == indexer)
				g.setColor(Color.red);
			else
				g.setColor(Color.white);
			g.drawString(options[i], GamePanel.WIDTH / 2 - 64, 80 * (i + 1));
		}
		g.drawString(indexer + "", (int) GamePanel.WIDTH - 100,
				(int) GamePanel.HEIGHT - 100);
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_UP)
			indexer = indexer - 1 < 0 ? options.length - 1 : --indexer;
		if (key == KeyEvent.VK_DOWN)
			indexer = indexer + 1 >= options.length ? 0 : ++indexer;
		if (key == KeyEvent.VK_ENTER)
			SelectOption();
	}

	public void keyReleased(int key) {

	}

	private void SelectOption() {
		switch (indexer) {
		case 0:
			for (int i = 0; i < GameStateManager.states.size() + 1; ++i)
				GameStateManager.states.pop();
			GameStateManager.states.peek().init();
			break;
		case 1:
			GameStateManager.states.pop();
			GameStateManager.states.peek().init();
			break;
		case 2:
			System.exit(0);
			break;
		}
	}

}
