import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel {
    public String[][] boardState = new String[8][8];
    private static final int SIDE = 8;
    private static final int GAP = 0;
    private static final Color BG = Color.BLACK;
    private static final Dimension BTN_PREF_SIZE = new Dimension(80, 80);

    private JButton[][] buttons = new JButton[SIDE][SIDE];

    private List<Point> highlighted = new ArrayList<>(); 

    public Board() {
        setBackground(BG);
        // 8×8 grid, no sub‐panels
        setLayout(new GridLayout(SIDE, SIDE, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        // Create and add each button directly to this panel
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                Piece p = new Piece(i, j, boardState);
                String piece = p.toString();

                buttons[i][j] = new JButton(piece);
                buttons[i][j].setPreferredSize(BTN_PREF_SIZE);
                bcolor(i,j, buttons[i][j]);

                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(e -> {
                    handleClick(row, col, p);
                });

                add(buttons[i][j]);
            }
        }

    }

    private void handleClick(int row, int col, Piece p) {
            if(!highlighted.isEmpty()) {
                for(Point pt : highlighted) {
                    int r = pt.x, c = pt.y; 
                    bcolor(r,c, buttons[r][c]);
                }
                highlighted.clear(); 
            }    
            
            List<Point> legalMoves = p.getLegal(row, col, boardState); 

            for (Point move : legalMoves) {

                if(buttons[move.x][move.y].getText().equals("")){
                    buttons[move.x][move.y].setBackground(Color.YELLOW);
                    
                }
                else if (buttons[move.x][move.y].getText().charAt(0) == '2') {
                     buttons[move.x][move.y].setBackground(Color.RED);

                }

                highlighted.add(new Point(move.x,move.y));

            }
            
    }

    public static void bcolor(int i, int j, JButton x) {
        if( (i%2 != 0 && j % 2 == 0) || i%2 == 0 && j %2 !=0 )
            x.setBackground(Color.CYAN);
        else  x.setBackground(Color.WHITE);
    }
}
