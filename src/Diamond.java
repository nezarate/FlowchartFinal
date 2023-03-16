import java.awt.*;

public class Diamond extends Shape{


    public Diamond(int x, int y, String label) {
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        int[]xPoints = {x - 40, x, x + 40, x};
        int[]yPoints = {y, y - 30, y, y + 30};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawString("n < 100", x - 20, y + 5);
    }
}
