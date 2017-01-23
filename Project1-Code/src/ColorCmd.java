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
	 * Also, change the color in which new objects are added to the 
	 * appropriate color.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		// Find the frontmost shape containing p.		
		Shape s = dwg.getFrontmostContainer(p);

		if (s != null) { // was there a Shape containing p?
			
			// The frontmost shape containing p should have its color altered to the selected color.
			s.setColor(dwg.getColor());
		}
	}
}
