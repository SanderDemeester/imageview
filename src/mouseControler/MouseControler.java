package mouseControler;

import imageController.ImageModel;
import imageController.MyImage;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;

public class MouseControler implements MouseInputListener{
	private ImageModel imagemodel;
	public MouseControler(ImageModel imagemodel){
		this.imagemodel = imagemodel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Incoming click event");
		Rectangle minire = new Rectangle(e.getX(), e.getY(), 1, 1);
		for(MyImage image : imagemodel.getLijst())
			if(image.getrec().intersects(minire))
				imagemodel.setSelectedImage(image);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
