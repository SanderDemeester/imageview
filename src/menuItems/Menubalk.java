package menuItems;

import imageController.ImageModel;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menubalk extends JMenuBar{
	private JMenu[] menu = new JMenu[4]; //de algemenu menu's
	private JMenuItem[] menuitem = new JMenuItem[4];
	
	private final String[] ACTIECOMMAND =  {"open-afb","open-folder","close-app","fez"};
	private final String[] OPSCHRIFT = {"Open afbeelding",
										"Open folder",
										"Sluit programma",
										"fez"};
	private final String[] LISTACCELERATOR = {"ctrl A","ctrl O","ctrl Q","ctrl F"};
	
	
	public Menubalk(ImageModel imagemodel){
		super();
		for(int i = 0; i < OPSCHRIFT.length; i++){
			menuitem[i] = new JMenuItem(OPSCHRIFT[i]);
			menuitem[i].setActionCommand(ACTIECOMMAND[i]);
			menuitem[i].addActionListener(new MenuActieLuisteraar(imagemodel));
			menuitem[i].setAccelerator(KeyStroke.getKeyStroke(LISTACCELERATOR[i]));
		}
		
		menu[0] = new JMenu("Bestand");
		menu[0].setMnemonic(KeyEvent.VK_M);
		JMenu menu = new JMenu("Bestand");
		
		for(int i = 0; i < menuitem.length-1; i++)
		menu.add(menuitem[i]);
		
		menu.addSeparator();
		menu.add(menuitem[3]);
		
		add(menu);
	}
}
