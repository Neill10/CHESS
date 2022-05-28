package pieces;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int x, int y,boolean white)
    {
        super("bishop",x,y,white);
    }

    public ArrayList<BoardTile> possibleMoves() { //is not assigned to piece instance variable possible moves
        ArrayList<BoardTile> bishopPossibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX();//row = 5 , col = 2
        int col = this.getPositionY();

        int diffX = col - 1;
        int diffY = row - 1;
        //upward left movement (using row)
        while(inBounds(diffX) && inBounds(diffY))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffY][diffX];//changes rows (height)
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    bishopPossibleMoves.add(currentTile);
                }
                break;
            }
            else
            {
                bishopPossibleMoves.add(currentTile);
                diffX--;
                diffY--;
            }
        }

        //upwards right movement (using row) //(5,2)
        diffX = col + 1;
        diffY = row - 1;
        while(inBounds(diffX) && inBounds(diffY))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffY][diffX];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    bishopPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                bishopPossibleMoves.add(currentTile);
                diffX++;
                diffY--;
            }
        }

        //downwards left movement
        diffY = row + 1;
        diffX = col - 1;
        while(inBounds(diffX) && inBounds(diffY))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffY][diffX];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    bishopPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                bishopPossibleMoves.add(currentTile);
                diffX--;
                diffY++;
            }
        }

        //downwards right movement
        diffY = row + 1 ;
        diffX = col + 1;
        while(inBounds(diffX) && inBounds(diffY))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffY][diffX];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    bishopPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                bishopPossibleMoves.add(currentTile);
                diffX++;
                diffY++;
            }
        }
        return bishopPossibleMoves;
    }

    @Override
    public String toString() {
        return super.toString() + "B";
    }
}
