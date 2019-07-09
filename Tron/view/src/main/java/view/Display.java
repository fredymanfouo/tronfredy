package view;
/**
 * <h1>The Display class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.IElements;
import model.ITronModel;

public class Display extends JPanel implements Observer {
	/** The serial version. */
	private static final long serialVersionUID = 1L;
	
	/** le model. */
	private ITronModel model;
	
	
	public Display(ITronModel model) {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		System.out.println("Affichage");
		this.model = model;
		
		model.getGrid().getRider1().addObserver(this);
		model.getGrid().getRider2().addObserver(this);
		
		
		
		
	}
	
	public void drawGrid(Graphics g)throws IOException, InterruptedException {
		
		
		/**Rider1
   *@author fredy Manfouo
	 * since 2019-07-08
	 */
		g.setColor(model.getGrid().getRider1().getColor());
		g.fillRect(
				model.getGrid().getRider1().getX()*model.getGrid().getWidth()/(model.getGrid().getNbCelsWidth()),
				model.getGrid().getRider1().getY()*model.getGrid().getHeight()/(model.getGrid().getNbCelsHeight()),
				model.getGrid().getWidth()/(model.getGrid().getNbCelsWidth()),
				model.getGrid().getHeight()/(model.getGrid().getNbCelsHeight())
				
				);
		/**Rider2
	*@author fredy Manfouo
	 * since 2019-07-08
		 */
		g.setColor(model.getGrid().getRider2().getColor());
		g.fillRect(
				model.getGrid().getRider2().getX()*model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
				model.getGrid().getRider2().getY()*model.getGrid().getHeight()/model.getGrid().getNbCelsHeight(),
				model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
				model.getGrid().getHeight()/model.getGrid().getNbCelsHeight()
				
				);
		
		
		
		//Rider1 particles
		for (IElements element : model.getGrid().getRider1().getParticles()) {
			g.setColor(model.getGrid().getRider1().getColor());
			g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
		}
		// rider 2 particles
		for (IElements element : model.getGrid().getRider2().getParticles()) {
			g.setColor(model.getGrid().getRider2().getColor());
			g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			 try {
				drawGrid(g);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		/**System.out.println("mise a jour ")
		 * *@author fredy Manfouo
	 * since 2019-07-08;
		 */
		
	}

}
