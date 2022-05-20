package pieces;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(int x, int y,boolean white)
    {
        super("Bishop",x,y,white);
    }

    public ArrayList<BoardTile> possibleMoves() { //is not assigned to piece instance variable possible moves
        ArrayList<BoardTile> bishopPossibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX();
        int col = this.getPositionY();

        int diffX = col - 1;
        int diffY = row - 1;
        //upward left movement (using row)
        while(diffX >= 0 && diffX < 8 && diffY >= 0 && diffY < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffX][diffY];//changes rows (height)
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
                diffY--;
            }
        }
        //upwards right movement (using row) //(2,5)
        diffX = col + 1;
        diffY = row - 1;
        while(diffX < 8 && diffX >= 0 && diffY < 8 && diffY>= 0)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffX][diffY];
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
        diffX = row + 1;
        diffY = col - 1;
        while(diffX >= 0 && diffX < 8 && diffY >= 0 && diffY < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffX][diffY];
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

        //downwards right movement
        diffX = row + 1 ;
        diffY = col + 1;
        while(diffX >= 0 && diffX < 8 && diffY >= 0 && diffY < 8)
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diffX][diffY];
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
