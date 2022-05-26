package pieces;

import javax.swing.*;
import java.util.*;
public abstract class Piece {
    private boolean white;
    private int positionX;//(a,b,c,d,e,f,g,h)(ROW)
    private int positionY;//(1,2,3,4,5,6,7,8)(COL)
    private String pieceName;
    private ArrayList<BoardTile> possibleMoves;
    private Board board;//associated board

    public Piece(String pieceName, int x, int y,boolean white)
    {
        this.pieceName = pieceName;
        positionX = x;
        positionY = y;
        this.white = white;
        possibleMoves = new ArrayList<BoardTile>();
    }

    //public abstract? boolean move(int x, int y);//returns if piece successfully moved
    public boolean move(int x, int y) {
        possibleMoves = possibleMoves();
        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                //BoardTile[][] b = board.getBoard();
                board.getBoard()[getPositionX()][getPositionY()].setPiece(null);

                board.getBoard()[x][y].setPiece(this);//replacings any pieces at new location
                System.out.println(board.getBoard()[x][y].getPiece().getClass());
                board.getBoard()[x][y].getPiece().setPositionX(x);
                board.getBoard()[x][y].getPiece().setPositionY(y);
                board.setSelectedAll(false);
                return true;
            }
        }
        return false;
    }
    /*
     public boolean move(int x, int y) {
        possibleMoves = possibleMoves();
        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                board.getBoard()[getPositionX()][getPositionY()].setPiece(null);
                JLabel replacingLabel = board.getBoard()[getPositionX()][getPositionY()].getjLabel();
                board.getBoard()[getPositionX()][getPositionY()].removeLabel();
                board.getBoard()[x][y].setjLabel(replacingLabel);
                board.getBoard()[x][y].setPiece(this);
                return true;
            }
        }
        return false;
    }
     */
    public abstract ArrayList<BoardTile> possibleMoves();

    public void setBoard(Board board) {
        this.board = board;
    }

    //getter methods
    public boolean isWhite()
    {
        return white;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean inBounds(int num)
    {
        return num >= 0 && num < 8;
    }

    public Board getAssociatedBoard() {
        return board;
    }

    public String getPieceName()
    {
        return pieceName;
    }

    public void setPossibleMoves(ArrayList<BoardTile> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public ArrayList<BoardTile> getPossibleMoves()
    {
        return possibleMoves;
    }

    public Icon getIcon()
    {
        if(isWhite())
        {
            return new ImageIcon("src/Assets/" + getPieceName() + "White.png");
        }
        else
        {
            return new ImageIcon("src/Assets/" + getPieceName() + "Black.png");
        }
    }

    public String toString()
    {

        if(white)
        {
            return "W";
        }
        else
        {
            return "B";
        }
    }
}
