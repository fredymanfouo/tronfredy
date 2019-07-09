package model;

public class timer implements ITimer{
	private double time;
	
	public timer() {
		time=0;
	}
	/** lancer le jeu
	 * @author fredy Manfouo
	 * since 2019-07-08
	 */
	public void start() {
		this.time=System.currentTimeMillis();
	}
	
	/**  arreter le jeu
	 * @author fredy Manfouo
	 * since 2019-07-08
	 */
	public void stop() {
		
		this.time=(System.currentTimeMillis()-time)/1000;
	}
	
	public double getTime() {
		
		return this.time;
	}
	
}
