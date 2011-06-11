package panelen;

import imageController.ImageModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import acties.AfbeeldingDeleteAction;
import acties.MoveDown;
import acties.MoveUp;

public class Paneel extends JPanel{
	
	public Paneel(ImageModel imagemodel){
		super();
		setLayout(new BorderLayout());
		
		getActionMap().put("d-afbeelding",new AfbeeldingDeleteAction(imagemodel));
		getActionMap().put("up", new MoveUp(imagemodel));
		getActionMap().put("down", new MoveDown(imagemodel));
		
		
		getInputMap().put(KeyStroke.getKeyStroke("ctrl d"), "d-afbeelding");
		getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		
		
		JScrollPane scrollpaneel = new JScrollPane(new PreviewPanel(imagemodel));
		scrollpaneel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpaneel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollpaneel,BorderLayout.WEST);
		add(new FotoPaneel(imagemodel),BorderLayout.CENTER);
	}

}
