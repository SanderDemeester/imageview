package menuActies;

import imageController.ImageModel;
import imageController.MyImage;
import imageViewer.Main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import menuItems.MenuActies;

public class Fez implements MenuActies{
	
	private static MyImage image;
	static{
		try {
			image = new MyImage(ImageIO.read(
					new File(
					Main.class.getResource("/images/fez.jpg").getFile())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(ImageModel imagemodel) {
		// TODO Auto-generated method stub
		System.out.println(image.hashCode());
		imagemodel.setSelectedImage(image);
		
	}

}
