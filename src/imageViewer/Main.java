package imageViewer;

import imageController.ImageModel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import menuItems.Menubalk;
import panelen.Paneel;

public class Main {
	
	private static void createGUI(){
		ImageModel imagemodel = new ImageModel();
		JFrame frame = new JFrame("Image viewer");
		frame.setContentPane(new Paneel(imagemodel));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(800,500));
		frame.pack();
		
		frame.setJMenuBar(new Menubalk(imagemodel));
	}
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createGUI();
			}
		});
	}

}
