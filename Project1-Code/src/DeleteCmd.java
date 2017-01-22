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
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * remove it from the drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		// Find the frontmost shape containing p.
		Shape s = dwg.getFrontmostContainer(p);

		if (s != null) { // was there a Shape containing p?
			// The frontmost shape containing p should be removed from dwg.
			dwg.remove(s);

		}
	}
}
