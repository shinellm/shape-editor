import java.awt.*;

/**
 * AddEllipse.java
 * Class for adding an ellipse to the drawing.
 *
 * @author Shinell J. Manwaring 
 * @see Command
 */
public class AddEllipse extends Command {
	private Point pressedPoint = null; // Where the mouse was pressed
	private Ellipse currentEllipse = null; // The ellipse being altered 
	
	/**
	 * Records the point of the press and creates a new ellipse in that location.
	 * 
	 * @param p the coordinates of the press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) { 
		pressedPoint = p;
		currentEllipse = new Ellipse(pressedPoint.x, pressedPoint.y, 0, 0, dwg.getColor());
	}

	/**
	 * Adjusts the size of the current ellipse by appropriately setting
	 * its coordinates. Once dragging is complete, it sets the color of the current 
	 * ellipse and adds it to the list of shapes.
	 * 
	 * @param p the coordinates of the drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) { 
		if (currentEllipse != null) { // makes sure that there is a currentRect
			Point pt = p;
			currentEllipse.setX(Math.min(pt.x, pressedPoint.x));
			currentEllipse.setY(Math.min(pt.y, pressedPoint.y));
			currentEllipse.setWidth(Math.abs(pt.x - pressedPoint.x));
			currentEllipse.setHeight(Math.abs(pt.y - pressedPoint.y));
			
			currentEllipse.setColor(dwg.getColor());
			dwg.add(currentEllipse);
		}
	}
}
