package panelen;

import imageController.ImageModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FotoPaneel extends JPanel implements ChangeListener{
	private ImageModel imagemodel;
	private Image image = null;
	public FotoPaneel(ImageModel imagemodel){
		super();
		this.imagemodel = imagemodel;
		imagemodel.addChangeListener(this);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.black);
		setPreferredSize(new Dimension(300,800));
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		image = imagemodel.getCurrentImage();
		repaint();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintt(g);
		}
	
	public void paintt(Graphics g){
//		g.drawRect(20, 20, 500, 300);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		if(image != null){
			BufferedImage bi = new BufferedImage(image.getWidth(null),
					image.getHeight(null),
					BufferedImage.TYPE_USHORT_565_RGB);
			Graphics gg = bi.getGraphics();
			g2.drawImage(image, 10, 10, getWidth()-20, getHeight()-20, null);
		}
	}

}
