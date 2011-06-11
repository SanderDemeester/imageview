package imageController;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MyImage extends ImageIcon{
	private ImageIcon imageicon;
	private Rectangle rec;
	public MyImage(int widht, int height, int type){
//		super(widht,height,type);
		super();
	}
	public MyImage(){
		super();
	}
	public MyImage(ImageIcon imageicon){
		super();
		this.imageicon = imageicon; 
	}
	public MyImage(ImageIcon imageicon, Rectangle rec){
		super();
		this.imageicon = imageicon;
		this.rec = rec;
	}
	
	public Image getImage(){
		return imageicon.getImage();
	}
	
	public Rectangle getrec(){
		return rec;
	}
	
	

}
