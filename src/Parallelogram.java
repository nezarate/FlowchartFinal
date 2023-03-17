import java.awt.*;

public class Parallelogram extends Shape{

    public Parallelogram(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[]xPoints = {x1 - 45, x1 - 25, x1 + 45, x1 + 25};
        int[]yPoints = {y1 + 20, y1 - 20, y1 - 20, y1 + 20};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }
}
