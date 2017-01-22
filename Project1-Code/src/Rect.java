import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Shinell J. Manwaring 
 * @see Shape
 */
public class Rect extends Shape {
	private int myX, myY; //Coordinates of Rect
	private int width, height; //Rect's width and height
	
	/**
	* Constructor just saves the parameters in the instance variables.
	* 
	* @param left x coordinate of the top-left corner
	* @param top y coordinate of the top-left corner
	* @param width the width
	* @param height the height
	* @param color the color
	*/
	public Rect(int x, int y, int width, int height, Color color) {
	    super(color);
	    this.myX = x;
	    this.myY = y;
	    this.width = width;
	    this.height = height;
	}
	
	/**
	 * Have Rect draw itself.
	 *
	 * @param page the page you wish to draw on
	 */
	public void drawShape(Graphics page) {
		page.fillRect(myX, myY, width, height);
	}

	/**
	 * Return true if Rect contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p) {
		return pointInRect(p, myX, myY, width, height);
	}
	
	
	// Helper method that returns whether Point p is in an Ellipse with the given
	// top left corner and size.
	private static boolean pointInRect(Point p, int x1, int y1, int width,
			int height) {
		double a = width / 2.0; // half of the width
		double b = height / 2.0; // half of the height
		double centerx = x1 + a; // x-coord of the center
		double centery = y1 + b; // y-coord of the center
		double x = p.x - centerx; // horizontal distance between p and center
		double y = p.y - centery; // vertical distance between p and center

		// Now we just apply the standard geometry formula.
		// (See CRC, 29th edition, p. 178.)
		return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
	}

	/**
	 * Have the Rect move itself.
	 * 
	 * @param deltaX new x coordinate
	 * @param deltaY new y coordinate
	 */
	public void move(int deltaX, int deltaY) {
		myX += deltaX;
		myY += deltaY;
	}

	/**
	 * Return the Rect's center.
	 * 
	 * @return the center of the Rect
	 */
	public Point getCenter() {
		return new Point(myX + (width / 2), myY + (height / 2));
	}
	
	/**
	 * Sets a new x value for the upper left corner of Rect
	 * 
	 * @param x new x value
	 */
	public void setX(int x) {
		myX = x;
	}

	/**
	 * Sets a new y value for the upper left corner of Rect
	 * 
	 * @param y new y value
	 */
	public void setY(int y) {
		myY = y;
	}
	
	/**
	 * Set the new width of the Rect
	 * 
	 * @param width the new width
	 */
	public void setWidth(int w) {
		width = w;
	}

	/**
	 * Set the new height of the Rect
	 * 
	 * @param height the new height
	 */
	public void setHeight(int h) {
		height = h;
	}
	
}
