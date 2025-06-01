import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel {

    private static final int SIDE = 8;
    private static final int GAP = 0;
    private static final Color BG = Color.BLACK;
    private static final Dimension BTN_PREF_SIZE = new Dimension(80, 80);

    private JButton[][] buttons = new JButton[SIDE][SIDE];

    public Board() {
        setBackground(BG);
        // 8×8 grid, no sub‐panels
        setLayout(new GridLayout(SIDE, SIDE, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        // Create and add each button directly to this panel
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Piece p = new Piece(i, j);
                String piece = p.toString();

                buttons[i][j] = new JButton(piece);
                buttons[i][j].setPreferredSize(BTN_PREF_SIZE);
                bcolor(i,j, buttons[i][j]);
                add(buttons[i][j]);
            }
        }


    }
    public static void bcolor(int i, int j, JButton x) {
        if( (i%2 != 0 && j % 2 == 0) || i%2 == 0 && j %2 !=0 )
            x.setBackground(Color.CYAN);
        else  x.setBackground(Color.WHITE);
    }
}
