package acties;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import imageController.ImageModel;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class AfbeeldingDeleteAction extends AbstractAction{
	private ImageModel imagemodel;
	public AfbeeldingDeleteAction(ImageModel imagemodel){
		this.imagemodel = imagemodel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		imagemodel.deleteCurrentImage();
		
	}
	
}
