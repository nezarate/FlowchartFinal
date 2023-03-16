import java.awt.*;

public class Parallelogram extends Shape{

    public Parallelogram(int x, int y, String label) {
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        int[]xPoints = {x - 45, x - 25, x + 45, x + 25};
        int[]yPoints = {y + 20, y - 20, y - 20, y + 20};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawString("n < 100", x - 20, y + 5);
    }
}
