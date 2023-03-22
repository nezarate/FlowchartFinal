import java.awt.*;

public abstract class RectangleTool extends Shape implements Rectangle{
    protected Rectangle rectangle;

    public RectangleTool(int x1, int y1, String label) {
        super(x1, y1, label);
    }

    public void add(Rectangle d){
        rectangle = d;
    }

    @Override
    public void relocate(int x, int y) {
        rectangle.relocate(x, y);
        this.xPoints = new int[]{x-50, x+50, x+50, x-50};
        this.yPoints = new int[]{y-50, y-50, y+50, y+50};
        this.x1 = x;
        this.y1 = y;
    }

    public boolean checkClick(int x, int y) {
        Point p = new Point(x, y);
        shape = new Polygon(this.xPoints, this.yPoints, this.numPoints);
        return shape.contains(p);
    }

    public void draw(Graphics g){
        rectangle.draw(g);
    }

}
