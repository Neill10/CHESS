public class ChessBoard {
    String[][] board = new String[8][8];

    public void fillBoard() {
        //Fills the empty spaces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " ";
            }
        }

        // Rooks
        board [0][0] = "R";
        board [0][7] = "R";
        board [7][0] = "R";
        board [7][7] = "R";

        // Knights
        board [0][1] = "N";
        board [0][6] = "N";
        board [7][1] = "N";
        board [7][6] = "N";

        //Bishops
        board [0][2] = "B";
        board [0][5] = "B";
        board [7][2] = "B";
        board [7][5] = "B";

        //Queens
        board [0][3] = "Q";
        board [7][3] = "Q";

        //Kings
        board [0][4] = "K";
        board [7][4] = "K";


        //Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "P";
            board[6][i] = "P";
        }
    }

    public void presentBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}