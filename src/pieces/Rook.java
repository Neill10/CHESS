package pieces;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(int x, int y,boolean white)
    {
        super("Rook",x,y,white);
    }

    /*
    @Override
    public boolean move(int x, int y) {

        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                return true;
            }
        }
        return false;
    }

     */

    @Override
    public ArrayList<BoardTile> possibleMoves() { //is not assigned to piece instance variable possible moves
        ArrayList<BoardTile> possibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX();
        int col = this.getPositionY();

        int diff = col - 1;
        
        //upward movement (using row)
        // need to consider after enemy pieces
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];//changes rows (height)
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
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
        diff = col + 1;
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][row];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
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
        diff = row - 1;
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[col][diff];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
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
        diff = row + 1 ;
        while(diff >= 0 && diff < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[col][diff];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
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
        setPossibleMoves(possibleMoves);
        return possibleMoves;
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
