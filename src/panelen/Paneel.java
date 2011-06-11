package panelen;

import imageController.ImageModel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import acties.AfbeeldingDeleteAction;

public class Paneel extends JPanel{
	
	public Paneel(ImageModel imagemodel){
		super();
		setLayout(new BorderLayout());
		
		ActionMap actiemap = this.getActionMap();
		actiemap.put("d-afbeelding",new AfbeeldingDeleteAction(imagemodel));
		
		InputMap inputMap = this.getInputMap();
		inputMap.put(KeyStroke.getKeyStroke("ctrl D"), "d-afbeelding");
		
		
		JScrollPane scrollpaneel = new JScrollPane(new PreviewPanel(imagemodel));
		scrollpaneel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollpaneel,BorderLayout.WEST);
		add(new FotoPaneel(imagemodel),BorderLayout.CENTER);
	}

}
