import java.awt.*;

public class Circle extends Shape{
    Color textColor;
    public Circle(int x, int y, String label, Color textColor) {
        super(x, y, label);
        this.textColor = textColor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.x - 25, this.y - 25, 50, 50 );
        g.setColor(this.textColor);
        g.drawString(label, x - 15, y + 5);
    }
}
