package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

/**
 * A puma eats deers and competes against a jaguar. 
 */
public class Puma extends Animal 
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Puma (Jungle j, int r, int c, int a) 
	{
		super.age = a;
		super.row = r;
		super.column = c;
		super.jungle = j;
	}
		
	/**
	 * A puma occupies the square. 	 
	 */
	public State who()
	{
		return State.PUMA; 
	}
	
	/**
	 * A puma dies of old age or hunger, or from attack by a jaguar. 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		if (age == PUMA_MAX_AGE) {
			return new Empty(jNew, row, column);
		}
		
		int[] population = new int[5];
		census(population);
		if (population[JAGUAR] > population[PUMA]) {
			return new Jaguar(jNew, row, column, 0);
		}
		
		else if (population[JAGUAR] + population[PUMA] > population[DEER]) {
			return new Empty(jNew, row, column);
		}
		
		else {
			return new Puma(jNew, row, column, age + 1);
		}
	}
	
	public String toString() {
		return "P" + myAge() + " ";
	}
}
