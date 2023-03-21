import java.awt.*;

public class Diamond extends Shape{

    public Diamond(int x1, int y1, Color color, String label) {
        super(x1, y1, color, label);
        xPoints = new int[]{x1 - 40, x1, x1 + 40, x1};
        yPoints = new int[]{y1, y1 - 30, y1, y1 + 30};
        shape = new Polygon(xPoints, yPoints, numPoints);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setColor(Color.BLACK);
        if(label != null)
            g.drawString(label, x1 - 20, y1 + 5);
    }


}
