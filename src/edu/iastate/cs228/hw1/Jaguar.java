package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

/**
 * A jaguar eats a deer and competes against a puma. 
 */
public class Jaguar extends Animal
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Jaguar (Jungle j, int r, int c, int a) 
	{
		super.age = a;
		super.row = r;
		super.column = c;
		super.jungle = j;
	}

	/**
	 * A jaguar occupies the square. 	 
	 */
	public State who()
	{
		return State.JAGUAR; 
	}

	/**
	 * A jaguar dies of old age or hunger, from isolation and attack by more numerous pumas.
	 *  
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		int[] population = new int[5];
		census(population);
		if (age == JAGUAR_MAX_AGE) {
			return new Empty(this.jungle, this.row, this.column);
		}

		else if (population[PUMA] >= population[JAGUAR]*2) {
			return new Puma(jNew, row, column, 0);
		}

		else if (population[JAGUAR] + population[PUMA] > population[DEER]) {
			return new Empty(jNew, row, column);
		}

		else {
			return new Jaguar(jNew, row, column, age + 1);
		}
	}

	public String toString() {
		return "J" + myAge() + " ";
	}
}
