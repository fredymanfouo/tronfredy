package model;



/**
 * <h1>The Grid Interface</h1>
 * 
 * 
 * @version 1.0
 */
public interface IGrid {
	/**
	 * get nb cels height
	 */
	public int getNbCelsHeight();
	/**
	 * get nb cels width
	 */
	public int getNbCelsWidth();
	/**
	 * get the width
	 */
	public int getWidth();
	/**
	 * get the height
	 */
	public int getHeight();
	/**
	 * get rider 1
	 */
	public IRider getRider1();
	/**
	 * Get the rider 2
	 */
	public IRider getRider2();
	
	public ITimer getTimer();
	
	
	public void save();
	
	

}
