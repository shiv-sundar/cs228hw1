package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class DeerTest{
	
	Deer d = new Deer(null, 2, 1, 0);
	
	@Test
	public void constructorTest() {
		assertEquals("The Deer is not constructed properly", 0, d.age);
	}
	
	@Test
	public void constructorTest2() {
		assertEquals("The Deer is not constructed properly", 2, d.row);
	}
	
	@Test
	public void constructorTest3() {
		assertEquals("The Deer is not constructed properly", 1, d.column);
	}
	
	@Test
	public void whoTest() {
		assertEquals("The Deer is not constructed properly", State.DEER, d.who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-3x3.txt");
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The Deer next method is not correct", new Jaguar(j1, 1, 2, 0).getClass(), ((Deer) j.grid[1][1]).next(j1).getClass());
	}
	
	@Test
	public void ageTest() {
		assertEquals("The age() method is not set up properly", 0, d.myAge());
	}
	
	@Test
	public void stringTest() {
		assertEquals("The toString() method is not set up properly", "D0 ", d.toString());
	}
}