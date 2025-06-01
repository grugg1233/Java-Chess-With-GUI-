import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame {

    public Frame() {
        // Create the main frame
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

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
                frame.getContentPane().removeAll();
                frame.getContentPane().add(board);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });


        // Set layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(panel, BorderLayout.CENTER);


        frame.setVisible(true);
    }
}
