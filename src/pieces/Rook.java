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
        ArrayList<BoardTile> possibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX();
        int col = this.getPositionY();

        int diff = row;
        
        //upward movement (using row) // need to consider after enemy pieces
        while(diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                    diff++;
                }
                else
                {
                    break;
                }
                diff++;
            }
            else
            {
                possibleMoves.add(currentTile);
                diff++;
            }
        }
        //downwards movement (using row)
        diff = row;
        while(diff >= 0)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                    diff--;
                }
                else
                {
                    break;
                }
            }
            else
            {
                possibleMoves.add(currentTile);
                diff--;
            }
        }

        return possibleMoves;
    }
}
