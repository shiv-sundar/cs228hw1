package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author Shivkarthi Sundar
 *
 */
public class AnimalTest {

	Animal a = (Animal) new Jaguar(null, 2, 1, 3);
	Animal b = (Animal) new Puma(null, 3, 4, 2);
	
	@Test
	public void testAnimal() {
		assertEquals("The Animal is not set up properly", true, 3 == a.myAge());
	}

	@Test
	public void testAnimal2() {
		assertEquals("The Animal is not set up properly", true, 2 == b.myAge());
	}
}
