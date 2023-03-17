import java.awt.*;

public class Diamond extends Shape{

    public Diamond(int x1, int y1, int x2, int y2, Color color, String label) {
        super(x1, y1, x2, y2, color, label);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[]xPoints = {x1 - 40, x1, x1 + 40, x1};
        int[]yPoints = {y1, y1 - 30, y1, y1 + 30};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }
}
