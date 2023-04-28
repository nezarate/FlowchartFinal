import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;

public class PanelHandler extends JFrame {

    private JPanel panelContainer;
    private CardLayout cardLayout;
    private WorkingPanel mainPanel;
    private Repository mainRepo;
    private ControlHandler mainController;

    public enum Panel {
        Workspace,
        Login,
        MainMenu,
        FlowChartProblem
    }
    private static PanelHandler panelHandler;

    /**
     * Singleton - gets the static panelHandler instance
     * @return panelHandler
     */
    public static PanelHandler getInstance(){
        if (panelHandler == null)
            panelHandler = new PanelHandler();
        return panelHandler;
    }

    public PanelHandler() {
        this.mainPanel = new Workspace();
        this.mainRepo = Repository.getInstance();
        this.mainController = ControlHandler.getInstance();
        mainRepo.addObserver(mainPanel);
        mainPanel.addMouseListener(mainController);
        mainPanel.addMouseMotionListener(mainController);

        JPanel loginPanel = new LoginPanel();
        JPanel flowChartPanel = new FlowChartProblemPage();


        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        panelContainer.add(loginPanel, "loginPanel");
        panelContainer.add(flowChartPanel, "loginPanel");

        JButton switchButton = new JButton("SWITCH PLEASE");
        //switchButton.addActionListener(e -> cardLayout.next(panelContainer));

        //getContentPane().add(panelContainer, BorderLayout.CENTER);
        //getContentPane().add(switchButton, BorderLayout.SOUTH);

        add(loginPanel);
        //add(mainPanel)
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

    public void switchWorkingPanel(Panel panelType) {//, WorkingPanel newPanel, ControlHandler newController){
        getContentPane().removeAll();

        WorkingPanel newPanel = null;
        ControlHandler newController = null;
        // based on the type of Panel added, it will set up JMenu/ActionListners needed
        switch(panelType){
            case Workspace:
                setUpWorkspace();
                break;
            case Login:
                newPanel = new LoginPanel();
                newController = getController(); // change this to a login controller later
                break;
            case MainMenu:
                newPanel = new MainMenuPanel();

                break;
            case FlowChartProblem:
                System.out.println("inside switchWorkingPanel");
                newPanel = new FlowChartProblemPage();
                //cardLayout.next(panelContainer);
                //cardLayout.
                //cardLayout.show(panelContainer, "flowchartPanel");
                newController = getController();    // change this to flowchart controller
                break;
        }

        mainPanel = newPanel;
        getContentPane().add(mainPanel);
        revalidate();
        repaint();


        if(newController != null){
            mainController = newController;
        }
    }

    public ControlHandler getController() {
        return mainController;
    }

}
