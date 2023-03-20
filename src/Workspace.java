import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class Workspace extends JPanel implements Observer {
    public Workspace(){
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Repository repository = Repository.getInstance();
        for(Shape shape: repository.getUnremovableShape()){
            shape.draw(g);
        }
        for(Shape shape : repository.getShapes()){
            shape.draw(g);
        }
        for(ConnectingLine line : repository.getLines()){
            line.draw(g);
        }
        for(Rectangle rectangle : repository.getRects()){
            rectangle.draw(g);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
