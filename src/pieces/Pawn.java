package pieces;



import java.util.*;
public class Pawn extends Piece {
    private boolean check;
    private boolean firstMove;
    public Pawn(int x, int y,boolean white)
    {
        super("pawn",x,y,white);
        firstMove = true;
    }

    /*
    @Override
    public boolean move(int x, int y)//returns true if successfully moved.
    {
        return true;
    }
     */

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        ArrayList<BoardTile> pawnPossibleMoves = new ArrayList<BoardTile>();
        int row = getPositionX();
        int col = getPositionY();

        //white pawn moves upwards
        if(isWhite())
        {
            //moving forwards

            BoardTile currentTile = getAssociatedBoard().getBoard()[row - 1][col];
            if(!(currentTile.isOccupied())) {
                pawnPossibleMoves.add(currentTile);
                if(inBounds(row - 2)) {
                    currentTile = getAssociatedBoard().getBoard()[row - 2][col];
                }
                if (firstMove && !currentTile.isOccupied()) {
                    pawnPossibleMoves.add(currentTile);
                }
            }
            //capturing pieces
            //left capture (our view)
            if(inBounds(row - 1) & inBounds(col - 1)) {
                BoardTile leftTile = getAssociatedBoard().getBoard()[row - 1][col - 1];
                if(leftTile.isOccupied() && leftTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(leftTile);
                }
            }
            //right capture
            if(inBounds(row - 1) && inBounds(col + 1)) {
                BoardTile rightTile = getAssociatedBoard().getBoard()[row - 1][col + 1];
                if (rightTile.isOccupied() && rightTile.getPiece().isWhite() != isWhite()) {
                    pawnPossibleMoves.add(rightTile);
                }
            }
        }
        else//black pawn moves downwards
        {
            BoardTile currentTile = getAssociatedBoard().getBoard()[row + 1][col];
            if(!(currentTile.isOccupied())) {
                pawnPossibleMoves.add(currentTile);
                if(inBounds(row + 2))
                {
                    currentTile = getAssociatedBoard().getBoard()[row + 2][col];
                }
                if (firstMove && !currentTile.isOccupied()) {
                    pawnPossibleMoves.add(currentTile);
                }
            }
            //capturing pieces
            if(inBounds(row + 1) & inBounds(col - 1)) {
                BoardTile leftTile = getAssociatedBoard().getBoard()[row + 1][col - 1];
                if(leftTile.isOccupied() && leftTile.getPiece().isWhite() != isWhite())
                {
                    pawnPossibleMoves.add(leftTile);
                }
            }
            if(inBounds(row + 1) && inBounds(col + 1)) {
                BoardTile rightTile = getAssociatedBoard().getBoard()[row + 1][col + 1];
                if (rightTile.isOccupied() && rightTile.getPiece().isWhite() != isWhite()) {
                    pawnPossibleMoves.add(rightTile);
                }
            }
        }
        return pawnPossibleMoves;
    }

    @Override
    public String toString()
    {
        return super.toString() + "P";
    }
}
