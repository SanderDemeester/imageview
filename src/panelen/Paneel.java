package panelen;

import imageController.ImageModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import acties.AfbeeldingDeleteAction;
import acties.MoveDown;
import acties.MoveUp;

public class Paneel extends JPanel{
	
	private JScrollBar scrollbar;
	private ImageModel imagemodel;
	
	public Paneel(ImageModel imagemodel){
		super();
		this.imagemodel = imagemodel;
		setLayout(new BorderLayout());
		
		getActionMap().put("d-afbeelding",new AfbeeldingDeleteAction(imagemodel));
		getActionMap().put("up", new MoveUp(imagemodel,this));
		getActionMap().put("down", new MoveDown(imagemodel,this));
		
		
		getInputMap().put(KeyStroke.getKeyStroke("ctrl D"), "d-afbeelding");
		getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		
		
		JScrollPane scrollpaneel = new JScrollPane(new PreviewPanel(imagemodel));
		scrollpaneel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpaneel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar = scrollpaneel.getVerticalScrollBar();
		add(scrollpaneel,BorderLayout.WEST);
		add(new FotoPaneel(imagemodel),BorderLayout.CENTER);
	}
	
	public void updateScrollPanel(){
		int pos = imagemodel.getCurrentIndexOfSelectedImage();
		int scrollbarmax = scrollbar.getMaximum();
		int scrollbarmin = scrollbar.getMinimum();
		System.out.println(scrollbarmax);
		System.out.println(scrollbarmin);
		System.out.println(pos);
		scrollbar.setValue(scrollbar.getMaximum());
		
	}

}
