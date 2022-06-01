package pieces;



import javax.swing.*;
import java.util.*;
public class Pawn extends Piece {
    private boolean firstMove;
    public Pawn(int x, int y,boolean white)
    {
        super("pawn",x,y,white);
        firstMove = true;
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        setFirstMove(false);
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    @Override
    public ArrayList<BoardTile> possibleMoves() {
        ArrayList<BoardTile> pawnPossibleMoves = new ArrayList<BoardTile>();
        int row = getPositionX();
        int col = getPositionY();

        //white pawn moves upwards
        if(isWhite())
        {
            //moving forwards
            if(inBounds(row-1))
            {
                BoardTile currentTile = getAssociatedBoard().getBoard()[row - 1][col];
                if (!(currentTile.isOccupied()))
                {
                    pawnPossibleMoves.add(currentTile);
                    if (inBounds(row - 2))
                    {
                        currentTile = getAssociatedBoard().getBoard()[row - 2][col];
                    }
                    if (firstMove && !currentTile.isOccupied())
                    {
                        pawnPossibleMoves.add(currentTile);
                    }
                }
            }
            //capturing pieces
            //left capture (our view)
            if(inBounds(row - 1) & inBounds(col - 1))
            {
                BoardTile leftTile = getAssociatedBoard().getBoard()[row - 1][col - 1];
                if(leftTile.isOccupied() && leftTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(leftTile);
                }
            }
            //right capture
            if(inBounds(row - 1) && inBounds(col + 1))
            {
                BoardTile rightTile = getAssociatedBoard().getBoard()[row - 1][col + 1];
                if (rightTile.isOccupied() && rightTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(rightTile);
                }
            }
        }
        else//black pawn moves downwards
        {
            if (inBounds(row + 1))
            {
                BoardTile currentTile = getAssociatedBoard().getBoard()[row + 1][col];
                if (!(currentTile.isOccupied()))
                {
                    pawnPossibleMoves.add(currentTile);
                    if (inBounds(row + 2))
                    {
                        currentTile = getAssociatedBoard().getBoard()[row + 2][col];
                    }
                    if (firstMove && !currentTile.isOccupied())
                    {
                        pawnPossibleMoves.add(currentTile);
                    }
                }
            }
            //capturing pieces
            if(inBounds(row + 1) & inBounds(col - 1))
            {
                BoardTile leftTile = getAssociatedBoard().getBoard()[row + 1][col - 1];
                if(leftTile.isOccupied() && leftTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(leftTile);
                }
            }
            if(inBounds(row + 1) && inBounds(col + 1))
            {
                BoardTile rightTile = getAssociatedBoard().getBoard()[row + 1][col + 1];
                if (rightTile.isOccupied() && rightTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(rightTile);
                }
            }
        }
        setPossibleMoves(pawnPossibleMoves);
        return pawnPossibleMoves;
    }

    @Override
    public String toString()
    {
        return super.toString() + "P";
    }
}
