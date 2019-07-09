package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;



public class RiderTest {

	private Rider rider;
	private Direction directiontest = Direction.NORD;
	
	private Grid grid;
	 /**
	 * Set up the test configuration.
	 * 
	 * @throws Exception
	 * 			Signals that an exception has occurred
	 */
	@Before
	public void setUp() throws Exception {
		rider = new Rider(100, 200, Color.red, directiontest, grid);
		}
	/**
	 * Test pour tourner à droite
	 */
	@Test
	public void testTurnRight() {
		rider.turnRight();
		assertEquals(Direction.EST,rider.direction);
	}

	/**
	 * Test pour tourner à gauche
	 */
	
	@Test
	public void testTurnLeft() {
		rider.turnLeft();
		assertEquals(Direction.OUEST,rider.direction);
	}
}
