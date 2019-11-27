package edu.iastate.cs228.hw1;

/**
 *  
 * @author Shivkarthi Sundar
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * The jungle is represented as a square grid of size width X width. 
 *
 */
public class Jungle 
{
	private int width; // grid size: width X width 

	public Living[][] grid; 

	/**
	 *  Default constructor reads from a file 
	 */
	public Jungle(String inputFileName) throws FileNotFoundException
	{
		File file = new File(inputFileName);
		width = 0;
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			width += 1;
			scan.nextLine();
		}

		scan.close();
		scan = new Scanner(file);
		Living[][] LAA = new Living[width][width];
		int row = 0;
		int col = 0;
		while (scan.hasNextLine()) {
			Scanner scanLine = new Scanner(scan.nextLine());
			col = 0;
			while (scanLine.hasNext()) {
				char[] living = scanLine.next().toCharArray();
				if (living[0] == 'J') {
					LAA[row][col] = new Jaguar(this, row, col, living[1] - '0'); 
				}
				
				else if (living[0] == 'D') {
					LAA[row][col] = new Deer(this, row, col, living[1] - '0');
				}
				
				else if (living[0] == 'P') {
					LAA[row][col] = new Puma(this, row, col, living[1] - '0');
				}
				
				else if (living[0] == 'G') {
					LAA[row][col] = new Grass(this, row, col);
				}
				
				else {
					LAA[row][col] = new Empty(this, row, col);
				}
				
				col += 1;
			}
			row += 1;
			scanLine.close();
		}
		
		scan.close();
		grid = LAA.clone();
	}

	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Jungle(int w)
	{
		width = w;
		grid = new Living[w][w];
	}


	public int getWidth()
	{
		return width; 
	}

	/**
	 * Initialize the jungle by randomly assigning to every square of the grid  
	 * one of Deer, Empty, Grass, Jaguar, or Puma.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		for (int row = 0; row < grid[0].length; row++) {
			for (int col = 0; col < grid.length; col++) {
				int newLiving = generator.nextInt(5);
				if (newLiving == 0) {
					grid[row][col] = new Puma(this, row, col, 0);
				}
				
				else if (newLiving == 1) {
					grid[row][col] = new Deer(this, row, col, 0);
				}
				
				else if (newLiving == 2) {
					grid[row][col] = new Jaguar(this, row, col, 0);
				}
				
				else if (newLiving == 3) {
					grid[row][col] = new Grass(this, row, col);
				}
				
				else if (newLiving == 4) {
					grid[row][col] = new Empty(this, row, col);
				}
			}
		}
	}


	/**
	 * Output the jungle grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String name = "";
		for (int row = 0; row < grid[0].length; row++) {
			for (int col = 0; col < grid.length; col++) {
				name += grid[row][col].toString();
			}
			
			name += "\n";
		}
		
		return name;
	}


	/**
	 * Write the jungle grid to an output file.  Also useful for saving a randomly 
	 * generated jungle for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File file = new File(outputFileName);
		PrintWriter pw = new PrintWriter(file);
		for (int row = 0; row < this.getWidth(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				pw.write(this.grid[row][col].toString());
			}
			pw.println();
		}
		
		pw.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Jungle j = new Jungle(3);
		j.randomInit();
		j.write("outputFile.txt");
	}
}
