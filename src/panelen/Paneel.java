package panelen;

import imageController.ImageModel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ProgressMonitor;

import settingsobject.PanelControler;
import acties.AfbeeldingDeleteAction;
import acties.MoveDown;
import acties.MoveUp;

public class Paneel extends JPanel{
	
	private JScrollBar scrollbar;
	private ImageModel imagemodel;
	private PanelControler panelcontroler;
	private JProgressBar jprogressbar;
	private ProgressMonitor pmonitor;
	private int aantalfotos;
	
	public Paneel(ImageModel imagemodel, PanelControler panelcontroler){
		super();
		this.imagemodel = imagemodel;
		this.panelcontroler = panelcontroler;
		
		jprogressbar = new JProgressBar();
		
		panelcontroler.setpanel(this);
		imagemodel.setPanelControler(panelcontroler);
		setLayout(new BorderLayout());
		
		getActionMap().put("d-afbeelding",new AfbeeldingDeleteAction(imagemodel));
		getActionMap().put("up", new MoveUp(imagemodel,this));
		getActionMap().put("down", new MoveDown(imagemodel,this));
		
		
		getInputMap().put(KeyStroke.getKeyStroke("ctrl D"), "d-afbeelding");
		getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		
		
		JScrollPane scrollpaneel = new JScrollPane(new PreviewPanel(imagemodel));
		scrollpaneel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpaneel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpaneel.getVerticalScrollBar().setUnitIncrement(16);
		
		scrollbar = scrollpaneel.getVerticalScrollBar();
		add(scrollpaneel,BorderLayout.WEST);
		add(new FotoPaneel(imagemodel),BorderLayout.CENTER);
	}
	
	public void updateScrollPanel(){
		int pos = imagemodel.getCurrentIndexOfSelectedImage();
		int scrollbarmax = scrollbar.getMaximum();
		int scrollbarmin = scrollbar.getMinimum();
		
		System.out.println("max : " + scrollbarmax);
		System.out.println("min : " + scrollbarmin);
		System.out.println("pos : " + pos);
		scrollbar.setValue(scrollbar.getValue()-200);
		System.out.println("scrolbar huidige value" + scrollbar.getValue());
		
	}

	public void startprogressbar(int max) {
		// TODO Auto-generated method stub
		System.out.println("Start progresbar Paneel.java - startprogessbar");
		System.out.println(max);
		aantalfotos = max;
		pmonitor = new ProgressMonitor(this, "De afbeelding worden ingeladen", "", 0, max);
		
	}
	public void stepProgresBar(int aantal){
		System.out.println(aantal);
		pmonitor.setNote("Ingeladen: " + aantal);
		if(aantal == aantalfotos){
			System.out.println("close progressbar");
			pmonitor.close();
		}
	
		pmonitor.setProgress(aantal);
	}

}
