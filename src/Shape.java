import java.awt.*;

public abstract class Shape {
    int x, y;
    String label;
    Color color;
    public Shape(int x, int y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
        this.color = Color.white;
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
