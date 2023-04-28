import javax.swing.*;
import java.awt.*;
/**
 * Main - creates the workspace, repository, and JPanels
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Main extends JFrame {


    /**
     * Sets up the default objects in the panel
     * @param args
     */
    public static void main(String[] args) {
        //Main main = new Main(new Workspace(),new ControlHandler());
        PanelHandler panelHandler = PanelHandler.getInstance();
        //Repository.getInstance().addUnremovableShape(new Circle(30, 30, Color.LIGHT_GRAY, "Begin", Color.BLACK));
        //Repository.getInstance().addUnremovableShape(new Circle(750, 560, Color.BLACK, "End", Color.WHITE));
        panelHandler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelHandler.setSize(800, 650);
        panelHandler.setVisible(true);
    }


}
