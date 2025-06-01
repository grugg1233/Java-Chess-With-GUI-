import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChessFrame {

    public ChessFrame() {
        // Create the main frame
        JFrame cframe = new JFrame("Chess");
        cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cframe.setSize(800, 800);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Create a panel with a button
        JPanel panel = new JPanel();
        JButton button = new JButton("Play");
        panel.add(button);

        // Add action to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                cframe.getContentPane().removeAll();
                cframe.getContentPane().add(board);
                cframe.pack();
                cframe.setLocationRelativeTo(null);
                cframe.setVisible(true);
            }
        });


        // Set layout for the main frame
        cframe.setLayout(new BorderLayout());
        cframe.setJMenuBar(menuBar);
        cframe.add(panel, BorderLayout.CENTER);


        cframe.setVisible(true);
    }
}
