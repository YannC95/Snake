package fr.isika.cda25.entites;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Used to generate the Grid of the game and some events : eggs and arrow events.
 * The other events in the game will occur in other classes but the result will be generate and print thanks to this one.
 * </pre>
 * @author yann
 *
 */
public class Grid {

	static final int LINE_SIZE = 16;
	private List<Coordinate> occupiedCoordinate;
	private List<Coordinate> finalGrid;

	/**
	 * Generate the final grid with all the elements of the game (empty coordinate, edge, snake, arrows).
	 * @param snake (Snake) snake to print
	 */
	public Grid(Snake snake) {
		this.occupiedCoordinate = generateOccupiedCoordinate(snake);
		this.finalGrid = makingGrid();
	}
	
	
	private void generateEgg () {
//		TODO
	}
	
	void eatEgg (Snake snake) {
//		TODO
		snake.addBody();
	}
	
	private void generateArrow () {
//		TODO
	}
	
	private void collision () {
//		TODO
//		Collision with body
//		Collision with arrow
	}
	
	
	
	
	
	/**
	 * Generates the edges Coordinate and put them in a list.
	 * 
	 * @return (List<Coordinate>) list of all the edge Coordinate
	 */
	private static List<Coordinate> generateEdge() {
		List<Coordinate> edgeCoordinate = new ArrayList<>();
		for (ListOfCoordinate coordinate : ListOfCoordinate.values()) {
			if ((coordinate.toString().charAt(0) == ListOfCoordinate.values()[0].toString().charAt(0))
					|| (coordinate.toString().charAt(
							0) == ListOfCoordinate.values()[ListOfCoordinate.values().length - 1].toString().charAt(0))
					|| (coordinate.toString().length() == 2
							&& (coordinate.toString().charAt(1) == ListOfCoordinate.values()[0].toString().charAt(1)))
					|| (coordinate.toString().length() == 3 && (coordinate.toString()
							.charAt(2) == ListOfCoordinate.values()[ListOfCoordinate.values().length - 1].toString()
									.charAt(2)))) {
				Coordinate newEdgeCoordinate = new Coordinate("¤", coordinate.toString());
				edgeCoordinate.add(newEdgeCoordinate);
			}
		}
		return edgeCoordinate;
	}

	/**
	 * <pre>
	 * Generates the starting occupied Coordinate in this Grid (ie the location of the snake and the edges).
	 * </pre>
	 * 
	 * @return (List<Coordinate>) list of Coordinate which are occupied in this Grid
	 */
	private List<Coordinate> generateOccupiedCoordinate(Snake... snakes) {
		List<Coordinate> occupiedCoordinate = new ArrayList<>();
		List<Coordinate> snakeLocation = new ArrayList<>();
		List<Coordinate> edgeCoordinate = generateEdge();
		for (Snake snake : snakes) {
			snake.getSnakeLocation(snakeLocation);
			for (Coordinate coordinate : snakeLocation) {
				occupiedCoordinate.add(coordinate);
			}
		}
		for (Coordinate coordinate : edgeCoordinate) {
			occupiedCoordinate.add(coordinate);
		}
		return occupiedCoordinate;
	}

	/**
	 * Generates the final grid (with the snake and the eggs).
	 * 
	 * @return (List<Coordinate>) list of Coordinate (the finals coordinate of the Grid)
	 */
	private List<Coordinate> makingGrid() {
		List<Coordinate> grid = new ArrayList<>();
		for (ListOfCoordinate coordinate : ListOfCoordinate.values()) {
			boolean test = false;
			for (Coordinate occCoordinate : occupiedCoordinate) {
				if (coordinate.toString().equals(occCoordinate.getCoordinate())) {
					grid.add(occCoordinate);
					test = true;
					break;
				}
			}
			if (!test) {
				Coordinate emptyCoordinate = new Coordinate();
				emptyCoordinate.setCoordinate(coordinate.toString());
				grid.add(emptyCoordinate);
			}
		}
		return grid;
	}

	/**
	 * <pre>
	 * Prints this Grid (with location of the snake and eggs).
	 * Every modification of the grid will be print when this method is called.
	 * </pre>
	 */
	public void printGrid() {
		String print = "";
		String format = "%-2s%s%n";
		String print2 = "";
		int k = 1;
		int j = 0;
		System.out.printf(format, "",
				"    A    B    C    D    E    F    G    H    I    J    K    L    M    N    O    P\n");
		for (int i = 0; i < ListOfCoordinate.values().length; i++) {
			if ((i % LINE_SIZE) == 0) {
				print2 = Integer.toString(k);
				k++;
			}

			print += "    " + finalGrid.get(i).getStatus();

			if (j == LINE_SIZE - 1) {
				System.out.printf(format, print2, print);
				print = "";
				j = -1;
			}
			j++;
			if (i == ListOfCoordinate.values().length - 1) {
				System.out.println();
			}
		}

	}

}
