package model;
/**
 * <h1>The  Element Interface</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import java.awt.Color;
import java.util.Observer;



public interface IElements {
	/**
	 * Get Element's X
	 * @return x
	 */
	public int getX();
	/**
	 * Get Element's y
	 * @return y
	 */
	public int getY();
	/**
	 * Get Element's color
	 * @return color
	 */
	public Color getColor();
	
	/**
	 * Add observer
	 * @param o
	 */
	void addObserver(Observer o);

	
	
	

}
