package menuActies;

import imageController.ImageFilter;
import imageController.ImageModel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menuItems.MenuActies;

public class OpenFolder implements MenuActies{
	private JFileChooser folderkiezer = new JFileChooser("/home");
	private File folder;

	@Override
	public void execute(ImageModel imagemodel) {
		// TODO Auto-generated method stub
		BufferedImage[] lijstafbeeldingen;
		folderkiezer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		folderkiezer.showOpenDialog(null);
		folder = folderkiezer.getSelectedFile();
		
		if(folder != null){
		File[] bestanden = folder.listFiles(new ImageFilter());
		lijstafbeeldingen = new BufferedImage[bestanden.length];
		imagemodel.getPanelctr().startprogressbar(bestanden.length);
		for(int i = 0; i < bestanden.length; i++)
			try {
				lijstafbeeldingen[i] = ImageIO.read(new File(bestanden[i].getAbsolutePath()));
				imagemodel.getPanelctr().step();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fout gebeurd(t) tijdens het inladen van de nieuwe afbeedingen");
				JOptionPane.showMessageDialog(null, "Er is een fout gebeurd(t) tijdens het inladen van de foto's," +
						"dit zou normaal nooit mogen gebeuren");
			}
		
		
		imagemodel.setLijstafbeeldingen(lijstafbeeldingen);
		}


	}

}
