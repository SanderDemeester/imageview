package imageController;

import java.io.File;
import java.io.FileFilter;

public class ImageFilter implements FileFilter{

	private String[] ext = {"jpg","png","gif"};
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		for(String exttest : ext){
			if(file.getName().toLowerCase().endsWith(exttest))
				return true;
			else 
				return false;
		}
		return false;
	}

}
