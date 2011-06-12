package acties;

import imageController.ImageModel;
import imageController.MyImage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import panelen.Paneel;

public class MoveDown extends AbstractAction{
	private ImageModel imagemodel;
	private Paneel panel;
	public MoveDown(ImageModel imagemodel,Paneel panel){
		this.imagemodel = imagemodel;
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MoveDown");
		ArrayList<MyImage> lijst = new ArrayList<MyImage>();
		lijst = imagemodel.getLijst();
		MyImage image = imagemodel.getCurrentMyImage();
		
		if(lijst.size() > 0  && lijst.indexOf(image)+1 <= lijst.size()-1)
			imagemodel.setSelectedImage(lijst.get(lijst.indexOf(image)+1));
		else if(lijst.size() <= 0)
			if(lijst.size()>0)
			imagemodel.setSelectedImage(lijst.get(0));
//		panel.updateScrollPanel();
		
	}

}
