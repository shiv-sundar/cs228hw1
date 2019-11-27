package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class JungleTest {

	String msg = "This instance is not created properly \nf";
	Jungle j = new Jungle(3);
	Jungle j1 = new Jungle(7);

	@Test
	public void testEmptyConstructor() {
		assertEquals(msg, 3, j.getWidth());
	}

	@Test
	public void testEmptyConstructor2() {
		assertEquals(msg, Jungle.class, j.getClass());
	}

	@Test
	public void testRandomInit() {
		j1.randomInit();
		Random rand = new Random();
		assertEquals(msg, false, j1.grid[rand.nextInt(j1.getWidth())][rand.nextInt(j1.getWidth())] == null);
	}

	@Test
	public void testRandomInit2() {
		j.randomInit();
		Random rand = new Random();
		assertEquals(msg, false, j.grid[rand.nextInt(j.getWidth())][rand.nextInt(j.getWidth())] == null);
	}

	@Test
	public void testGetWidth() {
		assertEquals(msg, true, 3 == j.getWidth());
	}

	@Test
	public void testGetWidth2() {
		assertEquals(msg, true, 7 == j1.getWidth());
	}

	@Test
	public void testFileConstructor() throws FileNotFoundException {
		j = new Jungle("public1-3x3.txt");
		assertEquals(msg, State.JAGUAR, j.grid[0][1].who());
	}

	@Test
	public void testFileConstructor2() throws FileNotFoundException {
		j = new Jungle("public2-6x6.txt");
		assertEquals(msg, 6, j.getWidth());
	}

	@Test
	public void testWrite() throws FileNotFoundException {
		j = new Jungle("public2-6x6.txt");
		j.write("newTest.txt");
		File file = new File("public2-6x6.txt");
		File file1 = new File("newTest.txt");
		Scanner scan1 = new Scanner(file);
		Scanner scan2 = new Scanner(file1);
		while (scan1.hasNextLine()) {
			char[] cA1 = scan1.nextLine().toCharArray();
			char[] cA2 = scan2.nextLine().toCharArray();
			for (int x = 0; x < cA1.length; x++) {
				if (cA1[x] != cA2[x]) {
					assertEquals("The write method is not correct", true, false);
				}
			}
		}
		
		scan1.close();
		scan2.close();
		assertEquals("The write method is not correct", true, true);
	}
}
