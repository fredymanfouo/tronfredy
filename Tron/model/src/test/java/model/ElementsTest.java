package model;


import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class ElementsTest {

	private Elements element;
	
	 

	 
	 /**
		 * Set up the test configuration.
		 * 
		 * @throws Exception
		 * 			Signals that an exception has occurred
		 */
		@Before
		public void setUp() throws Exception {
			element = new Elements(10, 12, Color.red);
			
		}
		
		
		/**
		 * Test for getting the color
		 * 
		 *
		 */
		@Test
		public void testgetColor() {
			Color expected = Color.red;
			assertEquals(expected,element.getColor());
			
		} 
		/**
		 * Test pour set la couleur
		 */
		@Test
		public void testsetColor() {
			Color expected = Color.blue;
			element.setColor(Color.blue);
			assertEquals(expected,element.getColor());
			
		} 
		
		
		
		
		
		
}
