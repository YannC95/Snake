package fr.isika.cda25.entites;

/**
 * <pre>
 * Used as an attribute in Snake, Body and Grid classes.
 * Has 2 attributes : value (ie the coordinate) and status (to define what element of the game is at this coordinate).
 * </pre>
 * 
 * @author yann
 * 
 */
public class Coordinate {

	private String value;
	private String status;

	/**
	 * By default, value = "" and status = "."
	 */
	Coordinate() {
		this.status = ".";
		this.value = "";

	}

	/**
	 * @param status (String) status (., o, O, ¤, +) of this coordinate
	 * @param value  (String) value of this coordinate (see ListOfCoordinate)
	 */
	Coordinate(String status, String value) {
		this.status = status;
		this.value = value;
	}

	/**
	 * Gets the status of Coordinate (., o, O, ¤, +)
	 * 
	 * @return (String) Coordinate's status
	 */
	String getStatus() {
		return status;
	}

	/**
	 * Gets the coordinate value of Coordinate
	 * 
	 * @return (String) Coordinate's value
	 */
	String getCoordinate() {
		return value;
	}

	/**
	 * Sets the value of this Coordinate
	 * 
	 * @param coordinate (String) new coordinate (see ListOfCoordinate)
	 */
	void setCoordinate(String coordinate) {
		value = coordinate;
	}

	/**
	 * Sets the status of this Coordinate
	 * 
	 * @param status (String) new status (., o, O, ¤, +)
	 */
	void setStatus(String status) {
		this.status = status;
	}

}
