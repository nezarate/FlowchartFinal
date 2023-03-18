import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){
        Workspace draw = new Workspace();
        ControlHandler control = new ControlHandler();

        add(draw);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu ("File");
        JMenu menuHelp = new JMenu("Help");
        JMenuItem clear = new JMenuItem ("Clear");
        JMenuItem save = new JMenuItem ("Save file");
        JMenuItem load = new JMenuItem ("Load file");

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

        shapes.add(method);
        shapes.add(instruction);
        shapes.add(io);
        shapes.add(var);
        shapes.add(condition);

        setJMenuBar(menuBar);

        clear.addActionListener(control);
        save.addActionListener(control);
        load.addActionListener(control);
        method.addActionListener(control);
        instruction.addActionListener(control);
        io.addActionListener(control);
        var.addActionListener(control);
        condition.addActionListener(control);


    }

    public static void main(String[] args) {
        Main main = new Main();
        Repository.getInstance().add(new Circle(30, 30, Color.LIGHT_GRAY, "Begin", Color.BLACK));
        Repository.getInstance().add(new Circle(450, 410, Color.BLACK, "End", Color.WHITE));
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(500, 500);
        main.setVisible(true);
    }


}
