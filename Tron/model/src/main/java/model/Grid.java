package model;
/**
 * <h1>The Grid Class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */


import java.awt.Color;

import DAO.Datamanager;



public class Grid implements IGrid{
	
	
	private IRider rider1;
	private IRider rider2;
	private int width = 600;
	private int height = 400;
	private int nbCelsHeight=40;
	private int nbCelsWidth=60;
	private ITimer timer;
	private Datamanager db = new Datamanager();

	
	

	/**
	 * Constructeur
	 * Mise en place 2 riders sur la grid
	 *@author fredy Manfouo
	 * since 2019-07-08 
	 */
	public Grid () {
		this.rider1= new Rider(2,2,Color.white,Direction.EST,this);
		this.rider2= new Rider(30,30,Color.magenta,Direction.OUEST,this);
		this.timer= new timer();
		timer.start();
	}
	
	/**
	 * Vérifie les colision du rider
	 * Vérifie si le rider est dans les colision
	 *@author fredy Manfouo
	 * since 2019-07-08
	 * @param rider
	 * @return boolean colision
	 * 
	 */
	public boolean checkColision(Rider rider) {
		if(rider.getX()>this.nbCelsWidth || rider.getX()<=0 || rider.getY()<=0 || rider.getY()>this.nbCelsHeight) {rider.setAlive(false); return true;} 
		
		for (IElements particle : rider1.getParticles()) {
			if(rider.getX() == particle.getX() && rider.getY() == particle.getY()) {rider.setAlive(false);return true;}
		}
		
		for (IElements particle : rider2.getParticles()) {
			if(rider.getX() == particle.getX() && rider.getY() == particle.getY()) {rider.setAlive(false);return true;}
	
	}
		return false;
	
}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getRider1()
	 */
	@Override
	public IRider getRider1() {
		return rider1;
	}

	/**
	 * Set rider 1
	 */
	public void setRider1(Rider rider1) {
		this.rider1 = rider1;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getRider2()
	 */
	@Override
	public IRider getRider2() {
		return rider2;
	}

	/**
	 * Set rider 2
	 */
	public void setRider2(Rider rider2) {
		this.rider2 = rider2;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getWidth()
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * Set la largeur
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getHeight()
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * set la hauteur en pixel
	 * *@author fredy Manfouo
	 * since 2019-07-08
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getNbCelsHeight()
	 */
	@Override
	public int getNbCelsHeight() {
		return nbCelsHeight;
	}


	public void setNbCelsHeight(int nbCelsHeight) {
		this.nbCelsHeight = nbCelsHeight;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getNbCelsWidth()
	 */
	@Override
	public int getNbCelsWidth() {
		return nbCelsWidth;
	}


	public void setNbCelsWidth(int nbCelsWidth) {
		this.nbCelsWidth = nbCelsWidth;
	}
	@Override
	public ITimer getTimer() {
		return timer;
	}
	@Override
	public void save() {
		
		if(rider1.isAlive()) {
			db.save(2, (int) timer.getTime());}
		else {
			db.save(1, (int) timer.getTime());}
		}
		

}

	
	
	
	
	
	
	
	
	
	
	

