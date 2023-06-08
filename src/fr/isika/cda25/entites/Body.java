package fr.isika.cda25.entites;

import java.util.List;
import java.util.Scanner;

/**
 * Used to create and edit body part of a snake and to move a snake.
 * 
 * @author yann
 *
 */
public class Body {

	private static Scanner input = new Scanner(System.in);
	private Body nextBody;
	private Coordinate location;

	/**
	 * <pre>
	 * Body of the snake.
	 * Designed to create the head or to add a body at the tail.
	 * </pre>
	 * 
	 * @param coordinate location of this body in the Grid
	 */
	Body(Coordinate coordinate) {
		this.location = coordinate;
		this.nextBody = null;
	}

	/**
	 * Sets the next body of this body
	 * 
	 * @param nextBody (Body) next body to reference
	 */
	void setNextBody(Body nextBody) {
		this.nextBody = nextBody;
	}

	/**
	 * Gets the next body of this body
	 * 
	 * @return (Body) next body of this body
	 */
	Body getNextBody() {
		return nextBody;
	}

	/**
	 * <pre>
	 * Called by the Snake.movingSnake method.
	 * Copy the reference of a Coordinate object (attribute location) and paste it in the next body.
	 * </pre>
	 */
	void refreshSnake() {
		if (this.getNextBody().getNextBody() != null) {
			this.getNextBody().refreshSnake();
		}
		this.getNextBody().setThisBodyLocation(this.getThisBodyLocation());
	}

	/**
	 * <pre>
	 * Used to create the first snake (the 2nd and 3rd body exactly) at the beginning of the game.
	 * The Head has been defined in the Run.main class.
	 * </pre>
	 */
	void initializeSnake() {
		this.setNextBody(new Body(new Coordinate("o",
				ListOfCoordinate.values()[ListOfCoordinate.valueOf(this.location.getCoordinate()).ordinal()
						+ Grid.LINE_SIZE].toString())));
		this.nextBody
				.setNextBody(
						new Body(new Coordinate("o",
								ListOfCoordinate.values()[ListOfCoordinate
										.valueOf(this.nextBody.location.getCoordinate()).ordinal() + Grid.LINE_SIZE]
										.toString())));
	}

	/**
	 * <pre>
	 * Adds the location of every body (and head) of the snake in an empty list.
	 * Used in the Grid.generateOccupiedCoordinate method.
	 * </pre>
	 * @param snakeLocation (List<Coordinate>) empty list which will contain the locations of the snake
	 */
	void getBodysLocation(List<Coordinate> snakeLocation) {
		snakeLocation.add(this.location);
		if (this.getNextBody() != null) {
			this.getNextBody().getBodysLocation(snakeLocation);
		}
	}

	/**
	 * Gets the location of this body.
	 * @return (Coordinate) location of this body
	 */
	Coordinate getThisBodyLocation() {
		return location;
	}

	/**
	 * Sets the location (Coordinate) of this body.
	 * @param coordinate (Coordinate) new location of this body
	 */
	void setThisBodyLocation(Coordinate coordinate) {
		this.location = coordinate;
	}

	/**
	 *<pre>
	 * Called by Snake.movingSnake method.
	 * 1) Asks in which direction you want to move the snake.
	 * 2) Checks if this direction is allowed (ie not towards the 2nd body).
	 * 3) Calculates the new head coordinate.
	 * </pre>
	 * @return (String) new coordinate of the head
	 */
	String calculateNewCoordinate() {
		String direction = input.nextLine();
		String newHeadLocation = "";
		int coordinateIndexOfTheHead = ListOfCoordinate.valueOf(this.location.getCoordinate()).ordinal();
		switch (direction) {
		case "z":
			newHeadLocation = ListOfCoordinate.values()[coordinateIndexOfTheHead - Grid.LINE_SIZE].toString();
			if (this.nextBody.getThisBodyLocation().getCoordinate().equals(newHeadLocation)) {
				return calculateNewCoordinate();
			}
			return newHeadLocation;
		case "q":
			newHeadLocation = ListOfCoordinate.values()[coordinateIndexOfTheHead - 1].toString();
			if (this.nextBody.getThisBodyLocation().getCoordinate().equals(newHeadLocation)) {
				return calculateNewCoordinate();
			}
			return newHeadLocation;
		case "s":
			newHeadLocation = ListOfCoordinate.values()[coordinateIndexOfTheHead + Grid.LINE_SIZE].toString();
			if (this.nextBody.getThisBodyLocation().getCoordinate().equals(newHeadLocation)) {
				return calculateNewCoordinate();
			}
			return newHeadLocation;
		case "d":
			newHeadLocation = ListOfCoordinate.values()[coordinateIndexOfTheHead + 1].toString();
			if (this.nextBody.getThisBodyLocation().getCoordinate().equals(newHeadLocation)) {
				return calculateNewCoordinate();
			}
			return newHeadLocation;
		default:
			return calculateNewCoordinate();
		}
	}
	
	/**
	 * Gets the tail (ie the last body) of a snake.
	 * @return (Body) the last body of this snake
	 */
	Body getTail() {
		if (this.nextBody == null) {
//			System.out.println("Tail at "+this.location.getCoordinate());
			return this;
		} else {
			return this.nextBody.getTail() ;
		}
	}

//	public int numberOfBody() {
//		int number = 1;
//		if (this.getNextBody() != null) {
//			return this.getNextBody().numberOfBody();
//		} else {
//			return number;
//		}
//	}

}
