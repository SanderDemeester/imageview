package settingsobject;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import panelen.Paneel;

public class PanelControler{
	private Paneel paneel;
	private int aantal = 1;
	public void setpanel(Paneel paneel) {
		// TODO Auto-generated method stub
		this.paneel = paneel;
	}
	
	public void step(){
		aantal = aantal +1;
				paneel.stepProgresBar(aantal);
	
	}

	public void startprogressbar(final int max) {
				paneel.startprogressbar(max);
		
	}


}
