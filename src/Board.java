public class Board {
    private BoardTile[][] board;

    public Board()//creates a new board
    {
        board = new BoardTile[8][8];

        for(int i = 0; i < 8; i++)
        {
            int num = 0;
            for(int x = 0; x < 8;x++)
            {
                board[i][x] = new BoardTile();
                num++;
                System.out.print(num);
            }
            System.out.print("\n");
        }
    }
    public void fillBoard()
    {
        Queen qW = new Queen("Queen",1,4,false,false,true);
        Queen qB = new Queen("Queen",1,4,false,false,true);

        board [0][3] = new BoardTile(qW,1,4,true,true);
        board [7][3] = ;

    }
    public void printBoard()
    {
        for(int i = 0; i < 8; i++)
        {
            for(int x = 0; x < 8;x++)
            {
                if(board[i][x].getPiece() != null)
                {
                    System.out.print(board[i][x].getPiece().toString());//piecce in boardtile in board
                }
                else
                {
                    System.out.println("                                                   ");
                }

            }
            System.out.print("\n");
        }
    }
    public BoardTile[][] getBoard() {
        return board;
    }

}
