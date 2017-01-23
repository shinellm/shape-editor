import java.awt.*;

/**
 * DeleteCmd.java
 * Command class to perform a delete command.
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class DeleteCmd extends Command {

	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * remove it from the drawing.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		// Find the frontmost shape containing p.
		Shape s = dwg.getFrontmostContainer(p);

		System.out.println(s != null);
		
		if (s != null) { // was there a Shape containing p?
			// The frontmost shape containing p should be removed from dwg.
			dwg.remove(s);

		}
	}
}
