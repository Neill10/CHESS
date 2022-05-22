package pieces;

import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(int x, int y,boolean white)
    {
        super("Knight",x,y,white);
    }

    public ArrayList<BoardTile> possibleMoves() {
        ArrayList<BoardTile> knightPossibleMoves = new ArrayList<BoardTile>();
        int row = this.getPositionX(); //row = 7, col = 1
        int col = this.getPositionY();
        int[][] offsets = {
                /*
                top/bot first = move 1 square
                left/right first = move 2 squares
                top/bot second = move 2 square
                left/right second = move 1 square
                tldr: basically just moves that knight can go
                 */
                {-2, -1},//top left
                {-2, 1},//top right
                {-1, -2},//left top
                {1, -2},//left bot
                {2, -1},//bot left
                {2, 1},//bot right
                {-1, 2},//left top
                {1, 2} //left bot
        };
        for (int[] o : offsets) {
            if(inBounds(o[0] + getPositionX()) && inBounds(o[1] + getPositionY())) {
                BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                    knightPossibleMoves.add(currentTile);
                }
                else if(!currentTile.isOccupied())
                {
                    knightPossibleMoves.add(currentTile);
                }
            }
            /*
            if(o[0] + getPositionX() < 8 && o[0] + getPositionX() >= 0 && o[1] + getPositionY() < 8 && o[1] + getPositionY() >= 0 ) {
                BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                    knightPossibleMoves.add(currentTile);
                }
                else if(!currentTile.isOccupied())
                {
                    knightPossibleMoves.add(currentTile);
                }
            }

             */
        }
        return knightPossibleMoves;
    }

    @Override
    public String toString() {
        return super.toString() + "N";
    }
}
