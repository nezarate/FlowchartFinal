import java.awt.*;

/**
 * This interface is the root of the Rectangle decorator pattern.
 * Contains a draw and relocate method.
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public interface Rectangle {
    /**
     * Specifies how the Rectangle should be drawn
     * @param g The Graphics to be drawn on
     */
    void draw(Graphics g);

    /**
     * Changes coordinates of shape to relocate it
     * @param x The x coordinate to relocate to
     * @param y The y coordinate to relocate to
     */
    void relocate(int x, int y);
}
