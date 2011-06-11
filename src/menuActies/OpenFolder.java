package menuActies;

import imageController.ImageFilter;
import imageController.ImageModel;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import menuItems.MenuActies;

public class OpenFolder implements MenuActies{
	private JFileChooser folderkiezer = new JFileChooser("/home");
	private File folder;

	@Override
	public void execute(ImageModel imagemodel) {
		// TODO Auto-generated method stub
		ImageIcon[] lijstafbeeldingen;
		folderkiezer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		folderkiezer.showOpenDialog(null);
		folder = folderkiezer.getSelectedFile();
		
		File[] bestanden = folder.listFiles(new ImageFilter());
		lijstafbeeldingen = new ImageIcon[bestanden.length];
		for(int i = 0; i < bestanden.length; i++)
			lijstafbeeldingen[i] = new ImageIcon(bestanden[i].getAbsolutePath());
		imagemodel.setLijstafbeeldingen(lijstafbeeldingen);


	}

}
