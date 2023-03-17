import java.awt.*;

public abstract class Shape {
    int x1, y1, x2, y2;
    String label;
    Color color;
    public Shape(int x1, int y1, int x2, int y2, Color color, String label){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.label = label;
        this.color = color;
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
}
