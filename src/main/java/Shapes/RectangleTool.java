package Shapes;
import java.awt.*;

/**
 * Abstract class that represents the generic Shapes.RectangleTool in the
 * Shapes.Rectangle decorator pattern. Contains an add method and has a Shapes.Rectangle.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public abstract class RectangleTool extends Shape implements Rectangle{
    protected Rectangle rectangle;

    /**
     * Public constructor of Shapes.RectangleTool
     * @param x1 The x position of the center of the Shapes.Rectangle
     * @param y1 The y position of the center of the Shapes.Rectangle
     * @param label The label to be drawn on the Shapes.Rectangle
     */
    public RectangleTool(int x1, int y1, String label) {
        super(x1, y1, label);
        rectangle = new RectangleStandard(x1, y1, label);
        //rectangle
    }

    /**
     * Allows for decoration by adding a Shapes.Rectangle type to
     * this Shapes.RectangleTool object.
     * @param d The Shapes.Rectangle object you want to decorate
     */
    public void add(Rectangle d){
        rectangle = d;
    }

    /**
     * Allows for relocation of the shape
     * @param x The x position to relocate to
     * @param y The y position to relocate to
     */
    @Override
    public void relocate(int x, int y) {
        rectangle.relocate(x, y);
        this.xPoints = new int[]{x-50, x+50, x+50, x-50};
        this.yPoints = new int[]{y-50, y-50, y+50, y+50};
        this.x1 = x;
        this.y1 = y;
    }

    /**
     * Checks if a click was inside this object in
     * order to test for selection
     * @param x The x position of the click
     * @param y The y position of the click
     * @return Whether or not the click was in this shape
     */
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

    /**
     * Draw method that specifies to draw the contained
     * Shapes.Rectangle object, allowing for decoration.
     * @param g The Graphics to be drawn on
     */
    public void draw(Graphics g){
        rectangle.draw(g);
    }
}
