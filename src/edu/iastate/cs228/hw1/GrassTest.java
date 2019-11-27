package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class GrassTest {
	Grass g = new Grass(null, 3, 4);
	
	@Test
	public void constructorTest2() {
		assertEquals("The Grass is not constructed properly", 3, g.row);
	}
	
	@Test
	public void constructorTest() {
		assertEquals("The Grass is not constructed properly", 4, g.column);
	}
	
	@Test
	public void whoTest() {
		assertEquals("The Grass is not constructed properly", State.GRASS, g.who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		Jungle j = new Jungle("public1-3x3.txt");
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The Deer next method is not correct", new Grass(j1, 1, 2).getClass(), ((Grass) j.grid[0][0]).next(j1).getClass());
	}
	
	@Test
	public void stringTest() {
		assertEquals("The toString() method is not set up properly", "G  ", g.toString());
	}
}
