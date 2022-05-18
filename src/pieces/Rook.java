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
    public ArrayList<BoardTile> possibleMoves() { //is not assigned to piece instance variable possible moves
        ArrayList<BoardTile> possibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX();
        int col = this.getPositionY();

        int diff = row + 1;
        
        //upward movement (using row)
        // need to consider after enemy pieces
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                    break;
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
        //downwards movement (using row)
        diff = row - 1;
        while(diff < 8 && diff >= 0)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                   break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                possibleMoves.add(currentTile);
                diff++;
            }
        }

        //leftwards movement
        diff = col -1;
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[col][diff];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                    break;
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

        //rightwards movement
        diff = col +1;
        while(diff < 8 && diff >= 0)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[col][diff];
            if(currentTile.isOccupied()) {
                if (isWhite() == currentTile.getPiece().isWhite())
                {
                    possibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                possibleMoves.add(currentTile);
                diff++;
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return "R";
    }
}
