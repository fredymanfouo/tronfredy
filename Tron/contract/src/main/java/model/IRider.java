package model;
/**
 * <h1>The Rider (lightcycle) Interface</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import java.util.ArrayList;

public interface IRider extends IElements{
	/**
	 * Move the rider
	 */
	public void move();
	/**
	 * Get rider's particles
	 */
	public ArrayList<IElements> getParticles();
	/**
	 * turn rider left
	 */
	public void turnLeft();
	/**
	 * Turn rider Right
	 */
	public void turnRight();
	/**
	 * Check if rider isAlive
	 */
	public boolean isAlive();

	
	
}
