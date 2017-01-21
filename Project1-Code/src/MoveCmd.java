import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class MoveCmd extends Command {

	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * set the point where the mouse currently is as dragPoint and set the
	 * center of the shape to be located at the dragPoint.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		// Find the frontmost shape containing p.
		Shape s = dwg.getFrontmostContainer(p);
		// Initially sets the dragPoint to null
		Point dragPoint = null; 

		if (s != null) { // was there a Shape containing p?
			// We have a shape to be moved.
			dragPoint = p; // Set dragPoint to wherever the mouse is located
			s.setCenter(dragPoint); // Set the center of the shape to be the location of dragPoint
		}
	}
	
	/**
	 * Calls the executePress function and updates the position of the 
	 * frontmost shape.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeDrag(Point p, Drawing dwg) {
		// Dragging the mouse should do the same thing that pressing it does 
		executePress(p, dwg);	
	}
}
