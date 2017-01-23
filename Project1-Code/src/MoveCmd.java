import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class MoveCmd extends Command {
	private Point startPoint = null; // Where the mouse was pressed
	private Shape moveShape = null; // The rectangle being altered 
	
	/**
	 * Records the point of the press and finds the frontmost Shape in 
	 * that location. If there is no such shape, then there is no shape to be moved.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		startPoint = p; // set dragPoint to wherever the mouse is located
		moveShape = dwg.getFrontmostContainer(startPoint); // find the frontmost shape containing p.
	}
	
	/**
	 * If there is a Shape to move, the center of the shape is set to the points 
	 * where the mouse is dragged.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing that the mouse is dragged in
	 */
	public void executeDrag(Point p, Drawing dwg) {
		Point dragPoint = p; // where the mouse was dragged
		
		if (moveShape != null) { // was there a Shape containing p?
			moveShape.setCenter(dragPoint); // set the center of the shape to be the dragPoint
		}
	}
}
