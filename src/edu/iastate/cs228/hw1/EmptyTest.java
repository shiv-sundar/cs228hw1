package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class EmptyTest {

	Empty e = new Empty(null, 3, 4);
	
	@Test
	public void constructorTest2() {
		assertEquals("The Empty is not constructed properly", 3, e.row);
	}
	
	@Test
	public void constructorTest() {
		assertEquals("The Empty is not constructed properly", 4, e.column);
	}
	
	@Test
	public void whoTest() {
		assertEquals("The Empty is not constructed properly", State.EMPTY, e.who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-3x3.txt");
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The Empty next method is not correct", new Deer(j1, 1, 2, 0).getClass(), ((Empty) j.grid[2][2]).next(j1).getClass());
	}
	
	@Test
	public void stringTest() {
		assertEquals("The toString() method is not set up properly", "E  ", e.toString());
	}

}
