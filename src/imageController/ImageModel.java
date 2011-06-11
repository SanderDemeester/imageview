package imageController;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ImageModel extends Model{
	private ArrayList<MyImage> lijstafbeeldingen = new ArrayList<MyImage>();
	private static final int hoogteafbeelding = 190;
	private MyImage voorkeurImage = new MyImage();
	private MyImage huidigeSelectImage = new MyImage();

	public ImageModel(){
		super();
		voorkeurImage = null;
		huidigeSelectImage = null;
		
	}
	public void setLijstafbeeldingen(ImageIcon[] lijst){
		for(ImageIcon icon : lijst){
			lijstafbeeldingen.add(new MyImage(icon, new Rectangle(0, 
					lijstafbeeldingen.size()*hoogteafbeelding, 
					200, 
					180)));
		}
		fireStateChanged();
	}
	public ArrayList<MyImage> getLijst(){
		return lijstafbeeldingen;
	}
	public void setSelectedImage(MyImage image) {
		// TODO Auto-generated method stub
		huidigeSelectImage = image;
		fireStateChanged();
		
	}
	
	public Image getCurrentImage() {
		// TODO Auto-generated method stub
		if(huidigeSelectImage != null)
		return huidigeSelectImage.getImage();
		else 
			return null;
	}
	
	public void deleteCurrentImage(){
		int index = lijstafbeeldingen.indexOf(huidigeSelectImage);
		lijstafbeeldingen.remove(huidigeSelectImage);
		if(lijstafbeeldingen.size() > 0){
		huidigeSelectImage=lijstafbeeldingen.get(index%lijstafbeeldingen.size());
		}else{
			huidigeSelectImage = null;
		}
		fireStateChanged();
	}
	public MyImage getCurrentMyImage() {
		// TODO Auto-generated method stub
		return huidigeSelectImage;
	}
	

}
