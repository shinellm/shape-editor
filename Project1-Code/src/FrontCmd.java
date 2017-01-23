import java.awt.*;

/**
 * FrontCmd.java
 * Command class moving the frontmost object, that is under the 
 * mouse position at the time of the click, to the front of the 
 * linear ordering of objects in the drawing. 
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class FrontCmd extends Command {
	
	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * move it to the front of the drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		Shape s = dwg.getFrontmostContainer(p); // find the frontmost shape containing p.

		if (s != null) { // was there a Shape containing p?
			dwg.moveToFront(s); // the frontmost shape containing p should be moved to the front of the drawing.
		}
	}
}
