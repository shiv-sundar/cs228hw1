package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class PumaTest {
	Puma p = new Puma(null, 2, 1, 0);
	
	@Test
	public void constructorTest() {
		assertEquals("The Puma is not constructed properly", 0, p.age);
	}
	
	@Test
	public void constructorTest2() {
		assertEquals("The Puma is not constructed properly", 2, p.row);
	}
	
	@Test
	public void constructorTest3() {
		assertEquals("The Puma is not constructed properly", 1, p.column);
	}
	
	@Test
	public void whoTest() {
		assertEquals("The Puma is not constructed properly", State.PUMA, p.who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-3x3.txt");
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The Puma next() method is not correct", new Puma(j1, 1, 2, 1).getClass(), ((Puma) j.grid[1][2]).next(j1).getClass());
	}
	
	@Test
	public void ageTest() {
		assertEquals("The age() method is not set up properly", 0, p.myAge());
	}
	
	@Test
	public void stringTest() {
		assertEquals("The toString() method is not set up properly", "P0 ", p.toString());
	}
}
