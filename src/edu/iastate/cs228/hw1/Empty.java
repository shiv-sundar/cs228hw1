package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Jungle j, int r, int c) 
	{
		super.jungle = j;
		super.column = c;
		super.row = r;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Deer, Grass, Jaguar, or Puma, or 
	 * remain empty. 
	 * @param jNew     jungle in the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Jungle jNew)
	{
		int[] population = new int[5];
		census(population);
		
		if (population[DEER] > 1) {
			return new Deer(jNew, row, column, 0);
		}
		
		else if (population[PUMA] > 1) {
			return new Puma(jNew, row, column, 0);
		}
		
		else if (population[JAGUAR] > 1) {
			return new Jaguar(jNew, row, column, 0);
		}
		
		else if (population[GRASS] >= 1) {
			return new Grass(jNew, row, column);
		}
		
		else {
			return new Empty(jNew, row, column);
		}
	}
	
	public String toString() {
		return "E  ";
	}
}
