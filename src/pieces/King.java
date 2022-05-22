package pieces;



import java.util.*;
public class King extends Piece {
    private boolean check;
    private boolean firstMove;
    public King(int x, int y,boolean white)
    {
        super("King",x,y,white);
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
        ArrayList<BoardTile> kingPossibleMoves = new ArrayList<BoardTile>();
        int[][] offsets = {
                {1, 0},//bot
                {0, 1},//right
                {-1, 0},//up
                {0, -1},//left
                {1, 1},//bot right
                {-1, 1},//top right
                {-1, -1},//top left
                {1, -1}//bot left
        };
        for (int[] o : offsets) {
            if(inBounds(o[0] + getPositionX()) && inBounds(o[1] + getPositionY())) {
                BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                    kingPossibleMoves.add(currentTile);
                } else if (!currentTile.isOccupied()) {
                    kingPossibleMoves.add(currentTile);
                }
            }
            /* old code
            if (o[0] + getPositionX() < 8 && o[0] + getPositionX() >= 0 && o[1] + getPositionY() < 8 && o[1] + getPositionY() >= 0) {
                BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                    kingPossibleMoves.add(currentTile);
                } else if (!currentTile.isOccupied()) {
                    kingPossibleMoves.add(currentTile);
                }
            }
             */
        }
        return kingPossibleMoves;
    }

    @Override
    public String toString()
    {
        return super.toString() + "K";
    }
}
