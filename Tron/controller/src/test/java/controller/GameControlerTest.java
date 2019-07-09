package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ITronModel;
import view.IView;


public class GameControlerTest {

	IView view;
	ITronModel model;
	
	public GameControler gamecontroller;
	
	/**
	 * Set up the test configuration.
	 * 
	 * @throws Exception
	 * 			Signals that an exception has occurred
	 */
	@Before
	public void setUp() throws Exception {
	gamecontroller = new GameControler(null, null);
	}
	/**
	 * V�rifie que le mod�le est le bon
	 */
	@Test
	public void testcontrolermodel() {
		ITronModel modelExpected = null ;
		assertEquals(modelExpected,gamecontroller.model);
		
	} 
	/**
	 * V�rifie que la vue est la bonne
	 */
	@Test
	public void testcontrolerview() {
		IView viewExpected = null ;
		assertEquals(viewExpected,gamecontroller.view);
	}	

}
