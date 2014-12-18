package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import control.GamePanel;

public class MenuState extends GameState {

	private String menuStrings[] = { "Start", "Options", "Exit" };
	private int indexer;

	public MenuState(GameStateManager gsm) {
		this.gameStateManager = gsm;
		this.indexer = 0;
	}

	public void init() {	}

	public void tick() {	}

	public void draw(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 48));
		for (int i = 0; i < menuStrings.length; ++i) {
			if (i == indexer)
				g.setColor(Color.red);
			else
				g.setColor(Color.white);
			g.drawString(menuStrings[i], GamePanel.WIDTH / 2 - 64, 80 * (i + 1));
		}
	}

	public void keyPressed(int key) {
		if (key == KeyEvent.VK_UP)
			indexer = indexer - 1 < 0 ? menuStrings.length - 1 : --indexer;
		if (key == KeyEvent.VK_DOWN)
			indexer = indexer + 1 >= menuStrings.length ? 0 : ++indexer;
		if (key == KeyEvent.VK_ENTER)
			SelectOption();
	}

	public void keyReleased(int key) {	}

	private void SelectOption() {
		switch (indexer) {
		case 0:
			GameStateManager.states.push(new LevelSelectState(gameStateManager));
			break;
		case 1:
			System.out.println(menuStrings[indexer]);
			break;
		case 2:
			System.exit(0);
			break;
		}
	}
}
