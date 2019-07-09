package view;
/**
 * <h1>The Frame Class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ITronModel;

public class Frame extends JFrame implements KeyListener, IView {
	
	/** The serial version. */
	private static final long serialVersionUID = -7393744101067014109L;
	
	/** The width of the frame. */
	private int width;
	
	/** The height of the frame. */
	private int height;
	
	
	private Display display;
	

	private ITronModel model;
	
	
	
 	
 	
 	
	
	/**
	 * Instantiation de  nouveau frame
	 **@author fredy Manfouo
	 * since 2019-07-08
	 * @param model
	 * 			the model
	 */
	public Frame(ITronModel model) {
		this.model = model;
		this.width=model.getGrid().getWidth();
		this.height=model.getGrid().getHeight();
		
		this.display = new Display(this.model);
		this.setTitle("Tron");
	    this.setContentPane(this.display);
	    this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.addKeyListener(this);
		this.setVisible(true);

	}



	/**
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 *@author fredy Manfouo
	 * since 2019-07-08
	 */
	@Override
  	public final void keyPressed(final KeyEvent keyEvent) {
  	switch(keyEvent.getKeyCode()) {
  	case KeyEvent.VK_RIGHT: model.getGrid().getRider1().turnRight();System.out.println("1r");break;
  	case KeyEvent.VK_LEFT: model.getGrid().getRider1().turnLeft();System.out.println("1l");break;
  	case KeyEvent.VK_D: model.getGrid().getRider2().turnRight();System.out.println("2r");break;
  	case KeyEvent.VK_Q: model.getGrid().getRider2().turnLeft();System.out.println("2l");break;
  	default:break;
  	
  	
  	
  	
  	}
		 
	}
	

	public final void keyTyped(final KeyEvent keyEvent) {
		// this.keyCodeToUserOrder(keyEvent.getKeyCode());
		
	}
	    
	/**
	 * Repaint the components.
	 */ 
	public void repaint() {
		this.display.repaint();
		
	}

	
	/**
	 * Get the display.
	 * 
	 * @return the display
	 */
	public Display getDisplay() {
		return display;
		
	}
	
	/**
	 * Get the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
		
	}

	
	/**
	 * Set the width.
	 * 
	 * @param width
	 * 			the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
		
	}

	/**
	 * Get the height.
	 * 
	 * @return the Height
	 */
	public int getHeight() {
		return height;
		
	}
	
	/**
	 * Set the height.
	 * 
	 * @param height
	 * 			the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
		
	}

	/**
	 * Set the display.
	 * 
	 * @param Display
	 * 			the display to set
	 */
	
	public void setDisplay(Display Display) {
		this.display = Display;
		
	}


	/**
	 * (non-Javadoc)
	 * @see view.IView#displayMessage
	 */
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));	
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}