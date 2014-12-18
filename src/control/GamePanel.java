package control;

import gameState.GameStateManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 800, HEIGHT = 600;
	public static boolean isRunning = false;
	public long currentFPS;
	
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	private GameStateManager gsm;
	private Thread thread;
	
	public GamePanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);
		setFocusable(true);
		
		start();
	}
	
	public void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop(){
		isRunning = false;
		try{
			thread.join();
		}
		catch(InterruptedException ex) { ex.printStackTrace(); }
	
	}
	
	public void run() {
		gsm = new GameStateManager();

		long start;
		long elapsed;
		long wait;
		while(isRunning){
			start = System.nanoTime();
			
			tick();
			repaint();

			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait < 0)
				wait = 5;

			currentFPS = (int) (1000 / wait);
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void tick(){
		gsm.tick();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	
		gsm.draw(g);

		g.setColor(Color.white); 
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.drawString("FPS: " + currentFPS, WIDTH - 200, 24);
	}
	
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		gsm.keyPressed(arg0.getKeyCode());
	}

	public void keyReleased(KeyEvent arg0) {
		gsm.keyReleased(arg0.getKeyCode());
	}

	public void keyTyped(KeyEvent arg0) {
		//Just here for the interface
	}

}
