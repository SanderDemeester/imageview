package settingsobject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

import panelen.Paneel;

public class PanelControler implements PropertyChangeListener{
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

	public void startprogressbar(int max) {
		// TODO Auto-generated method stub
		paneel.startprogressbar(max);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		JProgressBar bar = (JProgressBar)evt.getSource();
		bar.setValue(bar.getValue()+1);
		
		
	}

}
