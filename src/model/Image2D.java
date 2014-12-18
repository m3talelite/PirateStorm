package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image2D {

	private Image image;
//	private ArrayList<Image> sprites;
	public Image2D(Image i){
		image = i;
	}
	
	public Image2D(String imageName){
		try {
			image = ImageIO.read(new File(imageName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createSpriteSheet(BufferedImage spritesheet, int width, int height){
		
		for (int x = 0; x < spritesheet.getWidth(); ++x){
			for (int y = 0; y < spritesheet.getHeight(); ++y){
//make spritesheet
			}
		}
		
	}
}
