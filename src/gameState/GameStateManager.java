package gameState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class GameStateManager {
	public static Stack<GameState> states;
	
	public GameStateManager(){
		states = new Stack<GameState>();
		states.push(new MenuState(this));
	}
	
	public void tick(){
		states.peek().tick();
//		Win condition
//		if (states.peek().isDone()){	}
	}
	public void draw(Graphics g){
		states.peek().draw(g);
	}
	public void keyPressed(int key){
		if (key == KeyEvent.VK_SPACE)
			System.out.println("length stack: " + states.size());
		if (key == KeyEvent.VK_BACK_SPACE && states.size() > 1){
			states.pop();
			states.peek().init();
		}
		states.peek().keyPressed(key);
	}
	public void keyReleased(int key){
		states.peek().keyReleased(key);
	}
}
