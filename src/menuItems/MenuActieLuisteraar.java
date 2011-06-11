package menuItems;

import imageController.ImageModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import menuActies.Closeapp;
import menuActies.Fez;
import menuActies.OpenAfbeelding;
import menuActies.OpenFolder;

public class MenuActieLuisteraar implements ActionListener{
	private ImageModel imagemodel;
	private Map<String,MenuActies> mapping = new HashMap<String, MenuActies>();
	public MenuActieLuisteraar(ImageModel imagemodel){
		this.imagemodel = imagemodel;
		mapping.put("open-afb",new OpenAfbeelding());
		mapping.put("open-folder",new OpenFolder());
		mapping.put("close-app",new Closeapp());
		mapping.put("fez",new Fez());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mapping.get(e.getActionCommand()).execute(imagemodel);
	}

}
