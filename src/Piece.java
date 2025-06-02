import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
public class Piece {
    private String p;
    public Piece(int i, int j) {
        if (i == 1 ) {
            p = "2P";
        } else if (i == 0 ) {
            switch (j) {
                case 0:
                    p = "2R";
                    break;
                case 1:
                    p = "2N";
                    break;
                case 2:
                    p = "2B";
                    break;
                case 3:
                    p = (i == 7) ? "2Q" : "2K";
                    break;
                case 4:
                    p = (i == 7) ? "2K" : "2Q";
                    break;
                case 5:
                    p = "2B";
                    break;
                case 6:
                    p = "2N";
                    break;
                case 7:
                    p = "2R";
                    break;
                default:
                    p = "";
            }
        } else if (i == 6) {
            p = "P";
            
        } else if ( i == 7) {
            
            switch (j) {
                case 0:
                    p = "R";
                    break;
                case 1:
                    p = "N";
                    break;
                case 2:
                    p = "B";
                    break;
                case 3:
                    p = (i == 7) ? "Q" : "K";
                    break;
                case 4:
                    p = (i == 7) ? "K" : "Q";
                    break;
                case 5:
                    p = "B";
                    break;
                case 6:
                    p = "N";
                    break;
                case 7:
                    p = "R";
                    break;
                default:
                    p = "";
            }
        } else {
            p = "";
        }
    }

    @Override
    public String toString() {
        return p;
    }

    public List<Point> getLegal(int i, int j) {
        
        List<Point> legal = new ArrayList<>(); 
        if(p.equals("P")) {
            if(i == 6) { // only on first pawn move 
                legal.add(new Point(i-2, j)); 
            } 
                legal.add(new Point(i-1, j)); 
        }
        else if(p.equals("R")) {
       
            
            for (int r = i - 1; r >= 0; r--) {
                legal.add(new Point(r, j));
            }
            
            for (int r = i + 1; r < 8; r++) {
                legal.add(new Point(r, j));
            }
           
            for (int c = j - 1; c >= 0; c--) {
                legal.add(new Point(i, c));
            }
            
            for (int c = j + 1; c < 8; c++) {
                legal.add(new Point(i, c));
            }
        }
        else if(p.equals("N")) {
                //upper left corner knight moves 
                if(i-2 >= 0 && j-1 >= 0 ) legal.add(new Point(i-2, j-1));
                if(i-1 >= 0 && j-2 >= 0 ) legal.add(new Point(i-1, j-2));
                //upper right corner knight moves 
                if(i-2 >= 0 && j+1 <= 7 ) legal.add(new Point(i-2, j+1));
                if(i-1 >= 0 && j+2 <= 7 )legal.add(new Point(i-1, j+2));
                // lower left corner knight moves 
                if (i + 2 <= 7 && j + 1 <= 7) legal.add(new Point(i + 2, j + 1));
                if (i + 1 <= 7 && j + 2 <= 7) legal.add(new Point(i + 1, j + 2));
                // lower right corner knight moves 
                if (i + 2 <= 7 && j - 1 >= 0) legal.add(new Point(i + 2, j - 1));
                if (i + 1 <= 7 && j - 2 >= 0) legal.add(new Point(i + 1, j - 2));
            
        }
        else if(p.equals("B")) {
            for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
                    legal.add(new Point(r, c));
            }
            for (int r = i - 1, c = j + 1; r >= 0 && c < 8; r--, c++) {
                    legal.add(new Point(r, c));
            }
            for (int r = i + 1, c = j - 1; r < 8 && c >= 0; r++, c--) {
                    legal.add(new Point(r, c));
            }
            for (int r = i + 1, c = j + 1; r < 8 && c < 8; r++, c++) {
                    legal.add(new Point(r, c));
            }
        
        }
        
        
        return legal; 
    }
}
