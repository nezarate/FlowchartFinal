import java.awt.*;

public class Circle extends Shape{

    Color textColor;
    public Circle(int x1, int y1, Color color, String label, Color textColor) {
        super(x1, y1, label);
        this.textColor = textColor;
        // Sets up square hitbox for click checking
        xPoints = new int[]{x1-25, x1+25, x1+25, x1-25};
        yPoints = new int[]{y1-25, y1-25, y1+25, y1+25};
        shape = new Polygon(xPoints, yPoints, numPoints);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1 - 25, y1 - 25, 50, 50 );
        g.setColor(textColor);
        if(label != null)
            g.drawString(label, x1 - 15, y1 + 5);
    }

    // Check click will be imitating a square hitbox
}
