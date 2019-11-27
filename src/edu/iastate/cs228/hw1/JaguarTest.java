package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class JaguarTest {
	Jaguar j = new Jaguar(null, 2, 1, 0);
	
	@Test
	public void constructorTest() {
		assertEquals("The Jaguar is not constructed properly", 0, j.age);
	}
	
	@Test
	public void constructorTest2() {
		assertEquals("The Jaguar is not constructed properly", 2, j.row);
	}
	
	@Test
	public void constructorTest3() {
		assertEquals("The Jaguar is not constructed properly", 1, j.column);
	}
	
	@Test
	public void whoTest() {
		assertEquals("The Jaguar is not constructed properly", State.JAGUAR, j.who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-3x3.txt");
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The Jaguar next method is not correct", new Empty(j1, 1, 2).getClass(), ((Jaguar) j.grid[0][1]).next(j1).getClass());
	}
	
	@Test
	public void ageTest() {
		assertEquals("The age() method is not set up properly", 0, j.myAge());
	}
	
	@Test
	public void stringTest() {
		assertEquals("The toString() method is not set up properly", "J0 ", j.toString());
	}
}
