package panelen;

import imageController.ImageModel;
import imageController.MyImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mouseControler.MouseControler;
import acties.AfbeeldingDeleteAction;
import acties.MoveDown;
import acties.MoveUp;

public class PreviewPanel extends JPanel implements ChangeListener{
	private ImageModel imagemodel;
	private ArrayList<MyImage> lijst = new ArrayList<MyImage>();
	private MouseControler mousecontroler;
	public PreviewPanel(ImageModel imagemodel){
		super();
		this.imagemodel = imagemodel;
		imagemodel.addChangeListener(this);
		mousecontroler = new MouseControler(imagemodel);
	    
		addMouseListener(mousecontroler);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(200,800));
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		lijst = imagemodel.getLijst();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintt(g);
		}

		public void paintt(Graphics g){
			int x = 0;
			int y = 0;
			Graphics2D g2 = (Graphics2D)g;
			for(int i = 0; i < lijst.size(); i++){
				System.out.println("hier");
				System.out.println(i);
				g2.drawImage(lijst.get(i).getImage(), x, y, 200, 180, null);
//				g2.draw(lijst.get(i).getrec());
				y += 190;
			}
		}
			

	}
	

