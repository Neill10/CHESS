public class Board {
    private BoardTile[][] board;

    public Board()//creates a new board
    {
        board = new BoardTile[8][8];

        for(int i = 0; i < 8;i++)
        {
            for (int x = 0; x < 8;x++)
            {
                if(x % 2 == 1)
                {
                    board[i][x] = new BoardTile(i+1,x+1,true,false);
                }
                else {
                    board[i][x] = new BoardTile(i+1,x+1,false,false);
                }
            }
        }
    }


    public void fillBoard()
    {
        Queen qW = new Queen("Queen",1,4,false,false,true);
        Queen qB = new Queen("Queen",1,4,false,false,true);
        //Queens
        board [0][3] = new BoardTile(qW,1,4,true,true);
        board [7][3] = new BoardTile(qB,8,4,false,true);

        /*
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

        //Kings
        board [0][4] = "K";
        board [7][4] = "K";


        //Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "P";
            board[6][i] = "P";
        }

         */

    }
    public void printBoard()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int x = 0; x < 8;x++)
            {
                if(board[i][x].getPiece() != null)
                {
                    System.out.print(board[i][x].getPiece().toString());//piece in boardTile in board
                }
                else
                {
                    System.out.print("O");
                }

            }
            System.out.print("\n");
        }
    }
    public BoardTile[][] getBoard() {
        return board;
    }

}
