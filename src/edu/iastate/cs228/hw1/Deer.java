package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

/*
 * A deer eats grass and lives no more than six years.
 */
public class Deer extends Animal 
{
	/**
	 * Creates a Deer object.
	 * @param j: jungle  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Deer (Jungle j, int r, int c, int a) 
	{
		super.age = a;
		super.jungle = j;
		super.row = r;
		super.column = c;
	}

	// Deer occupies the square.
	public State who()
	{
		return State.DEER; 
	}

	/**
	 * @param jNew     jungle in the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Jungle jNew)
	{
		int[] population = new int[5];
		census(population);
		if (age == DEER_MAX_AGE) {
			return new Empty(jNew, row, column);
		}
		
		else if (population[GRASS] == 0) {
			return new Empty(jNew, row, column);
		}
		
		else if (population[PUMA] + population[JAGUAR] > population[DEER] && population[PUMA] >= population[JAGUAR]*2) {
			return new Puma(jNew, row, column, 0);
		}
		
		else if (population[PUMA] + population[JAGUAR] > population[DEER] && population[JAGUAR] >= population[PUMA]) {
			return new Jaguar(jNew, row, column, 0);
		}
		
		else {
			return new Deer(jNew, row, column, age + 1);
		}
	}

	public int myAge() {
		return super.myAge();
	}
	
	public String toString() {
		return "D" + myAge() + " ";
	}
}
