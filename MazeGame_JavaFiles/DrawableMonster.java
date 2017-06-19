/**
 * DrawableMonster.java
 * DrawableMonster: A class that draws the Monster.
 * @author Tyler Yun
 * @version Program 3
 * @version CPE 102-16
 * @version Spring 2015
 * @version 4/30/15
 */
public class DrawableMonster extends Monster implements Drawable {
	// constructors 
	public DrawableMonster(Maze maze) {
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed) {
		super(maze, seed);
	}

	public DrawableMonster(Maze maze, Square location) {
		super(maze, location);
	}

	// Methods

	public void draw() {
		
	}
}