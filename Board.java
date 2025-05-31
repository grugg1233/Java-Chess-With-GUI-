import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Board extends JPanel {

    private static final int SML_SIDE = 3;
    private static final int SIDE = SML_SIDE * SML_SIDE;
    private static final int GAP = 0;
    private static final Color BG = Color.BLACK;
    private static final Dimension BTN_PREF_SIZE = new Dimension(80, 80);

    private JButton[][] buttons = new JButton[SIDE][SIDE];

    public Board() {
        setBackground(BG);
        setLayout(new GridLayout(SML_SIDE, SML_SIDE, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        JPanel[][] smallPanels = new JPanel[SML_SIDE][SML_SIDE];
        for (int i = 0; i < smallPanels.length; i++) {
            for (int j = 0; j < smallPanels[i].length; j++) {
                smallPanels[i][j] = new JPanel(new GridLayout(SML_SIDE, SML_SIDE));
                add(smallPanels[i][j]);
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            int panelI = i / SML_SIDE;
            for (int j = 0; j < buttons[i].length; j++) {
                int panelJ = j / SML_SIDE;
                Piece p = new Piece(i, j);
                String piece = p.toString();

                buttons[i][j] = new JButton(piece);
                buttons[i][j].setPreferredSize(BTN_PREF_SIZE);
                smallPanels[panelI][panelJ].add(buttons[i][j]);
            }
        }
    }
}
