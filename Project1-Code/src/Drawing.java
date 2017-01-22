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
	 * Adds a shape to the front of the existing list of shapes.
	 * Will appear as the frontmost shape in the drawing.
	 * 
	 * @param s the shape you want to add
	 */
	public void add(Shape s) {
		shapes.add(0,s);
	}
	
	/**
	 * Draws all shapes in the existing list of shapes.
	 * Iterates from the end of the list to the front of the list.
	 * 
	 * @param page the page you wish to draw the shape on
	 */
	public void draw(Graphics page) {
		int listSize = shapes.size() - 1;
		while (listSize >= 0) {
				shapes.get(listSize).draw(page);
				listSize = listSize - 1;
		}
	}
	
	/**
	 * References the frontmost shape in the drawing, which contains Point p
	 * If none of the shapes contain Point p, it should return null.
	 * 
	 * @param p, which is the point where you want look for the frontmost shape
	 * @return the frontmost shape or null
	 */
	public Shape getFrontmostContainer(Point p) {
		int counter = 0;
		Shape frontMostContainer = null;
		
		while (counter < shapes.size()) {
			if (shapes.get(counter).containsPoint(p))
				frontMostContainer = shapes.get(counter);
			else counter += 1;
		}
		return frontMostContainer;
	}
	
	/**
	 * Must create a remove, moveToFront, and moveToBack method.
	 * Methods to be executed by ColorCmd.java are also needed.
	 */
	
	/**
	 * Removes the given shape from the drawing.
	 * 
	 * @param s the shape to be removed
	 */
	public void remove(Shape s) {
		int index = shapes.indexOf(s); // Finds the shape's index
		
		if (index != -1)
			shapes.remove(index);
	}
	
	/**
	 * Moves the given shape to the front of the drawing.
	 * 
	 * @param s the shape to be moved to the front
	 */
	public void moveToFront(Shape s) {
		int index = shapes.indexOf(s); // Finds the shape's index
		
		if (index != -1)
			shapes.remove(index);
			shapes.add(0,s); //adds to front of the array list
	}
	
	/**
	 * Moves the given shape to the front of the drawing.
	 * 
	 * @param s the shape to be moved to the front
	 */
	public void moveToBack(Shape s) {
		int index = shapes.indexOf(s); // Finds the shape's index
		
		if (index != -1)
			shapes.remove(index);
			shapes.add(s); //adds to back of the array list
	}
	
	/**
	 * Get the current color selected.
	 * 
	 * @return the current color
	 */
	public Color getColor() {
		return theColor;
	}
	
	/**
	 * Selects a new color.
	 * 
	 * @param newColor the new color to be used
	 */
	public void setColor(Color newColor) {
		theColor = newColor;
	}
}
