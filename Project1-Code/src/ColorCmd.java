import java.awt.*;

/**
 * ColorCmd.java
 * Command class to perform a color change.
 * 
 * @author Shinell J. Manwaring
 * @see Command
 */
public class ColorCmd extends Command {
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape,
	 * using the current color selected, change the shape's color.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		Shape s = dwg.getFrontmostContainer(p); // find the frontmost shape containing p.

		if (s != null) { // was there a Shape containing p?
			s.setColor(dwg.getColor()); // the frontmost shape containing p should have its color altered.
		}
	}
}
