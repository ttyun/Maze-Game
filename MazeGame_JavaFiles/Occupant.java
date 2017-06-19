/**
 * Occupant.java
 * Occupant: An abstract class that includes properties common to all maze occupants.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public abstract class Occupant {
	// instance variables
	private Square start;

	// constructors
	public Occupant() {
	}

	public Occupant(Square start) {
		this.start = start;
	}

	// Occupant Methods

	public Square location() {
		return start;
	}

	public void moveTo(Square newLoc) {
		start = newLoc;
	}
}