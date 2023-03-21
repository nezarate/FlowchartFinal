import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        Workspace draw = new Workspace();
        ControlHandler control = new ControlHandler();

        add(draw);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu ("File");
        JMenuItem clear = new JMenuItem ("Clear");
        JMenuItem save = new JMenuItem ("Save file");
        JMenuItem load = new JMenuItem ("Load file");

        menuBar.add(menu);
        menu.add(clear);
        menu.add(save);
        menu.add(load);
        setJMenuBar(menuBar);

        clear.addActionListener(control);
        save.addActionListener(control);
        load.addActionListener(control);


    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(500, 500);
        main.setVisible(true);
    }


}
