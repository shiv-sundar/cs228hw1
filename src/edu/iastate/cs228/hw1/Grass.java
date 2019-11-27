package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

/**
 * Grass may be eaten out or taken over by deers. 
 *
 */
public class Grass extends Living 
{
	public Grass (Jungle j, int r, int c) 
	{
		super.jungle = j;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many deers in the neighborhood. Deers may also 
	 * multiply fast enough to take over Grass. 
	 * 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		int[] population = new int[5];
		census(population);
		if (population[DEER] >= population[GRASS]*3) {
			return new Empty(jNew, row, column);
		}
		
		else if (population[DEER] >= 4) {
			return new Deer(jNew, row, column, 0);
		}
		
		else {
			return new Grass(jNew, row, column);
		}
	}
	
	public String toString() {
		return "G  ";
	}
}
