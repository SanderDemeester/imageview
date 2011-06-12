package imageViewer;

import imageController.ImageModel;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import menuItems.Menubalk;
import panelen.Paneel;

public class Main {
	
	private static void createGUI(){
		ImageModel imagemodel = new ImageModel();
		JFrame frame = new JFrame("Developerbranch");
		frame.setContentPane(new Paneel(imagemodel));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(800,500));
		frame.pack();
		
		frame.setJMenuBar(new Menubalk(imagemodel));
	}
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			//set de default look and feel
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createGUI();
			}
		});
	}

}
