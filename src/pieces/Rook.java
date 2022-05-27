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
    public boolean move(int x, int y) {
        setPossibleMoves(possibleMoves());
        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                Board board = getAssociatedBoard();
                BoardTile[][] b = board.getBoard();
                b[getPositionX()][getPositionY()].setPiece(null);

                b[x][y].setPiece(this);
                System.out.println(b[x][y].getPiece().getClass());
                b[x][y].getPiece().setPositionX(x);
                b[x][y].getPiece().setPositionY(y);
                board.setSelectedAll(false);
                setFirstMove(false);
                return true;
            }
        }
        return false;
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
        return rookPossibleMoves;
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
