package Shapes;
import Shapes.RectangleStandard;
import com.google.gson.annotations.Expose;

import java.awt.*;

/**
 * Abstract class that represents the generic RectangleTool in the
 * Rectangle decorator pattern. Contains an add method and has a Rectangle.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public abstract class RectangleTool extends RectangleStandard implements Rectangle{

    /**
     * Public constructor of RectangleTool
     * @param x1 The x position of the center of the Rectangle
     * @param y1 The y position of the center of the Rectangle
     * @param label The label to be drawn on the Rectangle
     */
    public RectangleTool(int x1, int y1, String label) {
        super(x1, y1, label);
    }



}
