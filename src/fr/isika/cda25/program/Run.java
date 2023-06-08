package fr.isika.cda25.program;

import fr.isika.cda25.entites.*;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		/*
		 * Idée de jeu : de temps en temps une triplette de - va traverser la grille si
		 * elle touche le serpent, il sera coupé en 2 (les extremités sont les tetes) on
		 * déplacera les 2 serpents en meme temps si une tete touche un corps, le
		 * serpent est tué
		 * 
		 * 
		 */
		Scanner input = new Scanner(System.in);

//		Making the snake
		Snake hiss = new Snake("H10");

//		Making a simple grid
		Grid startingGrid = new Grid(hiss);
		startingGrid.printGrid();

//		Moving the snake
		boolean breakLoop = false;
		int i = 0;
		do {
			i++;
			hiss.movingSnake();
			Grid movingGrid = new Grid(hiss);
			movingGrid.printGrid();
			if (i % 6 == 0) {
				System.out.println("addBody");
				hiss.addBody();
			}
			if (i % 20 == 0) {
				System.out.println("Continue ? (y/n)");
				if (input.nextLine().equals("n")) {
					breakLoop = true;
				}
			}
		} while (!breakLoop);

		System.out.println("--------------------------------------- END ---------------------------------------");

	}
}
