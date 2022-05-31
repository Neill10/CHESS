package pieces;



import javax.swing.*;
import java.util.*;
public class Pawn extends Piece {
    private boolean firstMove;
    private boolean promoted;
    public Pawn(int x, int y,boolean white)
    {
        super("pawn",x,y,white);
        firstMove = true;
        promoted = false;
    }

    @Override
    public void move(int x, int y) {
        super.move(x,y);
        setFirstMove(false);
        /*
        if(firstMove)
        {
            super.move(x,y);
            setFirstMove(false);
        }
        else if(isWhite())
        {
            if(x == 0)
            {
                Board board = getAssociatedBoard();
                Queen promoteWhite = new Queen(x,y,true);
                promoteWhite.setBoard(board);
                board.getBoard()[getPositionX()][getPositionY()].setPiece(null);//removes pawn
                board.getBoard()[x][y].setPiece(promoteWhite);
                JLabel queenLabel = new JLabel("src/Assets/queenWhite");
                board.getBoard()[x][y].removeJLabel();
                board.getBoard()[x][y].setjLabel(queenLabel);
                setPromoted(true);
                System.out.println("promoted");
            }
            else
            {
                super.move(x,y);
            }
        }
        else {
            if (x == 7) {
                Queen promoteBlack = new Queen(x, y, false);
                getAssociatedBoard().getBoard()[x][y].setPiece(promoteBlack);
                JLabel queenLabel = new JLabel("src/Assets/queenBlack");
                getAssociatedBoard().getBoard()[x][y].setjLabel(queenLabel);
                setPromoted(true);
                System.out.println("promoted");
            }
            else
            {
                super.move(x,y);
            }
        }

         */


    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public boolean getPromoted()
    {
        return promoted;
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
        return pawnPossibleMoves;
    }

    @Override
    public String toString()
    {
        return super.toString() + "P";
    }
}
