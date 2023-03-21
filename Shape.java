import java.awt.*;

public abstract class Shape {
    int x1, y1;
    Polygon shape;
    int[] xPoints, yPoints;
    int numPoints = 4;
    String label;
    Color color;
    public Shape(int x1, int y1, Color color, String label){
        this.x1 = x1;
        this.y1 = y1;
        this.label = label;
        this.color = color;
    }

    public Shape() {

    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(String label){
        return this.label;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        return shape.contains(p);
    }
}
