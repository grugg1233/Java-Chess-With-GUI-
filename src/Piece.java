import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String p;

    public Piece(int i, int j, String[][] boardState) {


        if (i == 1) {
            p = "2P";
            
        }
        else if (i == 0) {
            switch (j) {
                case 0:  p = "2R";  break;
                case 1:  p = "2N"; break;
                case 2:  p = "2B"; break;
                case 3:  p = "2K"; break;
                case 4:  p = "2Q"; break;
                case 5:  p = "2B"; break;
                case 6:  p = "2N"; break;
                case 7:  p = "2R"; break;
                default: p = "";   break;
            }
            
        }
        else if (i == 6) {
            p = "P";
        }
        else if (i == 7) {
            switch (j) {
                case 0:  p = "R"; break;
                case 1:  p = "N"; break;
                case 2:  p = "B"; break;
                case 3:  p = "Q"; break;
                case 4:  p = "K"; break;
                case 5:  p = "B"; break;
                case 6:  p = "N"; break;
                case 7:  p = "R"; break;
                default: p = "";   break;
            }
            
        }
        else {
            p = "";
            
            if (i == 3 && j == 3) {
                p = "R";
               
            }
        }
        boardState[i][j] = p;
    }

    @Override
    public String toString() {
        return p;
    }

    public List<Point> getLegal(int i, int j, String[][] boardState) {
        List<Point> legal = new ArrayList<>();

        if (p.equals("P")) {
            if (i > 0 && boardState[i-1][j].equals("")) {
                legal.add(new Point(i-1, j));
                if (i == 6 && boardState[i-2][j].equals("")) {
                    legal.add(new Point(i-2, j));
                }
            }
            else if (i > 0 && j+1 < 8 && !boardState[i-1][j+1].equals("")) {
                if (boardState[i-1][j+1].charAt(0) == '2')legal.add(new Point(i-1, j+1));
            }
            else if (i > 0 && j-1 >= 0 && !boardState[i-1][j-1].equals("")) {
                if (boardState[i-1][j-1].charAt(0) == '2') legal.add(new Point(i-1, j-1));
            }
        }
        else if (p.equals("R")) {
            for (int r = i-1; r >= 0; r--) {
                String cell = boardState[r][j];
                if (cell.equals("")) {
                    legal.add(new Point(r, j));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, j));
                }
                break;
            }
            for (int r = i+1; r < 8; r++) {
                String cell = boardState[r][j];
                if (cell.equals("")) {
                    legal.add(new Point(r, j));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, j));
                }
                break;
            }
            for (int c = j-1; c >= 0; c--) {
                String cell = boardState[i][c];
                if (cell.equals("")) {
                    legal.add(new Point(i, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(i, c));
                }
                break;
            }
            for (int c = j+1; c < 8; c++) {
                String cell = boardState[i][c];
                if (cell.equals("")) {
                    legal.add(new Point(i, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(i, c));
                }
                break;
            }
        }
        else if (p.equals("N")) {
            if (i-2 >= 0 && j-1 >= 0) {
                String cell = boardState[i-2][j-1];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i-2, j-1));
                }
            }
            if (i-1 >= 0 && j-2 >= 0) {
                String cell = boardState[i-1][j-2];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i-1, j-2));
                }
            }
            if (i-2 >= 0 && j+1 < 8) {
                String cell = boardState[i-2][j+1];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i-2, j+1));
                }
            }
            if (i-1 >= 0 && j+2 < 8) {
                String cell = boardState[i-1][j+2];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i-1, j+2));
                }
            }
            if (i+2 < 8 && j-1 >= 0) {
                String cell = boardState[i+2][j-1];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i+2, j-1));
                }
            }
            if (i+1 < 8 && j-2 >= 0) {
                String cell = boardState[i+1][j-2];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i+1, j-2));
                }
            }
            if (i+2 < 8 && j+1 < 8) {
                String cell = boardState[i+2][j+1];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i+2, j+1));
                }
            }
            if (i+1 < 8 && j+2 < 8) {
                String cell = boardState[i+1][j+2];
                if (cell.equals("") || cell.charAt(0) == '2') {
                    legal.add(new Point(i+1, j+2));
                }
            }
        }
        else if (p.equals("B")) {
            for (int r = i-1, c = j-1; r >= 0 && c >= 0; r--, c--) {
                String cell = boardState[r][c];
                if (cell.equals("")) {
                    legal.add(new Point(r, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, c));
                }
                break;
            }
            for (int r = i-1, c = j+1; r >= 0 && c < 8; r--, c++) {
                String cell = boardState[r][c];
                if (cell.equals("")) {
                    legal.add(new Point(r, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, c));
                }
                break;
            }
            for (int r = i+1, c = j-1; r < 8 && c >= 0; r++, c--) {
                String cell = boardState[r][c];
                if (cell.equals("")) {
                    legal.add(new Point(r, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, c));
                }
                break;
            }
            for (int r = i+1, c = j+1; r < 8 && c < 8; r++, c++) {
                String cell = boardState[r][c];
                if (cell.equals("")) {
                    legal.add(new Point(r, c));
                    continue;
                }
                if (cell.charAt(0) == '2') {
                    legal.add(new Point(r, c));
                }
                break;
            }
        }

        return legal;
    }
}
