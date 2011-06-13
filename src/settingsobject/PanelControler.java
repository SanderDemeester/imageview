package settingsobject;

import java.awt.EventQueue;

import javax.swing.JPanel;

import panelen.Paneel;

public class PanelControler {
	private Paneel paneel;
	private int aantal = 1;
	public void setpanel(Paneel paneel) {
		// TODO Auto-generated method stub
		this.paneel = paneel;
	}
	
	public void step(){
		aantal = aantal +1;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				paneel.stepProgresBar(aantal);
			}
		});
	}

	public void startprogressbar(int max) {
		// TODO Auto-generated method stub
		paneel.startprogressbar(max);
		
	}

}
