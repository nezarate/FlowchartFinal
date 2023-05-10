package Panels;
import Handlers.Repository;
import Shapes.*;
import Shapes.Shape;
import java.awt.*;
import java.util.Observable;

/**
 * This Panels.Workspace class represents the JPanel that displays all lines and shapes to the user
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Workspace extends WorkingPanel {
    public Workspace(){
        super();
    }

    /**
     * Override of the paintComponents method in JPanel
     * Gets the Instance of the Handlers.Repository and draws all shapes, lines and Rectangles to draw
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Repository repository = Repository.getInstance();
        for(Shape shape: repository.getUnremovableShape()){
            shape.draw(g);
        }
        for(Shapes.Shape shape : repository.getShapes()){
            shape.draw(g);
        }
        for(ConnectingLine line : repository.getLines()){
            line.draw(g);
        }
//        for(Shapes.Rectangle rectangle : repository.getRects()){
//            rectangle.draw(g);
//        }
    }

    /**
     * Override of the update method for Observer
     * Will repaint the JPanel when the Handlers.Repository changes
     * @param o     the observable object.
     * @param arg   The repository
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("repainting");
        repaint();
    }

}
