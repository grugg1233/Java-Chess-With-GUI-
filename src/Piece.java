public class Piece {
    private String p;
    public Piece(int i, int j) {
        if (i == 1 || i == 6) {
            p = "P";
            if(j==8) p =""; 
        } else if (i == 0 || i == 7) {
            switch (j) {
                case 0:
                    p = "R";
                    break;
                case 1:
                    p = "K";
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
                    p = "K";
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

    public int[] getLegal(int i, int j) {
        
        int[] legal; 
        if(p.equals("P")) {
            if(i == 6) 
            {
                legal = new int[]{i-1, i-2}; 
            } 
            else {
                legal = new int[]{i-1}; 
            }
        }
        else legal =new int[]{}; 
        return legal; 
    }
}
