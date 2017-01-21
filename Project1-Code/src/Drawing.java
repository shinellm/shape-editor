import java.awt.*;
import java.util.ArrayList;

/**
 * Drawing.java
 * Creates and stores drawings as an array list id shapes
 *
 * @author Shinell J. Manwaring
 */
public class Drawing {
	private ArrayList<Shape> shapes;	// The list of shapes already used
	private Color theColor;			// The default color selected

	/**
	 * (1) A constructor, which creates an empty drawing with an 
	 * initial default Color given as a parameter. The init method of
	 * the Editor class in Editor.java calls it.
	 * (2) A method draw that, given a reference to a Graphics object, 
	 * has each Shape in the drawing draw itself. The paintComponent 
	 * method of the CanvasPanel class in Editor.java calls it.
	 * (3) A method getFrontmostContainer that, given a reference to 
	 * a Point, returns the frontmost Shape in the drawing that contains 
	 * the Point, or null if no Shape contains the Point. The executeClick 
	 * method of ExchangeCmd calls it.
	 */
	
	/**
	 * Constructor that creates an empty list of Shapes with a default color.
	 * 
	 * @params initialColor the initial default drawing color
	 */
	public Drawing(Color initialColor) {
		shapes = new ArrayList<Shape>();
		theColor = initialColor;
	}
	
	/**
	 * Draws all shapes in the existing list of shapes.
	 * 
	 * @param page the page you wish to draw the shape on
	 */
	public void Draw(Graphics page) {
		
	}
	
	/**
	 * References the frontmost shape in the drawing, which contains Point p
	 * If none of the shapes contain Point p, it should return null.
	 * 
	 * @param p, which is the point where you want look for the frontmost shape
	 * @return the frontmost shape or null
	 */
	public Shape getFrontmostContainer(Point p) {
		
	}
	
}
