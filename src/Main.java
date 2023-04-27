import javax.swing.*;
import java.awt.*;
/**
 * Main - creates the workspace, repository, and JPanels
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version FlowchartFinal v1.0
 */
public class Main extends JFrame {
    private WorkingPanel mainPanel;
    private Repository mainRepo;
    private ControlHandler mainController;

    public Main(WorkingPanel startPanel, ControlHandler controller) {
        this.mainPanel = startPanel;
        this.mainRepo = Repository.getInstance();
        this.mainController = controller;
        mainRepo.addObserver(mainPanel);
        mainPanel.addMouseListener(mainController);
        mainPanel.addMouseMotionListener(mainController);

        add(mainPanel);
        // To be replaced by the SetUp for the startingPanel
        setUpWorkspace();
    }

    // Setup for JMenu Options/ActionListener for Workspace
    public void setUpWorkspace(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu ("File");
        JMenuItem clear = new JMenuItem ("Clear");
        JMenuItem save = new JMenuItem ("Save file");
        JMenuItem load = new JMenuItem ("Load file");

        JMenu menuHelp = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");


        JMenu shapes = new JMenu("Shapes");
        JMenuItem method = new JMenuItem("Call a Method");
        JMenuItem instruction = new JMenuItem("Instruction");
        JMenuItem io = new JMenuItem("Input or Output");
        JMenuItem var = new JMenuItem("Variable Declaration");
        JMenuItem condition = new JMenuItem("Condition");

        menuBar.add(menu);
        menuBar.add(menuHelp);
        menuBar.add(shapes);

        menu.add(clear);
        menu.add(save);
        menu.add(load);

        menuHelp.add(about);

        shapes.add(method);
        shapes.add(instruction);
        shapes.add(io);
        shapes.add(var);
        shapes.add(condition);

        setJMenuBar(menuBar);

        about.addActionListener(mainController);
        clear.addActionListener(mainController);
        save.addActionListener(mainController);
        load.addActionListener(mainController);
        method.addActionListener(mainController);
        instruction.addActionListener(mainController);
        io.addActionListener(mainController);
        var.addActionListener(mainController);
        condition.addActionListener(mainController);
    }

    // null for newController if keeping the same control scheme
    public void switchWorkingPanel(String panelType, WorkingPanel newPanel, ControlHandler newController){
        getContentPane().removeAll();
        mainPanel = newPanel;
        if(newController != null){
            mainController = newController;
        }

        // based on the type of Panel added, it will set up JMenu/ActionListners needed
        switch(panelType){
            case "Workspace":
                setUpWorkspace();
                break;
        }
    }

    /**
     * Sets up the default objects in the panel
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main(new Workspace(),new ControlHandler());
        Repository.getInstance().addUnremovableShape(new Circle(30, 30, Color.LIGHT_GRAY, "Begin", Color.BLACK));
        Repository.getInstance().addUnremovableShape(new Circle(750, 560, Color.BLACK, "End", Color.WHITE));
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(800, 650);
        main.setVisible(true);
    }


}
