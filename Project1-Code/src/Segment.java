import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * @author Shinell J. Manwaring
 * @see Shape
 */
public class Segment extends Shape {
  // YOU FILL IN INSTANCE VARIABLES AND METHODS.
	private int x1, y1, x2, y2; //End points on the segment

	/**
	 * Constructor just saves the parameters in the instance variables.
	 * 
	 * @param x1 x coordinate of point 1
	 * @param y1 y coordinate of point 1
	 * @param x2 x coordinate of point 2
	 * @param y2 y coordinate of point 2
	 * @param color the color
	 */
	public Segment(int x1, int y1, int x2, int y2, Color color) {
		super(color);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/**
	 * Have the Segment draw itself.
	 *
	 * @param page the page you wish to draw on
	 */
	public void drawShape(Graphics page) {
		page.drawLine(x1, y1, x2, y2);
	}

	/**
	   * Return true if the Segment contains Point p, false otherwise.
	   * 
	   * @param p point tested for containment
	   */
	  public boolean containsPoint(Point p) {
	    return almostContainsPoint(p, x1, y1, x2, y2,3);
	  }

  // Helper method that returns true if Point p is within a tolerance of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance 
        && distanceToPoint(p, left, top, right, bottom) <= tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
  
  /**
   * Have the Segment move itself.
   * 
   * @param deltaX new x coordinate
   * @param deltaY new y coordinate
   */
  public void move(int deltaX, int deltaY) {
    x1 += deltaX;
    y1 += deltaY;
  }

  /**
   * Return the Segment's center.
   * 
   * @return the center of the Segment
   */
  public Point getCenter() {
    return new Point(x1 + ((x2-x1) / 2), y1 + ((y2-y1) / 2));
  }
  
	/**
	 * Sets a new x value for the x coordinate of point 1 on the Segment
	 * 
	 * @param x new x value
	 */
	public void setX1(int x) {
		x1 = x;
	}

	/**
	 * Sets a new y value for the y coordinate of point 1 on the Segment
	 * 
	 * @param y new y value
	 */
	public void setY1(int y) {
		y1 = y;
	}
	
	/**
	 * Sets a new x value for the x coordinate of point 2 on the Segment
	 * 
	 * @param width the new width
	 */
	public void setX2(int w) {
		x2 = w;
	}

	/**
	 * Sets a new y value for the y coordinate of point 2 on the Segment
	 * 
	 * @param height the new height
	 */
	public void setY2(int h) {
		y2 = h;
	}
}
