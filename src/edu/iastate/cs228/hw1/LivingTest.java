package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class LivingTest {

	Jungle j = new Jungle(6);
	
	@Test
	public void censusTest() {
		j.randomInit();
		int[] pop = new int[5];
		j.grid[2][3].census(pop);
		int numPop = 0;
		for (int x = 0; x < 5; x++) {
			numPop += pop[x];
		}
		
		assertEquals("Something is wrong with the census method", 9, numPop);
	}
	
	@Test
	public void censusTest2() {
		int[] pop = new int[5];
		j.randomInit();
		j.grid[0][0].census(pop);
		int numPop = 0;
		for (int x = 0; x < 5; x++) {
			numPop += pop[x];
		}
		
		assertEquals("Something is wrong with the census method", 4, numPop);
	}
	
	@Test
	public void genNeighborHoodTest() {
		j.randomInit();
		Living[][] lAA = j.grid[2][3].genNeighborhood();
		assertEquals("genNeighborHood() helper method is not set up correctly", 3, lAA.length);
	}
	
	@Test
	public void genNeighborHoodTest2() {
		j.randomInit();
		Living[][] lAA = j.grid[j.getWidth() - 1][j.getWidth() - 1].genNeighborhood();
		assertEquals("genNeighborHood() helper method is not set up correctly", 2, lAA.length);
	}
	
	@Test
	public void whoTest() throws FileNotFoundException {
		j = new Jungle("public1-3x3.txt");
		assertEquals("who() method is not set up correctly", State.GRASS, j.grid[0][2].who());
	}
	
	@Test
	public void nextTest() throws FileNotFoundException {
		j = new Jungle("public1-3x3.txt");
		Jungle q = new Jungle(3);
		assertEquals("next() method is not set up correctly", new Puma(q, 2, 1, 1).getClass(), j.grid[1][2].next(q).getClass());
	}
}
