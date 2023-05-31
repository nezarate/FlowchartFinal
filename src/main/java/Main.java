import Handlers.PanelHandler;
import javax.swing.JFrame;
import javax.swing.UIManager;
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
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch(Exception e){
            System.out.println("Could not set Look and Feel");
        }
        PanelHandler panelHandler = PanelHandler.getInstance();
        panelHandler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelHandler.getContentPane().setBackground(Color.decode("#6C757C"));
        panelHandler.setSize(900, 700);
        panelHandler.setVisible(true);
    }


}
