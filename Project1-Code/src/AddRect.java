import java.awt.*;

/**
 * AddRect.java
 * Class for adding a rectangle to the drawing.
 *
 * @author Shinell J. Manwaring 
 * @see Command
 */
public class AddRect extends Command {
	private Point pressedPoint = null; // Where the mouse was pressed
	private Rect currentRect = null; // The rectangle being altered 
	
	/**
	 * Records the point of the press and creates a new rectangle in that location.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) { 
		pressedPoint = p;
		currentRect = new Rect(pressedPoint.x, pressedPoint.y, 0, 0, dwg.getColor());
	}

	/**
	 * Adjusts the size of the current rectangle by appropriately setting
	 * its coordinates. Once dragging is complete, it sets the color of the current 
	 * rectangle and adds it to the list of shapes.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) { 
		if (currentRect != null) { // makes sure that there is a current rect
			Point pt = p; // where the mouse was dragged
			
			currentRect.setX(Math.min(pt.x, pressedPoint.x)); // updates the value of x in the current rect
			currentRect.setY(Math.min(pt.y, pressedPoint.y)); // updates the value of y in the current rect
			currentRect.setWidth(Math.abs(pt.x - pressedPoint.x)); // updates the value of width in the current rect
			currentRect.setHeight(Math.abs(pt.y - pressedPoint.y)); // updates the value of height in the current rect
			
			currentRect.setColor(dwg.getColor()); // sets the current rect to the default color
			dwg.add(currentRect);  // adds the current rect to the current list of shapes			
		}
	}
}
