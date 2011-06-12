package panelen;

import imageController.ImageModel;
import imageController.MyImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		setPreferredSize(new Dimension(200,200));
		setBackground(Color.white);
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
			int x = 15;
			int y = 10;
			Graphics2D g2 = (Graphics2D)g;
			for(int i = 0; i < lijst.size(); i++){
				
				if(lijst.get(i).getImage().equals(imagemodel.getCurrentImage())){
				g2.drawRect(0, y, 250, 150);
				g2.setColor(Color.gray);
				g2.fillRect(0, y, 250, 150);
				}
				g2.drawImage(lijst.get(i).getImage(), x, y, 180, 150, null);
				y += 190;
			}
			setPreferredSize(new Dimension(200,y));
			revalidate();
			System.out.println(getAlignmentX());
			System.out.println(getAlignmentY());
		}
			

	}
	

