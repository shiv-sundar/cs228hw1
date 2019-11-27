package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class CircleOfLifeTest {

	@Test
	public void updateJungleTest() {
		Jungle j = new Jungle(3);
		j.randomInit();
		Jungle j1 = new Jungle(3);
		CircleOfLife.updateJungle(j, j1);
		boolean isNull = false;
		for (int row = 0; row < j.getWidth(); row++) {
			for (int col = 0; col < j.getWidth(); col++) {
				if (j1.grid[row][col] == null) {
					isNull = true;
					assertEquals("The updateJungle() method does not work properly", false, isNull);
				}
			}
		}

		assertEquals("The updateJungle() method does not work properly", false, isNull);
	}
	
	@Test
	public void updateJungleTest2() throws FileNotFoundException {
		Jungle j = new Jungle("public3-10x10.txt");
		Jungle j1 = new Jungle(10);
		CircleOfLife.updateJungle(j, j1);
		assertEquals("The updateJungle() method does not work properly", State.PUMA, j1.grid[6][4].who());
	}
}