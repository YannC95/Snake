package fr.isika.cda25.entites;

import java.util.List;

/**
 * Used to create or move a snake.
 * 
 * @author yann
 *
 */
public class Snake {

	private Body head;

	/**
	 * Creates a snake where you want.
	 * @param headFirstLocation (String) coordinate of the head
	 */
	public Snake(String headFirstLocation) {
		head = new Body(new Coordinate("O", headFirstLocation));
		head.initializeSnake();
	}

	/**
	 * Gets the full location of a snake (ie head + bodys)
	 * @param snakeLocation (List<Coordinate>) all the body's coordinate of a snake
	 */
	void getSnakeLocation(List<Coordinate> snakeLocation) {
		if (head != null) {
			head.getBodysLocation(snakeLocation);
		}
	}

	/**
	 * <pre>
	 * Moves a snake to the next coordinate.
	 * Will call a method to ask you in which direction you want to move.
	 * </pre>
	 */
	public void movingSnake() {
		if (head != null) {
			String newHeadCoordinate = head.calculateNewCoordinate();
			if (head.getNextBody() != null) {
				head.refreshSnake();
			}
			head.setThisBodyLocation(new Coordinate("O", newHeadCoordinate));
			if (head.getNextBody() != null) {
			head.getNextBody().getThisBodyLocation().setStatus("o");
			}
		}
	}
	
	/**
	 * <pre>
	 * Adds a body at the tail of a snake.
	 * 1) Gets and keeps the location of the current tail.
	 * 2) Calls the movingSnake method to free up the current tail space.
	 * 3) Adds a body a this location.
	 * 4) Generates a temporary grid and print it.
	 * </pre>
	 */
	public void addBody() {
		Coordinate newBodyLocation = head.getTail().getThisBodyLocation();
//		System.out.println("before movingSnake");
		this.movingSnake();
//		System.out.println("after movingSnake");
		head.getTail().setNextBody(new Body(newBodyLocation));
//		System.out.println("before new Grid print");
		new Grid(this).printGrid();
//		System.out.println("after new Grid print");
	}

//	public Body getHead() {
//		return head;
//	}

//	public int getSnakesize() {
//		if (isEmpty()) {
//			return 0;
//		} else {
//			return this.head.numberOfBody();
//		}
//	}

}
