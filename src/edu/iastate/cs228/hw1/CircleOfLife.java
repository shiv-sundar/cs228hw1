package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Shivkarthi Sundar
 */

/**
 * 
 * The CircleOfLife class performs simulation over a grid jungle 
 * with squares occupied by deers, jaguars, pumas, grass, or none. 
 *
 */
public class CircleOfLife 
{
	/**
	 * Update the new jungle from the old jungle in one cycle. 
	 * @param jOld  old jungle
	 * @param jNew  new jungle 
	 */
	public static void updateJungle(Jungle jOld, Jungle jNew)
	{
		for (int row = 0; row < jOld.getWidth(); row++) {
			for (int col = 0; col < jOld.getWidth(); col++) {
				jNew.grid[row][col] = jOld.grid[row][col].next(jNew);
			}
		}
	}

	/**
	 * Repeatedly generates jungles either randomly or from reading files. 
	 * Over each jungle, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		Scanner scan = new Scanner(System.in);
		String fileName;
		int cycles = 0;
		int option = 0;
		Jungle odd;
		Jungle even;
		while (true) {
			System.out.println("Circle of Life Simulator \n Please choose an option: 1(random jungle), 2(file input), 3(exit)\n");
			option = scan.nextInt();
			while (option < 1) {
				System.out.println("That is not a valid option.\n");
				System.out.println("Circle of Life Simulator \n Please choose an option: 1(random jungle), 2(file input), 3(exit)\n");
				option = scan.nextInt();
			}

			if (option == 1) {
				System.out.println("Please enter the size of the jungle: ");
				int width = scan.nextInt();
				while (width < 1) {
					System.out.println("That is not a valid size of the jungle.\n");
					System.out.println("Please enter the size of the jungle: ");
					width = scan.nextInt();
				}

				even = new Jungle(width);
				odd = new Jungle(width);
				even.randomInit();
				System.out.println("Please enter the number of cycles to be simulated: ");
				cycles = scan.nextInt();
				while (cycles < 1) {
					System.out.println("That is not a valid number of cycles.\n");
					System.out.println("Please enter the number of cycles to be simulated: ");
					cycles = scan.nextInt();
				}
				
				System.out.println(even);
			}

			else if (option == 2) {
				System.out.println("Please enter the file name: ");
				fileName = scan.next();
				even = new Jungle(fileName);
				odd = new Jungle(even.getWidth());
				System.out.println("Please enter the number of cycles to be simulated: ");
				cycles = scan.nextInt();
				while (cycles < 1) {
					System.out.println("That is not a valid number of cycles.\n");
					cycles = scan.nextInt();
				}
				
				System.out.println(even);
			}
			
			else {
				System.out.println("EXIT");
				break;
			}
			
			for (int iter = 0; iter < cycles; iter++) {
				if (iter%2 == 0) {
					updateJungle(even, odd);
				}

				else {
					updateJungle(odd, even);
				}
			}
			
			if (cycles%2 == 0) {
				System.out.println("Last Jungle");
				System.out.println(even);
			}
			
			else {
				System.out.println("Last Jungle");
				System.out.println(odd);
			}			
		}
		
		scan.close();
	}
}
