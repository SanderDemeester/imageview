package imageController;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MyImage extends ImageIcon{
	private BufferedImage image;
	private Rectangle rec;
	public MyImage(int widht, int height, int type){
//		super(widht,height,type);
		super();
	}
	public MyImage(){
		super();
	}
	public MyImage(BufferedImage image){
		super();
		this.image = image; 
	}
	public MyImage(BufferedImage image, Rectangle rec){
		super();
		this.image = image;
		this.rec = rec;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public Rectangle getrec(){
		return rec;
	}
	
	

}
