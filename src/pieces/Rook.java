package pieces;

import java.util.ArrayList;

public class Rook extends Piece{
    private boolean firstMove;
    public Rook(int x, int y,boolean white)
    {
        super("rook",x,y,white);
        firstMove = true;
    }

    @Override
    public void move(int x, int y) {
        setFirstMove(false);
        super.move(x,y);
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        ArrayList<BoardTile> rookPossibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX(); // row = 7, col = 0
        int col = this.getPositionY();

        int diff = col - 1;
        
        //upward movement (using row)
        // need to consider after enemy pieces
        while(inBounds(diff))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[row][diff];//changes rows (height)
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    rookPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                rookPossibleMoves.add(currentTile);
                diff--;
            }
        }
        //downwards movement (using row)
        diff = col + 1;
        while(inBounds(diff))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[row][diff];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    rookPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                rookPossibleMoves.add(currentTile);
                diff++;
            }
        }

        //leftwards movement
        diff = row - 1;
        while(inBounds(diff))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][col];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    rookPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                rookPossibleMoves.add(currentTile);
                diff--;
            }
        }

        //rightwards movement
        diff = row + 1 ;
        while(inBounds(diff))
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[diff][col];
            if(currentTile.isOccupied()) {
                if (isWhite() != currentTile.getPiece().isWhite())
                {
                    rookPossibleMoves.add(currentTile);
                    break;
                }
                else
                {
                    break;
                }
            }
            else
            {
                rookPossibleMoves.add(currentTile);
                diff++;
            }
        }
        setPossibleMoves(rookPossibleMoves);
        return rookPossibleMoves;
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
