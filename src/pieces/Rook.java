package pieces;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(int x, int y,boolean white)
    {
        super("Rook",x,y,white);
    }

    @Override
    public boolean move(Board b, int x, int y) {
        return true;
    }

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        int row = this.getPostionY();
        int col = this.getPostionX();
        for(int i = 0; i < Board.LEN;i++)
        {

        }

    }
}
